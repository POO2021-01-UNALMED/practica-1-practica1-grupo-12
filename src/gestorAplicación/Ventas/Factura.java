package gestorAplicación.Ventas;

import java.io.Serializable;
import java.util.*;

import gestorAplicación.Almacen.Empleado;
import gestorAplicación.Almacen.Ferreteria;
import gestorAplicación.Almacen.Inventario;
import gestorAplicación.Almacen.Producto;
//Clase Ferreteria, autores  Santiago y Jose Daniel Bustamante Arango 
//Esta clase se encarga de crear una factura, la cual puede ser una venta de la ferreteria o una compra a los proveedores

public class Factura implements Serializable,Imprimir{



	public  int numerofactura;
	private String fecha;
	private  ArrayList<Object[]> productosFactura = new ArrayList<Object[]>();
	private String tipo;
	
	private Empleado atendidopor;
	private Cliente cliente;
	
	
	
	double devolver = 0;
	
	//Sobrecarga de constructores. Este constructor se usa para las Ventas
	public Factura (String fecha, ArrayList<Object[]> productos, String tipo,Empleado atendidopor, Cliente cliente) {
		this.numerofactura = Ferreteria.facturas.size() + 10000;
		this.fecha=fecha;
		this.productosFactura = productos;
		this.tipo=tipo;
		
		this.atendidopor=atendidopor;
		this.cliente = cliente;
		Ferreteria.facturas.add(this);
		
	}
	//Sobrecarga de constructores. Este constructor se usa para las Compras
   public Factura (String fecha, ArrayList<Object[]> productos, String tipo,double valortotal) {
		
		this.numerofactura = Ferreteria.facturas.size() + 10000;
		this.fecha=fecha;
		this.productosFactura = productos;
		this.tipo=tipo;
		Ferreteria.facturas.add(this);
		
	}
   
   
   

	
	
	//Este método recibe 2 int, una referencia de un producto y una cantidad. Se encarga de retirar productos de una referencia de la factura.
	public double RetirarProducto(int ref, int cantidad) {
		
		for(Object[] p: productosFactura) {
			Producto producto = (Producto) p[0];
			if(ref == producto.getReferencia()) {
				int aux= (int)p[1];
				p[1] = (int) p[1] - cantidad;
				
				if((int)p[1] >= 0) {
				devolver = devolver+(producto.getPrecio()*cantidad);
				
				Object[] inventario = {producto, cantidad};
						Inventario.getProductos().add(inventario);
						
				
		      
					
				}
				else {
					System.out.println("No es posible eliminar esa cantidad de productos ");
					p[1]=aux;
				}
			}
			
			
	}
		return devolver;
		
		
	}
	
	//Este método se encarga de mostrar los datos 
	@Override
	public String Mostrar(Object[] p) {
		
		return ((Producto) p[0]).getReferencia() + "            " + ((Producto) p[0]).getNombre()
		+ "     " + (int) p[1] +" "+((Producto) p[0]).FormadeVenta()+   "         " + ((Producto) p[0]).getPrecio();
		
	}
	
	
	//Este método se encarga de sumar todos los productos de la factura y luego regresa este valor.
	public double CalcularValorTotal(){
		int valortotal = 0;
		for (Object[] p : productosFactura){
			
			valortotal += ((Producto)p[0]).getPrecio() * (int)p[1];
			
		}
		
		return valortotal;
		
	}


	public int getNumerofactura() {
		return numerofactura;
	}


	public void setNumerofactura(int numerofactura) {
		this.numerofactura = numerofactura;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public ArrayList<Object[]> getProductosFactura() {
		return productosFactura;
	}


	public void setProductosFactura(ArrayList<Object[]> productosFactura) {
		this.productosFactura = productosFactura;
	}


	




	public Empleado getAtendidopor() {
		return atendidopor;
	}


	public void setAtendidopor(Empleado atendidopor) {
		this.atendidopor = atendidopor;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public String getTipo() {
		return tipo;
	}
	
}
