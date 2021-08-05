package gestorAplicación.Almacen;

import java.io.Serializable;
import java.util.ArrayList;



//Creación de la clase Proveedores

public class Proveedores  implements Serializable{
	private Boolean esEmpresa;
	private String nombre;
	private int identificacion;	
	
	public static ArrayList<Proveedores> proveedores = new ArrayList<Proveedores>();
//Constructor	
	public Proveedores(Boolean esEmpresa, String nombre, int identificacion) {
		this.esEmpresa=esEmpresa;
		this.nombre=nombre;
		this.identificacion=identificacion;
		proveedores.add(this);
	}

	
	
// Metodos MostrarProveedores e/p muestra aparte los proveedores empresa y personas	
	public static String mostrarProveedorese()	{
		String x = null;
		for(Proveedores p: proveedores) {
			if(p.getEsEmpresa()==true) {
			x=(p.getNombre()+"       "+p.getIdentificacion());	
			}	
		}
		return x;
	}
	public static String mostrarProveedoresp()	{
		String x = null;
		for(Proveedores p: proveedores) {
			if(p.getEsEmpresa()==false) {
			x=(p.getNombre()+"       "+p.getIdentificacion());	
			}	
		}
		return x;
	}
	
	
//Metodo buscarIdent busca la identificación del proveedor, ya sea nit o cedula
	public static int buscarIdent (int x) {
		int a = 1;
		
		for(Proveedores p: proveedores) {
			
			if (x==p.getIdentificacion()) {
			
				a = 0;
				break;
			}
			else {
				a = 1;
				
			}
		}
		return a;
		
	}
	
	public void entregarProductos(){	
	}
	public void recogerDefectuosos(){
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public Boolean getEsEmpresa() {
		return esEmpresa;
	}

	public void setEsEmpresa(Boolean esEmpresa) {
		this.esEmpresa = esEmpresa;
	}




	public static ArrayList<Proveedores> getProveedores() {
		return proveedores;
	}




	public static void setProveedores(ArrayList<Proveedores> proveedores) {
		Proveedores.proveedores = proveedores;
	}
	
	
}
