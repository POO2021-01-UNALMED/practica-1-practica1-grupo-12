package Almacen;

public class Producto {
	private int referencia;
	private String nombre;
	private double precio;
	private boolean estado;
	
	public Producto(int referencia,String nombre,double precio,boolean estado) {
		this.referencia = referencia;
		this.nombre = nombre;
		this.precio = precio;
		this.estado = estado;
	
		
	}
	
	public void SeDa�a() {
		System.out.println("Producto da�ado no apto para la venta");
		
		
	}
	

}
