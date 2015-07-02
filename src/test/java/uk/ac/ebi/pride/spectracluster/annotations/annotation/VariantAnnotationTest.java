package uk.ac.ebi.pride.spectracluster.annotations.annotation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.ac.ebi.pride.jfasta.FastaReader;
import uk.ac.ebi.pride.spectracluster.annotations.data.AnnotatedSpectraCluster;
import uk.ac.ebi.pride.spectracluster.annotations.io.SpectraClusterFileParsingExecutable;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VariantAnnotationTest {

    File spectraFile;
    List<AnnotatedSpectraCluster> clusters = null;

    @Before
    public void setUp() throws Exception {
        URL resource = ContaminantAnnotationTest.class.getClassLoader().getResource("final.csv");
        spectraFile = new File(resource.toURI());
        clusters = new ArrayList<AnnotatedSpectraCluster>();
        SpectraClusterFileParsingExecutable spectrumReader = new SpectraClusterFileParsingExecutable(spectraFile, clusters);
        spectrumReader.run();
        clusters = spectrumReader.retrieveClusters();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAnnotator() throws Exception {

        VariantAnnotation variantAnnotation = VariantAnnotation.getInstance();

        for(AnnotatedSpectraCluster cluster: clusters){
            variantAnnotation.annotator(cluster);
        }

        assertEquals(clusters.size(), 99);
    }
}