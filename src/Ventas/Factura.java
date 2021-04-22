package Ventas;

import java.util.*;
 import Almacen.*;

public class Factura {

	private int numerofactura;
	private Date fecha;
	private Producto productos;
	private String tipo;
	private int valortotal;
	private Empleado atendidopor;
	
	public Factura (int numerodefactura, Date fecha, Producto productos, String tipo, int valortotal, Empleado atendidopor) {
		
		this.numerofactura=numerodefactura;
		this.fecha=fecha;
		this.productos= productos;
		this.tipo=tipo;
		this.valortotal=valortotal;
		this.atendidopor=atendidopor;
		
	}
	
	
	
	
	
	
	
	
	
	
}
