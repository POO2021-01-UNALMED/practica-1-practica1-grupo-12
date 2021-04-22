package Almacen;
import  Ventas.*;
import java.util.*;


public class Ferreteria {
	private String Direccion = "carrera";
	private Jefe jefe;
	private long NIT = 213123;
	private String nombre;
	private ArrayList<Empleado> empleados;
	private ArrayList<Proveedor> proveedores;
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
