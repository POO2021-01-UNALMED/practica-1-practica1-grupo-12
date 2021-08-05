package gestorAplicación.Almacen;

import java.io.Serializable;
import java.util.ArrayList;
//Creación de la clase Herramienta que es subclase de Producto
public class Herramienta extends Producto implements Serializable {
	
	String tamaño;
	static ArrayList<Herramienta> herramientas= new ArrayList<Herramienta>() ;
	
//constructor de herramienta
	public Herramienta(int referencia, String nombre, double precio,String tamaño) {
		super(referencia, nombre, precio); //uso de la herencia de la clase Producto
		this.tamaño=tamaño;
		
		herramientas.add(this); //Se agrega el producto a la lista de herramientas
		Object[] a = new Object[2];
		a[0] = this;
		a[1] = 1;
		Inventario.productos.add(a);//se crea un objeto que contiene el producto y la cantidad (1) y se agregan al inventario
	}
    
	//uso del metodo abstracto, al ser herramientas se venden por unidades
	public String FormadeVenta() {
		return "unidades";
		
	}    

	
}