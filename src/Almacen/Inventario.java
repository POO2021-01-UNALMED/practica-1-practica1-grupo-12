package Almacen;

import java.util.ArrayList;

public class Inventario {
	public static ArrayList<Object[]> productos = new ArrayList<Object[]>();
    private int cantidad;
    private Ferreteria almacen;
    
    
    /*public Inventario(ArrayList<String> producto,int cantidad,Ferreteria almacen) {
    	//this.producto = producto;
    	this.cantidad = cantidad;
    	this.almacen = almacen;
    }*/
    
    public  boolean buscarExistenciaProducto(int referenciaProducto) {
		for (Object[] p : getProductos()) {
			if( ((Producto) p[0]).getReferencia() == referenciaProducto ) {
					return true;
			}
			
		}

		return false;

	}
    
    public void agregarProducto() {
    	
    }
    public void quitarProducto() {
    	
    }
    public void verificarProducto() {
    	
    }

	public static ArrayList<Object[]> getProductos() {
		return productos;
	}

	public static void setProductos(ArrayList<Object[]> productos) {
		Inventario.productos = productos;
	}
}
