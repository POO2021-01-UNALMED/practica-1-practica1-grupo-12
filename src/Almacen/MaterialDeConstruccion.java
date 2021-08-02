package Almacen;

import java.util.ArrayList;

public class MaterialDeConstruccion extends Producto {
	static ArrayList<MaterialDeConstruccion> material= new ArrayList<MaterialDeConstruccion>() ;
	boolean perecedero;
	String medida;
	
	public  MaterialDeConstruccion(int referencia, String nombre, double precio, boolean estado,boolean perecedero,String medida) {
		super(referencia, nombre, precio, estado); //uso de herencia
		
		this.perecedero=perecedero;
		material.add(this);
	    Object[] a = new Object[2];
	    a[0] = this;
	    a[1] = 1;
	    Inventario.productos.add(a);

}

	@Override
	public String FormadeVenta() {
		
		return medida;
	}

}
