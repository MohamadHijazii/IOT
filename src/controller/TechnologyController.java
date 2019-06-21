package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DB;
import model.Det;
import model.Details;
import model.Technology;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TechnologyController implements Initializable {

    private ObservableList<Technology> technologies;

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
    private TableView<Technology> tb;

    @FXML
    private TableColumn<Technology, String> colname;

    @FXML
    private TableColumn<Technology, Det> colRange;

    @FXML
    private TableColumn<Technology, Det> colTopology;

    @FXML
    private TableColumn<Technology, Det> colBattery;

    @FXML
    private TableColumn<Technology, Det> colSec;

    @FXML
    private TableColumn<Technology, Det> colSimp;

    @FXML
    private TableColumn<Technology, Det> colCost;

    @FXML
    private TableColumn<Technology, Det> colLatency;

    @FXML
    private MenuItem deleteUsers;


    @FXML
    private void delete(){

    }

    @FXML
    void createTechnology(ActionEvent event) {
        if(Helper.emptyField(name)){
            Helper.error("Pleaze enter the name!");
            return;
        }

        Technology t = new Technology(name.getText(),
                getSelected(range),
                getSelected(topology),
                getSelected(battery),
                sec.isSelected(),
                getSelected(simplicity),
                getSelected(cost),
                getSelected(latency));
        Helper.informe("A new technologt "+t+" is added");
        loadTech();

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

    private void setColumns(){
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRange.setCellValueFactory(new PropertyValueFactory<>("range"));
        colTopology.setCellValueFactory(new PropertyValueFactory<>("topology"));
        colBattery.setCellValueFactory(new PropertyValueFactory<>("batteryLife"));
        colSec.setCellValueFactory(new PropertyValueFactory<>("security"));
        colSimp.setCellValueFactory(new PropertyValueFactory<>("simplicity"));
        colCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        colLatency.setCellValueFactory(new PropertyValueFactory<>("latency"));
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Details d = Details.get_instance();
        {setChoiceBox(range,d.getRange());
        setChoiceBox(topology,d.getTopology());
        setChoiceBox(battery,d.getBtteryLife());
        setChoiceBox(simplicity,d.getSimplicity());
        setChoiceBox(cost,d.getCost());
        setChoiceBox(latency,d.getLatency());}

        tb.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        setColumns();
        loadTech();


    }

    private void loadTech() {
        technologies = FXCollections.observableArrayList();
        technologies.addAll(DB.technologies);
        tb.setItems(technologies);

    }
}
