package controller;

import java.util.ArrayList;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class AlertHelper {

    private static Alert alert = null;

    public static void InitializeAlert(){
        if(alert == null){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Preparing ....");
        }
        alert.show();
        alert.close();
        //alert.setResizable(true);
        alert.setHeight(250);
        alert.setWidth(450);
    }

    public static void ErrorAlert(String content){
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setContentText(content);
        alert.show();
    }

    public static void InformationAlert(String content){
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setContentText(content);
        alert.show();
    }

    public static boolean ConfirmationAlert(String content){
        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.setContentText(content);
        Optional<ButtonType> action = alert.showAndWait();
        System.out.println(alert.getHeight());
        System.out.println(alert.getWidth());
        return  action.get() == ButtonType.OK;
    }


    public static void WarningAlert(String content){
        alert.setAlertType(Alert.AlertType.WARNING);
        alert.setContentText(content);
        alert.show();
    }

    public static boolean emptyField(TextField t){
        return (t.getText().equals(""));
    }

    public static Integer intField(TextField t){
        try {
            int c = Integer.parseInt(t.getText());
            return c;
        }catch (Exception e){
            return null;
        }
    }

    
	public static<T> ObservableList getObservable(ArrayList<T> lo){
            ObservableList<T> ret = FXCollections.observableArrayList();
            System.out.println(lo == null);
        for (int i = 0; i < lo.size(); i++) {
            ret.add(lo.get(i));
        }
        return ret;
    }
}
