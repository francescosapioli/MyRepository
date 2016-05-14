package it.polito.tdp.lab4.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab4.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Lab4Controller {
	
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnExecute;

    @FXML
    void doExecute(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Lab4.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Lab4.fxml'.";
        assert btnExecute != null : "fx:id=\"btnExecute\" was not injected: check your FXML file 'Lab4.fxml'.";
        
        this.txtResult.setEditable(false);

    }

	public void setModel(Model model) {
		
		this.model = model;
	}
}
