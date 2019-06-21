package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Det;

import java.net.URL;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
