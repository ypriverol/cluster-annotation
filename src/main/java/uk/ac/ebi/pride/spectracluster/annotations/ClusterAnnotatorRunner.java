package uk.ac.ebi.pride.spectracluster.annotations;

import org.biojava.nbio.core.exceptions.CompoundNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.jfasta.FastaReader;
import uk.ac.ebi.pride.jfasta.model.DBFastaSequence;
import uk.ac.ebi.pride.spectracluster.annotations.annotation.ContaminantAnnotation;
import uk.ac.ebi.pride.spectracluster.annotations.annotation.VariantAnnotation;
import uk.ac.ebi.pride.spectracluster.annotations.data.AnnotatedSpectraCluster;
import uk.ac.ebi.pride.spectracluster.annotations.io.SpectraClusterFileParsingExecutable;
import uk.ac.ebi.pride.spectracluster.annotations.utils.SpectraClusterAnnotationUtils;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Main class to call to collect cluster statistics
 *
 * @author Yasset Perez-Riverol
 * @version $Id$
 */
public class ClusterAnnotatorRunner {

    public static final Logger logger = LoggerFactory.getLogger(ClusterAnnotatorRunner.class);

    public static void main(String[] args) throws IOException, CompoundNotFoundException {
        if (args.length != 3) {
            System.err.println("Usage: <origin file> <contaminant database> <output file>");
            System.exit(1);
        }

        File inputFile  = new File(args[0]);
        File fastaFile  = new File(args[1]);
        File outputFile = new File(args[2]);

        PrintStream out = new PrintStream(outputFile);


        List<AnnotatedSpectraCluster> clusters = new ArrayList<AnnotatedSpectraCluster>();
        SpectraClusterFileParsingExecutable spectrumReader = new SpectraClusterFileParsingExecutable(inputFile, clusters);
        spectrumReader.run();
        clusters = spectrumReader.retrieveClusters();

        FastaReader fastaReader = new FastaReader(fastaFile, "r");

        fastaReader.readFastaFile();

        Map<String, String> seq = new HashMap<String, String>();
        for(String id: fastaReader.getDBFastaSequenceIds()){
            DBFastaSequence seqDB = fastaReader.get(id);
            if(id != null && id.length() > 0 && seqDB != null && seqDB.getSequence() != null){
                seq.put(SpectraClusterAnnotationUtils.getRawProteinID(seqDB.getHeader()),seqDB.getSequence());
            }
        }

        ContaminantAnnotation contaminantAnnotation = ContaminantAnnotation.getInstance(seq);
        VariantAnnotation variantAnnotation = VariantAnnotation.getInstance();

        for(AnnotatedSpectraCluster cluster: clusters){
            if(cluster.getPeptideSequenceWithHighestRatio() != null){
                List<String> contaminants = contaminantAnnotation.annotator(cluster.getPeptideSequenceWithHighestRatio());
                cluster.setPepSeqContaminantList(contaminants);
            }
            if(cluster.getSecondPeptideSequenceWithHighestRatio() != null){
                List<String> contaminants = contaminantAnnotation.annotator(cluster.getSecondPeptideSequenceWithHighestRatio());
                cluster.setSecondPepSeqContaminantList(contaminants);
            }
            if(cluster.getThirdPeptideSequenceWithHighestRatio() != null){
                List<String> contaminants = contaminantAnnotation.annotator(cluster.getThirdPeptideSequenceWithHighestRatio());
                cluster.setThirdPepSeqContaminantList(contaminants);
            }
            if(cluster.getFourPeptideSequenceWithHighestRatio() != null){
                List<String> contaminants = contaminantAnnotation.annotator(cluster.getFourPeptideSequenceWithHighestRatio());
                cluster.setFourPepSeqContaminantList(contaminants);
            }
            cluster.setSimilarities(variantAnnotation.annotator(cluster));
        }

        out.println(SpectraClusterAnnotationUtils.getValuesHeader());

        for(AnnotatedSpectraCluster cluster: clusters){
            out.append(cluster.reportLine()).append("\n");
        }

    }
}
