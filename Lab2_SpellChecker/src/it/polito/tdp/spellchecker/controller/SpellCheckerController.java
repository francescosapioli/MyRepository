package it.polito.tdp.spellchecker.controller;

import java.awt.Color;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.EnglishDictionary;
import it.polito.tdp.spellchecker.model.ItalianDictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class SpellCheckerController {
	
	
	private Dictionary dictionary;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Dictionary> cmbLanguage;

    
    
    
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
    
    
    

    public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	@FXML
    void doClearText(ActionEvent event) {
    	
    	this.txtTextUnchecked.clear();
    	this.txtTextChecked.clear();
    	
    	

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	long t0 = System.currentTimeMillis();
    	
    	
    	this.dictionary=this.cmbLanguage.getValue();
    	
    	
    	if(this.txtTextUnchecked.getText().compareTo("")==0)
    		this.lblStatus.setText("You did not insert the text.");
    	else{
    		this.dictionary.loadDictionary();
    		
    		LinkedList<String> txtUncheckedList = new LinkedList<String>();
    		//String txtUncheckedArray[] = this.txtTextUnchecked.getText().toLowerCase().split(" ");
    		
    		StringTokenizer st = new StringTokenizer(this.txtTextUnchecked.getText(), " ");
    		
    		while(st.hasMoreTokens()){
    			txtUncheckedList.add(st.nextToken().toLowerCase());
    		}
    		
    		
    		/*for(int i=0; i<txtUncheckedArray.length;i++){
    			
    			
    			
    			
    			
    			txtUncheckedList.add(txtUncheckedArray[i]);
    			
    			
    		}*/
    		/*for(String s : txtUncheckedList ){
    			
    			
    			s.replace(".", " ");
    			s.replace(":", "");
    			s.replace(",", "");
    			s.replace(";", "");
    			s.replace("-", "");
    			s.replace("_", "");
    			s.replace("?", "");
    			s.replace("!", "");
    			s.replace("<", "");
    			s.replace(">", "");
    			
    			
    		}*/
    		
    		List<RichWord> result = this.dictionary.spellCheckText(txtUncheckedList);
    		
    		String txtChecked= "";
    		
    		for(RichWord s : result){
    			if(s.isCorrect()==false)
    				txtChecked = txtChecked+" "+s.getWord().toUpperCase();//per ora che non so come impostare il testo
    			                                                        //rosso, lo metto MAIUSCOLO
    			else
    				txtChecked = txtChecked+" "+s.getWord().toLowerCase();
    			
    		}
    		
    		
    		
    		
    		this.txtTextChecked.setText(txtChecked);
    		//il testo dovrebbe essere rosso ma  non ho idea di coma si faccia 
    		
    		if(txtChecked.compareTo("")==0)
    			this.lblStatus.setText("Your text does not contain errors.");
    		else
    			this.lblStatus.setText("Your text contains errors");
    		
    		this.lblTime.setText("time:"+((double)System.currentTimeMillis()-(double)t0)/1000);
    		
    	}
    	

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
        EnglishDictionary ed = new EnglishDictionary();
        ItalianDictionary id = new ItalianDictionary();
        this.cmbLanguage.getItems().addAll(ed, id);
        this.cmbLanguage.setValue(ed);
        
        //blocco la seconda textArea altrimenti ci si puo' scrivere sopra
        this.txtTextChecked.setEditable(false);
        

    }
}
