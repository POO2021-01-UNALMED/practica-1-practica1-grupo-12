package Almacen;

public class Herramienta extends Producto{
	
	String tama�o;
	Herramienta[] herramnientas;
	

	public Herramienta(int referencia, String nombre, double precio, boolean estado,String tama�o, Herramienta[]herramientas) {
		super(referencia, nombre, precio, estado);
		this.tama�o=tama�o;
		this.herramnientas=herramientas;	
	}

	
}
