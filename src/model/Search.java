package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

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
        for (Technology t : technologies) {
            if(parameters.acceptV2(t))
                result.add(t);
        }
        return result;
    }




}
