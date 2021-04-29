package Almacen;
import  Ventas.*;
import java.util.*;


public class Ferreteria {
	private final String Direccion = "carrera";   //uso de constante
	
	private long NIT = 213123;
	private String nombre;
	private ArrayList<Empleado> empleados;
	private ArrayList<Proveedores> proveedores;
	private ArrayList<Inventario> inventario;
	private ArrayList<Cliente> cliente;
	private ArrayList<Factura >facturas ;
	private static boolean estado;
	
	
	public Ferreteria(	) {
		
		
	}
	
	public static void abrirFerreteria(){
		estado = true;
		
	}

	
	public static void cerrarFerreteria(){
		estado = true;
		
	}
	
}
