package Ventas;

import java.util.*;
 import Almacen.*;

public class Factura {

	public static int numerofactura;
	private String fecha;
	private ArrayList<Object[]> productosFactura = new ArrayList<Object[]>();
	private String tipo;
	private double valortotal;
	private Empleado atendidopor;
	private Cliente cliente;
	private static int autoNumerico = 1;
	double devolver = 0;
	
	
	

	
	public Factura (String fecha, ArrayList<Object[]> productos, String tipo,Empleado atendidopor, Cliente cliente) {
		
		this.numerofactura = autoNumerico;
		this.fecha=fecha;
		this.productosFactura = productos;
		this.tipo=tipo;
		this.valortotal = valortotal;
		this.atendidopor=atendidopor;
		this.productosFactura = productos;
		this.cliente = cliente;
		Ferreteria.facturas.add(this);
		
	
		autoNumerico++;
		
		
		
	}

	
	public void MostrarProductos() {
		System.out.println("Referencia"+"  "+"nombre"+"  "+"Cantidad");
		
		for(Object[] p: productosFactura) {
			Producto producto = (Producto) p[0];
			System.out.println(producto.getReferencia()+" "+producto.getNombre()+" "+p[1]);
		}
	}
	
	public void RetirarProducto(int ref, int cantidad) {
		
		for(Object[] p: productosFactura) {
			Producto producto = (Producto) p[0];
			if(ref == producto.getReferencia()) {
				p[1] = (int) p[1] - cantidad;
				devolver = devolver+(producto.getPrecio()*cantidad);
				
				Object[] inventario = {producto, cantidad};
						Inventario.getProductos().add(inventario);
			}
			
	}
		
		System.out.println("Estado de la factura:");
		MostrarProductos();
		System.out.println("valor a devolver al cliente: " + devolver);
		
	}
	
public double CalcularValorTotal(){
		
		for (Object[] p : productosFactura){
			
			this.valortotal += ((Producto)p[0]).getPrecio() * (int)p[1];
			
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


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	
	
}
