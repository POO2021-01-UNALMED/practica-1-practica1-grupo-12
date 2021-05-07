package Almacen;

import java.util.ArrayList;

public class Herramienta extends Producto{
	
	String tamaño;
	static ArrayList<Herramienta> herramientas= new ArrayList<Herramienta>() ;
	

	public Herramienta(int referencia, String nombre, double precio, boolean estado,String tamaño) {
		super(referencia, nombre, precio, estado);
		this.tamaño=tamaño;
		herramientas.add(this);
	}

	
}
