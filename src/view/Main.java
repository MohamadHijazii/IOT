package view;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DB;
import model.Details;
import model.Technology;

import java.util.Objects;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Technology.fxml"));
			Scene scene = new Scene(root,1000,600);
//			scene.getStylesheets().add(getClass().getResource("styles/Style.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		DB db = DB.instance();
		db.readDetails();
		db.ReadTech();
		System.out.println(DB.technologies);
		launch(args);
		System.out.println("hello world!");
		db.WriteTech();
		db.writeDetails();
	}
}
