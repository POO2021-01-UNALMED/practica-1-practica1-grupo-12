package Almacen;

import java.io.Serializable;

/*-------------------------------------------------------------------------------------------------------------------------------------
 * CREACIÓN DE LA CLASE ABSTRACT
 */

public abstract class Producto implements Serializable {
	private int referencia;
	private String nombre;
	private double precio;
	private boolean estado;
	
	
	//CONSTRUCTOR DE LA CLASE
	
	public Producto(int referencia,String nombre,double precio,boolean estado) {
		this.referencia = referencia;
		this.nombre = nombre;
		this.precio = precio;
		this.estado = estado;
		
	}
	
	// METODO ABSTRACTO

    public abstract String FormadeVenta(); 
    
    

	public int getReferencia() {
		return referencia;
	}

	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}

}
