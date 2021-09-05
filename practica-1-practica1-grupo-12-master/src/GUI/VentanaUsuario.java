package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
import uiMain.Main;

public class VentanaUsuario  {
	
   private Scene scene1;
   public MenuItem salir;
   
  




public MenuItem getSalir() {
	return salir;
}




public void setSalir(MenuItem salir) {
	this.salir = salir;
}




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
	   MenuItem aplicacion = new MenuItem("aplicacion");
	   Alert diag = new  Alert(AlertType.NONE);
	   
	   salir = new MenuItem("Salir");
	   archivo.getItems().addAll(aplicacion,salir);
	   archivo.setStyle("-fx-border-radius: 7;-fx-border-color: white;-fx-background-color: #FFA27B;");
	   Menu procesos = new Menu("Procesos y Consultas");
	   MenuItem funcionalidad1 = new MenuItem("Registrar cliente");
	   MenuItem funcionalidad2 = new MenuItem("Devolver producto");
	   MenuItem funcionalidad3 = new MenuItem("Vender producto");
	   MenuItem funcionalidad4 = new MenuItem("Hacer pedido");
	   MenuItem funcionalidad5 = new MenuItem("Ganancia neta por mes");
	   procesos.getItems().addAll(funcionalidad1,funcionalidad2,funcionalidad3,funcionalidad4,funcionalidad5);
	   procesos.setStyle("-fx-border-radius: 7;-fx-border-color: white;-fx-background-color: #FFA27B;");
	   Menu ayuda = new Menu("Ayuda");
	   MenuItem acerca = new MenuItem("Acerca de:");
	   ayuda.getItems().add(acerca);
	   ayuda.setStyle("-fx-border-radius: 7;-fx-border-color: white;-fx-background-color: #FFA27B;");
	   
	   VBox proceso =new VBox();
	   Label titulo= new Label("Interfaz de Inicio");
	   titulo.setFont(Font.font ("Georgia",FontWeight.BOLD, 20));
	   titulo.setPadding(new Insets(20,2, 20, 460));
	   TextArea descripcion = new TextArea("\n Información de como usar la aplcación\n "
	   		+ "Seleccione la opcion de procesos y consultas ubicada en la parte superior para poder acceder a cada una de las 5 funcionalidades. \n "
	   		+ "Una vez seleccione una funcionalidad se desplagará un forumulario con información necesaria para llevar a cabo cada proceso \n "
	   		+ "El formulario contiene campos que se deben llenar y otros que no para el buen funcionamiento de la aplicación ");
	   descripcion.setEditable(false);
	   descripcion.setStyle(" -fx-text-inner-color: #2E7F86 ; -fx-background-color: #DAF2F5 ; -fx-border-radius: 7;");
	   descripcion.setFont(Font.font ("Georgia",FontWeight.BOLD, 16));
	   descripcion.setPrefHeight(120); 
	   descripcion.setPrefWidth(420);
	   TextArea resultadoFuncionalidad = new TextArea("holaaaaaaaaa");
	  
	   
	   proceso.getChildren().addAll(titulo, descripcion);
	   
	   barramenu1.getMenus().addAll(archivo, procesos, ayuda);
	   barraBotones.getChildren().add(barramenu1);
	   
	   
	   panel1.getChildren().addAll(barraBotones, proceso);
	   
	   panel0.setTop(Ini);
	  
	   panel0.setCenter(panel1);
	   
	   scene1=new Scene (panel0, 1100, 700);
   
   
	  
	   
   
	   EventHandler<ActionEvent> evento = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			diag.setAlertType(AlertType.INFORMATION);
			diag.setTitle("Aplicación");
			diag.setHeaderText("descripcion de la aplicación");
			diag.show();
		}
		
		
	
	   
	   };
	   
	   EventHandler<ActionEvent> EventoAyuda = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				diag.setAlertType(AlertType.INFORMATION);
				diag.setTitle("Acerca de:");
				diag.setHeaderText("Autores de la apicación:\n José Daniel Bustamante Arango \n Santiago Montoya Orozco");
				diag.show();
			}
			
			
		
		   
		   };
	   
	   salir.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				Inicio.primaryStage.setScene(new Inicio().getScene());
				Inicio.main(null);
				
			}
			
		}
		);
	   
	   funcionalidad1.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				proceso.getChildren().clear();
				Label titulo = new Label("Registrar Clientes");
				TextArea descripcion = new TextArea("Esta funcionalidad se encarga de registrar clientes al sistema");
				descripcion.setEditable(false);
				titulo.setFont(Font.font ("Georgia",FontWeight.BOLD, 20));
				titulo.setPadding(new Insets(20,2, 20, 460));
				descripcion.setStyle(" -fx-text-inner-color: #2E7F86 ; -fx-background-color: #DAF2F5 ; -fx-border-radius: 7;");
				descripcion.setFont(Font.font ("Georgia",FontWeight.BOLD, 16));
				descripcion.setPrefHeight(120); 
				descripcion.setPrefWidth(420);
				String[] criterios = {"Fecha","Cédula Empleado","Cédula cliente","Nombre Cliente","Teléfono Cliente","Direccion Cliente"};
				String[] valores = {};
				boolean[] habilitado = null;
				FieldPanel f1 = new FieldPanel("Criterio",criterios,"valor",valores,null);
				proceso.getChildren().addAll(titulo, descripcion);
				proceso.getChildren().add(f1.getRaiz());
				proceso.getChildren().add(resultadoFuncionalidad);
			}
			
		}
		);
	   
	   
	   funcionalidad2.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				proceso.getChildren().clear();
				Label titulo = new Label("Devolver Producto");
				TextArea descripcion = new TextArea("Esta funcionalidad se encarga de devolver un producto de una factura de un cliente");
				descripcion.setEditable(false);
				titulo.setFont(Font.font ("Georgia",FontWeight.BOLD, 20));
				titulo.setPadding(new Insets(20,2, 20, 460));
				descripcion.setStyle(" -fx-text-inner-color: #2E7F86 ; -fx-background-color: #DAF2F5 ; -fx-border-radius: 7;");
				descripcion.setFont(Font.font ("Georgia",FontWeight.BOLD, 16));
				descripcion.setPrefHeight(120); 
				descripcion.setPrefWidth(420);
				String[] criterios = {"Número factura","Referencia del Producto","Cantidad de producto"};
				String[] valores = {};
				boolean[] habilitado = null;
				FieldPanel f1 = new FieldPanel("Criterio",criterios,"valor",valores,null);
				proceso.getChildren().addAll(titulo, descripcion);
				proceso.getChildren().add(f1.getRaiz());
				proceso.getChildren().add(resultadoFuncionalidad);
				
			}
			
		}
		);
	   
	   funcionalidad3.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				proceso.getChildren().clear();
				Label titulo = new Label("Vender Producto");
				TextArea descripcion = new TextArea("Esta funcionalidad se encarga de vender un producto a un cliente");
				descripcion.setEditable(false);
				titulo.setFont(Font.font ("Georgia",FontWeight.BOLD, 20));
				titulo.setPadding(new Insets(20,2, 20, 460));
				descripcion.setStyle(" -fx-text-inner-color: #2E7F86 ; -fx-background-color: #DAF2F5 ; -fx-border-radius: 7;");
				descripcion.setFont(Font.font ("Georgia",FontWeight.BOLD, 16));
				descripcion.setPrefHeight(120); 
				descripcion.setPrefWidth(420);
				String[] criterios = {"Cédula del comprador","Cédula Empleado","fecha","referencia","cantidad"};
				String[] valores = {};
				boolean[] habilitado = null;
				FieldPanel f1 = new FieldPanel("Criterio",criterios,"valor",valores,null);
				proceso.getChildren().addAll(titulo, descripcion);
				proceso.getChildren().add(f1.getRaiz());
				proceso.getChildren().add(resultadoFuncionalidad);
			
				
				
		
			}
			
		}
		);
	   
	   funcionalidad4.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				proceso.getChildren().clear();
				Label titulo = new Label("Hacer pedido");
				TextArea descripcion = new TextArea("Esta funcionalidad se encarga de hacer el pedido de productos al proveedor");
				descripcion.setEditable(false);
				titulo.setFont(Font.font ("Georgia",FontWeight.BOLD, 20));
				titulo.setPadding(new Insets(20,2, 20, 460));
				descripcion.setStyle(" -fx-text-inner-color: #2E7F86 ; -fx-background-color: #DAF2F5 ; -fx-border-radius: 7;");
				descripcion.setFont(Font.font ("Georgia",FontWeight.BOLD, 16));
				descripcion.setPrefHeight(120); 
				descripcion.setPrefWidth(420);
				String[] criterios = {"fecha","ID del proveedor","referencia","cantidad"};
				String[] valores = {};
				boolean[] habilitado = null;
				FieldPanel f1 = new FieldPanel("Criterio",criterios,"valor",valores,null);
				proceso.getChildren().addAll(titulo, descripcion);
				proceso.getChildren().add(f1.getRaiz());
				proceso.getChildren().add(resultadoFuncionalidad);
				
			
					
					
			
			}
			
		}
		);
	   
	   funcionalidad5.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				proceso.getChildren().clear();
				Label titulo = new Label("Ganancias netas por mes");
				TextArea descripcion = new TextArea("Esta funcionalidad muestra el estado de cuenta de la ferreteria en un año ");
				descripcion.setEditable(false);
				titulo.setFont(Font.font ("Georgia",FontWeight.BOLD, 20));
				titulo.setPadding(new Insets(20,2, 20, 460));
				descripcion.setStyle(" -fx-text-inner-color: #2E7F86 ; -fx-background-color: #DAF2F5 ; -fx-border-radius: 7;");
				descripcion.setFont(Font.font ("Georgia",FontWeight.BOLD, 16));
				descripcion.setPrefHeight(120); 
				descripcion.setPrefWidth(420);
				String[] criterios = {"Año de consulta"};
				String[] valores = {};
				boolean[] habilitado = null;
				FieldPanel f1 = new FieldPanel("Criterio",criterios,"valor",valores,null);
				proceso.getChildren().addAll(titulo, descripcion);
				proceso.getChildren().add(f1.getRaiz());
				proceso.getChildren().add(resultadoFuncionalidad);
				
				
			}
			
		}
		);
	   
	   
   
	   aplicacion.setOnAction(evento);
	   acerca.setOnAction(EventoAyuda);
   
   
   
	   
   
   
   
   }
   

	

   public Scene getEscena() {
	   return scene1;
	   
   }
	
	
}


