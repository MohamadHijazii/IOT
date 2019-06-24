package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
	@FXML
    private Label lb;

    @FXML
    void create(ActionEvent event) {
    	try {
    		lb.setText("hello");
    		Main.redirect("Technology.fxml",event);
        	lb.setText("!!!");
    	}
    	catch(Exception e) {
    		lb.setText("error");
    		Main.redirect("filter.fxml", event);
    	}
    }

    @FXML
    void filter(ActionEvent event) {

        Main.redirect("filter.fxml",event);
    }
	
}
