package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Inicio extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane Scene = new BorderPane();
		TextArea p3 = new TextArea("Bienvenidos al software de la Ferretería BC \n eeeeeeeeeeeee");
		p3.setStyle("-fx-font-size: 17");
		p3.setDisable(true);
		p3.setPrefHeight(200); 
		p3.setPrefWidth(400);
		
		FlowPane p4 = new FlowPane();
		p4.setVgap(300);
		p4.setHgap(300);
		p4.setPadding(new Insets(100,100, 100, 100));
		Button entrar = new Button("entrar al sistema");
		p4.getChildren().add(entrar);
	    
		
		FlowPane p1 = new FlowPane();
		p1.setVgap(200);
		p1.setHgap(300);
	    p1.setPadding(new Insets(50,50, 50, 50));
		p1.getChildren().add(p3);
		p1.getChildren().add(p4);
		Scene scene = new Scene(Scene, 1100, 700);
		
		FlowPane p2 = new FlowPane();
		p2.setVgap(200);
		p2.setHgap(300);
	    p2.setPadding(new Insets(50,50, 50, 50));
		
		Scene.getChildren().add(p1);
		
		
		
		
		primaryStage.setTitle("Inicio");
		primaryStage.setScene(scene);
		//primaryStage.setScene(scene2);
		primaryStage.show();
	}
	
	public static void MostrarVentanaInicio(String args) {
		launch(args);
	}
	
}
