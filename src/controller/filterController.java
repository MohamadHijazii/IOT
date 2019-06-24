package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;
import view.Main;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class filterController implements Initializable {

    @FXML
    private ComboBox<Det> range;

    @FXML
    private ComboBox<String> topology;

    @FXML
    private ComboBox<Det> battery;

    @FXML
    private CheckBox security;

    @FXML
    private ComboBox<Det> simplicity;

    @FXML
    private ComboBox<Det> cost;

    @FXML
    private ComboBox<Det> latency;

    @FXML
    private ImageView img;

    @FXML
    private TableView<Technology> tb;

    @FXML
    private TableColumn<Technology, String> colname;

    @FXML
    private TableColumn<Technology, String> colRange;

    @FXML
    private TableColumn<Technology, String> colTopology;

    @FXML
    private TableColumn<Technology, String> colBattery;

    @FXML
    private TableColumn<Technology, String> colSec;

    @FXML
    private TableColumn<Technology, String> colSimp;

    @FXML
    private TableColumn<Technology, String> colCost;

    @FXML
    private TableColumn<Technology, String> colLatency;

    @FXML
    private TableColumn<Technology, Integer> acc;

    @FXML
    void delete(ActionEvent event) {

    }

    private Search getSearch(){
        Search search = new Search(
          range.getValue(),
          topology.getValue(),
          battery.getValue(),
          security.isSelected(),
          simplicity.getValue(),
          cost.getValue(),
          latency.getValue()
        );
        return search;
    }

    @FXML
    void filter(ActionEvent event) {
        Search s = getSearch();
        ObservableList<Technology> result = s.filter();
        setColumns();
        tb.setItems(result);
        tb.getSortOrder().add(acc);
        acc.setSortType(TableColumn.SortType.DESCENDING);
        tb.refresh();
    }

    @FXML
    void back(ActionEvent event) {
        Main.redirect("Main.fxml",event);
    }
    @FXML
    void reset(ActionEvent event) {
        range.getSelectionModel().clearSelection();
        topology.getSelectionModel().clearSelection();
        battery.getSelectionModel().clearSelection();
        simplicity.getSelectionModel().clearSelection();
        cost.getSelectionModel().clearSelection();
        latency.getSelectionModel().clearSelection();
        security.setSelected(false);
    }

    private void setComboBox(ComboBox<Det> box, ArrayList<Det> ld){
        box.getItems().addAll(ld);
        //box.setValue(ld.get(0));
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
        acc.setCellValueFactory(new PropertyValueFactory<>("accuracy"));

        tb.getSelectionModel().selectedItemProperty().addListener((obs,old,newItem) ->{
            File im = new File(newItem.getImage());
            img.setImage(new Image(im.toURI().toString()));
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Details d = Details.get_instance();
        {
            setComboBox(range,d.getRange());
            topology.getItems().addAll(d.getTopology());
            topology.getItems().remove(0);
            setComboBox(battery,d.getBtteryLife());
            setComboBox(simplicity,d.getSimplicity());
            setComboBox(cost,d.getCost());
            setComboBox(latency,d.getLatency());}

    }
}
