package uk.ac.ebi.pride.spectracluster.annotations.annotation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.ac.ebi.pride.jfasta.FastaReader;
import uk.ac.ebi.pride.jfasta.model.DBFastaSequence;
import uk.ac.ebi.pride.jfasta.utils.FastaAccessionPattern;
import uk.ac.ebi.pride.jfasta.utils.ProteinAccessionPattern;
import uk.ac.ebi.pride.spectracluster.annotations.data.AnnotatedSpectraCluster;
import uk.ac.ebi.pride.spectracluster.annotations.io.SpectraClusterFileParsingExecutable;
import uk.ac.ebi.pride.spectracluster.annotations.utils.SpectraClusterAnnotationUtils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ContaminantAnnotationTest {

    private File spectraFile;

    private List<AnnotatedSpectraCluster> clusters;

    private FastaReader fastaReader;

    @Before
    public void setUp() throws Exception {
        URL resource = ContaminantAnnotationTest.class.getClassLoader().getResource("final.csv");
        spectraFile = new File(resource.toURI());
        clusters = new ArrayList<AnnotatedSpectraCluster>();
        SpectraClusterFileParsingExecutable spectrumReader = new SpectraClusterFileParsingExecutable(spectraFile, clusters);
        spectrumReader.run();
        clusters = spectrumReader.retrieveClusters();
        resource = ContaminantAnnotationTest.class.getClassLoader().getResource("contaminants.fasta");
        fastaReader = new FastaReader(resource, "r");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAnnotator() throws Exception {
        fastaReader.readFastaFile();

        Map<String, String> seq = new HashMap<String, String>();
        for(String id: fastaReader.getDBFastaSequenceIds()){
            DBFastaSequence seqDB = fastaReader.get(id);
            if(id != null && id.length() > 0 && seqDB != null && seqDB.getSequence() != null){
                seq.put(SpectraClusterAnnotationUtils.getRawProteinID(seqDB.getHeader()),seqDB.getSequence());
            }
        }

        ContaminantAnnotation contaminantAnnotation = ContaminantAnnotation.getInstance(seq);

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
        }

        assertEquals(clusters.size(), 99);
    }

}