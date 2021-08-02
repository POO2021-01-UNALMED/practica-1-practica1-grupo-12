package Almacen;
import  Ventas.*;

import java.io.Serializable;
import java.util.*;
import baseDatos.Deserializador;

public class Ferreteria  implements Serializable {
	private static final String Direccion = "carrera";   //uso de constante
	
	private long NIT = 213123;
	private String nombre;
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	private ArrayList<Proveedores> proveedores;
	private Inventario inventario = new Inventario();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<Factura >facturas = new ArrayList<Factura>();
	private static boolean estado;
	
	
	
	private static final long serialVersionUID = 1L;
	
	public Ferreteria(	) {
		Deserializador.deserializar(this);
		
	}
	

	

	
	
		
	




	public Empleado buscarEmpleado(int codigo) {
		for (Empleado empleado : empleados) {
			if (empleado.getCedula() == codigo) {
				return empleado;
			}

		}
		return null;
	}


   public static Factura buscarFactura (int referencia) {
	   for(Factura factura:facturas) {
			if(factura.getNumerofactura()==referencia) {
			return factura;	
			}		
     }
	return null;
	//new Factura(nombre, null, nombre, NIT);
   }
   
   public static double VentasMensuales(int mes,int año){
		double ventas_mensuales = 0;
		for(Factura factura : facturas) { // Este for se encarga de recorrer todas las facturas en el arreglo de facturas de la clase Ferreteria
			
			int primerSlash = factura.getFecha().indexOf("/");
			int segundoSlash = factura.getFecha().lastIndexOf("/");
			int longitudFecha = factura.getFecha().length();
			//System.out.println((factura.getFecha().substring(primerSlash+1,segundoSlash)));
			//System.out.println(factura.getFecha().substring(segundoSlash+1,longitudFecha));
			if((factura.getFecha().substring(primerSlash+1,segundoSlash)).equals(mes+"") && factura.getTipo().equals("Venta") && (factura.getFecha().substring(segundoSlash+1,longitudFecha).equals(año+""))) { //este if se encarga de comparar que el mes de la factura coincida con el mes del parametro
				ventas_mensuales += factura.CalcularValorTotal();
				
			}
			
		}
		
		return ventas_mensuales;
	}
   
   
	public static double ComprasMensuales(int mes, int año){
		double compras_mensuales = 0;
		for(Factura factura : facturas) { // Este for se encarga de recorrer todas las facturas en el arreglo de facturas de la clase Ferreteria
			
			int primerSlash = factura.getFecha().indexOf("/");
			int segundoSlash = factura.getFecha().lastIndexOf("/");
			int longitudFecha = factura.getFecha().length();
			
			if((factura.getFecha().substring(primerSlash+1,segundoSlash)).equals(mes+"")  && factura.getTipo().equals("Compra")  && (factura.getFecha().substring(segundoSlash+1,longitudFecha)).equals(año+"") ){ //este if se encarga de comparar que el mes de la factura coincida con el mes del parametro
				compras_mensuales += factura.CalcularValorTotal();
			}
			
		}
		
		return compras_mensuales;
	}


	
	public static Cliente ClienteMayorCompras(int mes,int año){
		//tengo que buscar todas las facturas que cumplan
		int i = 0;
		Cliente clienteEncontrado= new Cliente(0,"zzz");
		HashMap<Cliente,Integer> hm = new HashMap<Cliente,Integer>();
		
		for(Factura factura:facturas) {
			int primerSlash = factura.getFecha().indexOf("/");
			int segundoSlash = factura.getFecha().lastIndexOf("/");
			int longitudFecha = factura.getFecha().length();
			
			
			//System.out.println(hm.containsKey(factura.getCliente()));
			//System.out.println((factura.getFecha().substring(primerSlash+1,segundoSlash)));
			//System.out.println(factura.getFecha().substring(segundoSlash+1,longitudFecha));
			if((factura.getFecha().substring(primerSlash+1,segundoSlash)).equals(mes+"")  && factura.getTipo().equals("Venta")  && (factura.getFecha().substring(segundoSlash+1,longitudFecha)).equals(año+"") ){ //este if se encarga de comparar que el mes de la factura coincida con el mes del parametro
				
				if(hm.containsKey(factura.getCliente()) == false) {
					
					hm.put(factura.getCliente(),1);
				}
				else{
					hm.replace(factura.getCliente(), hm.get(factura.getCliente()), hm.get(factura.getCliente()) + 1);
				}
			}
			
			
		}
		
		
		for (Cliente cliente: hm.keySet()) {
		    Integer valor = hm.get(cliente);
		    if(valor>i) {
		    	i=valor;
		    	clienteEncontrado = cliente;
		    	 
		    }
		   
		}
		
		
		return clienteEncontrado;
	}	

	
	public long getNIT() {
		return NIT;
	}


	public void setNIT(long nIT) {
		NIT = nIT;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}


	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}


	public ArrayList<Proveedores> getProveedores() {
		return proveedores;
	}


	public void setProveedores(ArrayList<Proveedores> proveedores) {
		this.proveedores = proveedores;
	}


	public Inventario getInventario() {
		return inventario;
	}


	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}


	public ArrayList<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}


	public static ArrayList<Factura> getFacturas() {
		return facturas;
	}


	public static ArrayList<Factura> setFacturas(ArrayList<Factura> facturas) {
		return facturas;
	}


	public static boolean isEstado() {
		return estado;
	}


	public static void setEstado(boolean estado) {
		Ferreteria.estado = estado;
	}


	public static String getDireccion() {
		return Direccion;
	}












	






	




































	
	
}
