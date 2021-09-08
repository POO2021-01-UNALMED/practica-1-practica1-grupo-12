package uiMain;
import GUI.*;
import java.util.*;

import Errores.ExceptionC1;

import java.io.Serializable;
import java.lang.Math;
import baseDatos.*;
import gestorAplicación.Almacen.Empleado;
import gestorAplicación.Almacen.Ferreteria;
import gestorAplicación.Almacen.Herramienta;
import gestorAplicación.Almacen.Inventario;
import gestorAplicación.Almacen.MaterialDeConstruccion;
import gestorAplicación.Almacen.Producto;
import gestorAplicación.Almacen.Proveedores;
import gestorAplicación.Ventas.Cliente;
import gestorAplicación.Ventas.Factura;
public class Main implements Serializable{
	public static int opcion = 0;
	public static Ferreteria ferr = new Ferreteria();
	public static String resultado = "";
	public static void main(String[] args) throws ExceptionC1{
		ferr = new Ferreteria();
		
		
		
		//Inicio i = new Inicio();
		
		//i.MostrarVentanaInicio(null);
		
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
		
		
		
		
		do{
			
		switch(opcion){
		



			case 1: System.out.println("funcionalidad 1");
					registrarCliente(ferr,null,0,0,null,0,null);
					break;
			case 2:
					System.out.println("funcionalidad 2");
					devolucion(ferr,0,null);
					break;
			case 3: 
					System.out.println("funcionalidad 3");
					VenderProductos(ferr,0,0,null,null);
					break;
			case 4: 
					System.out.println("funcionalidad 4");
			        pedido(ferr,null,0,null);break;
			case 5: System.out.println("funcionalidad 5");
					GananciasNetasMensuales(ferr, opcion);
					break;
			case 6:	System.out.println("salir");
				salirDelPrograma(ferr);
					break;
			 
			
		
			}
		}while(opcion != 6);
	
	
	
	}
	//funicionalidad1
		public static void registrarCliente(Ferreteria f,String fecha1,int cedulaEmpleado,int cedulaCliente,String nombre1,int telefono1,String Direccion1) throws ExceptionC1 {
			
			//
			Scanner input = new Scanner(System.in);
			
			System.out.println("Digite la fecha en el siguiente formato: DIA/MES/AÑO");
			String fecha = fecha1;
			
			System.out.println("digite el número de la cédula del empleado");
			Empleado empleadoEncargado = null;
			boolean a = true;
			
				int empleado = cedulaEmpleado;
				a = Empleado.buscarCedulaEmpleado(empleado);
				empleadoEncargado = f.buscarEmpleado(empleado);
				System.out.println("booleano empleado" + a);
				if (a == false || empleadoEncargado instanceof  Empleado) {
					System.out.print("entro a empleado ");
					throw new ExceptionC1("valor de criterio erróneo:empleado no encontrado","Empleado");
					
				}
			
			
			System.out.println("digite el número de la cédula del nuevo cliente");
			int cedula = 0;
			Cliente clienteBuscar = null;
			boolean a1 = true;
			
				cedula = cedulaCliente;
				boolean b = Cliente.buscarCedula(cedula);
				clienteBuscar = Cliente.buscarCedula((long)cedula);  //sobrecarga
				//System.out.println("entro");
				//System.out.println(clienteBuscar);
				if (b == true) {
					//resultado = ("Cliente ya registrado, digite otra cedula");
					System.out.print("entro a cliente");
					throw new ExceptionC1("valor de criterio erróneo:Cliente ya registrado","Cliente");
					
				}
			
			
			
			System.out.println("digite el nombre completo del nuevo cliente");
			//input.nextLine();
			String nombre = nombre1;
			
			System.out.println("digite el teléfono del nuevo cliente,cero en caso contrario");
			int telefono = telefono1;
			
			System.out.println("digite la dirección del nuevo cliente,cero en caso contrario");
			String direccion = Direccion1;
			
			if(direccion.equals("0") && telefono == 0  ){
				clienteBuscar  = new Cliente(cedula,nombre);
			}
			else if(direccion.equals("0")){
				clienteBuscar  = new Cliente(cedula,nombre,telefono);
			}
			else if(telefono != 0  ){
				clienteBuscar  = new Cliente(cedula,nombre,direccion);
			}
			else{
				clienteBuscar  = new Cliente(cedula,nombre,telefono,direccion);
			}
			//System.out.println(clienteBuscar);
			
			System.out.println("Cliente creado con exito ");
			System.out.println("Por ser cliente nuevo se le regala el siguiente producto: ");
			  
			  //4
			  //[2,3] cantidad > 0
			  //restarproducto()
			    
			
			int longitudInvetario = f.getInventario().getProductos().size();
			int cantidadObjetos = 0;
			while(cantidadObjetos == 0) {
				int indiceProductoAleatorio = (int)(Math.random() * longitudInvetario); //error
				
				cantidadObjetos =  (int)(f.getInventario().getProductos().get(indiceProductoAleatorio))[1];
				
			
				if(longitudInvetario > 0 && cantidadObjetos>0){
					Object productoRegalo = (f.getInventario().getProductos().get(indiceProductoAleatorio))[0];
					f.getInventario().restarProducto( ((Producto)productoRegalo).getReferencia(), 1);
				
					Object[] productosPedidos = {(Producto)productoRegalo,1} ;
					
					ArrayList<Object[]> productosFactura =new  ArrayList<Object[]>() ; //error
					productosFactura.add(productosPedidos);
					Factura facturaNueva = new Factura(fecha , productosFactura, "Venta",empleadoEncargado,clienteBuscar);
					
					System.out.println("-----------FACTURA-----------");
					System.out.println("Fecha: " + facturaNueva.getFecha());
					System.out.println("Dirección Ferreteria: " + f.getDireccion());
					System.out.println("Número factura: " + facturaNueva.getNumerofactura());
					System.out.println("Cedula Cliente: " + facturaNueva.getCliente().getCedula());
					System.out.println("Nombre Cliente: " + facturaNueva.getCliente().getNombre());
					System.out.println("Producto regaldo:");
					System.out.println("Referencia    Nombre    Cantidad   PrecioUnidad");
					for (Object[] p : productosFactura) {
						System.out.println(facturaNueva.Mostrar(p));
					}
					System.out.println("valor total 0");
					
					break;
				
				}
			
			}
			
		
			
			
			
			
			resultado = "Cliente creado con exito";

		}
	
		// Funcionalidad 2
		public static void devolucion(Ferreteria f,int pedido1, ArrayList<Object[]> productos) throws ExceptionC1{
			Scanner input = new Scanner(System.in);
			
				System.out.println("DEVOLUCIÓN");
				System.out.println("----------");
				double devolver =0;
				
				System.out.println("digite el número de la factura:");
				int pedido=1;
				
				pedido = pedido1;	
				 
				Factura facturabuscar=Ferreteria.buscarFactura(pedido);
				
				if(facturabuscar instanceof Factura) {
					resultado = resultado +("Referencia"+"      "+"nombre"+"                 "+"Cantidad");
					
				   for(Object[] p: facturabuscar.getProductosFactura()) {
					  
							Producto producto = (Producto) p[0];
							resultado = resultado + (producto.getReferencia()+"           "+producto.getNombre()+"                     "+p[1]) + "\n";
							
				   }
				   int referencia=1;
				   /*while (referencia!=0) {
					   double devolver =0;
					   System.out.println("Digite la referencia del producto que se desea devolver o 0 para finalizar");
					   referencia = referencia1;
					   System.out.println("Digite la cantidad de productos que se desean devolver");
						int cantidad = cantidad1;
						
						devolver = facturabuscar.RetirarProducto(referencia, cantidad);
						System.out.println(" ");
						System.out.println("valor a devolver al cliente: " + devolver);	
				   }*/
				   for(Object[] producto: productos) {
					   devolver += facturabuscar.RetirarProducto(Integer.parseInt((String)producto[0]), Integer.parseInt((String)producto[1]));
					   
				   }
				   
				   resultado = resultado + "valor a devolver al cliente: " + devolver + "\n";
				   
				   resultado = resultado + ("proceso finalizado")+ "\n";
				   for(Object[] p: facturabuscar.getProductosFactura()) {
						Producto producto = (Producto) p[0];
						resultado = resultado + (producto.getReferencia()+"           "+producto.getNombre()+"                     "+p[1]) + "\n";
				   }
				//break;
				}
				
				
				else if( facturabuscar== (null) ) {
					//resultado = ("La factura no existe en el sistema, por favor ingrese un numero de factura válido");
					throw new ExceptionC1("valor de criterio erróneo:factura no encontrada","Factura");
				}
				
				 
				 
			
				
				
				
				
				
		    }
				
				//System.out.println("Dijite el código de otra funcionalidad");

		


	// Funcionalidad 3
	// Funcionalidad 3
	public static void VenderProductos(Ferreteria f,int cedulaComprador1,int cedulaEmpleado1,String fecha1,ArrayList<Object[]> productos) throws ExceptionC1 {
		Scanner input = new Scanner(System.in);

		System.out.println("Digite la cedula del comprador");
		int cedulaComprador = cedulaComprador1;

		if (Cliente.buscarCedula(cedulaComprador) == true) {
			System.out.println("Digite la cedula del empleado que lo atendió"); 
			Empleado empleadoEncargado = null;
			boolean a = true;
			
			
			/*do {
				int empleado = input.nextInt();
				a = Empleado.buscarCedulaEmpleado(empleado);
				empleadoEncargado = f.buscarEmpleado(empleado);
				if (a == false) {
					System.out.println("Empleado no encontrado, digite otra cedula");
				}
			} while (!a);*/
			int empleado = cedulaEmpleado1;
			a = Empleado.buscarCedulaEmpleado(empleado);
			empleadoEncargado = f.buscarEmpleado(empleado);
			if (a == false) {
				System.out.println("Empleado no encontrado, digite otra cedula");
				throw new ExceptionC1("valor de criterio erróneo:empleado no encontrado","Cliente");
				
			}
			
			System.out.println("Digite la fecha en el siguiente formato: DIA/MES/AÑO");
			String fecha = fecha1;
			//String producto = "hola";

			ArrayList<Object[]> productosPedidos = new ArrayList<Object[]>();
			
				System.out.println("Digite el producto de la siguiente manera: referencia,cantidad");
				//producto = input.next();

				//String producto2[] = producto.split(",");
				//int referencia = Integer.parseInt(producto2[0]);
				//int cantidadPedida = Integer.parseInt(producto2[1]);
				
				 for(Object[] producto: productos) {
					 f.getInventario().restarProducto(Integer.parseInt((String)producto[0]), Integer.parseInt((String)producto[1]));
					 Object productoYcantidad[] = { f.getInventario().buscarProducto(Integer.parseInt((String)producto[0])),Integer.parseInt((String)producto[1]) };
					 productosPedidos.add(productoYcantidad);  
				 }
				 
				 Factura facturaNueva = new Factura(fecha, productosPedidos, "Venta", empleadoEncargado,Cliente.buscarCedula((long)cedulaComprador));
				 
				 resultado = resultado + ("-----------FACTURA-----------") + "\n";
				 resultado = resultado + ("Fecha: " + facturaNueva.getFecha()) + "\n";
				 resultado = resultado + ("Dirección Ferreteria: " + f.getDireccion()) + "\n";
				 resultado = resultado + ("Número factura: " + facturaNueva.getNumerofactura()) + "\n";
				 resultado = resultado + ("Cedula Cliente: " + facturaNueva.getCliente().getCedula())+ "\n";
				 resultado = resultado + ("Nombre Cliente: " + facturaNueva.getCliente().getNombre()) + "\n";
				 resultado = resultado + ("Productos comprados:") + "\n";
				 resultado = resultado + ("Referencia    Nombre    Cantidad   PrecioUnidad") + "\n";
				 
				 for (Object[] p : productosPedidos) {
						
					 resultado = resultado + (facturaNueva.Mostrar(p)) + "\n";
					}
				// este if se encarga de determinar de parar la funcionalidad (de que ya no se
				// pida más productos para vender)
				/*if (producto.equals("0,0")) {

					   //sobrecarga
					System.out.println("-----------FACTURA-----------");
					System.out.println("Fecha: " + facturaNueva.getFecha());
					System.out.println("Dirección Ferreteria: " + f.getDireccion());
					System.out.println("Número factura: " + facturaNueva.getNumerofactura());
					System.out.println("Cedula Cliente: " + facturaNueva.getCliente().getCedula());
					System.out.println("Nombre Cliente: " + facturaNueva.getCliente().getNombre());
					System.out.println("Productos comprados:");
					System.out.println("Referencia    Nombre    Cantidad   PrecioUnidad");
					for (Object[] p : productosPedidos) {
						
						System.out.println(facturaNueva.Mostrar(p));
					}

					//f.getFacturas().add(facturaNueva); //<---- posiblemente tenga que quitar esta linea

					System.out.println("Valor total " + facturaNueva.CalcularValorTotal());
					
				}*/
				 for (Object[] producto : productos) {
				boolean existenciaProducto = f.getInventario().buscarExistenciaProducto(Integer.parseInt((String)producto[0]));
				
			
				 }
				/*
				if (existenciaProducto) {

					ArrayList<Object[]> inventario = f.getInventario().getProductos();
					for (int i = 0; i < inventario.size(); i++) {
						if (((Producto) inventario.get(i)[0]).getReferencia() == referencia) {
							if (cantidadPedida > (int) inventario.get(i)[1]) {
								System.out.println("");
								System.out
										.println("cantidades disponibles del producto pedido: " + inventario.get(i)[1]);
								break;
							}

							else {
								System.out.println("ok!");
								Object productoYcantidad[] = { f.getInventario().buscarProducto(referencia),
										cantidadPedida };
								System.out.println(f.getInventario().buscarProducto(referencia).getReferencia());
								productosPedidos.add(productoYcantidad);
								f.getInventario().restarProducto(referencia, cantidadPedida);

								break;
							}

						}
					}

					// se añade la facutara del compradaor a la lista de facturas de la ferreteria

				}

				else {

					System.out.println("No se puede el producto no existe");

					// este for se encarga de buscar las cantidades disponibles del producto

				}*/

			
		}

		else {
			
			throw new ExceptionC1("valor de criterio erróneo:Cliente no registrado","Cliente");

		}
		System.out.println("Dijite el código de otra funcionalidad");
	}


	// Funcionalidad 4
	


	
	   public static void pedido (Ferreteria f,String fecha,int cedulaProveedor,ArrayList<Object[]> productos) throws ExceptionC1 {
		   
		   Scanner input = new Scanner(System.in);
		   System.out.println("HACER PEDIDO");
			System.out.println("------------");
			
			System.out.println("Digite la fecha en el siguiente formato: DIA/MES/AÑO");
			String fechaf= fecha;
			
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
		    
		    System.out.println("Digite la cedula o el Nit del proveedor");
			int x= cedulaProveedor;
		    confirmacion = Proveedores.buscarIdent(x);
		    if(confirmacion==0) {
		    	System.out.println("proveedor encontrado");
		    }
		    else {
		    	throw new ExceptionC1("valor de criterio erróneo:Proveedor no encontrado","Cliente");
		    	//System.out.println("proveedor no encontrado");
		    }
		    
		    int acumulado = 0;
		    ArrayList<Object[]> lista = new ArrayList<Object[]>();
		    for(Object[] producto: productos) {
				 int producto1 = Integer.parseInt((String)producto[0]);
				 int cantidad = Integer.parseInt((String)producto[1]);
				 System.out.println(producto1);
				 System.out.println(cantidad);
				 Object[] a = new Object[2];
				 a[0] = f.getInventario().buscarProducto(producto1);
				 a[1] = cantidad;
				 acumulado += Inventario.agregarProducto(producto1, cantidad);
				 lista.add(a);
				 
		    }
		    
		    
		    Factura facturaNueva = new Factura(fechaf, lista,"compra",acumulado );
		    resultado = resultado + ("proceso finalizado") +"\n";
		    resultado = resultado + ("-----------FACTURA-----------");
		    resultado = resultado + ("Número de factura:"+ facturaNueva.getNumerofactura())+ "\n";
		    resultado = resultado + ("fecha: "+ fechaf) +"\n";
		    resultado = resultado + ("Productos comprados:")+"\n";
		    resultado = resultado + ("Referencia   Cantidad   valor")+"\n";
			for(Object[] p : lista) {
				
				
				resultado = resultado +( (((Producto)p[0]).getReferencia()) + "            "+ p[1] +" "+((Producto) p[0]).FormadeVenta()+"         "+ ((((Producto)p[0]).getPrecio()/10)*7)) +"\n";
			 }
		    /*
		    //double acumulado = 0;
		    int y = 1,z=1;
		    //ArrayList<Object[]> lista = new ArrayList<Object[]>();
		   
		    while(y!=0 || z!=0) {
		    		
		    System.out.println("Digite el código de cada producto y la cantidad a pedir,finalice su pedido digitando los dos valores en 0");
		    y=input.nextInt();
		    z=input.nextInt();
		    
		    if(y==0 && z==0) {
		    	break;
		    }
		    double aux=0;
		    Object[] a = new Object[2];
		    a[0] = f.getInventario().buscarProducto(y);
		    aux=acumulado;
		    acumulado += Inventario.agregarProducto(y, z);
		    if(acumulado ==0|| acumulado==aux) {
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
		    System.out.println("Número de factura:"+ facturaNueva.getNumerofactura());
		    System.out.println("fecha: "+ fechaf);
		    System.out.println("Productos comprados:");
			System.out.println("Referencia   Cantidad   valor");
			for(Object[] p : lista) {
				
				
				System.out.println( (((Producto)p[0]).getReferencia()) + "            "+ p[1] +" "+((Producto) p[0]).FormadeVenta()+"         "+ ((((Producto)p[0]).getPrecio()/10)*7));
			 }
			
			}
		    
		    else {
			    System.out.println("No se realizó ninguna compra");
		    }
				
			 
		    System.out.println( "-------------------------------");
					System.out.println( "total                   "+ acumulado);
					
					System.out.println("Dijite el código de otra funcionalidad");
					*/
   
	   }

   
 //funcionalidad 5
	
 	public static void GananciasNetasMensuales(Ferreteria f,int año) {
 		
 	
 		
 		
 		
 		
 		//ir a facturas, ordenarlas por mes, buscar el cliente que más se repite,, usar un metodo de la clase cliente
 		
 		
 		
 		Scanner input = new Scanner(System.in);
 		
 		System.out.println("Dijite el año de consulta");
 		resultado = resultado + "                                    " + año + "\n";
 		resultado = resultado +  "Mes"+ "        " +"Ganancias Totales"+ "        " +"Gastos Totales"+ "        " + "Ganancias Netas" + "        " + "Cliente con más compras" + "\n";
 		resultado = resultado +  "----------------------------------------------------------------------------------------------------" + "\n";
 		
 		
 		System.out.println("                                    " + año);
 		System.out.println("Mes"+ "        " +"Ganancias Totales"+ "        " +"Gastos Totales"+ "        " + "Ganancias Netas" + "        " + "Cliente con más compras");
 		System.out.println("----------------------------------------------------------------------------------------------------");
 		
 		for(int i = 1; i<=12 ;i++){
 			resultado = resultado + i + "               " + f.VentasMensuales(i,año)+ "                   " + (Empleado.SueldoMensualEmpleados() + f.ComprasMensuales(i, año))+ "                " + (f.VentasMensuales(i,año) - (Empleado.SueldoMensualEmpleados() + f.ComprasMensuales(i, año)) ) + "                "  + f.ClienteMayorCompras(i, año).getCedula() + "\n";
 			System.out.println(i + "               " + f.VentasMensuales(i,año)+ "                   " + (Empleado.SueldoMensualEmpleados() + f.ComprasMensuales(i, año))+ "                " + (f.VentasMensuales(i,año) - (Empleado.SueldoMensualEmpleados() + f.ComprasMensuales(i, año)) ) + "                "  + f.ClienteMayorCompras(i, año).getCedula());
 			
 			
 			
 			
 		}
 		
 		
 		 //resultado = "";
 		System.out.println("Dijite el código de otra funcionalidad");

 		
 	} 
 	

 	
 	
 	public static void salirDelPrograma(Ferreteria f){
			System.out.println("Sistema cerrado");
			Serializador.serializar(f);
			//System.exit(0);
		}
	public Ferreteria getFerr() {
		return ferr;
	}
	public void setFerr(Ferreteria ferr) {
		this.ferr = ferr;
	}
		
		

}