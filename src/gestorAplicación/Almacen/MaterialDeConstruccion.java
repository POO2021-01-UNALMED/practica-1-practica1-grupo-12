package gestorAplicación.Almacen;

import java.util.ArrayList;

public class MaterialDeConstruccion extends Producto {
	static ArrayList<MaterialDeConstruccion> material= new ArrayList<MaterialDeConstruccion>() ;
	boolean perecedero;
	
	public  MaterialDeConstruccion(int referencia, String nombre, double precio, boolean estado,boolean perecedero) {
		super(referencia, nombre, precio, estado);
		
		this.perecedero=perecedero;
		material.add(this);
	    Object[] a = new Object[2];
	    a[0] = this;
	    a[1] = 1;
	    Inventario.productos.add(a);

}

}