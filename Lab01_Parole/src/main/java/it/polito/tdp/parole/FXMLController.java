package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtResultTempi;

    @FXML
    private Button btnReset;
    
    @FXML
    void doCancella(ActionEvent event) {
    	elenco.removeParola(this.txtResult.getSelectedText());
    	
    	this.txtResult.clear();
    	LinkedList<String> elencoOrdinato = new LinkedList<String>();
    	elencoOrdinato = (LinkedList<String>) elenco.getElenco();
    	
    	for(String s : elencoOrdinato)
    		txtResult.appendText(s+"\n");
    	
    	this.txtResultTempi.appendText(Long.toString(System.nanoTime())+"\n");
    	
    	long tempi = System.nanoTime();
    	txtResultTempi.appendText(String.valueOf(tempi+"\n"));
    }

    @FXML
    void doInsert(ActionEvent event) {
    	txtResult.clear();
    	
    	for(int i=0; i<txtParola.getText().length(); i++) {
    		if(!Character.isAlphabetic(txtParola.getText().charAt(i))) {
    			txtResult.appendText("Carattere non valido");
    		}
    	}
    	
    	String parolaDaInserire = txtParola.getText();
    	
    	//VERSIONE LINKEDLIST
    	
    	elenco.addParola(parolaDaInserire);  // posso farlo su un'unica riga btw
    	
    	LinkedList<String> elencoOrdinato = new LinkedList<String>();
    	elencoOrdinato = (LinkedList<String>)elenco.getElenco();
    	
    	for(String s : elencoOrdinato)
    		txtResult.appendText(s+"\n");
    	
    	//VERSIONE ARRAYLIST
    	
    	/*elenco.addParolaArray(parolaDaInserire);
    	
    	ArrayList<String> elencoArrayOrdinato = new ArrayList<String>();
    	elencoArrayOrdinato = (ArrayList<String>) elenco.getElencoArray();
    	
    	for(String s : elencoArrayOrdinato)
    		txtResult.appendText(s+"\n");*/
    	
    	long tempi = System.nanoTime();
    	txtResultTempi.appendText(String.valueOf(tempi+"\n"));
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	elenco.reset();
    	
    	// Ha senso qui?
    	/*long tempi = System.nanoTime();
    	txtResultTempi.appendText(String.valueOf(tempi+"\n"));*/
    	
    	txtResultTempi.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
