package gestorAplicación.Almacen;

import java.io.Serializable;
import java.util.ArrayList;
//Creación de la clase Inventario
public class Inventario  implements Serializable {
	public static ArrayList<Object[]> productos = new ArrayList<Object[]>();
    private int cantidad;
    private Ferreteria almacen;
    
//Metodo agregarProducto, se usa cuando se hace una compra al proveedor     
    public static double agregarProducto(int y,int z) {
    	double e =0;
    	if (y==0) {
    		
    	}
    	else {
    	for (Object[] p : productos) {
			if( ((Producto) p[0]).getReferencia() == y ) {
				p[1] =  (int)p[1] + z;
				e=((((Producto) p[0]).getPrecio()/10)*7)*z;//el precio de compra equivale a un 70% del valor de venta, asi se genera utilidad		
			}
			
		}
          if(e==0) {
        	  return 0;
          }
    	}
    	return e;
    }
    

  //Metodo restarProducto, se usa cuando se hace una venta a un cliente 	
	public void restarProducto(int referenciaProducto ,int cantidad) {
		for (Object[] p : productos) {
			if( ((Producto) p[0]).getReferencia() == referenciaProducto ) {
				p[1] =  (int)p[1] - cantidad;
			}
			
		}
	}
	//Metodo buscarExistenciaProducto, busca si un producto se encuentra la lista de productos 
	public  boolean buscarExistenciaProducto(int referenciaProducto) {
		for (Object[] p : productos) {
			if( ((Producto) p[0]).getReferencia() == referenciaProducto ) {
					return true;
			}
			
		}

		return false;

	}
	//Metodo buscarProducto, a diferencia del anterior este metodo devuelve el producto
	public Producto buscarProducto(int referenciaProducto){
		for (Object[] p : productos) {
			if( ((Producto) p[0]).getReferencia() == referenciaProducto ) {
					return ((Producto) p[0]);
			}
			
		}
		
		return null;
	}
	
	
	
	public static ArrayList<Object[]> getProductos() {
		return productos;
	}

	public static void setProductos(ArrayList<Object[]> productos) {
		Inventario.productos = productos;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Ferreteria getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Ferreteria almacen) {
		this.almacen = almacen;
	}

}
