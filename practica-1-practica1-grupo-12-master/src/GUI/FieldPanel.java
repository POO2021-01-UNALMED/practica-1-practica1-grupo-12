package GUI;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import uiMain.Main;
import uiMain.*;
public class FieldPanel extends Pane {

	private String tituloCriterios;
	private String[] criterios;
	private String tituloValores;
	private String[] valores;
	private boolean[] habilitado;
	private GridPane raiz;
	private HBox raiz1;
	private int contador = 1;
	private ArrayList<TextField> arregloTextos=new ArrayList<TextField>();
	public static ArrayList<String> resultados=new ArrayList<String>();
	private ArrayList<Object> listaobj= new ArrayList<Object>();
	private ListView<String> lista;
/**
crea un nuevo objeto de tipo FieldPanel
@arg tituloCriterios titulo para la columna "Criterio"
@arg criterios array con los nombres de los criterios
@arg tituloValores titulo para la columna "valor"
@arg valores array con los valores iniciales; Si 'null', no hay valores iniciales
@arg habilitado array con los campos no-editables por el usuario; Si 'null', todos son editables
*/
public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores, boolean[]habilitado) {
	this.tituloCriterios = tituloCriterios;
	raiz1 = new HBox();
	raiz = new GridPane();
	raiz1.getChildren().add(raiz);
	
	for(String criterio: criterios){
		Label criterio2 = new Label(criterio);
		TextField t = new TextField();
		raiz.add(criterio2, 0, contador);
		arregloTextos.add(t);
		raiz.add(t, 1, contador);
		contador++;
		
	}
	
	raiz.setPadding(new Insets(20,20,20,400));
	raiz.setVgap(5);
	raiz.setHgap(5);
	
	
	Button agregar = new Button("Agregar producto");
	Button aceptar = new Button("Aceptar");
	Button borrar = new Button("Borrar");
	raiz.add(aceptar, 0, contador);
	raiz.add(borrar, 1, contador);
	lista = new ListView<String>();
	
	
	
	//se agrega el boton de agregar productos solo a las funcionalidades que tienen 3,4 o 5 criterios
	
	if(arregloTextos.size()==3||arregloTextos.size()==5||arregloTextos.size()==4) {
	raiz.add(agregar, 2, contador-1);
	lista.setPrefWidth(200);
	lista.setPrefHeight(30);

	raiz1.getChildren().add(lista);
	
	
	}

	
	// acciones del boton aceptar
	aceptar.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent arg0) {
			if(arregloTextos.size()==6) { //funcionalidad 1. Define la funcionalidad de acuerdo al numero de textfields
				for (int i=0;i < arregloTextos.size();i++) {
					resultados.add(arregloTextos.get(i).getText());//agrega los valores de los textfields a un arreglo de strings
					
				}
				System.out.println("funcionalidad 1"); //solo se usa pa confirmar si se agregan los datos
				for (int i=0;i < resultados.size();i++) {
					System.out.println("dato"+(i+1)+" "+resultados.get(i));
				}
				
				
				
			}
			
			else if(arregloTextos.size()==3) {//funcionalidad 2 tiene 3 criterios
				for (int i=0;i < 1;i++) {
					resultados.add(arregloTextos.get(i).getText());
					
				}
				System.out.println("funcionalidad 2");
				for (int i=0;i < resultados.size();i++) {
					System.out.println("dato"+(i+1)+" "+resultados.get(i));
				}
				
				
				
			}
			
			
			else if(arregloTextos.size()==5) { //funcionalidad 3 tiene 5 criterios
				for (int i=0;i < 3;i++) {
					resultados.add(arregloTextos.get(i).getText());
					
				}
				System.out.println("funcionalidad 3");
				for (int i=0;i < resultados.size();i++) {
					System.out.println("dato"+(i+1)+" "+resultados.get(i));
				}
				Main.GananciasNetasMensuales(new Main().getFerr(), Integer.parseInt(resultados.get(0)));
			} 
			
			
			
			else if(arregloTextos.size()==4) { //funcionalidad 4 
				for (int i=0;i < 2;i++) {
					resultados.add(arregloTextos.get(i).getText());
					
				}
				System.out.println("funcionalidad 4");
				for (int i=0;i < resultados.size();i++) {
					System.out.println("dato"+(i+1)+" "+resultados.get(i));
				}
			}
			
			
			else if(arregloTextos.size()==1) { // funcionalidad 5
				for (int i=0;i < arregloTextos.size();i++) {
					resultados.add(arregloTextos.get(i).getText());
					
				}
				System.out.println("funcionalidad 5");
				for (int i=0;i < resultados.size();i++) {
					System.out.println("dato"+(i+1)+" "+resultados.get(i));
				}
			}
			
	
		
			
		}
		
		
		
	}
	);
	
	
	//eventos del boton agregar para las funcionalidades que lo tengan
	agregar.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent arg1) {
			
			if(arregloTextos.size()==3) { //evento en la funcionalidad 2
				Object[] producto= new Object[2]; //se crea un objeto de dos parametros
				producto[0]=arregloTextos.get(1).getText();
				producto[1]=arregloTextos.get(2).getText();//se agrega al objeto los dos ultimos criterios: referencia y cantidad
				lista.getItems().add("Referencia producto:"+arregloTextos.get(1).getText() + " " + "Cantidad:"+arregloTextos.get(2).getText());
				arregloTextos.get(1).clear();
				arregloTextos.get(2).clear();// se remueven los dos ultimos valores de los text fields
				listaobj.add(producto); //se agrega el objeto a una lista
				System.out.println(listaobj.size());
				
				
			}
			
			else if (arregloTextos.size()==5) { //evento en la funcionalidad 3
				Object[] producto= new Object[2];
				producto[0]=arregloTextos.get(3).getText();
				producto[1]=arregloTextos.get(4).getText();
				lista.getItems().add("Referencia producto:"+arregloTextos.get(3).getText() + " " + "Cantidad:"+arregloTextos.get(4).getText());
				arregloTextos.get(3).clear();
				arregloTextos.get(4).clear();
				listaobj.add(producto);
				
			}
			else if (arregloTextos.size()==4) { //evento en la funcionalidad 4
				Object[] producto= new Object[2];
				producto[0]=arregloTextos.get(2).getText();
				producto[1]=arregloTextos.get(3).getText();
				lista.getItems().add("Referencia producto:"+arregloTextos.get(2).getText() + " " + "Cantidad:"+arregloTextos.get(3).getText());
				arregloTextos.get(2).clear();
				arregloTextos.get(3).clear();
				listaobj.add(producto);
				
			}
			
		
			
		}
		
	}
	);
	
	
}



public ListView<String> getLista() {
	return lista;
}
/**
@arg criterio el criterio cuyo valor se quiere obtener
@return el valor del criterio cuyo nombre es 'criterio'
public String getValue(String criterio) {
...
}
*/
public HBox getRaiz() {
	return raiz1;
}
public void setRaiz(GridPane raiz) {
	this.raiz = raiz;
}

}
