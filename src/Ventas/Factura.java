package Ventas;

import java.util.*;
 import Almacen.*;

public class Factura {

	public static int numerofactura;
	private String fecha;
	private ArrayList<Object[]> productos;
	private String tipo;
	private double valortotal;
	private Empleado atendidopor;
	
	double devolver = 0;
	public Factura (int numerodefactura, String fecha,ArrayList<Object[]>productos, String tipo, Empleado atendidopor) {
		
		this.setNumerofactura(numerodefactura);
		this.fecha=fecha;
		this.tipo=tipo;
		this.atendidopor=atendidopor;
		this.productos = productos;
		Ferreteria.facturas.add(this);
		
		
		
		
	}

	public int getNumerofactura() {
		return numerofactura;
	}

	public void setNumerofactura(int numerofactura) {
		this.numerofactura = numerofactura;
	}
	


	public double getValortotal() {
		return valortotal;
	}
	
	public void MostrarProductos() {
		System.out.println("Referencia"+"  "+"nombre"+"  "+"Cantidad");
		
		for(Object[] p: productos) {
			Producto producto = (Producto) p[0];
			System.out.println(producto.getReferencia()+" "+producto.getNombre()+" "+p[1]);
		}
	}
	
	public void RetirarProducto(int ref, int cantidad) {
		
		for(Object[] p: productos) {
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
	

	
	
}
