package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Inicio extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		VBox Scene = new VBox();
		Scene.setStyle("-fx-background-color: #DAF2F5;");
		
		
		
		//Se crea el area de texto p3
		TextArea p3 = new TextArea("\n Bienvenidos al software de la Ferretería ABC \n             el lugar donde encontrarás todo lo \n relacionado con herramientas de construccion, \n          reparación y accesorios para el hogar.");
		p3.setEditable(false);
		p3.setStyle(" -fx-text-inner-color: #2E7F86; -fx-background-color: #DAF2F5 ; -fx-border-radius: 7;-fx-base: #DAF2F5");
		p3.setFont(Font.font ("Georgia",FontWeight.BOLD, 16));
		p3.setPrefHeight(120); 
		p3.setPrefWidth(420);
		

		
		
		Image imagen = new Image(getClass().getResourceAsStream("./imagenes/img1.jpg"),300,300,false,false);
		Label label = new Label("", new ImageView(imagen));
		FlowPane p4 = new FlowPane();
		p4.setVgap(40);
		p4.setHgap(80);
		p4.setPadding(new Insets(0,70,0, 70));
		Button entrar = new Button("entrar al sistema");
		entrar.setStyle("-fx-border-radius: 7;-fx-border-color: #FD793C;-fx-base: #DAF2F5;-fx-text-fill: #2E7F86;");
		
		entrar.setPadding(new Insets(10,100,5,100));
		p4.getChildren().add(label);
		p4.getChildren().add(entrar);
		
		
	    
		
		FlowPane p1 = new FlowPane();
		p1.setVgap(50);
		p1.setHgap(700);
	    p1.setPadding(new Insets(70,5, 50, 40));
		p1.getChildren().add(p3);
		p1.getChildren().add(p4);
		//p1.setStyle("-fx-background-color: blue;");
		Scene scene = new Scene(Scene, 1100, 700);
		
		FlowPane p2 = new FlowPane();
		p2.setVgap(50);
		p2.setHgap(700);
	    p2.setPadding(new Insets(70,5, 50, 40));
	   // p2.setStyle("-fx-background-color: red;");
	    //p2.getChildren().addAll(p3,p4);
		
		Scene.getChildren().addAll(p1,p2);
		
		
		
		
		primaryStage.setTitle("Inicio");
		primaryStage.setScene(scene);
		//primaryStage.setScene(scene2);
		primaryStage.show();
	}
	
	public static void main (String[] args) {
		launch(args);
	}
	
}
