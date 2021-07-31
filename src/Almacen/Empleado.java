package Almacen;

import java.util.ArrayList;

public class Empleado {
	protected int cedula;
	protected String nombre;
	protected String cargo;
	protected int sueldo;
	private static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	
	public Empleado(int cedula, String nombre, String cargo, int sueldo) {
		this.cedula=cedula;
		this.nombre=nombre;
		this.cargo=cargo;
		this.sueldo=sueldo;
		empleados.add(this); 
	}
	
	
	
	public void venderProducto(){
		
	}

	public void enseñarProducto(){
		
		
	}

	public void verificarEstado(){
		
	}


	public static boolean buscarCedulaEmpleado(int cedula) {
		for (Empleado empleado : empleados) {
			if (empleado.cedula == cedula) {
				return true;
			}
		}
		return false;
	}


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



	

	
	


	
	
}
