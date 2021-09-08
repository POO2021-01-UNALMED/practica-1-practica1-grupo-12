package gestorAplicación.Almacen;

import java.util.ArrayList;
//Creación de la clase MaterialDeConstruccion que es subclase de Producto
public class MaterialDeConstruccion extends Producto {
	static ArrayList<MaterialDeConstruccion> material= new ArrayList<MaterialDeConstruccion>() ;
	
	String medida;

	//constructor
	public  MaterialDeConstruccion(int referencia, String nombre, double precio,String medida) {
		super(referencia, nombre, precio); //uso de la herencia de la clase Producto
		
	
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

	public static ArrayList<MaterialDeConstruccion> getMaterial() {
		return material;
	}

	public static void setMaterial(ArrayList<MaterialDeConstruccion> material) {
		MaterialDeConstruccion.material = material;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

}