package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Inicio extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane Scene = new BorderPane();
		TextArea p3 = new TextArea();
		BorderPane p4 = new BorderPane();
		TextField saludo = new TextField("Holadfsgdsgggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
		//p3.getChildren().add(saludo);
		//p3.setTop(saludo);
		BorderPane p1 = new BorderPane();
		p1.getChildren().add(p3);
		//p3.getChildren().add(saludo);
		Scene scene = new Scene(Scene, 1100, 700);
		
		Scene.getChildren().add(p1);
		Scene.getChildren().add(saludo);
		
		
		
		primaryStage.setTitle("Calculadora");
		primaryStage.setScene(scene);
		//primaryStage.setScene(scene2);
		primaryStage.show();
	}
	
	public static void MostrarVentanaInicio(String args) {
		launch(args);
	}
	
}
