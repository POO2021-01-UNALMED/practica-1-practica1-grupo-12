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
	   Image log = new Image(getClass().getResourceAsStream("./imagenes/logo.png"),110,110,false,false);
		Label logo = new Label("", new ImageView(log));
		BorderPane panel0= new BorderPane();
	   panel0.setStyle("-fx-background-color: #DAF2F5;");
	   Label nombreApp = new Label ("Ferretería ABC");
	   nombreApp.setFont(Font.font ("Arial",FontWeight.BOLD, 50));
	   nombreApp.setTextFill(Color.web("#2E7F86"));
	   nombreApp.setPadding(new Insets(30,5, 50, 40));
	   VBox panel1= new VBox();
	   HBox barraBotones = new HBox();
	   barraBotones.setStyle("-fx-background-color: #FD793C;");
	   barraBotones.setPadding(new Insets(2,2, 2, 2));
	   HBox Ini = new HBox ();
	   Ini.getChildren().addAll(logo, nombreApp);
	   
	   
	   
	   
	   MenuBar barramenu1 = new MenuBar();
	   barramenu1.setStyle("-fx-background-color: #FD793C;");
	   Menu archivo = new Menu("Archivo");
	   archivo.setStyle("-fx-border-radius: 7;-fx-border-color: white;-fx-background-color: #FFA27B;");
	   Menu procesos = new Menu("Procesos y Consultas");
	   procesos.setStyle("-fx-border-radius: 7;-fx-border-color: white;-fx-background-color: #FFA27B;");
	   Menu ayuda = new Menu("Ayuda");
	   ayuda.setStyle("-fx-border-radius: 7;-fx-border-color: white;-fx-background-color: #FFA27B;");
	   
	   VBox proceso =new VBox();
	   Label titulo= new Label("titulo del proceso");
	   titulo.setFont(Font.font ("Georgia",FontWeight.BOLD, 20));
	   titulo.setPadding(new Insets(20,2, 20, 460));
	   TextField descripcion=new TextField("este proceso trata de.......");
	   descripcion.setEditable(false);
	   GridPane areadetrabajo =new GridPane();
	   
	   proceso.getChildren().addAll(titulo, descripcion, areadetrabajo);
	   
	   barramenu1.getMenus().addAll(archivo, procesos, ayuda);
	   barraBotones.getChildren().add(barramenu1);
	   
	   
	   panel1.getChildren().addAll(barraBotones, proceso);
	   
	   panel0.setTop(Ini);
	  
	   panel0.setCenter(panel1);
	   
	   scene1=new Scene (panel0, 1100, 700);
   }
   

	

   public Scene getEscena() {
	   return scene1;
	   
   }
	
	
}

