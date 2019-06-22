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

import javax.swing.SingleSelectionModel;
import javax.swing.plaf.basic.BasicTreeUI;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TechnologyController implements Initializable {

    private ObservableList<Technology> technologies;
    private ObservableList<String> topos;

    private Technology selected;
    @FXML
    private TextField name;
    @FXML
    private TextField search;

    @FXML
    private ComboBox<Det> range;

    @FXML
    private ListView<String> topology;

    @FXML
    private ComboBox<Det> battery;

    @FXML
    private CheckBox sec;

    @FXML
    private ComboBox<Det> simplicity;

    @FXML
    private ComboBox<Det> cost;

    @FXML
    private ComboBox<Det> latency;


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
        try{
        DB db = DB.instance();
        db.removeTech(tb.getSelectionModel().selectedItemProperty().get());
        loadTech();}
        catch (Exception e){}

    }

    @FXML
    void createTechnology(ActionEvent event) {
        if(Helper.emptyField(name)){
            Helper.error("Pleaze enter the name!");
            return;
        }

        topos = topology.getSelectionModel().getSelectedItems();
        String [] top = new String[topos.size()];
        for (int i = 0; i < topos.size(); i++) {
            top[i] = topos.get(i);

        }


        Technology t = new Technology(name.getText(),
                getSelected(range),
                top,
                getSelected(battery),
                sec.isSelected(),
                getSelected(simplicity),
                getSelected(cost),
                getSelected(latency));
        Helper.informe("A new technologt "+t+" is added");
        loadTech();

    }

    private void setComboBox(ComboBox<Det> box,ArrayList<Det> ld){
        box.getItems().addAll(ld);
        //box.setValue(ld.get(0));
    }

    private Det getSelected(ComboBox<Det> box){
        return box.getValue();
    }

    private void setColumns(){
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRange.setCellValueFactory(new PropertyValueFactory<>("range"));
        colTopology.setCellValueFactory(new PropertyValueFactory<>("topos"));
        colBattery.setCellValueFactory(new PropertyValueFactory<>("batteryLife"));
        colSec.setCellValueFactory(new PropertyValueFactory<>("security"));
        colSimp.setCellValueFactory(new PropertyValueFactory<>("simplicity"));
        colCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        colLatency.setCellValueFactory(new PropertyValueFactory<>("latency"));
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Details d = Details.get_instance();
        {setComboBox(range,d.getRange());
        iniTopo();
        setComboBox(battery,d.getBtteryLife());
        setComboBox(simplicity,d.getSimplicity());
        setComboBox(cost,d.getCost());
        setComboBox(latency,d.getLatency());}

        tb.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        setColumns();
        loadTech();


    }

    private void iniTopo(){
        Details d = Details.get_instance();
        topology.getItems().addAll(d.getTopology());
        topology.getItems().remove(0);
        topology.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    private boolean matchName(String container,String sub){
        return  container.contains(sub);
    }



    private void loadTech() {
        technologies = FXCollections.observableArrayList();
        technologies.addAll(DB.technologies);
        tb.setItems(technologies);

    }
}
