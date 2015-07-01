package uk.ac.ebi.pride.spectracluster.annotations.io;

import uk.ac.ebi.pride.spectracluster.annotations.data.AnnotatedSpectraCluster;
import uk.ac.ebi.pride.spectracluster.annotations.utils.SpectraClusterAnnotationUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Yasset Perez-Riverol (ypriverol@gmail.com)
 * @date 01/07/2015
 */
public class SpectraClusterFileReader {

    File clusteringFile;
    private BufferedReader br;
    private boolean inCluster = false;
    List<AnnotatedSpectraCluster> clusters = new ArrayList<AnnotatedSpectraCluster>();

    public SpectraClusterFileReader(File clusteringFile) {
       this.clusteringFile = clusteringFile;
    }


    public List<AnnotatedSpectraCluster> readClustersIteratively(List<AnnotatedSpectraCluster> clusters) throws Exception {
        clusters = new ArrayList<AnnotatedSpectraCluster>();

        if(this.br == null) {
            this.br = new BufferedReader(new FileReader(this.clusteringFile));
            this.inCluster = false;
        }

        AnnotatedSpectraCluster cluster;

        if(!this.readHeader(this.br)){
           throw new Exception("The header is not well formatted");
        }

        while((cluster = this.readNextCluster(this.br)) != null) {
            clusters.add(cluster);
        }

        this.clusters = clusters;
        return this.clusters;

    }

    /**
     * Check the first line of the spectra file to see if contains the
     * @return if the header is correct
     * @throws IOException
     */
    private boolean readHeader(BufferedReader br) throws IOException {
        String line = br.readLine();
        String[] lineHeader = line.split(SpectraClusterAnnotationUtils.TAB_DELIMITED);
        if(lineHeader[0] != null && lineHeader[0].length() > 0 && lineHeader[0].equalsIgnoreCase(SpectraClusterAnnotationUtils.HEADER.ID.getHeader()))
            return true;
        return false;
        //Todo: in the future will be nice to check more than one
    }


    private AnnotatedSpectraCluster readNextCluster(BufferedReader br) throws Exception {

        AnnotatedSpectraCluster cluster = null;
        String line = br.readLine();
        if(line != null){
            String[] lineCluster = line.trim().split(SpectraClusterAnnotationUtils.TAB_DELIMITED);

            if(lineCluster.length >= 37){
                cluster = new AnnotatedSpectraCluster();

                cluster.setId(parseStringValue(lineCluster[0]));
                cluster.setAveragePrecursorMz(parseFloatValueString(lineCluster[1]));
                cluster.setAveragePrecursorMzWithHighestRatio(parseFloatValueString(lineCluster[2]));
                cluster.setAveragePrecursorCharge(parseIntegerValueString(lineCluster[3]));
                cluster.setAveragePrecursorChargeWithHighestRatio(parseIntegerValueString(lineCluster[4]));
                cluster.setMaxPrecursorCharge(parseIntegerValueString(lineCluster[5]));
                cluster.setMinPrecursorCharge(parseIntegerValueString(lineCluster[6]));
                cluster.setMaxPrecursorChargeWithHighestRatio(parseIntegerValueString(lineCluster[7]));
                cluster.setMinPrecursorChargeWithHighestRatio(parseIntegerValueString(lineCluster[8]));
                cluster.setMaxPrecursorMz(parseFloatValueString(lineCluster[9]));
                cluster.setMinPrecursorMz(parseFloatValueString(lineCluster[10]));

                cluster.setPrecursorMzRange(parseFloatValueString(lineCluster[11]));
                cluster.setMaxPrecursorMzWithHighestRatio(parseFloatValueString(lineCluster[12]));
                cluster.setMinPrecursorMzWithHighestRatio(parseFloatValueString(lineCluster[13]));
                cluster.setPrecursorMzRangeOnPeptideWithHighestRatio(parseFloatValueString(lineCluster[14]));
                cluster.setNumberOfSpectra(parseIntegerValueString(lineCluster[15]));
                cluster.setProjects(new HashSet<String>(parseStringValues(lineCluster[17])));
                cluster.setProjectOnPeptideWithHighestRatio(new HashSet<String>(parseStringValues(lineCluster[19])));
                cluster.setMultipleHighRankingPeptideSequences(parseBooleanString(lineCluster[20]));
                cluster.setNumberOfDistinctPeptideSequences(parseIntegerValueString(lineCluster[21]));
                cluster.setNumberOfPsms(parseIntegerValueString(lineCluster[22]));
                cluster.setSpeciesInTaxonomyId(new HashSet<String>(parseStringValues(lineCluster[24])));
                cluster.setSpeciesOnPeptideWithHighestRatioInTaxonomyId(new HashSet<String>(parseStringValues(lineCluster[26])));
                cluster.setHighestRatio(parseFloatValueString(lineCluster[27]));

                cluster.setPeptideSequenceWithHighestRatio(parseStringValue(lineCluster[28]));
                cluster.setPeptideCountWithHighestRatio(parseIntegerValueString(lineCluster[29]));
                cluster.setSecondPeptideSequenceWithHighestRatio(parseStringValue(lineCluster[30]));
                cluster.setSecondPeptideCountWithHighestRatio(parseIntegerValueString(lineCluster[31]));

                cluster.setThirdPeptideSequenceWithHighestRatio(parseStringValue(lineCluster[32]));
                cluster.setThirdPeptideCountWithHighestRatio(parseIntegerValueString(lineCluster[33]));

                cluster.setFourPeptideSequenceWithHighestRatio(parseStringValue(lineCluster[34]));
                cluster.setFourPeptideCountWithHighestRatio(parseIntegerValueString(lineCluster[35]));
                cluster.setFileName(parseStringValue(lineCluster[36]));
            }
        }

        return cluster;

    }

    /**
     * parse an String value
     * @param value the value to be parse
     * @return the String value
     */
    private String parseStringValue(String value){
        if(value != null && value.length() > 0 && !value.equalsIgnoreCase(SpectraClusterAnnotationUtils.NA))
                return value;
        return null;
    }

    private Float parseFloatValueString(String value){
        if(value != null && value.length() > 0 && !value.equalsIgnoreCase(SpectraClusterAnnotationUtils.NA)){
            return Float.valueOf(value);
        }
        return null;
    }

    private Integer parseIntegerValueString(String value){
        if(value != null && value.length() > 0 && !value.equalsIgnoreCase(SpectraClusterAnnotationUtils.NA)){
            return Integer.valueOf(value);
        }
        return null;
    }

    private Boolean parseBooleanString(String value){
        if(value != null && value.length() > 0 && !value.equalsIgnoreCase(SpectraClusterAnnotationUtils.NA)){
            return Boolean.parseBoolean(value);
        }
        return null;
    }


    private List<String> parseStringValues(String line) {
        List<String> values = new ArrayList<String>();
        if(line != null && line.length() > 0 && !line.equalsIgnoreCase(SpectraClusterAnnotationUtils.NA)){
            String[] stringValues = line.trim().split(",");
            int len = stringValues.length;
            for(int i = 0; i < len; i++) {
                if(stringValues[i] != null && stringValues[i].length() > 0){
                    values.add(stringValues[i]);
                }
            }
        }

        return values;
    }
}
