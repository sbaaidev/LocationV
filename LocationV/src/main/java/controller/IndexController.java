package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class IndexController {
	Main main;
	Stage stage;
	
	public void setMain(Main main,Stage stage){
		this.main=main;
		this.stage=stage;
	}
	
	@FXML
	public void minimiz() {
		stage.setIconified(true);
	}
	@FXML
	public void close() {
		stage.close();
	}

    

}
