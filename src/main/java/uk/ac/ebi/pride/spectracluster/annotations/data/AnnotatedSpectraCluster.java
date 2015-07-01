package uk.ac.ebi.pride.spectracluster.annotations.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Yasset Perez-Riverol (ypriverol@gmail.com)
 * @date 01/07/2015
 */

public class AnnotatedSpectraCluster extends SpectraCluster {

    // List of proteins where the first peptide appear
    List<String> pepSeqContaminantList = null;

    // List of the proteins where the second peptide appear
    List<String> secondPepSeqContaminantList = null;

    // List of the proteins where the third peptide appear
    List<String> thirdPepSeqContaminantList = null;

    // List of the proteins where the four peptide appear .
    List<String> fourPepSeqContaminantList = null;

    public AnnotatedSpectraCluster(){}

    public AnnotatedSpectraCluster(String id, Float averagePrecursorMz, Float averagePrecursorMzWithHighestRatio, Integer averagePrecursorCharge, Integer averagePrecursorChargeWithHighestRatio, Integer maxPrecursorCharge, Integer minPrecursorCharge, Integer maxPrecursorChargeWithHighestRatio, Integer minPrecursorChargeWithHighestRatio, Float maxPrecursorMz, Float minPrecursorMz, Float precursorMzRange, Float maxPrecursorMzWithHighestRatio, Float minPrecursorMzWithHighestRatio, Float precursorMzRangeOnPeptideWithHighestRatio, Integer numberOfSpectra, Set<String> projects, Set<String> projectOnPeptideWithHighestRatio, boolean multipleHighRankingPeptideSequences, Integer numberOfDistinctPeptideSequences, Integer numberOfPsms, Set<String> speciesInTaxonomyId, Set<String> speciesOnPeptideWithHighestRatioInTaxonomyId, Float highestRatio, String peptideSequenceWithHighestRatio, Integer peptideCountWithHighestRatio, String fileName, String secondPeptideSequenceWithHighestRatio, Integer secondPeptideCountWithHighestRatio, String thirdPeptideSequenceWithHighestRatio, Integer thirdPeptideCountWithHighestRatio, String fourPeptideSequenceWithHighestRatio, Integer fourPeptideCountWithHighestRatio) {
        super(id, averagePrecursorMz, averagePrecursorMzWithHighestRatio, averagePrecursorCharge, averagePrecursorChargeWithHighestRatio, maxPrecursorCharge, minPrecursorCharge, maxPrecursorChargeWithHighestRatio, minPrecursorChargeWithHighestRatio, maxPrecursorMz, minPrecursorMz, precursorMzRange, maxPrecursorMzWithHighestRatio, minPrecursorMzWithHighestRatio, precursorMzRangeOnPeptideWithHighestRatio, numberOfSpectra, projects, projectOnPeptideWithHighestRatio, multipleHighRankingPeptideSequences, numberOfDistinctPeptideSequences, numberOfPsms, speciesInTaxonomyId, speciesOnPeptideWithHighestRatioInTaxonomyId, highestRatio, peptideSequenceWithHighestRatio, peptideCountWithHighestRatio, fileName, secondPeptideSequenceWithHighestRatio, secondPeptideCountWithHighestRatio, thirdPeptideSequenceWithHighestRatio, thirdPeptideCountWithHighestRatio, fourPeptideSequenceWithHighestRatio, fourPeptideCountWithHighestRatio);
    }

    public List<String> getPepSeqContaminantList() {
        return pepSeqContaminantList;
    }

    public void setPepSeqContaminantList(List<String> pepSeqContaminantList) {
        this.pepSeqContaminantList = pepSeqContaminantList;
    }

    public void addPepSeqContaminant(String contaminant){
        if(this.pepSeqContaminantList == null) this.pepSeqContaminantList = new ArrayList<String>();
        this.pepSeqContaminantList.add(contaminant);
    }

    public List<String> getSecondPepSeqContaminantList() {
        return secondPepSeqContaminantList;
    }

    public void setSecondPepSeqContaminantList(List<String> secondPepSeqContaminantList) {
        this.secondPepSeqContaminantList = secondPepSeqContaminantList;
    }

    public void addSecondPepSeqContaminant(String contaminant){
        if(this.secondPepSeqContaminantList == null) this.secondPepSeqContaminantList = new ArrayList<String>();
        this.secondPepSeqContaminantList.add(contaminant);
    }

    public List<String> getThirdPepSeqContaminantList() {
        return thirdPepSeqContaminantList;
    }

    public void setThirdPepSeqContaminantList(List<String> thirdPepSeqContaminantList) {
        this.thirdPepSeqContaminantList = thirdPepSeqContaminantList;
    }

    public void addThirdPepSeqContaminant(String contaminant) {
        if(this.thirdPepSeqContaminantList == null) this.thirdPepSeqContaminantList = new ArrayList<String>();
        this.thirdPepSeqContaminantList.add(contaminant);
    }

    public List<String> getFourPepSeqContaminantList() {
        return fourPepSeqContaminantList;
    }

    public void setFourPepSeqContaminantList(List<String> fourPepSeqContaminantList) {
        this.fourPepSeqContaminantList = fourPepSeqContaminantList;
    }

    public void addFourPepSeqContaminant(String contaminant) {
        if(this.fourPepSeqContaminantList == null) this.fourPepSeqContaminantList = new ArrayList<String>();
        this.fourPepSeqContaminantList.add(contaminant);
    }
}
