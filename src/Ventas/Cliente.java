package Ventas;

import java.io.Serializable;
import java.util.ArrayList;

import Almacen.Empleado;

public class Cliente  implements Serializable{
	private int cedula;
	private String nombre;
	private int telefono;
	private String direccion;
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	
	public Cliente(int cedula, String nombre){
		this(cedula,nombre,0,"null");
		clientes.add(this);

		
	}

	
	public Cliente(int cedula, String nombre,int telefono){
		this(cedula,nombre,telefono,"null");
		clientes.add(this);

		
	}
	
	public Cliente(int cedula, String nombre,String direccion){
		this(cedula,nombre,0,direccion);
		clientes.add(this);

	}
	
	
	public Cliente(int cedula, String nombre, int telefono, String direccion) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		clientes.add(this);

	}


	
	public static boolean buscarCedula(int cedula) {
		for (Cliente cliente : clientes) {
			if (cliente.cedula == cedula) {
				return true;
			}
		}
		return false;
	}


	public static Cliente buscarClientePorCedula(int cedula) {
		for (Cliente cliente : clientes) {
			if (cliente.getCedula() == cedula) {
				return cliente;
			}

		}
		return null;
	}

	//Sobrecarga de métodos
	
	public int getCedula() {
		return cedula;
	}


	public void setCedula(int cedula) {
		this.cedula = cedula;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}


	public static void setClientes(ArrayList<Cliente> clientes) {
		Cliente.clientes = clientes;
	}

	
	
	
	
	
	
	

	

	
	
	
	
	
}
