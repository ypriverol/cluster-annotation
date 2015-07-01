package uk.ac.ebi.pride.spectracluster.annotations.data;

import java.util.Set;

/**
 * @author Yasset Perez-Riverol (ypriverol@gmail.com)
 * @date 01/07/2015
 */

public class SpectraCluster {

    private String id;

    private Float averagePrecursorMz;

    private Float averagePrecursorMzWithHighestRatio;

    private Integer averagePrecursorCharge;

    private Integer averagePrecursorChargeWithHighestRatio;

    private Integer maxPrecursorCharge;

    private Integer minPrecursorCharge;

    private Integer maxPrecursorChargeWithHighestRatio;

    private Integer minPrecursorChargeWithHighestRatio;

    private Float maxPrecursorMz;

    private Float minPrecursorMz;

    private Float precursorMzRange;

    private Float maxPrecursorMzWithHighestRatio;

    private Float minPrecursorMzWithHighestRatio;

    private Float precursorMzRangeOnPeptideWithHighestRatio;

    private Integer numberOfSpectra;

    private Set<String> projects;

    private Set<String> projectOnPeptideWithHighestRatio;

    private boolean multipleHighRankingPeptideSequences;

    private Integer numberOfDistinctPeptideSequences;

    private Integer numberOfPsms;

    private Set<String> speciesInTaxonomyId;

    private Set<String> speciesOnPeptideWithHighestRatioInTaxonomyId;

    private Float highestRatio;

    private String peptideSequenceWithHighestRatio;

    private Integer peptideCountWithHighestRatio;

    private String fileName;

    private String  secondPeptideSequenceWithHighestRatio = null;

    private Integer secondPeptideCountWithHighestRatio = null;

    private String  thirdPeptideSequenceWithHighestRatio = null;

    private Integer thirdPeptideCountWithHighestRatio = null;

    private String  fourPeptideSequenceWithHighestRatio = null;

    private Integer fourPeptideCountWithHighestRatio = null;

    public SpectraCluster(){

    }

    public SpectraCluster(String id, Float averagePrecursorMz,
                          Float averagePrecursorMzWithHighestRatio,
                          Integer averagePrecursorCharge, Integer averagePrecursorChargeWithHighestRatio, Integer maxPrecursorCharge,
                          Integer minPrecursorCharge, Integer maxPrecursorChargeWithHighestRatio, Integer minPrecursorChargeWithHighestRatio,
                          Float maxPrecursorMz, Float minPrecursorMz, Float precursorMzRange, Float maxPrecursorMzWithHighestRatio,
                          Float minPrecursorMzWithHighestRatio, Float precursorMzRangeOnPeptideWithHighestRatio, Integer numberOfSpectra,
                          Set<String> projects, Set<String> projectOnPeptideWithHighestRatio, boolean multipleHighRankingPeptideSequences,
                          Integer numberOfDistinctPeptideSequences, Integer numberOfPsms, Set<String> speciesInTaxonomyId,
                          Set<String> speciesOnPeptideWithHighestRatioInTaxonomyId, Float highestRatio, String peptideSequenceWithHighestRatio,
                          Integer peptideCountWithHighestRatio, String fileName, String secondPeptideSequenceWithHighestRatio,
                          Integer secondPeptideCountWithHighestRatio, String thirdPeptideSequenceWithHighestRatio,
                          Integer thirdPeptideCountWithHighestRatio, String fourPeptideSequenceWithHighestRatio,
                          Integer fourPeptideCountWithHighestRatio) {
        this.id = id;
        this.averagePrecursorMz = averagePrecursorMz;
        this.averagePrecursorMzWithHighestRatio = averagePrecursorMzWithHighestRatio;
        this.averagePrecursorCharge = averagePrecursorCharge;
        this.averagePrecursorChargeWithHighestRatio = averagePrecursorChargeWithHighestRatio;
        this.maxPrecursorCharge = maxPrecursorCharge;
        this.minPrecursorCharge = minPrecursorCharge;
        this.maxPrecursorChargeWithHighestRatio = maxPrecursorChargeWithHighestRatio;
        this.minPrecursorChargeWithHighestRatio = minPrecursorChargeWithHighestRatio;
        this.maxPrecursorMz = maxPrecursorMz;
        this.minPrecursorMz = minPrecursorMz;
        this.precursorMzRange = precursorMzRange;
        this.maxPrecursorMzWithHighestRatio = maxPrecursorMzWithHighestRatio;
        this.minPrecursorMzWithHighestRatio = minPrecursorMzWithHighestRatio;
        this.precursorMzRangeOnPeptideWithHighestRatio = precursorMzRangeOnPeptideWithHighestRatio;
        this.numberOfSpectra = numberOfSpectra;
        this.projects = projects;
        this.projectOnPeptideWithHighestRatio = projectOnPeptideWithHighestRatio;
        this.multipleHighRankingPeptideSequences = multipleHighRankingPeptideSequences;
        this.numberOfDistinctPeptideSequences = numberOfDistinctPeptideSequences;
        this.numberOfPsms = numberOfPsms;
        this.speciesInTaxonomyId = speciesInTaxonomyId;
        this.speciesOnPeptideWithHighestRatioInTaxonomyId = speciesOnPeptideWithHighestRatioInTaxonomyId;
        this.highestRatio = highestRatio;
        this.peptideSequenceWithHighestRatio = peptideSequenceWithHighestRatio;
        this.peptideCountWithHighestRatio = peptideCountWithHighestRatio;
        this.fileName = fileName;
        this.secondPeptideSequenceWithHighestRatio = secondPeptideSequenceWithHighestRatio;
        this.secondPeptideCountWithHighestRatio = secondPeptideCountWithHighestRatio;
        this.thirdPeptideSequenceWithHighestRatio = thirdPeptideSequenceWithHighestRatio;
        this.thirdPeptideCountWithHighestRatio = thirdPeptideCountWithHighestRatio;
        this.fourPeptideSequenceWithHighestRatio = fourPeptideSequenceWithHighestRatio;
        this.fourPeptideCountWithHighestRatio = fourPeptideCountWithHighestRatio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getAveragePrecursorMz() {
        return averagePrecursorMz;
    }

    public void setAveragePrecursorMz(Float averagePrecursorMz) {
        this.averagePrecursorMz = averagePrecursorMz;
    }

    public Float getAveragePrecursorMzWithHighestRatio() {
        return averagePrecursorMzWithHighestRatio;
    }

    public void setAveragePrecursorMzWithHighestRatio(Float averagePrecursorMzWithHighestRatio) {
        this.averagePrecursorMzWithHighestRatio = averagePrecursorMzWithHighestRatio;
    }

    public Integer getAveragePrecursorCharge() {
        return averagePrecursorCharge;
    }

    public void setAveragePrecursorCharge(Integer averagePrecursorCharge) {
        this.averagePrecursorCharge = averagePrecursorCharge;
    }

    public Integer getAveragePrecursorChargeWithHighestRatio() {
        return averagePrecursorChargeWithHighestRatio;
    }

    public void setAveragePrecursorChargeWithHighestRatio(Integer averagePrecursorChargeWithHighestRatio) {
        this.averagePrecursorChargeWithHighestRatio = averagePrecursorChargeWithHighestRatio;
    }

    public Integer getMaxPrecursorCharge() {
        return maxPrecursorCharge;
    }

    public void setMaxPrecursorCharge(Integer maxPrecursorCharge) {
        this.maxPrecursorCharge = maxPrecursorCharge;
    }

    public Integer getMinPrecursorCharge() {
        return minPrecursorCharge;
    }

    public void setMinPrecursorCharge(Integer minPrecursorCharge) {
        this.minPrecursorCharge = minPrecursorCharge;
    }

    public Integer getMaxPrecursorChargeWithHighestRatio() {
        return maxPrecursorChargeWithHighestRatio;
    }

    public void setMaxPrecursorChargeWithHighestRatio(Integer maxPrecursorChargeWithHighestRatio) {
        this.maxPrecursorChargeWithHighestRatio = maxPrecursorChargeWithHighestRatio;
    }

    public Integer getMinPrecursorChargeWithHighestRatio() {
        return minPrecursorChargeWithHighestRatio;
    }

    public void setMinPrecursorChargeWithHighestRatio(Integer minPrecursorChargeWithHighestRatio) {
        this.minPrecursorChargeWithHighestRatio = minPrecursorChargeWithHighestRatio;
    }

    public Float getMaxPrecursorMz() {
        return maxPrecursorMz;
    }

    public void setMaxPrecursorMz(Float maxPrecursorMz) {
        this.maxPrecursorMz = maxPrecursorMz;
    }

    public Float getMinPrecursorMz() {
        return minPrecursorMz;
    }

    public void setMinPrecursorMz(Float minPrecursorMz) {
        this.minPrecursorMz = minPrecursorMz;
    }

    public Float getPrecursorMzRange() {
        return precursorMzRange;
    }

    public void setPrecursorMzRange(Float precursorMzRange) {
        this.precursorMzRange = precursorMzRange;
    }

    public Float getMaxPrecursorMzWithHighestRatio() {
        return maxPrecursorMzWithHighestRatio;
    }

    public void setMaxPrecursorMzWithHighestRatio(Float maxPrecursorMzWithHighestRatio) {
        this.maxPrecursorMzWithHighestRatio = maxPrecursorMzWithHighestRatio;
    }

    public Float getMinPrecursorMzWithHighestRatio() {
        return minPrecursorMzWithHighestRatio;
    }

    public void setMinPrecursorMzWithHighestRatio(Float minPrecursorMzWithHighestRatio) {
        this.minPrecursorMzWithHighestRatio = minPrecursorMzWithHighestRatio;
    }

    public Float getPrecursorMzRangeOnPeptideWithHighestRatio() {
        return precursorMzRangeOnPeptideWithHighestRatio;
    }

    public void setPrecursorMzRangeOnPeptideWithHighestRatio(Float precursorMzRangeOnPeptideWithHighestRatio) {
        this.precursorMzRangeOnPeptideWithHighestRatio = precursorMzRangeOnPeptideWithHighestRatio;
    }

    public Integer getNumberOfSpectra() {
        return numberOfSpectra;
    }

    public void setNumberOfSpectra(Integer numberOfSpectra) {
        this.numberOfSpectra = numberOfSpectra;
    }

    public Set<String> getProjects() {
        return projects;
    }

    public void setProjects(Set<String> projects) {
        this.projects = projects;
    }

    public Set<String> getProjectOnPeptideWithHighestRatio() {
        return projectOnPeptideWithHighestRatio;
    }

    public void setProjectOnPeptideWithHighestRatio(Set<String> projectOnPeptideWithHighestRatio) {
        this.projectOnPeptideWithHighestRatio = projectOnPeptideWithHighestRatio;
    }

    public boolean isMultipleHighRankingPeptideSequences() {
        return multipleHighRankingPeptideSequences;
    }

    public void setMultipleHighRankingPeptideSequences(boolean multipleHighRankingPeptideSequences) {
        this.multipleHighRankingPeptideSequences = multipleHighRankingPeptideSequences;
    }

    public Integer getNumberOfDistinctPeptideSequences() {
        return numberOfDistinctPeptideSequences;
    }

    public void setNumberOfDistinctPeptideSequences(Integer numberOfDistinctPeptideSequences) {
        this.numberOfDistinctPeptideSequences = numberOfDistinctPeptideSequences;
    }

    public Integer getNumberOfPsms() {
        return numberOfPsms;
    }

    public void setNumberOfPsms(Integer numberOfPsms) {
        this.numberOfPsms = numberOfPsms;
    }

    public Set<String> getSpeciesInTaxonomyId() {
        return speciesInTaxonomyId;
    }

    public void setSpeciesInTaxonomyId(Set<String> speciesInTaxonomyId) {
        this.speciesInTaxonomyId = speciesInTaxonomyId;
    }

    public Set<String> getSpeciesOnPeptideWithHighestRatioInTaxonomyId() {
        return speciesOnPeptideWithHighestRatioInTaxonomyId;
    }

    public void setSpeciesOnPeptideWithHighestRatioInTaxonomyId(Set<String> speciesOnPeptideWithHighestRatioInTaxonomyId) {
        this.speciesOnPeptideWithHighestRatioInTaxonomyId = speciesOnPeptideWithHighestRatioInTaxonomyId;
    }

    public Float getHighestRatio() {
        return highestRatio;
    }

    public void setHighestRatio(Float highestRatio) {
        this.highestRatio = highestRatio;
    }

    public String getPeptideSequenceWithHighestRatio() {
        return peptideSequenceWithHighestRatio;
    }

    public void setPeptideSequenceWithHighestRatio(String peptideSequenceWithHighestRatio) {
        this.peptideSequenceWithHighestRatio = peptideSequenceWithHighestRatio;
    }

    public Integer getPeptideCountWithHighestRatio() {
        return peptideCountWithHighestRatio;
    }

    public void setPeptideCountWithHighestRatio(Integer peptideCountWithHighestRatio) {
        this.peptideCountWithHighestRatio = peptideCountWithHighestRatio;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSecondPeptideSequenceWithHighestRatio() {
        return secondPeptideSequenceWithHighestRatio;
    }

    public void setSecondPeptideSequenceWithHighestRatio(String secondPeptideSequenceWithHighestRatio) {
        this.secondPeptideSequenceWithHighestRatio = secondPeptideSequenceWithHighestRatio;
    }

    public Integer getSecondPeptideCountWithHighestRatio() {
        return secondPeptideCountWithHighestRatio;
    }

    public void setSecondPeptideCountWithHighestRatio(Integer secondPeptideCountWithHighestRatio) {
        this.secondPeptideCountWithHighestRatio = secondPeptideCountWithHighestRatio;
    }

    public String getThirdPeptideSequenceWithHighestRatio() {
        return thirdPeptideSequenceWithHighestRatio;
    }

    public void setThirdPeptideSequenceWithHighestRatio(String thirdPeptideSequenceWithHighestRatio) {
        this.thirdPeptideSequenceWithHighestRatio = thirdPeptideSequenceWithHighestRatio;
    }

    public Integer getThirdPeptideCountWithHighestRatio() {
        return thirdPeptideCountWithHighestRatio;
    }

    public void setThirdPeptideCountWithHighestRatio(Integer thirdPeptideCountWithHighestRatio) {
        this.thirdPeptideCountWithHighestRatio = thirdPeptideCountWithHighestRatio;
    }

    public String getFourPeptideSequenceWithHighestRatio() {
        return fourPeptideSequenceWithHighestRatio;
    }

    public void setFourPeptideSequenceWithHighestRatio(String fourPeptideSequenceWithHighestRatio) {
        this.fourPeptideSequenceWithHighestRatio = fourPeptideSequenceWithHighestRatio;
    }

    public Integer getFourPeptideCountWithHighestRatio() {
        return fourPeptideCountWithHighestRatio;
    }

    public void setFourPeptideCountWithHighestRatio(Integer fourPeptideCountWithHighestRatio) {
        this.fourPeptideCountWithHighestRatio = fourPeptideCountWithHighestRatio;
    }
}
