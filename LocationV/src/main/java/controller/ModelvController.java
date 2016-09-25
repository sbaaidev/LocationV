package controller;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener.Change;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Marque;
import model.Modelv;
import model.Voiture;
import services.InterServices;
import services.ServiceClass;

public class ModelvController {
	@FXML
	TableView<Modelv> tableModel;
	@FXML
	TableColumn<Modelv, Long> colidmodel;
	@FXML
	TableColumn<Modelv, String> colnommodel;
	@FXML
	TextField txtNomModel;
	InterServices services=ServiceClass.getService();
	ObservableList<Modelv> listTablev=FXCollections.observableArrayList();
	Main main;
	Stage stage;
	static Marque marque;
	public void initialize(){
		colidmodel.setCellValueFactory(new PropertyValueFactory<Modelv,Long>("idModelv"));
		colnommodel.setCellValueFactory(new PropertyValueFactory<Modelv,String>("name"));
		setDataTabl();
		ObservableList selectedCells = tableModel.getSelectionModel().getSelectedItems();
		selectedCells.addListener(new ListChangeListener() {
		    @Override
		    public void onChanged(Change c) {
		        	        
		        Modelv v=tableModel.getSelectionModel().getSelectedItem();
		        txtNomModel.setText(v.getName());
		       
		    }
		});
		
	}
	public void setMain(Main main,Stage stage){
		this.main=main;
		this.stage=stage;			
	}
	
	public void setDataTabl(){	
			listTablev.clear();
			for(Modelv v:services.getMarqueById(marque.getIdMarque()).getModel()){
				listTablev.add(v);
				tableModel.setItems(listTablev);				
			}
		}	
	public void addModel(){
		services.addModelv(new Modelv(txtNomModel.getText(),marque));
		setDataTabl();
		AddVoitureController.setDataList();
		txtNomModel.clear();
	}
	
public void deleteModel(){
	services.deleteModel(tableModel.getSelectionModel().getSelectedItem().getIdModelv());
	setDataTabl();
	AddVoitureController.setDataList();
	txtNomModel.clear();
}

public void editModel(){
Modelv v=services.getModelvById(tableModel.getSelectionModel().getSelectedItem().getIdModelv());
v.setName(txtNomModel.getText());
services.updateModel(v);
setDataTabl();
AddVoitureController.setDataList();
txtNomModel.clear();

}

public void exit(){
	stage.close();
}
	

}
