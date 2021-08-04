package gestorAplicación.Ventas;

import java.io.Serializable;
import java.util.*;

import gestorAplicación.Almacen.Empleado;
import gestorAplicación.Almacen.Ferreteria;
import gestorAplicación.Almacen.Inventario;
import gestorAplicación.Almacen.Producto;

public class Factura implements Serializable,Imprimir{

	public class setProductosFactura  {

	}


	public  int numerofactura;
	private String fecha;
	private  ArrayList<Object[]> productosFactura = new ArrayList<Object[]>();
	private String tipo;
	private double valortotal;
	private Empleado atendidopor;
	private Cliente cliente;
	
	private static int autoNumerico = 100;
	double devolver = 0;
	
	
	public Factura (String fecha, ArrayList<Object[]> productos, String tipo,Empleado atendidopor, Cliente cliente) {
		//System.out.println("tamaño " + Ferreteria.facturas.size());
		this.numerofactura = Ferreteria.facturas.size() + 10000;
		this.fecha=fecha;
		this.productosFactura = productos;
		this.tipo=tipo;
		this.valortotal = valortotal;
		this.atendidopor=atendidopor;
		this.cliente = cliente;
		Ferreteria.facturas.add(this);
		autoNumerico++;	
	}

   public Factura (String fecha, ArrayList<Object[]> productos, String tipo,double valortotal) {
		
		this.numerofactura = autoNumerico;
		this.fecha=fecha;
		this.productosFactura = productos;
		this.tipo=tipo;
		this.valortotal = valortotal;
		
		Ferreteria.facturas.add(this);
		autoNumerico++;	
	}
   
   
   
	public void MostrarProductos() {
		
		
		
	}
	
	public void RetirarProducto(int ref, int cantidad) {
		
		for(Object[] p: productosFactura) {
			Producto producto = (Producto) p[0];
			if(ref == producto.getReferencia()) {
				int aux= (int)p[1];
				p[1] = (int) p[1] - cantidad;
				
				if((int)p[1] >= 0) {
				devolver = devolver+(producto.getPrecio()*cantidad);
				
				Object[] inventario = {producto, cantidad};
						Inventario.getProductos().add(inventario);
						
				
		      
		      MostrarProductos();
		      System.out.println("valor a devolver al cliente: " + devolver);	
				}
				else {
					System.out.println("No es posible eliminar esa cantidad de productos ");
					p[1]=aux;
				}
			}
			
			
	}
		
		
	}
	
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


	


	public double getValortotal() {
		return valortotal;
	}


	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
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


	public static int getAutoNumerico() {
		return autoNumerico;
	}


	public static void setAutoNumerico(int autoNumerico) {
		Factura.autoNumerico = autoNumerico;
	}

	public String getTipo() {
		return tipo;
	}
	
}
