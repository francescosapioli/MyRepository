package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.HashSet;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class SpellCheckerController {
	
	private Dictionary dic;
	
	//variabili per il controllo delle prestazioni
	double media = 0;
	long sum =0;
	long num = 0;
	
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbLanguage;

    @FXML
    private TextArea txtTextUnchecked;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextFlow txtTextChecked;

    @FXML
    private Label lblStatus;

    @FXML
    private Button btnClearText;

    @FXML
    private Label lblTime;

    @FXML
    void doClearText(ActionEvent event) {
    	this.cmbLanguage.setValue("");
    	this.txtTextUnchecked.clear();
    	this.txtTextChecked.getChildren().clear();
    	this.lblStatus.setText("No text inserted.");
    	this.lblTime.setText("Here will be the time to complete the spell check.");
    	

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	this.txtTextChecked.getChildren().clear();
    	
    	if(this.cmbLanguage.getValue()==null)
    		this.lblStatus.setText("You did not insert the language.");
    	else
    	{
    		if(this.txtTextUnchecked.getText().trim().compareTo("")==0)
    			this.lblStatus.setText("You did not insert the text.");
    		else
    		{
    			//prendo il tempo
    			long t0 = System.nanoTime();
    			
    			if(this.cmbLanguage.getValue().compareTo("English")==0)
        			dic = new EnglishDictionary();
        		else
        			dic = new ItalianDictionary();
        		
    			dic.loadDictionary();
        		
    			List<String> listUnchecked = new LinkedList<String>();
    			String txtUnchecked = this.txtTextUnchecked.getText().toLowerCase();
    			StringTokenizer st = new StringTokenizer(txtUnchecked, " ");
    			while(st.hasMoreTokens()){
    				listUnchecked.add(st.nextToken());
    			}
    			List<RichWord> txtChecked = dic.spellCheckText(listUnchecked);
    			
    			boolean flag=false;
    			
    			Text richText = new Text("");
    			for(RichWord r : txtChecked){
    				if(r.isCorrect())
    					richText = new Text(r.getWord()+" ");
    				else{
    					richText = new Text(r.getWord()+" ");
    					richText.setFill(Color.RED);
    					flag=true;
;    				}
    				this.txtTextChecked.getChildren().add(richText);
    				
    				
    				
    			}
    			
				this.lblTime.setText("Time:"+(double)(System.nanoTime()-t0)/1000000000);
				
				//inizio controllo prestazioni 
				sum+=System.nanoTime()-t0;
				num++;
				media=(double)sum/(double)num;
				System.out.println("media:"+media+"---num:"+num);
				//fine controllo prestazioni
				
				listUnchecked.clear();
				txtUnchecked = "";
				
				if(flag)
					this.lblStatus.setText("The text contains errors.");
				else
					this.lblStatus.setText("The text is correct.");
    			
    			
    		}
    		
    		
    		
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
        
        this.cmbLanguage.getItems().add("English");
        this.cmbLanguage.getItems().add("Italian");
        
        

    }

	public void setDictionary(Dictionary dic) {
		this.dic=dic;
		
	}
}
