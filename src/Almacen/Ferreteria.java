package Almacen;
import  Ventas.*;
import java.util.*;

public class Ferreteria {
	private String Direccion = "carrera";
	private Dueño dueño;
	private long NIT = 213123;
	private String nombre;
	private Arraylist<Empleado> empleados;
	private Arraylist<Proveedor> proveedores;
	private Arraylist<Inventario> inventario;
	private Arraylist<Cliente> cliente;
	private Arraylist<Facturas >factura;
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
