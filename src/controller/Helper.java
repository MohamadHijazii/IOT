package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Helper {

    public static boolean emptyField(TextField t){
        return (t.getText().equals(""));
    }

    public static void error(String context){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(context);
        alert.show();
    }

    public static void informe(String context){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(context);
        alert.show();
    }

    public static  <T>boolean comboNull(ComboBox<T> box){
        return box.getValue() == null;
    }
}
