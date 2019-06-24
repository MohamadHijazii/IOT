package view;
	
import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DB;


public class Main extends Application {

	public static void redirect(String file,ActionEvent event) {
		try {
			Main m = new Main();
			m.r(file,event);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	private void r(String file, ActionEvent event) throws IOException {
		Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource(file));
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}





	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("styles/Style.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
		try {

		DB db = DB.instance();
		db.readDetails();
		db.ReadTech();
		launch(args);
		db.WriteTech();
		db.writeDetails();}
		catch(Exception err) {
			JOptionPane.showInputDialog(null,err.toString(),JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
