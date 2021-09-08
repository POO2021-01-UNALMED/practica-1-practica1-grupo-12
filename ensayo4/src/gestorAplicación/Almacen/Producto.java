package gestorAplicación.Almacen;

import java.io.Serializable;

/*-------------------------------------------------------------------------------------------------------------------------------------
 * CREACIÓN DE LA CLASE ABSTRACT
 */

public abstract class Producto implements Serializable {
	protected int referencia;
	protected String nombre;
	protected double precio;
	
	
	
	//constructor de la clase 
	
	public Producto(int referencia,String nombre,double precio) {
		this.referencia = referencia;
		this.nombre = nombre;
		this.precio = precio;
		
		
	}
	
	// metodo abstracto que se encarga de mostrar las unidades de medida en que se venden los productos

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