package uk.ac.ebi.pride.spectracluster.annotations.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.spectracluster.annotations.data.AnnotatedSpectraCluster;

import java.io.File;
import java.util.List;

/**
 * @author Yasset Perez-Riverol (ypriverol@gmail.com)
 * @date 01/07/2015
 */
public class SpectraClusterFileParsingExecutable{

    public static final Logger logger = LoggerFactory.getLogger(SpectraClusterFileParsingExecutable.class);

    private final File clusteringFile;

    private List<AnnotatedSpectraCluster> clusters;

    public SpectraClusterFileParsingExecutable(File clusteringFile, List<AnnotatedSpectraCluster> clusters) {
        this.clusteringFile = clusteringFile;
        this.clusters = clusters;
    }

    public void run() {

        try {
            doWork();
        } catch (InterruptedException ie) {
            // do nothing with interrupted exception
            logger.warn("Clustering file parsing thread interrupted: {}", clusteringFile.getAbsolutePath());
        } catch (Exception e) {
            String msg = "Failed to parse clustering file: " + clusteringFile.getAbsolutePath();
            logger.error(msg, e);
            throw new IllegalStateException(msg, e);
        } finally {
        }
    }

    private void doWork() throws Exception {
        SpectraClusterFileReader clusteringFileReader = new SpectraClusterFileReader(clusteringFile);
        this.clusters = clusteringFileReader.readClustersIteratively(clusters);
    }

    public List<AnnotatedSpectraCluster> retrieveClusters(){
        return this.clusters;
    }
}
