package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Det;
import model.Details;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TechnologyController implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private ChoiceBox<Det> range;

    @FXML
    private ChoiceBox<Det> topology;

    @FXML
    private ChoiceBox<Det> battery;

    @FXML
    private CheckBox sec;

    @FXML
    private ChoiceBox<Det> simplicity;

    @FXML
    private ChoiceBox<Det> cost;

    @FXML
    private ChoiceBox<Det> latency;


    @FXML
    private Button Create;


    @FXML
    void createTechnology(ActionEvent event) {

    }

    private void setChoiceBox(ChoiceBox<Det> box,ArrayList<Det> ld){
        for (int i = 0; i < ld.size(); i++) {
            box.getItems().add(ld.get(i));
        }
        box.setValue(ld.get(0));
    }

    private Det getSelected(ChoiceBox<Det> box){
        return box.getValue();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AlertHelper.InitializeAlert();
        Details d = Details.get_instance();
        setChoiceBox(range,d.getRange());
        setChoiceBox(topology,d.getTopology());
        setChoiceBox(battery,d.getBtteryLife());
        setChoiceBox(simplicity,d.getSimplicity());
        setChoiceBox(cost,d.getCost());
        setChoiceBox(latency,d.getLatency());
    }
}
