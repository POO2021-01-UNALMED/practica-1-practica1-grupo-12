package gestorAplicación.Ventas;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicación.Almacen.Empleado;
//Clase Ferreteria, autores  Santiago y Jose Daniel Bustamante Arango 
//Esta clase es para crear Clientes.



public class Cliente  implements Serializable{
	private int cedula;
	private String nombre;
	private int telefono;
	private String direccion;
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	//Sobrecarga de constructores
	public Cliente(int cedula, String nombre){
		this(cedula,nombre,0,"null");  //uso del this() para desambiaguar 
		clientes.add(this);

		
	}

	//Sobrecarga de constructores
	public Cliente(int cedula, String nombre,int telefono){
		this(cedula,nombre,telefono,"null"); //uso del this() para desambiaguar
		clientes.add(this);

		
	}
	//Sobrecarga de constructores
	public Cliente(int cedula, String nombre,String direccion){
		this(cedula,nombre,0,direccion); //uso del this() para desambiaguar
		clientes.add(this);

	}
	
	//Sobrecarga de constructores
	public Cliente(int cedula, String nombre, int telefono, String direccion) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		clientes.add(this);

	}


	//Sobrecarga de método
	//Este método recibe un int, la cedula de un cliente, luego lo busca en el arreglo cliente de la clase Clientes. Regresa true si está en el arreglo o false en caso contrario
	public static boolean buscarCedula(int cedula) {
		for (Cliente cliente : clientes) {
			if (cliente.cedula == cedula) {
				return true;
			}
		}
		return false;
	}

	//Sobrecarga de método
	//Este método recibe un long, la cedula de un cliente, luego lo busca en el arreglo cliente de la clase Clientes. Regresa el cliente si está en el arreglo o null en caso contrario
	public static Cliente buscarCedula(long cedula) {
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
