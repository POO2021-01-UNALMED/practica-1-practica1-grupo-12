package gestorAplicación.Almacen;

// Clase Ferreteria, autores  Santiago y Jose Daniel Bustamante Arango 
//Esta clase se encarga de crear una ferretería, la cual va almacenar empleados,proveedores,clientes y facturas en ArrayList

import java.io.Serializable;
import java.util.*;
import baseDatos.Deserializador;
import gestorAplicación.Ventas.Cliente;
import gestorAplicación.Ventas.Factura;

public class Ferreteria  implements Serializable {
	private static final String Direccion = "carrera 123#456";   //uso de constante
	
	private long NIT = 213123;
	private String nombre = "FerreteriaABC";
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	private ArrayList<Proveedores> proveedores;
	private Inventario inventario = new Inventario();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<Factura >facturas = new ArrayList<Factura>();
	private static final long serialVersionUID = 1L;
	
	public Ferreteria(	) {
		Deserializador.deserializar(this);
		
	}
	
	// Este método recibe un int el cual es la cédula de un empleado y regresa el Empleado con tal cedula, en caso contrario regresa null
	public Empleado buscarEmpleado(int codigo) {
		for (Empleado empleado : empleados) {
			if (empleado.getCedula() == codigo) {
				return empleado;
			}

		}
		return null;
	}

	//Este método recibe un int el cual es la referencia de una factura busca la factura en y caso de encotrarla la regresa, en caso contrario regresa null
   public static Factura buscarFactura (int referencia) {
	   for(Factura factura:facturas) {
			if(factura.getNumerofactura()==referencia) {
			return factura;	
			}		
     }
	return null;
	
   }
   
   //Este método se recibe 2 int un mes y un año, luego busca todas las facturas de tipo Venta que tengan el mismo mes y año y regresa la suma total de estas facturas
   public static double VentasMensuales(int mes,int año){
		double ventas_mensuales = 0;
		

		for(Factura factura : facturas) { // Este for se encarga de recorrer todas las facturas en el arreglo de facturas de la clase Ferreteria
			
			int primerSlash = factura.getFecha().indexOf("/");
			
			int segundoSlash = factura.getFecha().lastIndexOf("/");
			int longitudFecha = factura.getFecha().length();
			
			if((factura.getFecha().substring(primerSlash+1,segundoSlash)).equals(mes+"") && factura.getTipo().equals("Venta") && (factura.getFecha().substring(segundoSlash+1,longitudFecha).equals(año+""))) { //este if se encarga de comparar que el mes de la factura coincida con el mes del parametro
				ventas_mensuales += factura.CalcularValorTotal();
				
			}
			
		}
		
		return ventas_mensuales;
	}
   
   //Este método se recibe 2 int un mes y un año, luego busca todas las facturas de tipo Compra que tengan el mismo mes y año y regresa la suma total de estas facturas
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


	//Este método recibe 2 int, un mes y un año, luego busca todas entre las facturas de tipo Venta que tengan el mismo mes y año quien fue el cliente con mayor compras 
	public static Cliente ClienteMayorCompras(int mes,int año){
		//tengo que buscar todas las facturas que cumplan
		int i = 0;
		Cliente clienteEncontrado= new Cliente(0,"zzz");
		HashMap<Cliente,Integer> hm = new HashMap<Cliente,Integer>();
		
		for(Factura factura:facturas) {
			int primerSlash = factura.getFecha().indexOf("/");
			int segundoSlash = factura.getFecha().lastIndexOf("/");
			int longitudFecha = factura.getFecha().length();
			
			
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


	public ArrayList<Factura> getFacturas() {
		return facturas;
	}


	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	public static String getDireccion() {
		return Direccion;
	}












	






	




































	
	
}
