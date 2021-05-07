package Almacen;

public class MaterialDeConstruccion extends Producto {
	Herramienta[] MaterialesDeCostruccion;
	boolean perecedero;
	
	public  MaterialDeConstruccion(int referencia, String nombre, double precio, boolean estado,boolean perecedero) {
		super(referencia, nombre, precio, estado);
		this.MaterialesDeCostruccion=MaterialesDeCostruccion;
		this.perecedero=perecedero;
	}

}
