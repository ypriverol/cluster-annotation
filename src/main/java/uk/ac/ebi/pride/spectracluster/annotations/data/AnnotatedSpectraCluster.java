package uk.ac.ebi.pride.spectracluster.annotations.data;

import uk.ac.ebi.pride.spectracluster.annotations.utils.SpectraClusterAnnotationUtils;

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

    @Override
    public String toString() {
        return super.toString();
    }

    public StringBuilder reportLine(){

        StringBuilder line = new StringBuilder();

        line = SpectraClusterAnnotationUtils.appendObject(line, getId());

        line = SpectraClusterAnnotationUtils.appendFloat(line, getAveragePrecursorMz());

        // average precursor m/z on peptide with highest ratio
        line = SpectraClusterAnnotationUtils.appendFloat(line, getAveragePrecursorMzWithHighestRatio());

        // average precursor charge
        line = SpectraClusterAnnotationUtils.appendObject(line, getAveragePrecursorCharge());

        // average precursor charge on peptide with highest ratio
        line = SpectraClusterAnnotationUtils.appendObject(line, getAveragePrecursorChargeWithHighestRatio());

        // max precursor charge
        line = SpectraClusterAnnotationUtils.appendObject(line, getMaxPrecursorCharge());

        // min precursor charge
        line = SpectraClusterAnnotationUtils.appendObject(line, getMinPrecursorCharge());

        // max precursor charge on peptide with highest ratio
        line = SpectraClusterAnnotationUtils.appendObject(line, getMaxPrecursorChargeWithHighestRatio());

        // min precursor charge on peptide with highest ratio
        line = SpectraClusterAnnotationUtils.appendObject(line, getMinPrecursorChargeWithHighestRatio());

        // maximum precursor m/z
        line = SpectraClusterAnnotationUtils.appendFloat(line, getMaxPrecursorMz());

        // minimum precursor m/z
        line = SpectraClusterAnnotationUtils.appendFloat(line, getMinPrecursorMz());

        // precursor m/z range
        line = SpectraClusterAnnotationUtils.appendFloat(line, getPrecursorMzRange());

        // max precursor m/z on peptide with highest ratio
        line = SpectraClusterAnnotationUtils.appendFloat(line, getMaxPrecursorMzWithHighestRatio());

        // min precursor m/z on peptide with highest ratio
        line = SpectraClusterAnnotationUtils.appendFloat(line, getMinPrecursorMzWithHighestRatio());

        // precursor m/z range on peptide with highest ratio
        line = SpectraClusterAnnotationUtils.appendFloat(line, getPrecursorMzRangeOnPeptideWithHighestRatio());

        // Number of spectra
        line = SpectraClusterAnnotationUtils.appendObject(line, getNumberOfSpectra());

        // Number of projects
        Set<String> projects = getProjects();
        line = SpectraClusterAnnotationUtils.appendObject(line, projects.size());

        // projects
        line = SpectraClusterAnnotationUtils.appendObject(line, SpectraClusterAnnotationUtils.collectionToString(projects));

        // Number of projects on peptide with highest ratio
        Set<String> projectOnPeptideWithHighestRatio = getProjectOnPeptideWithHighestRatio();
        line = SpectraClusterAnnotationUtils.appendObject(line, projectOnPeptideWithHighestRatio.size());

        // projects on peptide with highest ratio
        line = SpectraClusterAnnotationUtils.appendObject(line, SpectraClusterAnnotationUtils.collectionToString(projectOnPeptideWithHighestRatio));

        // multiple high ranking peptide sequences
        line = SpectraClusterAnnotationUtils.appendObject(line, isMultipleHighRankingPeptideSequences());

        // Number of distinct peptide sequences
        line = SpectraClusterAnnotationUtils.appendObject(line, getNumberOfDistinctPeptideSequences());

        // Number of PSMs
        line = SpectraClusterAnnotationUtils.appendObject(line, getNumberOfPsms());

        // Number of species
        Set<String> speciesInTaxonomyId = getSpeciesInTaxonomyId();
        line = SpectraClusterAnnotationUtils.appendObject(line, speciesInTaxonomyId.size());

        // species
        line = SpectraClusterAnnotationUtils.appendObject(line, SpectraClusterAnnotationUtils.collectionToString(speciesInTaxonomyId));

        // Number of species on peptide with highest ratio
        Set<String> speciesOnPeptideWithHighestRatioInTaxonomyId = getSpeciesOnPeptideWithHighestRatioInTaxonomyId();
        line = SpectraClusterAnnotationUtils.appendObject(line, speciesOnPeptideWithHighestRatioInTaxonomyId.size());

        // species on peptide with highest ratio
        line = SpectraClusterAnnotationUtils.appendObject(line, SpectraClusterAnnotationUtils.collectionToString(speciesOnPeptideWithHighestRatioInTaxonomyId));

        // highest ratio
        line = SpectraClusterAnnotationUtils.appendFloat(line, getHighestRatio());

        // peptide sequence with highest ratio
        line = SpectraClusterAnnotationUtils.appendObject(line, getPeptideSequenceWithHighestRatio());
        line = SpectraClusterAnnotationUtils.appendObject(line, getPeptideCountWithHighestRatio());

        //add second sequence
        line = SpectraClusterAnnotationUtils.appendObject(line, getSecondPeptideSequenceWithHighestRatio());
        line = SpectraClusterAnnotationUtils.appendObject(line, getSecondPeptideCountWithHighestRatio());

        //add third sequence
        line = SpectraClusterAnnotationUtils.appendObject(line, getThirdPeptideSequenceWithHighestRatio());
        line = SpectraClusterAnnotationUtils.appendObject(line, getThirdPeptideCountWithHighestRatio());

        //add four sequence
        line = SpectraClusterAnnotationUtils.appendObject(line, getFourPeptideSequenceWithHighestRatio());
        line = SpectraClusterAnnotationUtils.appendObject(line, getFourPeptideCountWithHighestRatio());

        // clustering file name
        line = SpectraClusterAnnotationUtils.appendObject(line, getFileName());

        // list of Contaminants of first pep
        line = SpectraClusterAnnotationUtils.appendObject(line, SpectraClusterAnnotationUtils.collectionToString(pepSeqContaminantList));

        // list of Contaminants of first pep
        line = SpectraClusterAnnotationUtils.appendObject(line, SpectraClusterAnnotationUtils.collectionToString(secondPepSeqContaminantList));

        // list of Contaminants of first pep
        line = SpectraClusterAnnotationUtils.appendObject(line, SpectraClusterAnnotationUtils.collectionToString(thirdPepSeqContaminantList));

        // list of Contaminants of first pep
        line = SpectraClusterAnnotationUtils.appendObject(line, SpectraClusterAnnotationUtils.collectionToString(fourPepSeqContaminantList));

        // remove the last tab
        line = line.delete(line.length() - 1, line.length());


        return  line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnnotatedSpectraCluster)) return false;

        AnnotatedSpectraCluster that = (AnnotatedSpectraCluster) o;

        if (fourPepSeqContaminantList != null ? !fourPepSeqContaminantList.equals(that.fourPepSeqContaminantList) : that.fourPepSeqContaminantList != null)
            return false;
        if (pepSeqContaminantList != null ? !pepSeqContaminantList.equals(that.pepSeqContaminantList) : that.pepSeqContaminantList != null)
            return false;
        if (secondPepSeqContaminantList != null ? !secondPepSeqContaminantList.equals(that.secondPepSeqContaminantList) : that.secondPepSeqContaminantList != null)
            return false;
        if (thirdPepSeqContaminantList != null ? !thirdPepSeqContaminantList.equals(that.thirdPepSeqContaminantList) : that.thirdPepSeqContaminantList != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pepSeqContaminantList != null ? pepSeqContaminantList.hashCode() : 0;
        result = 31 * result + (secondPepSeqContaminantList != null ? secondPepSeqContaminantList.hashCode() : 0);
        result = 31 * result + (thirdPepSeqContaminantList != null ? thirdPepSeqContaminantList.hashCode() : 0);
        result = 31 * result + (fourPepSeqContaminantList != null ? fourPepSeqContaminantList.hashCode() : 0);
        return result;
    }
}
