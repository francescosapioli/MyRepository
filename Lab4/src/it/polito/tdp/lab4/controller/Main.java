package it.polito.tdp.lab4.controller;
	
import it.polito.tdp.lab4.model.Model;
import it.polito.tdp.lab4.model.Model1;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		Model1 model = new Model1();
		
		try {
			
			FXMLLoader loader =new FXMLLoader(getClass().getResource("Lab4.fxml"));
			
			BorderPane root = (BorderPane)loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Lab4Controller controller = loader.getController();
			controller.setModel(model);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
