package it.polito.tdp.spellchecker.controller;
	
import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		Dictionary d = new Dictionary();
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SpellChecker.fxml"));
			BorderPane root = (BorderPane)loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			SpellCheckerController controller = loader.getController();
			
			controller.setDictionary(d);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
