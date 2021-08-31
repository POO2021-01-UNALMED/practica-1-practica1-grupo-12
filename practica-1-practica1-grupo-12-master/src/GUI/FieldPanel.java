package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class FieldPanel extends Pane {

	private String tituloCriterios;
	private String[] criterios;
	private String tituloValores;
	private String[] valores;
	private boolean[] habilitado;
	private GridPane raiz;
	private int contador = 1;
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
	
	raiz = new GridPane();
	
	
	for(String criterio: criterios){
		Label criterio2 = new Label(criterio);
		TextField t = new TextField();
		raiz.add(criterio2, 0, contador);
		raiz.add(t, 1, contador);
		contador++;
		
	}
	
	raiz.setPadding(new Insets(20,20,20,400));
	raiz.setVgap(5);
	raiz.setHgap(5);
	
	Button aceptar = new Button("Aceptar");
	Button borrar = new Button("Borrar");
	raiz.add(aceptar, 0, contador);
	raiz.add(borrar, 1, contador);
}
/**
@arg criterio el criterio cuyo valor se quiere obtener
@return el valor del criterio cuyo nombre es 'criterio'
public String getValue(String criterio) {
...
}
*/
public GridPane getRaiz() {
	return raiz;
}
public void setRaiz(GridPane raiz) {
	this.raiz = raiz;
}

}