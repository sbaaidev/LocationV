package controller;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.itextpdf.text.io.GetBufferedRandomAccessSource;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Marque;
import model.Modelv;
import model.Voiture;
import services.InterServices;
import services.ServiceClass;
import services.Validator;


public class AddVoitureController {
	File file = null;
	Main main;
	Stage stage;
	@FXML
	TextField txtmat,txtprix,txtklm,txtpuissance,txtfrein;
	@FXML
	ComboBox<String> cmbxcolor;
	@FXML
	ComboBox<Marque>  txtmarque;
	@FXML
	ComboBox<Modelv> cmbxmodel;
	ObservableList<String> listColor=FXCollections.observableArrayList();
	 static ObservableList<Marque> listmarque=FXCollections.observableArrayList();
	 static ObservableList<Modelv> modellist=FXCollections.observableArrayList();
	static InterServices services=ServiceClass.getService();
	// VoitureValidator validatorV;
	Map<String, String> errs=new HashMap<String,String>();
	public void initialize() throws FileNotFoundException, URISyntaxException{
		 setDataList();
		 txtmarque.setItems(listmarque);
		 cmbxmodel.setItems(modellist);
			for(int i=0;i<10;i++){
				listColor.add("color-"+i);
				
			}
		 cmbxcolor.setItems(listColor);
		 txtmarque.setOnAction((event) -> {
			List<Modelv> models= services.getMarqueById(txtmarque.getSelectionModel().getSelectedItem().getIdMarque()).getModel();
			modellist.clear();
			for(Modelv mv:models){
				modellist.add(mv);
				
			}
			   
			});
		 Scanner sn=new Scanner(new File(getClass().getResource("/errors.txt").getFile()),"UTF-8");
		 String line="";
	       while(sn.hasNextLine()){	  
	        	String parts[]=sn.nextLine().split(":");
	        	errs.put(parts[0], parts[1]);	        	
	        }       
	}
	public void setMain(Main main,Stage stage){
		this.main=main;
		this.stage=stage;	
	}
	
	public static void setDataList(){
		listmarque.clear();
		for(Marque m:services.getAllMarque()){
			listmarque.add(m);
			
		}
		if(ModelvController.marque==null){
			
		}else{
			List<Modelv> models= services.getMarqueById(ModelvController.marque.getIdMarque()).getModel();
			modellist.clear();
			for(Modelv mv:models){
				modellist.add(mv);
				
			}
		}
		
	}
	
	@FXML
	public void addVoiture() throws IOException{	
	if(validate()){
		System.out.println("this is number double");
		Voiture v=new Voiture();
		v.setMat(txtmat.getText());
		v.setColeur(cmbxcolor.getSelectionModel().getSelectedItem());
		v.setMarque(txtmarque.getSelectionModel().getSelectedItem());
		v.setPrix(Double.parseDouble(txtprix.getText()));
		v.setPuissance(Double.parseDouble(txtpuissance.getText()));
		v.setImage("tiit");
		v.setCompteur(Integer.parseInt(txtklm.getText()));
		v.setFrein(Integer.parseInt(txtfrein.getText()));
		v.setModelv(cmbxmodel.getSelectionModel().getSelectedItem());
		services.addVoiture(v);	
		// add image
		File file2 = new File("imgVoiture/" + v.getMat() + ".jpg");	
		InputStream is = new FileInputStream(file);
		OutputStream os = new FileOutputStream(file2);
		byte[] buffer = new byte[1024];
		int lenght;
		while ((lenght = is.read(buffer)) > 0) {
			os.write(buffer, 0, lenght);
		}
		String url = file2.getPath();
		v.setImage(url.replace("\\", "/"));
		services.updateVoiture(v);
		if (is != null)
			is.close();
		if (os != null)
			os.close();
	
		VoitureGestionController.setDataTable();
	}else{
		//System.out.println(errs.get("validationForm"));
		Alert alert=new Alert(AlertType.ERROR);
		alert.setContentText(errs.get("validationForm"));
		alert.showAndWait();		
	}
	}
	
	public boolean validate(){
		if(Validator.validateNumber(txtprix.getText())&&Validator.validateNumber(txtpuissance.getText()) && !txtmat.getText().equals("")
				&& Validator.validateInteger(txtfrein.getText())&& Validator.validateInteger(txtklm.getText()) ){
			return true;
		}else{
			return false;
		}
	
	}
	
	@FXML
	public void modelwindow(){
		ModelvController.marque=txtmarque.getSelectionModel().getSelectedItem();
		main.modelvWindow();
	}
	
	@FXML
	public void marquewindow(){
		//ModelvController.marque=txtmarque.getSelectionModel().getSelectedItem();
		main.marqueWindow();
	}
	
	@FXML
	public void getimage() {
		Stage stg = new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("View Files");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		fileChooser.getExtensionFilters().addAll(

				new FileChooser.ExtensionFilter("JPG", "*.jpg")

		);

		file = fileChooser.showOpenDialog(stg);
		if (file == null) {

		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText(" „  Õ„Ì· «·’Ê—… »‰Ã«Õ");
			alert.showAndWait();

		}

	}


}
