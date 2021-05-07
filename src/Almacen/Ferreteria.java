package Almacen;
import  Ventas.*;
import java.util.*;


public class Ferreteria {
	private static final String Direccion = "carrera";   //uso de constante
	
	private long NIT = 213123;
	private String nombre;
	private ArrayList<Empleado> empleados;
	private ArrayList<Proveedores> proveedores;
	private ArrayList<Inventario> inventario;
	private ArrayList<Cliente> cliente;
	public static ArrayList<Factura >facturas = new ArrayList<Factura>();
	private static boolean estado;
	
	
	public Ferreteria(	) {
		
		
	}
	

	

	
	
		
	

	public ArrayList<Factura > getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura > facturas) {
		this.facturas = facturas;
	}
	
}
