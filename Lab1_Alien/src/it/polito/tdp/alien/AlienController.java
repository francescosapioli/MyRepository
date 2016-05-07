package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	AlienDictionary dizionario;
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    	dizionario= new AlienDictionary();
    	
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String parola = txtWord.getText().toLowerCase();
    	
    	if(parola.compareTo("")==0) // controllo che lutente abbia inserito qualcosa
    		txtResult.setText("non hai inserito nessuna parola");
    	else{
    		if(parola.compareTo("aaaaaaaaaa")<0 || parola.compareTo("zzzzzzzzzz")>0)
    			txtResult.setText("hai inserito dei caratteri non consentiti");
    	    else{
    		    if(parola.contains(" ") && parola.substring(0, 1).compareTo("")!=0 
    	    	&& parola.substring(parola.length()-1).compareTo(" ")!=0)
    	    	{//richiesta di inserimento di una nuova parola nel dizionario
    		    	
    		    	String parolaSplittata[];
    		    	parolaSplittata = parola.split(" ");
    		    	
    		    	//System.out.println(parolaSplittata[0]+" "+parolaSplittata[1]);
    		    	
    		    	dizionario.addWord(parolaSplittata[0], parolaSplittata[1]);


    		    	txtResult.setText("parola aggiunta");
    			
    	    	}
    	    	else{// richiesta traduzione
    	    		if(dizionario.translateWord(parola)!=null)
    	    			txtResult.setText(dizionario.translateWord(parola));
    	    		else
    	    		   txtResult.setText("la parola cercata non e' presente nel dizionario");
    			
    		    }
    		}
    	}
    	
    	
    	    	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	txtWord.setText("");
    	txtResult.setText("");

    }
    
}
