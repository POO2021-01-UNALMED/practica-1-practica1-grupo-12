package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class VentanaUsuario  {
	
   private Scene scene1; 
   
   public VentanaUsuario() {
	   BorderPane panel0= new BorderPane();
	   panel0.setStyle("-fx-background-color: #DAF2F5;");
	   Label nombreApp = new Label ("Ferretería ABC");
	   VBox panel1= new VBox();
	   HBox barraBotones = new HBox();
	   
	   
	   
	   
	   MenuBar barramenu1 = new MenuBar();
	   Menu archivo = new Menu("Archivo");
	   Menu procesos = new Menu("Procesos y Consultas");
	   Menu ayuda = new Menu("Ayuda");
	   
	   
	   VBox proceso =new VBox();
	   Label titulo= new Label("titulo del proceso");
	   TextField descripcion=new TextField("este proceso trata de.......");
	   GridPane areadetrabajo =new GridPane();
	   
	   proceso.getChildren().addAll(titulo, descripcion, areadetrabajo);
	   
	   barramenu1.getMenus().addAll(archivo, procesos, ayuda);
	   barraBotones.getChildren().add(barramenu1);
	   
	   
	   panel1.getChildren().addAll(barraBotones, proceso);
	   
	   panel0.setTop(nombreApp);
	   panel0.setCenter(panel1);
	   
	   scene1=new Scene (panel0, 1100, 700);
   }
   

	

   public Scene getEscena() {
	   return scene1;
	   
   }
	
	
}
