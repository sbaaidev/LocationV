package controller;


import application.Main;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Created by it4omanHamza on 14/06/2016.
 */
public class MenuController {
	Main main;
	Stage stage;

	public void setMain(Main main, Stage stage) {
		this.main = main;
		this.stage = stage;
	}
	public void initialize() {
	
		
	}
	
	public void voitureGestionWindow(){
		main.voitureGestionWindow();
		
	}

	
}
