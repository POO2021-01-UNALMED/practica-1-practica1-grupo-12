package Almacen;

import java.util.ArrayList;

public class Herramienta extends Producto{
	
	String tama�o;
	static ArrayList<Herramienta> herramientas= new ArrayList<Herramienta>() ;
	

	public Herramienta(int referencia, String nombre, double precio, boolean estado,String tama�o) {
		super(referencia, nombre, precio, estado);
		this.tama�o=tama�o;
		herramientas.add(this);
	}

	
}
