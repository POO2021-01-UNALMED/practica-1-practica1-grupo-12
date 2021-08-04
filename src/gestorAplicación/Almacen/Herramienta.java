package gestorAplicaci�n.Almacen;

import java.io.Serializable;
import java.util.ArrayList;

public class Herramienta extends Producto implements Serializable {
	
	String tama�o;
	static ArrayList<Herramienta> herramientas= new ArrayList<Herramienta>() ;
	

	public Herramienta(int referencia, String nombre, double precio, boolean estado,String tama�o) {
		super(referencia, nombre, precio, estado); //USO DE LA HERENCIA
		this.tama�o=tama�o;
		
		herramientas.add(this);
		Object[] a = new Object[2];
		a[0] = this;
		a[1] = 1;
		Inventario.productos.add(a);
	}
    
	//USO DELMETODO ABSTRACTO
	public String FormadeVenta() {
		return "unidades";
		
	}    

	
}