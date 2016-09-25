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
import javafx.stage.Stage;
import model.Marque;
import model.Modelv;
import services.InterServices;
import services.ServiceClass;

public class MarqueController {
	@FXML
	TableView<Marque> tableMarque;
	@FXML
	TableColumn<Marque, Long> colidmarque;
	@FXML
	TableColumn<Marque, String> colnommarque;
	@FXML
	TextField txtNomMarque;
	InterServices services=ServiceClass.getService();
	ObservableList<Marque> listTablev=FXCollections.observableArrayList();
	Main main;
	Stage stage;
	
	public void initialize(){
		colidmarque.setCellValueFactory(new PropertyValueFactory<Marque,Long>("idMarque"));
		colnommarque.setCellValueFactory(new PropertyValueFactory<Marque,String>("name"));
		setDataTabl();
		ObservableList selectedCells = tableMarque.getSelectionModel().getSelectedItems();
		selectedCells.addListener(new ListChangeListener() {
		    @Override
		    public void onChanged(Change c) {
		        	        
		        Marque m=tableMarque.getSelectionModel().getSelectedItem();
		        txtNomMarque.setText(m.getName());
		       
		    }
		});
		
	}
	public void setMain(Main main,Stage stage){
		this.main=main;
		this.stage=stage;		
	}
	public void setDataTabl(){
		listTablev.clear();
		for(Marque v:services.getAllMarque()){
			listTablev.add(v);
			tableMarque.setItems(listTablev);
		}
	}
	
	public void addModel(){
		services.addMarque(new Marque(txtNomMarque.getText()));
		setDataTabl();
		AddVoitureController.setDataList();
		txtNomMarque.clear();
	}
	
public void deleteModel(){
	services.deleteMarque(tableMarque.getSelectionModel().getSelectedItem().getIdMarque());
	setDataTabl();
	AddVoitureController.setDataList();
	txtNomMarque.clear();
}

public void edit(){
	Marque m=tableMarque.getSelectionModel().getSelectedItem();
	m.setName(txtNomMarque.getText());
	services.updateMarque(m);
	setDataTabl();
	AddVoitureController.setDataList();
	txtNomMarque.clear();
}


public void exit(){
	stage.close();
}
	
	

}
