package it.polito.tdp.lab4.controller;

import java.awt.Color;
import java.awt.List;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.lab4.model.Model;
import it.polito.tdp.lab4.model.Model1;
import it.polito.tdp.lab4.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Lab4Controller {
	
	
	//Model model;
	Model1 model1;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private TextFlow txtResult;

    @FXML
    private Button btnExecute;
    
    @FXML
    private Button btnReset;

    @FXML
    void doExecute(ActionEvent event) {
    	
    	Text t = new Text("You did not insert the word.");
    	
    	if(this.txtWord.getText().compareToIgnoreCase("") == 0)
    		//this.txtResult.setText("You did not insert the word.");
    	    this.txtResult.getChildren().add(t);
    	else{
    		String word = this.txtWord.getText();
    		//java.util.List<String> result = new LinkedList<String>();
    		java.util.List<RichWord> result = new LinkedList<RichWord>();
    		//model.executePermutation(word, 0);
    		//result = model.getResult();
    		
    		//result = this.model1.findPermuatations(word);
    		result = this.model1.richPermutations(word);
    		//System.out.println(result.toString());
    		//String txtResult = "";
    		//for(String s : result){
    			//txtResult += s + "\n";
    		//}
    		//this.txtResult.setText(txtResult);
    		
    		Text txtResultCol = new Text("");
    		txtResultCol.setText("");
    		for(RichWord rw : result){
    			//txtResultCol.setText(rw.getWord());
    			//System.out.println(txtResultCol.getText());
    			txtResultCol = new Text(rw.getWord()+"\n");
    			if(rw.isCorrect() == true)
    				txtResultCol.setFill(javafx.scene.paint.Color.RED);
    			//System.out.println(txtResultCol);
    			//this.txtResult.appendText(txtResultCol.getText()+"\n");
    			this.txtResult.getChildren().add(txtResultCol);
    			//System.out.println(this.txtResult.getText());
    			
    		
    		}
    		
    		
    		word = "";
    		result.clear();
    		//txtResult.setText("");
    	}
    	
    	

    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Lab4.fxml'.";
       // assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Lab4.fxml'.";
        assert btnExecute != null : "fx:id=\"btnExecute\" was not injected: check your FXML file 'Lab4.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Lab4.fxml'.";
        
        //this.txtResult.setEditable(false);
       
        
         
        
    }

	public void setModel(Model1 model1) {
		
		this.model1 = model1;
	}
	
	
	
	  @FXML
	  void doReset(ActionEvent event) {
		  
		  this.txtResult.getChildren().clear();
		  this.txtWord.clear();
		
	  }
	  
	  
}
