package uk.ac.ebi.pride.spectracluster.annotations.annotation;


import org.biojava.nbio.alignment.*;
import org.biojava.nbio.alignment.template.SequencePair;
import org.biojava.nbio.alignment.template.SubstitutionMatrix;
import org.biojava.nbio.core.exceptions.CompoundNotFoundException;
import org.biojava.nbio.core.sequence.AccessionID;
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.compound.AminoAcidCompound;
import org.biojava.nbio.core.sequence.compound.AminoAcidCompoundSet;
import uk.ac.ebi.pride.spectracluster.annotations.data.AnnotatedSpectraCluster;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yasset Perez-Riverol (ypriverol@gmail.com)
 * @date 02/07/2015
 */
public class VariantAnnotation {

    private static VariantAnnotation instance = null;

    private VariantAnnotation(){

    }

    public static VariantAnnotation getInstance(){
        if(instance == null)
            instance = new VariantAnnotation();
        return instance;
    }

    public List<Integer> annotator(AnnotatedSpectraCluster cluster) throws CompoundNotFoundException {
        List<Integer> valueSimilarity  = new ArrayList<Integer>();

        List<ProteinSequence> peptides = new ArrayList<>();
        if(cluster.getPeptideSequenceWithHighestRatio() != null){
            ProteinSequence pepSEq = new ProteinSequence(validateSeq(cluster.getPeptideSequenceWithHighestRatio()));
            pepSEq.setAccession(new AccessionID("PEP_SEQ"));
            peptides.add(pepSEq);
        }
        if(cluster.getSecondPeptideSequenceWithHighestRatio() != null){
            ProteinSequence pepSEq = new ProteinSequence(validateSeq(cluster.getSecondPeptideSequenceWithHighestRatio()));
            pepSEq.setAccession(new AccessionID("PEP_SEQ_SECOND"));
            peptides.add(pepSEq);
        }

        if(cluster.getThirdPeptideSequenceWithHighestRatio() != null){
            ProteinSequence pepSEq = new ProteinSequence(validateSeq(cluster.getThirdPeptideSequenceWithHighestRatio()));
            pepSEq.setAccession(new AccessionID("PEP_SEQ_THIRD"));
            peptides.add(pepSEq);
        }

        if(cluster.getFourPeptideSequenceWithHighestRatio() != null){
            ProteinSequence pepSEq = new ProteinSequence(validateSeq(cluster.getFourPeptideSequenceWithHighestRatio()));
            pepSEq.setAccession(new AccessionID("PEP_SEQ_FOUR"));
            peptides.add(pepSEq);
        }

        if(peptides.size() > 1){
            ProteinSequence peptideSEQ = peptides.get(0);
            SubstitutionMatrix<AminoAcidCompound> matrix = readMSMatrix();
            for(int i = 1; i < peptides.size(); i++){
                ProteinSequence currentPep = peptides.get(i);
                NeedlemanWunsch<ProteinSequence, AminoAcidCompound> alignment = new NeedlemanWunsch<ProteinSequence, AminoAcidCompound>(peptideSEQ, currentPep, new SimpleGapPenalty(3,1), matrix);
                Integer aligmentSimilarity = (int) (Math.round(100*alignment.getSimilarity()));
                valueSimilarity.add(aligmentSimilarity);
            }
        }
        return valueSimilarity;
    }

    public static SubstitutionMatrix<AminoAcidCompound> readMSMatrix(){
        return new SimpleSubstitutionMatrix<AminoAcidCompound>(AminoAcidCompoundSet.getAminoAcidCompoundSet(), new InputStreamReader(
                VariantAnnotation.class.getResourceAsStream("/pam30ms.txt")), "pam30ms");
    }

    private String validateSeq(String seq){
        return seq.replace("#", "").replace("@","").replace("]","");
    }

}
