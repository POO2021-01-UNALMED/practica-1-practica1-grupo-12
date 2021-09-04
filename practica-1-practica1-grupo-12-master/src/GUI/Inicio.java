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

public class Inicio extends Application {
	
	public static Stage primaryStage;
	private static Scene scene;
	VentanaUsuario v = new VentanaUsuario();
	

	int contador;
	int contador2;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
//colores #FD793C=naranja  	#2E7F86=verde	#DAF2F5=fondo
		

		HBox Scene1 = new HBox();
		
		MenuBar barramenu = new MenuBar();
	   	Menu inicio = new Menu("Inicio");
	   	barramenu.getMenus().add(inicio);
	   	Menu descripcion = new Menu("DescripciÃ³n");
	   	MenuItem salir = new MenuItem("Salir");
	   	MenuItem texto = new MenuItem("Descripcion del sistemasffffffffffffffffffffffffffffffff \n descripcion del sistema");
	   	
	   	descripcion.getItems().add(texto);
	   	inicio.getItems().addAll(descripcion,salir);
	   	
	   	barramenu.setStyle("-fx-background-color: #FD793C;");
	    barramenu.setPadding(new Insets(10,250,5,10));
	    
		Scene1.setStyle("-fx-background-color: #DAF2F5;");
		 scene = new Scene(Scene1, 1100, 700);

		
		//Se crea el area de texto p3
		TextArea p3 = new TextArea("\n Bienvenidos al software de la Ferretería ABC \n             el lugar donde encontrarás todo lo \n relacionado con herramientas de construccion, \n          reparaciÃ³n y accesorios para el hogar.");
		
		p3.setEditable(false);
		p3.setStyle(" -fx-text-inner-color: #2E7F86 ; -fx-background-color: #DAF2F5 ; -fx-border-radius: 7;");
		p3.setFont(Font.font ("Georgia",FontWeight.BOLD, 16));
		p3.setPrefHeight(120); 
		p3.setPrefWidth(420);
		

		//Se crea la imagen y el boton en p4
		
		Image imagen1 = new Image(getClass().getResourceAsStream("./imagenes/img1.jpg"),300,300,false,false);
		Label img1 = new Label("", new ImageView(imagen1));
		Image imagen2 = new Image(getClass().getResourceAsStream("./imagenes/img2.jpg"),300,300,false,false);
		Label img2 = new Label("", new ImageView(imagen2));
		Image imagen3 = new Image(getClass().getResourceAsStream("./imagenes/img3.jpg"),300,300,false,false);
		Label img3 = new Label("", new ImageView(imagen3));
		Image imagen4 = new Image(getClass().getResourceAsStream("./imagenes/img4.jpg"),300,300,false,false);
		Label img4 = new Label("", new ImageView(imagen4));
		FlowPane p4 = new FlowPane();
		p4.setVgap(40);
		p4.setHgap(80);
		p4.setPadding(new Insets(0,70,0, 70));
		Button entrar = new Button("entrar al sistema");
		entrar.setStyle("-fx-border-radius: 7;-fx-border-color: #FD793C;-fx-base: #DAF2F5;-fx-text-fill: #2E7F86;");
		
		entrar.setPadding(new Insets(10,100,5,100));
		p4.getChildren().add(img1);
		p4.getChildren().add(entrar);
		
		
	    
		
		FlowPane p1 = new FlowPane();
		p1.setVgap(50);
		p1.setHgap(700);
	    p1.setPadding(new Insets(20,5, 50, 40));
	    p1.getChildren().add(barramenu);
		p1.getChildren().add(p3);
		p1.getChildren().add(p4);
		//p1.setStyle("-fx-background-color: blue;");
		
		
		Label titulo1=new Label();
		titulo1.setText(" Acerca de los programadores:        ");
		titulo1.setFont(Font.font ("Georgia",FontWeight.BOLD, 18));
		titulo1.setTextFill(Color.web("#FD793C"));
		titulo1.setStyle("-fx-border-color:#2E7F86;");
		Label presentacion= new Label();
		String hojaDeVida1 = " Nombre: Santiago Montoya Orozco       \n  Edad: 24 AÃ±os  \n  Ciudad de residencia: MedellÃ­n\n  OcupaciÃ³n: Estudiante Ing de Sistemas";
		String hojaDeVida2 = " Nombre: José Daniel Bustamante Arango       \n  Edad: 20 Ã±os  \n  Ciudad de residencia: MedellÃ­n\n  OcupaciÃ³n: Estudiante Ing de Sistemas";
		presentacion.setPrefHeight(120);
		presentacion.setPrefWidth(320);
		presentacion.setStyle("-fx-background-color: #2E7F86;-fx-border-color: white;");
		presentacion.setTextFill(Color.WHITE);
		presentacion.setText(hojaDeVida1);
		presentacion.setFont(Font.font ("Arial",FontWeight.BOLD, 14));
		
		
		//Fotos Santiago
		Image foto1 = new Image(getClass().getResourceAsStream("./imagenes/foto1.jpg"),150,150,false,false);
		Label fot1 = new Label("", new ImageView(foto1));
		Image foto2 = new Image(getClass().getResourceAsStream("./imagenes/foto2.jpg"),150,150,false,false);
		Label fot2 = new Label("", new ImageView(foto2));
		Image foto3 = new Image(getClass().getResourceAsStream("./imagenes/foto3.jpg"),150,150,false,false);
		Label fot3 = new Label("", new ImageView(foto3));
		Image foto4 = new Image(getClass().getResourceAsStream("./imagenes/foto4.jpg"),150,150,false,false);
		Label fot4 = new Label("", new ImageView(foto4));
		//Fotos Jose Daniel
		Image foto5 = new Image(getClass().getResourceAsStream("./imagenes/java.png"),150,150,false,false);
		Label fot5 = new Label("", new ImageView(foto5));
		Image foto6 = new Image(getClass().getResourceAsStream("./imagenes/java.png"),150,150,false,false);
		Label fot6 = new Label("", new ImageView(foto5));
		Image foto7 = new Image(getClass().getResourceAsStream("./imagenes/java.png"),150,150,false,false);
		Label fot7 = new Label("", new ImageView(foto5));
		Image foto8 = new Image(getClass().getResourceAsStream("./imagenes/java.png"),150,150,false,false);
		Label fot8 = new Label("", new ImageView(foto5));
		GridPane fotos=new GridPane();
	    GridPane.setConstraints(fot1,0,0);
	    GridPane.setConstraints(fot2,0,1);
	    GridPane.setConstraints(fot3,1,0);
	    GridPane.setConstraints(fot4,1,1);
	    GridPane.setConstraints(fot5,0,0);
	    GridPane.setConstraints(fot6,0,1);
	    GridPane.setConstraints(fot7,1,0);
	    GridPane.setConstraints(fot8,1,1);
	    
		fotos.getChildren().addAll(fot1,fot2,fot3,fot4);
	    
	    fotos.setVgap(8);
		fotos.setHgap(8);
		
		
		
		
		FlowPane p2 = new FlowPane();
		p2.setVgap(50);
		p2.setHgap(700);
	    p2.setPadding(new Insets(90,5, 50, 40));
	   // p2.setStyle("-fx-background-color: red;");
	    p2.getChildren().addAll(titulo1,presentacion,fotos);
		
	    
	    
	    //Eventos del raton 
	    EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>(){
	    	@Override
	    	public void handle(MouseEvent mouseEvent) {
	    		//Este if se encarga de intercambiar las hojas de vida y las fotos
	    		if(mouseEvent.getEventType().toString().equals("MOUSE_CLICKED")) {
	    			contador++;	
	    			if(contador % 2 == 0) {
	    				presentacion.setText(hojaDeVida2);
	    				fotos.getChildren().clear();
	    				fotos.getChildren().addAll(fot5,fot6,fot7,fot8);
	    				
	    			}
	    			else{
	    				presentacion.setText(hojaDeVida1);
	    				fotos.getChildren().clear();
	    				fotos.getChildren().addAll(fot1,fot2,fot3,fot4);
	    			}
	    		}
	    		
	    		if(mouseEvent.getEventType().toString().equals("MOUSE_EXITED")){
	    			if(contador2 == 0){
	    				p4.getChildren().clear();
	    				p4.getChildren().add(img2);
	    				p4.getChildren().add(entrar);
	    				contador2++;
	    			}
	    			else if(contador2 == 1){
	    				p4.getChildren().clear();
	    				p4.getChildren().add(img3);
	    				p4.getChildren().add(entrar);
	    				contador2++;
	    			}
	    			else if(contador2 == 2){
	    				p4.getChildren().clear();
	    				p4.getChildren().add(img4);
	    				p4.getChildren().add(entrar);
	    				contador2++;
	    			}
	    			else if(contador2 == 3){
	    				p4.getChildren().clear();
	    				p4.getChildren().add(img1);
	    				p4.getChildren().add(entrar);
	    				contador2 = 0;
	    			}
	    		}
	    			
	    			
	    		
	    	
	    	}
	    };
	    presentacion.setOnMouseClicked(mouseHandler);
	    p4.setOnMouseExited(mouseHandler);
	    
	 	 
	    salir.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
				
			}
			
		}
		);
	 
	    entrar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(v.getEscena());
				
			}
			
		}
		);
	    
	    v.getSalir().setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(scene);
				
			}
			
		}
		);
	    
	   		

	    
	    
		Scene1.getChildren().addAll(p1,p2);
		
		
		
		
		primaryStage.setTitle("Ferreteria ABC");
		primaryStage.setScene(scene);
		//primaryStage.setScene(scene2);
		primaryStage.show();
	}
	
	public static void main (String[] args) {
		launch(args);
	}
	
	
	public static Scene getScene() {
		return scene;
	}
	
}
