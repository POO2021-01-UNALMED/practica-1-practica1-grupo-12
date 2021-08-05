package gestorAplicación.Almacen;

import java.io.Serializable;
import java.util.ArrayList;
//Clase Ferreteria, autores  Santiago y Jose Daniel Bustamante Arango 
//Esta clase se encarga de crear un Empleado, la cual va almacenar varios atributos y un arreglo de los empleados creados

public class Empleado implements Serializable {
	private int cedula;
	private String nombre;
	private String cargo;
	private int sueldo;
	private static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	
	public Empleado(int cedula, String nombre, String cargo, int sueldo) {
		this.cedula=cedula;
		this.nombre=nombre;
		this.cargo=cargo;
		this.sueldo=sueldo;
		empleados.add(this); 
	}
	
	


	//Este método recibe un int, la cedula de un empleado, y luego si en el arreglo empleados,hay un empleado con tal cedula, si este es el caso regrea true, en caso contrario false
	public static boolean buscarCedulaEmpleado(int cedula) {
		for (Empleado empleado : empleados) {
			if (empleado.cedula == cedula) {
				return true;
			}
		}
		return false;
	}

	// Este método se encarga de realizar la suma de todos los sueldos de los empleados que se encuentran en el arrelo empleados y regresa esa suma
	public static double SueldoMensualEmpleados(){  // neste método se encarga de recorrer toda la lista empleado para
		double costo = 0;
		for(Empleado emp : empleados) {
			costo += emp.getSueldo();
		}
		
		return costo;
		
	}

	

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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}



	public static ArrayList<Empleado> getEmpleados() {
		return empleados;
	}



	public static void setEmpleados(ArrayList<Empleado> empleados) {
		Empleado.empleados = empleados;
	}



	

	
	


	
	
}
