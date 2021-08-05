package gestorAplicación.Almacen;

import java.util.ArrayList;
//Creación de la clase MaterialDeConstruccion que es subclase de Producto
public class MaterialDeConstruccion extends Producto {
	static ArrayList<MaterialDeConstruccion> material= new ArrayList<MaterialDeConstruccion>() ;
	boolean perecedero;
	String medida;

	//constructor
	public  MaterialDeConstruccion(int referencia, String nombre, double precio, boolean estado,boolean perecedero,String medida) {
		super(referencia, nombre, precio, estado); //uso de la herencia de la clase Producto
		
		this.perecedero=perecedero;
		material.add(this);//Se agrega el producto a la lista de materiales
	    Object[] a = new Object[2];
	    a[0] = this;
	    a[1] = 1;
	    Inventario.productos.add(a);//se crea un objeto que contiene el producto y la cantidad (1) y se agregan al inventario
	    this.medida = medida;
}

	//uso del metodo abstracto
	@Override
	public String FormadeVenta() {
		
		return medida;
	}

}
