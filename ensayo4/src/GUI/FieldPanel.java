package GUI;

import java.util.ArrayList;

import Errores.ExceptionC1;
import Errores.ExceptionC2;
import gestorAplicación.Almacen.Ferreteria;
import gestorAplicación.Almacen.Producto;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	private ArrayList<String> criterios2=new ArrayList<String>();
	public static ArrayList<String> resultados=new ArrayList<String>();
	private ArrayList<Object[]> listaobj= new ArrayList<Object[]>();
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
		criterios2.add(criterio);
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
	borrar.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent arg0) {
			for(int i=0;i < arregloTextos.size();i++){
				arregloTextos.get(i).setText("");
			}
			
		}
		
		
		
	});
	aceptar.setOnAction(new EventHandler<ActionEvent>(){
		public void botonAceptar() throws ExceptionC1{
			if(arregloTextos.size()==6) {
				//funcionalidad 1. Define la funcionalidad de acuerdo al numero de textfields
				//VentanaUsuario.resultadoFuncionalidad.setText("");
				for (int i=0;i < arregloTextos.size();i++) {
					resultados.add(arregloTextos.get(i).getText());//agrega los valores de los textfields a un arreglo de strings
					System.out.println("me voy a meter a resultados" + arregloTextos.get(i).getText());
				}
				System.out.println("funcionalidad 1"); //solo se usa pa confirmar si se agregan los datos
				for (int i=0;i < resultados.size();i++) {
					System.out.println("dato"+(i+1)+" "+resultados.get(i));
					/*if(resultados.get(i).equals("")) {
						System.out.println("hola mundos");
					}*/
				}
				
				try {
				
					Main.registrarCliente(Main.ferr,  resultados.get(0),Integer.parseInt(resultados.get(1)),Integer.parseInt(resultados.get(2)),resultados.get(3),Integer.parseInt(resultados.get(4)),resultados.get(5));
					VentanaUsuario.resultadoFuncionalidad.setText(Main.resultado);
					Main.salirDelPrograma(Main.ferr);
					resultados.clear();
					
					
				}
				
				catch(ExceptionC1 e) {
					System.out.println(e.getMessage());
					if((e.getMessage()).equals("Manejo de errores de la Aplicación:valor de criterio erróneo:empleado no encontrado")){
						Alert a = new Alert(AlertType.ERROR);
						a.setTitle("Error de la aplicación"+ "\n");
						a.setHeaderText(e.getMessage());
						a.show();
						resultados.clear();
					}
					else if((e.getMessage()).equals("Manejo de errores de la Aplicación:valor de criterio erróneo:Cliente ya registrado")){
						Alert a = new Alert(AlertType.ERROR);
						a.setTitle("Error de la aplicación"+ "\n");
						a.setHeaderText(e.getMessage());
						a.show();
						resultados.clear();
						
					}
					
				}
				
				catch(Exception e){
					System.out.println("entroo");
					throw new ExceptionC1("faltan atributos");
					
					
				}
				
				
				
				
			
			}
			
			else if(arregloTextos.size()==3) {//funcionalidad 2 tiene 3 criterios
				//VentanaUsuario.resultadoFuncionalidad.setText("");
				for (int i=0;i < 1;i++) {
					resultados.add(arregloTextos.get(i).getText());
					
				}
				System.out.println("funcionalidad 2");
				for (int i=0;i < resultados.size();i++) {
					System.out.println("dato"+(i+1)+" "+resultados.get(i));
				}
				try {	
					Main.devolucion(Main.ferr, Integer.parseInt(resultados.get(0)), listaobj);
					VentanaUsuario.resultadoFuncionalidad.setText(Main.resultado);
					Main.salirDelPrograma(Main.ferr);
					Main.resultado = "";
					resultados.clear();
					listaobj.clear();
				}
				catch(ExceptionC1 e) {
					if((e.getMessage()).equals("Manejo de errores de la Aplicación:valor de criterio erróneo:factura no encontrada")){
						Alert a = new Alert(AlertType.ERROR);
						a.setTitle("Error de la aplicación"+ "\n");
						a.setHeaderText(e.getMessage());
						a.show();
						resultados.clear();
					}
					
				}
				catch(Exception e){
					throw new ExceptionC1("faltan atributos");
					//valor de criterio erróneo:factura no encontrada
				}
				
			}
			
			
			else if(arregloTextos.size()==5) { //funcionalidad 3 tiene 5 criterios
				//VentanaUsuario.resultadoFuncionalidad.setText("");
				for (int i=0;i < 3;i++) {
					resultados.add(arregloTextos.get(i).getText());
					
				}
				System.out.println("funcionalidad 3");
				for (int i=0;i < resultados.size();i++) {
					System.out.println("dato"+(i+1)+" "+resultados.get(i));
				}
				try {
					Main.VenderProductos(Main.ferr, Integer.parseInt(resultados.get(0)), Integer.parseInt(resultados.get(1)), resultados.get(2), listaobj);
					VentanaUsuario.resultadoFuncionalidad.setText(Main.resultado);
					Main.salirDelPrograma(Main.ferr);
					Main.resultado = "";
					resultados.clear();
					listaobj.clear();
				}
				catch(ExceptionC1 e) {
					System.out.println(e.getMessage());
					if((e.getMessage()).equals("Manejo de errores de la Aplicación:valor de criterio erróneo:empleado no encontrado")){
						Alert a = new Alert(AlertType.ERROR);
						a.setTitle("Error de la aplicación"+ "\n");
						a.setHeaderText(e.getMessage());
						a.show();
						resultados.clear();
					}
					else if((e.getMessage()).equals("Manejo de errores de la Aplicación:valor de criterio erróneo:Cliente no registrado")){
						Alert a = new Alert(AlertType.ERROR);
						a.setTitle("Error de la aplicación"+ "\n");
						a.setHeaderText(e.getMessage());
						a.show();
						resultados.clear();
						
					}
					
				}
				
				
				catch(Exception e){
					throw new ExceptionC1("faltan atributos");
					
				}
				
			}
				
				
			
			
			
			else if(arregloTextos.size()==4) { //funcionalidad 4 
				//VentanaUsuario.resultadoFuncionalidad.setText("");
				Main.resultado = "";	
				for (int i=0;i < 2;i++) {
					resultados.add(arregloTextos.get(i).getText());
					
				}
				System.out.println("funcionalidad 4");
				for (int i=0;i < resultados.size();i++) {
					System.out.println("dato"+(i+1)+" "+resultados.get(i));
				}
				try {
					Main.pedido(Main.ferr, resultados.get(0), Integer.parseInt(resultados.get(1)), listaobj);
					VentanaUsuario.resultadoFuncionalidad.setText(Main.resultado);
					Main.salirDelPrograma(Main.ferr);
					Main.resultado = "";
					resultados.clear();
					listaobj.clear();
				}
				catch(ExceptionC1 e) {
					if((e.getMessage()).equals("Manejo de errores de la Aplicación:valor de criterio erróneo:Proveedor no encontrado")){
						Alert a = new Alert(AlertType.ERROR);
						a.setTitle("Error de la aplicación"+ "\n");
						a.setHeaderText(e.getMessage());
						a.show();
						resultados.clear();
					}
					
				}
				
				catch(Exception e){
					throw new ExceptionC1("faltan atributos");
					
				}
					
			}
			
			
			else if(arregloTextos.size()==1) { // funcionalidad 5
				//VentanaUsuario.resultadoFuncionalidad.setText("");
				
				resultados.add(arregloTextos.get(0).getText());
					/*try {
						
						if(Integer.parseInt(arregloTextos.get(0).getText())>2021) {
							
							throw new ExceptionC2("Año no disponible",Integer.parseInt(arregloTextos.get(0).getText()));
						}
						
					}
					catch(ExceptionC2 e2 ){
						if((e2.getMessage()).equals("Manejo de errores de la Aplicación:Año no disponible")){
							Alert a = new Alert(AlertType.ERROR);
							a.setTitle(e2.getMessage());
							a.setHeaderText("El año no se encuentra disponible");
							a.show();
							}
					}*/
					
					
				
				System.out.println("funcionalidad 5");
				for (int i=0;i < resultados.size();i++) {
					System.out.println("dato"+(i+1)+" "+resultados.get(i));
				}
				try {
					if(Integer.parseInt(arregloTextos.get(0).getText())>2021) {
						throw new ExceptionC2("Año no disponible",Integer.parseInt(arregloTextos.get(0).getText()));
					}
					Main.GananciasNetasMensuales(Main.ferr,  Integer.parseInt(resultados.get(0)));
					VentanaUsuario.resultadoFuncionalidad.setText(Main.resultado);
					Main.salirDelPrograma(Main.ferr);
					Main.resultado = "";
					resultados.clear();
				}
				catch(ExceptionC2 e2 ){
					if((e2.getMessage()).equals("Manejo de errores de la Aplicación:Año no disponible")){
						Alert a = new Alert(AlertType.ERROR);
						a.setTitle(e2.getMessage());
						a.setHeaderText("El año no se encuentra disponible");
						a.show();
						resultados.clear();
						}
				}
				
				
				catch(Exception e){
					throw new ExceptionC1("faltan atributos");
				
				}
				
				
				
							
			}
			
			
		}
		
				
		
		@Override
		public void handle(ActionEvent arg0) {
			try {
				botonAceptar();
			} catch (ExceptionC1 e) {
				
				System.out.println(e.getMessage());
				// TODO Auto-generated catch block
				if((e.getMessage()).equals("Manejo de errores de la Aplicación:faltan atributos")) {
					Alert a = new Alert(AlertType.ERROR);
					
					String criterioFaltante = "";
					a.setTitle(e.getMessage());
					a.setHeaderText("Faltan los siguientes atributos:" + "\n");
					
					
					for(int i = 0; i<resultados.size();i++){
						System.out.println("hola " +resultados.get(i));
						if(resultados.get(i).equals("")){
							System.out.println(criterios2.get(i));
							criterioFaltante = criterioFaltante+ criterios2.get(i) + "\n" ;
							
							
							
						}
						
						
						
					}
					resultados.clear();
					a.setContentText("");
					a.setContentText(criterioFaltante);
					//criterios2.clear();
					a.show();
					
					System.out.println("Excepcionnnnnnnnnn");
					e.printStackTrace();
			
					}
				else if((e.getMessage()).equals("Manejo de errores de la Aplicación:valor de criterio erróneo:")){
					Alert a = new Alert(AlertType.ERROR);
					int posicion = 0;
					
					a.setTitle(e.getMessage()+ "\n");
					a.setHeaderText(e.getTipoError() + "\n");
					
					
				}
				
			
			
			}
	
		
			
		}
		
		
		
	}
	);
	
	
	//eventos del boton agregar para las funcionalidades que lo tengan
	agregar.setOnAction(new EventHandler<ActionEvent>(){
     
		
		public void metodoAgregar () throws ExceptionC2 {
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
				
				try {
				boolean existenciaProducto = Main.ferr.getInventario().buscarExistenciaProducto(Integer.parseInt(arregloTextos.get(3).getText()));
				if(existenciaProducto==false) {
					throw new ExceptionC2("producto no encontrado");
					
				}
				for (int i = 0; i < Main.ferr.getInventario().getProductos().size(); i++) {
					if ( ((Producto)  Main.ferr.getInventario().getProductos().get(i)[0]).getReferencia() ==  Integer.parseInt(arregloTextos.get(3).getText())) {
						if (Integer.parseInt((String)arregloTextos.get(4).getText())> ((int)(Main.ferr.getInventario().getProductos().get(i)[1]))) {
							System.out.println("entro");
							throw new ExceptionC2("cantidades no suficientes");
							
						}
					}
							
						}
				
				producto[0]=arregloTextos.get(3).getText();
			    producto[1]=arregloTextos.get(4).getText();
				lista.getItems().add("Referencia producto:"+arregloTextos.get(3).getText() + " " + "Cantidad:"+arregloTextos.get(4).getText());
				arregloTextos.get(3).clear();
				arregloTextos.get(4).clear();
				listaobj.add(producto);
				}
				catch(ExceptionC2 e2){
					if((e2.getMessage()).equals("Manejo de errores de la Aplicación:producto no encontrado")){
					Alert a = new Alert(AlertType.ERROR);
					a.setTitle(e2.getMessage());
					a.setHeaderText("no existe producto con esa referencia");
					a.show();
					}
					else if((e2.getMessage()).equals("Manejo de errores de la Aplicación:cantidades no suficientes")){
						Alert a = new Alert(AlertType.ERROR);
						a.setTitle(e2.getMessage());
						a.setHeaderText("no existen las cantidades solicitadas del producto");
						a.show();
				}
				
				
				
				
				
			}
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
		@Override
		public void handle(ActionEvent arg1)  {
			
			try {
				metodoAgregar();
			} catch (ExceptionC2 e2) {
		
			
		}
		
	}
	}
	);

	
}



public ListView<String> getLista() {
	return lista;
}

public HBox getRaiz() {
	return raiz1;
}
public void setRaiz(GridPane raiz) {
	this.raiz = raiz;
}

}
