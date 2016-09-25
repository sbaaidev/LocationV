package application;



import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.BoundsAccessor;

import controller.AddVoitureController;
import controller.IndexController;
import controller.MarqueController;
import controller.MenuController;
import controller.ModelvController;
import controller.VoitureGestionController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Marque;
import model.Modelv;
import model.Voiture;
import services.InterServices;
import services.ServiceClass;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	public static BorderPane indexpane;
	@Override
	public void start(Stage primaryStage) {
		index();		
	}	
	public static void main(String[] args) {
		InterServices services=ServiceClass.getService();
		launch(args);
	}	
	public void index() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/IndexWindow.fxml"));
			indexpane = (BorderPane) loader.load();
			IndexController indexController = loader.getController();
			Stage stage = new Stage();
			//stage.getIcons().add(new Image(Logo));
			stage.initModality(Modality.WINDOW_MODAL);
			indexController.setMain(this, stage);
			Scene scene = new Scene(indexpane, Color.BLUE);
			// adminStage.setFullScreen(true);
			stage.setMaximized(true);
			//stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(scene);
			stage.show();
			menuWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void menuWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/MenuWindow.fxml"));
			BorderPane pane = (BorderPane) loader.load();
			MenuController menuController = loader.getController();
			Stage stage = new Stage();
			//stage.getIcons().add(new Image(Logo));
			stage.initModality(Modality.WINDOW_MODAL);
			menuController.setMain(this, stage);
			indexpane.setCenter(pane);
				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void addVoitureWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/AddVoitureWindow.fxml"));
			BorderPane pane = (BorderPane) loader.load();
			AddVoitureController addVoitureController = loader.getController();
			Stage stage = new Stage();
			//stage.getIcons().add(new Image(Logo));
			stage.initModality(Modality.WINDOW_MODAL);
			addVoitureController.setMain(this, stage);
			Scene scene=new Scene(pane);
			stage.setScene(scene);
			stage.setMaximized(false);
			
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void voitureGestionWindow() {

			try {
				FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/VoitureGestionWindow.fxml"));
				BorderPane pane = (BorderPane) loader.load();
	            VoitureGestionController voitureController = loader.getController();
				Stage stage = new Stage();
				//stage.getIcons().add(new Image(Logo));
				stage.initModality(Modality.WINDOW_MODAL);
				voitureController.setMain(this, stage);
				indexpane.setCenter(pane);
			} catch (Exception e) {
				e.printStackTrace();
			}
	

		}
	
	public void modelvWindow() {
			try {
				FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/ModelWindow.fxml"));
				AnchorPane pane = (AnchorPane) loader.load();
	            ModelvController modelvController = loader.getController();
				Stage stage = new Stage();
				//stage.getIcons().add(new Image(Logo));
				stage.initModality(Modality.WINDOW_MODAL);
				modelvController.setMain(this, stage);
				Scene scene=new Scene(pane);
				stage.setScene(scene);
				stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
	

		}
	
	public void marqueWindow() {

		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/MarqueWindow.fxml"));
			AnchorPane pane = (AnchorPane) loader.load();
            MarqueController marqueController = loader.getController();
			Stage stage = new Stage();
			//stage.getIcons().add(new Image(Logo));
			stage.initModality(Modality.WINDOW_MODAL);
			marqueController.setMain(this, stage);
			Scene scene=new Scene(pane);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
