package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbLanguage; //da modificare con gli opportuini oggetti (dizionari)

    @FXML
    private TextArea txtTextUnchecked;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextArea txtTextChecked;

    @FXML
    private Label lblStatus;

    @FXML
    private Button btnClearText;

    @FXML
    private Label lblTime;

    @FXML
    void doClearText(ActionEvent event) {
    	
    	this.txtTextUnchecked.clear();
    	this.txtTextChecked.clear();
    	
    	

    }

    @FXML
    void doSpellCheck(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert cmbLanguage != null : "fx:id=\"cmbLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTextUnchecked != null : "fx:id=\"txtTextUnchecked\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTextChecked != null : "fx:id=\"txtTextChecked\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblStatus != null : "fx:id=\"lblStatus\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        
        //setto la comboBox
        this.cmbLanguage.getItems().addAll("English", "Italian");//da modificare con gli opportuini oggetti (dizionari)
        this.cmbLanguage.setValue("English");//da modificare con gli opportuini oggetti (dizionari)
        
        //blocco la seconda textArea altrimenti ci si puo' scrivere sopra
        this.txtTextChecked.setEditable(false);
        

    }
}
