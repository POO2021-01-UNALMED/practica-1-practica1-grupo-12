package Almacen;

public class Herramienta extends Producto{
	
	String tamaño;
	Herramienta[] herramnientas;
	

	public Herramienta(int referencia, String nombre, double precio, boolean estado,String tamaño, Herramienta[]herramientas) {
		super(referencia, nombre, precio, estado);
		this.tamaño=tamaño;
		this.herramnientas=herramientas;	
	}

	
}
