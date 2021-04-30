package Ventas;

public class Cliente {
	private int cedula;
	private String nombre;
	private int telefono;
	private String direccion;
	
	
	public Cliente(int cedula, String nombre){
		this(cedula,nombre,0,"null");
		
		
	}

	
	public Cliente(int cedula, String nombre,int telefono){
		this(cedula,nombre,telefono,"null");
		
		
	}
	
	public Cliente(int cedula, String nombre,String direccion){
		this(cedula,nombre,0,direccion);
		
	}
	
	
	public Cliente(int cedula, String nombre, int telefono, String direccion) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	//Sobrecarga de métodos
	


	
	
	
	
	
	
	

	

	
	
	
	
	
}
