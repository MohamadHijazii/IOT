package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Search {
    private Technology parameters;
    public ObservableList<Technology> result;
    public ArrayList<Technology> technologies;

    public Search(Det range, String topology, Det batteryLife, boolean security, Det simplicity, Det cost, Det latency) {
        parameters = new Technology(range,new String[]{topology},batteryLife,security,simplicity,cost,latency);
        result = FXCollections.observableArrayList();
        technologies = DB.technologies;
    }

    public ObservableList<Technology> filter(){
        technologies.forEach(t -> {
            if(parameters.acceptV2(t)){
                t.setAccuracy(100);
                t.setAccuracy(parameters);
                result.add(t);
            }
        });
        return result;
    }




}
