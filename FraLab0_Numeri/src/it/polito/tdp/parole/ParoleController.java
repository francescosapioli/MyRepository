package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


//import it.polito.tdp.parole.model.Parole;
import it.polito.tdp.parole.model.WordSet;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	//Parole elenco ;
	WordSet wordSet;
	Integer numero;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private Button btnCancella;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML
    void doInsert(ActionEvent event) {

    	/*elenco.addParola( txtParola.getText() );
    	
    	String result = "" ;
    	
    	for(String p: elenco.getElenco())
    		result += p + "\n" ;
    	
    	txtResult.setText(result);
    	
    	txtParola.clear();
    	*/
    	numero = Integer.parseInt(txtParola.getText());
    	wordSet.generaParole(numero);
    	
    	
    	
    	long t1 = wordSet.cancella(0);
    	
    	
    	long t2 = wordSet.cancella(numero/2);
    	
    	
    	long t3 = wordSet.cancella(numero-1);
    	
    	
    	
    	txtResult.setText("cancello primo elemento: \n"+"tempo:"+t1+"\n"+
    			"cancello center elemento: \n"+"tempo:"+t2+"\n"+"cancello ultimo elemento: \n"+
    			"tempo:"+t3);
    	
    	txtParola.clear();
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	//elenco.reset() ;
    	for(int i=0;i<numero;i++){
    		wordSet.cancella(i);
    	}
    	txtResult.clear() ;

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";

       // elenco = new Parole() ;
        wordSet = new WordSet();
        
    }
}
