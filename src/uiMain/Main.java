package uiMain;
import java.util.*;

import Almacen.Empleado;
import Almacen.Ferreteria;
import Almacen.Herramienta;
import Almacen.Inventario;
import Almacen.MaterialDeConstruccion;
import Almacen.Producto;
import Almacen.Proveedores;
import Ventas.Cliente;
import Ventas.Factura;
public class Main {
	
	public static void main(String[] args){
		Ferreteria ferr =  new Ferreteria();
		Proveedores prov1= new Proveedores(true,"javier,",20000);
		Proveedores prov2= new Proveedores(false,"juan,",20001);
		
		
		MaterialDeConstruccion g = new MaterialDeConstruccion(3, "CEMENTO", 12.3, true,true);
		Herramienta h = new Herramienta(123, "martillo", 20000, true,"grande");
		Herramienta i = new Herramienta(124, "destornillador", 20000, true,"mediano");
		Herramienta b = new Herramienta(233, "Martillo", 23.3, true,"Grande");
	
		
	
		Cliente jaime = new Cliente(2, "jaime", 31231, "cadca");
		Empleado javier = new Empleado(3,"javier,","cajero",20000);
		
		
	   
		
		
		
		System.out.println("------------------------------------------");
		System.out.println("//BIENVEDIOS AL SOFTWARE DE LA FERRETERÍA//");
		System.out.println("------------------------------------------");
		System.out.println("Selecciona el número correspondiente a la funcionalidad");
		System.out.println("1.Registrar cliente"); // cuando se crea un cliente se le va a regalar un material de construccion o una herramienta que se le ofrezca de manera aletoria, suponermos que todos los clientes que se vayan a registrar van a comprar otras cosas
		System.out.println("2.Devolver producto"); //tomar numero factura ---> revisar si existe ---> meter productos a inventario ---> verificar si se devuelven todos o no ---> en caso de devolver todos los productos se anula la factura
		System.out.println("3. Vender producto"); // Se pedile la cedula--> en caso de no estar registrado el programa para e imprime "cliente no registrado precione la opcion 1" --->. En caso de estar registrado,escribir el nombre del empleado que lo atendio, pedir los productos de la siguiente manera "referencia, cantidad",revisar en inventario las cantidades si se puede satisfacer el producto imprime ok si no ingrese se imprimira que cantidades insuficientes y cuantas hay en inventario. Oprimir 0,0 para parar. Luego mostrar el total. 
		System.out.println("4.Hacer pedido");// Se seleccion el proveedor---> la ferratería pide los productos --> "referencia, cantidad" --> en caso de que no haya referencia se procede a crear el producto en nuestra ferreteria(tendría que pedir todos los atributos,automaticamente el precio de venta es 30% más caro que el precio de compra), y de esta manera para cada referencia que no esté creada.Al final calcular el valor total del pedido,ver en utilidad si hay plata para cumplir con el pedido, se procede a  crear factura, almacenarla en un arreglo y depositar los productos en el inventario en caso en contrario se cancela el pedido.
		System.out.println("5.Ganancia neta por meses"); 
		System.out.println("Presione  6 para salir");
		
		Scanner input = new Scanner(System.in);
		
		int opcion = 0;
		
		
		do{
			opcion = input.nextInt();
		switch(opcion){
		



			case 1: System.out.println("funcionalidad 1");
					break;
			case 2:devolucion(ferr);break;
			case 3: VenderProductos(ferr);
					break;
			case 4: System.out.println("funcionalidad 4");
			        pedido(ferr);break;
			case 5: System.out.println("funcionalidad 5");
					break;
			
								
			case 6:	System.out.println("salir");
					break;
			 
			
		
			}
		}while(opcion != 6);
	
	}
	
	
	// Funcionalidad 2
	static void devolucion(Ferreteria f) {
		Scanner input = new Scanner(System.in);
		
			System.out.println("DEVOLUCIÓN");
			System.out.println("----------");
		
			
			System.out.println("digite el número de la factura:");
			int pedido=1;
			while(pedido != 0) {
			pedido = input.nextInt();	
			 
			Factura facturabuscar=Ferreteria.buscarFactura(pedido);
			
			if(facturabuscar instanceof Factura) {
				System.out.println("Referencia"+"      "+"nombre"+"                 "+"Cantidad");
				
			   for(Object[] p: facturabuscar.getProductosFactura()) {
				  
						Producto producto = (Producto) p[0];
						System.out.println(producto.getReferencia()+"           "+producto.getNombre()+"                     "+p[1]);
						
			   }
			   int referencia=1;
			   while (referencia!=0) {
				   System.out.println("Digite la referencia del producto que se desea devolver o 0 para finalizar");
				   referencia = input.nextInt();
				   System.out.println("Digite la cantidad de productos que se desean devolver");
					int cantidad = input.nextInt();
					
					facturabuscar.RetirarProducto(referencia, cantidad);
					System.out.println(" ");
				   
			   }
			   System.out.println("proceso finalizado");
			   for(Object[] p: facturabuscar.getProductosFactura()) {
					Producto producto = (Producto) p[0];
					System.out.println(producto.getReferencia()+"           "+producto.getNombre()+"                     "+p[1]);
			   }
			break;
			}
			
			
			else if( facturabuscar== (null) ) {
				System.out.println("La factura no existe en el sistema, por favor ingrese un numero de factura válido");
				
			}
			
			 
			 
		
			
			
			
			
			
	    }
	}



	// Funcionalidad 3
	static void VenderProductos(Ferreteria f) {
		Scanner input = new Scanner(System.in);

		System.out.println("Digite la cedula del comprador");
		int cedulaComprador = input.nextInt();

		if (Cliente.buscarCedula(cedulaComprador) == true) {
			System.out.println("Digite la cedula del empleado que lo atendió");
			Empleado empleadoEncargado = null;
			boolean a = true;
			do {
				int empleado =  input.nextInt();
				a = Empleado.buscarCedulaEmpleado(empleado);
				empleadoEncargado = f.buscarEmpleado(empleado);
				if(a == false) {
					System.out.println("Empleado no encontrado, digite otra cedula");
				}
			}while(!a);
			
			System.out.println("Digite la fecha en el siguiente formato: AÑO-MES-DIA");
			String fecha = input.next();
			String producto = "hola";
			
			ArrayList<Object[]> productosPedidos = new ArrayList<Object[]>();
			do{
				System.out.println("Digite el producto de la siguiente manera: referencia,cantidad");
				producto = input.next();

				String producto2[] = producto.split(",");
				int referencia = Integer.parseInt(producto2[0]);
				int cantidadPedida = Integer.parseInt(producto2[1]);
				
				// este if se encarga de determinar de parar la funcionalidad (de que ya no se pida más productos para vender)
				if(producto.equals("0,0")){
					
					Factura facturaNueva = new Factura(fecha, productosPedidos, "cliente",empleadoEncargado,Cliente.buscarClientePorCedula(cedulaComprador));
					System.out.println("-----------FACTURA-----------");
					System.out.println("Fecha: " + facturaNueva.getFecha());
					System.out.println("Dirección Ferreteria: " + f.getDireccion());
					System.out.println("Cedula Cliente: " + facturaNueva.getCliente().getCedula());
					System.out.println("Nombre Cliente: " + facturaNueva.getCliente().getNombre());
					System.out.println("Productos comprados:");
					System.out.println("Referencia    Nombre    Cantidad   PrecioUnidad");
					for(Object[] p : productosPedidos) {
						System.out.println( ((Producto)p[0]).getReferencia() + "            "+ ((Producto)p[0]).getNombre() +"     "+ (int)p[1] +"         "+ ((Producto)p[0]).getPrecio());
						
					} 
					
					f.getFacturas().add(facturaNueva);
					
					
					
					
					System.out.println("Valor total " + facturaNueva.CalcularValorTotal());
					break;
				}
				
				boolean existenciaProducto = f.getInventario().buscarExistenciaProducto(referencia);

				if (existenciaProducto) { 
				
			
				
				
					ArrayList<Object[]> inventario = f.getInventario().getProductos();
					for (int i = 0; i < inventario.size(); i++) {
						if (((Producto) inventario.get(i)[0]).getReferencia() == referencia) {
							if (cantidadPedida > (int) inventario.get(i)[1]) {
								System.out.println("");
								System.out.println("cantidades disponibles del producto pedido: " + inventario.get(i)[1]);
								break;
							}
							
							else {
								System.out.println("ok!");
								Object productoYcantidad[] = { f.getInventario().buscarProducto(referencia),cantidadPedida};
								productosPedidos.add(productoYcantidad);
								System.out.println(f.getInventario().buscarProducto(referencia));
								f.getInventario().restarProducto(referencia, cantidadPedida);
								
								break;
							}

						}
					}
					
					// se añade la facutara del compradaor a la lista de facturas de la ferreteria
					
				}
				
					
				
				else{

					System.out.println("No se puede el producto no existe");

					// este for se encarga de buscar las cantidades disponibles del producto
					
				}
				
				}while(true);	
			} 
		
		
			else {
				System.out.println("Cliente no registrado, precione la opcion 1");
			
			}
		
		
			
	}


	// Funcionalidad 4
	


	
   static void pedido (Ferreteria f) {
	   
	   Scanner input = new Scanner(System.in);
	   System.out.println("HACER PEDIDO");
		System.out.println("------------");
		
		System.out.println("Digite la fecha en el siguiente formato: DIA/MES/AÑO");
		String fechaf= input.next();
		
		System.out.println("total proveedores= "+Proveedores.proveedores.size());
		System.out.println(" ");
		System.out.println("Empresas :");
		System.out.println("Nombre         NIT :");
		System.out.println(Proveedores.mostrarProveedorese());
		System.out.println(" ");
		System.out.println("Personas naturales :");
		System.out.println("Nombre         Cedula :");
		System.out.println(Proveedores.mostrarProveedoresp());
		System.out.println(" ");
	

		
	    int confirmacion = 1;
	    while(confirmacion!=0) {
	    	System.out.println("Digite la cedula o el Nit del proveedor");
		    int x=input.nextInt();
	    confirmacion = Proveedores.buscarIdent(x);
	    if(confirmacion==0) {
	    	System.out.println("proveedor encontrado");
	    }
	    else {
	    	System.out.println("proveedor no encontrado");
	    }
	    
	    }
	    
	    
	    double acumulado = 0;
	    int y = 1,z=1;
	    ArrayList<Object[]> lista = new ArrayList<Object[]>();
	   
	    while(y!=0 || z!=0) {
	    		
	    System.out.println("Digite el código de cada producto y la cantidad a pedir,finalice su pedido digitando los dos valores en 0");
	    y=input.nextInt();
	    z=input.nextInt();
	    
	    if(y==0 && z==0) {
	    	break;
	    }
	    Object[] a = new Object[2];
	    a[0] = f.getInventario().buscarProducto(y);
	    acumulado += Inventario.agregarProducto(y, z);
	    if(acumulado ==0) {
	    System.out.println("no existe producto con esa referencia");
	    }
	    else {
	    	System.out.println("Agregado");
	    }
	    a[1] = z;
	    
        if(a[0] instanceof Producto) {
        	
        
	    lista.add(a);}
	    System.out.println("total pedido:"+ acumulado);
	    
	    }
	    if(acumulado !=0) {
	    Factura facturaNueva = new Factura(fechaf, lista,"compra",acumulado );
	    System.out.println("proceso finalizado");
	    System.out.println("-----------FACTURA-----------");
	    System.out.println("Número de factura:"+Factura.numerofactura);
	    System.out.println("fecha: "+ fechaf);
	    System.out.println("Productos comprados:");
		System.out.println("Referencia   Cantidad   valor");
		for(Object[] p : lista) {
			
			
			System.out.println( (((Producto)p[0]).getReferencia()) + "            "+ p[1] +"         "+ ((((Producto)p[0]).getPrecio()/10)*7));
		 }
		
		}
	    
	    else {
		    System.out.println("No se realizó ninguna compra");
	    }
			
		 
	    System.out.println( "-------------------------------");
				System.out.println( "total                   "+ acumulado);
	    
   }



}