package uk.ac.ebi.pride.spectracluster.annotations.utils;

import java.util.Collection;

/**
 * @author Yasset Perez-Riverol (ypriverol@gmail.com)
 * @date 01/07/2015
 */
public class SpectraClusterAnnotationUtils {

    public static String TAB_DELIMITED = "\t";

    public static String NA            = "NA";

    /**
     * Headers for the cluster statistics report
     * NOTE: Please keep this updated if you have changed content of the report
     * NOTE: The order of this enumeration is important, please keep the order in accordance of the output content
     */
    public static enum HEADER {
        ID ("CLUSTER_ID", "Cluster ID"),
        AVG_PRECURSOR_MZ("AVG_PMZ", "Average precursor m/z for the cluster"),
        AVG_PRECURSOR_MZ_HIGHEST("AVG_PMZ_HIGHEST", "Average precursor m/z for spectra with highest peptide identification ratio in the cluster"),
        AVG_PRECURSOR_CHARGE("AVG_PCHARGE", "Average precursor charge for the cluster"),
        AVG_PRECURSOR_CHARGE_HIGHEST("AVG_PCHARGE_HIGHEST", "Average precursor charge for spectra with highest peptide identification ratio in the cluster"),
        MAX_PRECURSOR_CHARGE("MAX_PCHARGE", "Maximum precursor charge for the cluster"),
        MIN_PRECURSOR_CHARGE("MIN_PCHARGE", "Minimum precursor charge for the cluster"),
        MAX_PRECURSOR_CHARGE_HIGHEST("MAX_PCHARGE_HIGHEST", "Maximum precursor charge for the cluster"),
        MIN_PRECURSOR_CHARGE_HIGHEST("MIN_PCHARGE_HIGHEST", "Minimum precursor charge for the cluster"),
        MAX_PRECURSOR_MZ("MAX_PMZ", "Maximum precursor m/z for the cluster"),
        MIN_PRECURSOR_MZ("MIN_PMZ", "Minimum precursor m/z for the cluster"),
        PRECURSOR_MZ_RANGE("PMZ_RANGE", "The range of the precursor m/z for all the spectra in the cluster, it represents difference between the lowest precursor m/z and the highest precursor m/z"),
        MAX_PRECURSOR_MZ_HIGHEST("MAX_PMZ_HIGHEST", "Maximum precursor m/z for spectra with highest peptide identification ratio in the cluster"),
        MIN_PRECURSOR_MZ_HIGHEST("MIN_PMZ_HIGHEST", "Minimum precursor m/z for spectra with highest peptide identification ratio in the cluster"),
        PRECURSOR_MZ_RANGE_HIGHEST("PMZ_RANGE_HIGHEST", "The range of the precursor m/z for the spectra with highest peptide identification ratio in the cluster, it represents the difference between the lowest precursor m/z and the highest precursor m/z"),
        NUMBER_OF_SPECTRA("NUM_SPECTRA", "Total number of spectra within the cluster"),
        NUMBER_OF_PROJECTS("NUM_PROJECTS", "Total number of COMPLETE projects from PRIDE Archive within the cluster"),
        PROJECT("PROJECT", "Project accessions from PRIDE Archive, separated by semicolon"),
        NUMBER_OF_PROJECTS_HIGHEST("NUM_PROJECTS_HIGHEST", "Total number of COMPLETE projects from PRIDE Archive for spectra with highest peptide identification ratio within the cluster"),
        PROJECT_HIGHEST("PROJECT_HIGHEST", "Project accessions from PRIDE Archive for spectra with highest peptide identification ratio, separated by semicolon"),
        MULTI_HIGHEST_PEPTIDES("MULTI_HIGHEST", "Boolean indicates whether there are multiple peptides that have the highest ratios"),
        NUMBER_OF_DISTINCT_PEPTIDES("NUM_PEPTIDES", "Total number of unique peptide sequences within the cluster"),
        NUMBER_OF_PSMS("NUM_PSMS", "Total number of PSMs within the cluster"),
        NUMBER_OF_SPECIES("NUM_SPECIES", "Total number of species within the cluster"),
        SPECIES("SPECIES", "Species within the cluster in taxonomy ID, separated by semicolon."),
        NUMBER_OF_SPECIES_HIGHEST("NUM_SPECIES_HIGHEST", "Total number of species for peptides that have the highest ratios within the cluster"),
        SPECIES_HIGHEST("SPECIES_HIGHEST", "Species for peptides that have the highest ratios within the cluster, in taxonomy ID, separated by semicolon."),
        MAX_RATIO("MAX_RATIO", "The highest ratio within the cluster"),

        PEPTIDE_HIGHEST("PEP_SEQ", "The peptide sequence for the peptide with the highest ratio within the cluster"),
        PEPTIDE_COUNT_HIGHEST("PEP_COUNT", "The peptide count  for the peptide with the highest ratio within the cluster"),

        PEPTIDE_HIGHEST_SECOND("PEP_SEQ_SECOND", "The peptide sequence for the second peptide with the highest ratio within the cluster"),
        PEPTIDE_COUNT_HIGHEST_SECOND("PEP_COUNT_SECOND", "The peptide count for the second peptide with the highest ratio within the cluster"),

        PEPTIDE_HIGHEST_THIRD("PEP_SEQ_THIRD", "The peptide sequence for the third peptide with the highest ratio within the cluster"),
        PEPTIDE_COUNT_HIGHEST_THIRD("PEP_COUNT_THIRD", "The peptide count for the third peptide with the highest ratio within the cluster"),

        PEPTIDE_HIGHEST_FOUR("PEP_SEQ_FOUR", "The peptide sequence for the four peptide with the highest ratio within the cluster"),
        PEPTIDE_COUNT_HIGHEST_FOUR("PEP_COUNT_FOUR", "The peptide count for the four peptide with the highest ratio within the cluster"),

        FILE_NAME("FILE_NAME", "The original clustering result file that contains this cluster"),

        PEP_CONTAMINANTS("PEP_CONTAMINANT", "The list of proteins where this peptides appear"),
        PEP_SECOND_CONTAMINANTS("PEP_CONTAMINANT_SECOND", "The list of proteins where this peptides appear"),
        PEP_THIRD_CONTAMINANTS("PEP_CONTAMINANT_THIRD", "The list of proteins where this peptides appear"),
        PEP_FOUR_CONTAMINANTS("PEP_CONTAMINANT_FOUR", "The list of proteins where this peptides appear"),

        PEP_SECOND_SIMILARITY("PEP_SIMILARITY_SECOND", "The list of proteins where this peptides appear"),
        PEP_THIRD_SIMILARITY("PEP_SIMILARITY_THIRD",   "The list of proteins where this peptides appear"),
        PEP_FOUR_SIMILARITY("PEP_SIMILARITY_FOUR",     "The list of proteins where this peptides appear");

        String header;
        String description;

        HEADER(String header, String description) {
            this.header = header;
            this.description = description;
        }

        public String getHeader() {
            return header;
        }

        public String getDescription() {
            return description;
        }

    }

    public static String getRawProteinID(String line){
        if(line != null && line.length() > 0){
            String[] lineString = line.split("\\s+");
            if(lineString != null && lineString.length >= 1)
                return lineString[0];
        }
        return line;
    }

    public static StringBuilder appendObject(StringBuilder line, Object s) {
        String str = s == null ? NA : s.toString();
        line.append(str).append("\t");
        return line;
    }

    public static StringBuilder appendFloat(StringBuilder line, Float f) {
        String fString = f == null ? NA : String.format("%10.3f", f).trim();
        line.append(fString).append("\t");
        return line;
    }

    public static StringBuilder appendDouble(StringBuilder line, Double f) {
        String fString = f == null ? NA : String.format("%10.3f", f).trim();
        line.append(fString).append("\t");
        return line;
    }

    public static String collectionToString(Collection objs) {
        StringBuilder appender = new StringBuilder();

        if (objs == null || objs.isEmpty())
            return NA;

        for (Object obj : objs) {
            appender.append(obj).append(";");
        }

        String content = appender.toString();
        return content.substring(0, content.length() - 1);
    }

    public static StringBuilder getValuesHeader(){
        StringBuilder line = new StringBuilder();
        for(HEADER value: HEADER.values())
            line.append(value.getHeader()).append(TAB_DELIMITED);
        return line;
    }

}
