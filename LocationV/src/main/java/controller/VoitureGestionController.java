package controller;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Marque;
import model.Voiture;
import services.InterServices;
import services.ServiceClass;

public class VoitureGestionController {
	Main main;
	Stage stage;
	@FXML
	ImageView imgv;
	@FXML
	TableView<Voiture> tableVoiture;
	@FXML
	TableColumn<String, Voiture> colMat;
	@FXML
	TableColumn<Marque, Voiture> colMarque;
	@FXML
	TableColumn<Double, Voiture> colPuissance;
	@FXML
	TableColumn<String, Voiture> colColeur;
	@FXML
	TableColumn<Double, Voiture> colPrix;
	@FXML
	Label marquelbl,modellbl,reservedlbl;
	
	static ObservableList<Voiture> listTable=FXCollections.observableArrayList();
	static InterServices services=ServiceClass.getService();
	public void initialize(){
		
		
		colMat.setCellValueFactory(new PropertyValueFactory<String,Voiture>("mat"));
		colMarque.setCellValueFactory(new PropertyValueFactory<Marque,Voiture>("marque"));
		colPuissance.setCellValueFactory(new PropertyValueFactory<Double,Voiture>("puissance"));
		colColeur.setCellValueFactory(new PropertyValueFactory<String,Voiture>("coleur"));
		colPrix.setCellValueFactory(new PropertyValueFactory<Double,Voiture>("prix"));
		setDataTable();
		tableVoiture.setItems(listTable);
		//tableVoiture.getSelectionModel().setR;
		ObservableList selectedCells = tableVoiture.getSelectionModel().getSelectedItems();
		selectedCells.addListener(new ListChangeListener() {
		    @Override
		    public void onChanged(Change c) {
		        System.out.println(tableVoiture.getSelectionModel().getSelectedItem().getMat());		        
		        Voiture v=services.getVoitureByMat(tableVoiture.getSelectionModel().getSelectedItem().getMat());
		        imgv.setImage(new Image("file:"+v.getImage()));
		        marquelbl.setText(v.getMarque().toString());
		        modellbl.setText(v.getModelv().toString());
		        reservedlbl.setText(String.valueOf(v.isReserved()));
		    }
		});
	}
	
	public void setMain(Main main ,Stage stage){
		this.main=main;
		this.stage=stage;
	}
	
	public static void setDataTable(){
		listTable.clear();
		for (Voiture v:services.getAllVoitures()){
			listTable.add(v);
		}
		
	}
	
	@FXML
	public void addVoiture(){
		main.addVoitureWindow();
	}
	

}
