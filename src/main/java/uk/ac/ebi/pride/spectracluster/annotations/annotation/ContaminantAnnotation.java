package uk.ac.ebi.pride.spectracluster.annotations.annotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Yasset Perez-Riverol (ypriverol@gmail.com)
 * @date 01/07/2015
 */

public class ContaminantAnnotation {

    Map<String, String> contaminantDatabase;

    private static ContaminantAnnotation instance = null;

    private ContaminantAnnotation(Map<String, String> contaminantDatabase){
        this.contaminantDatabase = contaminantDatabase;
    }

    /**
     * Contaminant database constructor
     * @param contaminantDatabase
     * @return
     */
    public static ContaminantAnnotation getInstance(Map<String, String> contaminantDatabase){
        if(instance == null)
            instance = new ContaminantAnnotation(contaminantDatabase);
        return instance;
    }

    public Map<String, String> getContaminantDatabase() {
        return contaminantDatabase;
    }

    public void setContaminantDatabase(Map<String, String> contaminantDatabase) {
        this.contaminantDatabase = contaminantDatabase;
    }

    public List<String> annotator(String sequence){
        List<String> identifiers = new ArrayList<String>();
        if(sequence != null && sequence.length() > 0){
            for(Map.Entry entry: contaminantDatabase.entrySet()){
                String key = (String) entry.getKey();
                String contaminant = (String) entry.getValue();
                if(contaminant.contains(sequence)){
                    identifiers.add(key);
                }
            }
        }
        return identifiers;
    }
}
