package Almacen;
import  Ventas.*;
import java.util.*;


public class Ferreteria {
	private static final String Direccion = "carrera";   //uso de constante
	
	private long NIT = 213123;
	private String nombre;
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();;
	private ArrayList<Proveedores> proveedores;
	private Inventario inventario = new Inventario();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<Factura >facturas = new ArrayList<Factura>();
	private static boolean estado;
	
	
	
	
	
	public Ferreteria(	) {
		
		
	}
	

	

	
	
		
	




	public Empleado buscarEmpleado(int codigo) {
		for (Empleado empleado : empleados) {
			if (empleado.getCedula() == codigo) {
				return empleado;
			}

		}
		return null;
	}





	
	public long getNIT() {
		return NIT;
	}


	public void setNIT(long nIT) {
		NIT = nIT;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}


	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}


	public ArrayList<Proveedores> getProveedores() {
		return proveedores;
	}


	public void setProveedores(ArrayList<Proveedores> proveedores) {
		this.proveedores = proveedores;
	}


	public Inventario getInventario() {
		return inventario;
	}


	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}


	public ArrayList<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}


	public ArrayList<Factura> getFacturas() {
		return facturas;
	}


	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}


	public static boolean isEstado() {
		return estado;
	}


	public static void setEstado(boolean estado) {
		Ferreteria.estado = estado;
	}


	public static String getDireccion() {
		return Direccion;
	}
























	
	
}
