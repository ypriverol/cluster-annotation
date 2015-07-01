package uk.ac.ebi.pride.spectracluster.annotations.io;

import org.junit.Test;
import uk.ac.ebi.pride.spectracluster.annotations.data.AnnotatedSpectraCluster;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

public class SpectraClusterFileParsingExecutableTest {

    private final ExecutorService threadPool = Executors.newFixedThreadPool(20);

    File spectraFile = null;

    @org.junit.Before
    public void setUp() throws Exception {
        URL resource = SpectraClusterFileParsingExecutableTest.class.getClassLoader().getResource("final.csv");
        spectraFile = new File(resource.toURI());
    }

    @Test
    public void readFile(){
        List<AnnotatedSpectraCluster> clusters = new ArrayList<AnnotatedSpectraCluster>();
        SpectraClusterFileParsingExecutable spectrumReader = new SpectraClusterFileParsingExecutable(spectraFile, clusters);
        spectrumReader.run();
        clusters = spectrumReader.retrieveClusters();
        assertEquals(clusters.size(), 99);
    }
    @org.junit.After
    public void tearDown() throws Exception {

    }
}