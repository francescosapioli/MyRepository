package it.polito.tdp.lab3.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab3.model.Corso;
import it.polito.tdp.lab3.model.Model;
import it.polito.tdp.lab3.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {
	
	private Model model;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private ComboBox<Corso> cmbCorso;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnCompleta;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCerca;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCerca(ActionEvent event) {
    	
    	if(this.cmbCorso.getValue() != null && this.txtMatricola.getText().compareTo("")==0){ 
    		List<Studente> stud = this.model.iscrittiCorso(this.cmbCorso.getValue());
    		String txt = "";
    		for(Studente s : stud){
    			txt += s.toString() + "\n";
    		}
    		this.txtResult.setText(txt);
    	}
    	if(this.cmbCorso.getValue() == null && this.txtMatricola.getText().compareTo("")!=0){
    		List<Corso> corsi = model.iscrittoCorsi(Integer.parseInt(this.txtMatricola.getText()));
    		if(corsi.size()<1)
    			this.txtResult.setText("La matricola non corrisponde a nessuno degli studenti presenti nel database.");
    		else{
    			String txt = "";
    			for(Corso c : corsi){
    				txt += c.getNome() + "\n";
    			}
    			this.txtResult.setText(txt);
    		}
    		
    	}
    	if(this.cmbCorso.getValue() != null && this.txtMatricola.getText().compareTo("")!=0){
    		
    		if(model.isIscritto(Integer.parseInt(this.txtMatricola.getText()), this.cmbCorso.getValue().getCodins()))
    		     this.txtResult.setText("Lo studente e' iscritto al corso selezionato.");
    	    else
    	    	this.txtResult.setText("Lo studente non e' iscritto al corso selezionato.");
    	}
    	if(this.cmbCorso.getValue() == null && this.txtMatricola.getText().compareTo("")==0)
    	this.txtResult.setText("ERRORE");

    }

    @FXML
    void doClear(ActionEvent event) {
    	
    	this.cmbCorso.setValue(null);
    	this.txtCognome.setText("");
    	this.txtMatricola.setText("");
    	this.txtNome.setText("");
    	this.txtResult.setText("");

    }

    @FXML
    void doCompleta(ActionEvent event) {
    	if(this.txtMatricola == null || this.txtMatricola.getText().compareTo("")==0)
    		this.txtResult.setText("Il campo matricola è vuoto.");
    	else{
    		Studente s = this.model.doCompleta(Integer.parseInt(this.txtMatricola.getText()));
    		if(s == null)
    			this.txtResult.setText("la matricola inserita non corrisponde a nessuno studente.");
    		else{
    			this.txtNome.setText(s.getNome());
    			this.txtCognome.setText(s.getCognome());
    		}
    	}
    	
    	

    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	if(model.doIscrivi(Integer.parseInt(this.txtMatricola.getText()), this.cmbCorso.getValue().getCodins()))
    		this.txtResult.setText("Lo studente e' stato iscirtto con successo.");
    	else
    		this.txtResult.setText("Non e' stato possibile iscrivere lo studente al corso.");

    }

    @FXML
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert cmbCorso != null : "fx:id=\"cmbCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCompleta != null : "fx:id=\"btnCompleta\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        
        
        this.txtResult.setEditable(false);
        
        
        

    }

	public void setModel(Model model) {
		this.model = model;
		
		Corso corsoFinto = new Corso("");
        this.cmbCorso.getItems().add(corsoFinto);
        this.cmbCorso.getItems().addAll(this.model.tuttiICorsi());
		
	}
}
