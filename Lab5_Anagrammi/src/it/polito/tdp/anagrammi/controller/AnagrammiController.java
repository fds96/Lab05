/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtIniziale"
    private TextField txtIniziale; // Value injected by FXMLLoader

    @FXML // fx:id="txtResultOK"
    private TextArea txtResultOK; // Value injected by FXMLLoader

    @FXML // fx:id="txtResultNO"
    private TextArea txtResultNO; // Value injected by FXMLLoader

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	for(String s : model.doAnagramma(txtIniziale.getText())) {
    		if(model.isCorrect(s))
    			txtResultOK.appendText(s+"\n");
    		else txtResultNO.appendText(s+"\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResultOK.clear();
    	txtResultNO.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtIniziale != null : "fx:id=\"txtIniziale\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResultOK != null : "fx:id=\"txtResultOK\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResultNO != null : "fx:id=\"txtResultNO\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model=model;
    }
}
