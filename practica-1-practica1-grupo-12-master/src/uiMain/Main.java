package uiMain;
import GUI.*;
import java.util.*;
import java.io.Serializable;
import java.lang.Math;
import baseDatos.*;
import gestorAplicaci�n.Almacen.Empleado;
import gestorAplicaci�n.Almacen.Ferreteria;
import gestorAplicaci�n.Almacen.Herramienta;
import gestorAplicaci�n.Almacen.Inventario;
import gestorAplicaci�n.Almacen.MaterialDeConstruccion;
import gestorAplicaci�n.Almacen.Producto;
import gestorAplicaci�n.Almacen.Proveedores;
import gestorAplicaci�n.Ventas.Cliente;
import gestorAplicaci�n.Ventas.Factura;
public class Main implements Serializable{
	public static int opcion = 0;
	public static Ferreteria ferr = new Ferreteria();
	public static String resultado = "";
	public static void main(String[] args){
		ferr = new Ferreteria();
		
		
		
		//Inicio i = new Inicio();
		
		//i.MostrarVentanaInicio(null);
		
		System.out.println("------------------------------------------");
		System.out.println("//BIENVEDIOS AL SOFTWARE DE LA FERRETER�A//");
		System.out.println("------------------------------------------");
		System.out.println("Selecciona el n�mero correspondiente a la funcionalidad");
		System.out.println("1.Registrar cliente"); // cuando se crea un cliente se le va a regalar un material de construccion o una herramienta que se le ofrezca de manera aletoria, suponermos que todos los clientes que se vayan a registrar van a comprar otras cosas
		System.out.println("2.Devolver producto"); //tomar numero factura ---> revisar si existe ---> meter productos a inventario ---> verificar si se devuelven todos o no ---> en caso de devolver todos los productos se anula la factura
		System.out.println("3. Vender producto"); // Se pedile la cedula--> en caso de no estar registrado el programa para e imprime "cliente no registrado precione la opcion 1" --->. En caso de estar registrado,escribir el nombre del empleado que lo atendio, pedir los productos de la siguiente manera "referencia, cantidad",revisar en inventario las cantidades si se puede satisfacer el producto imprime ok si no ingrese se imprimira que cantidades insuficientes y cuantas hay en inventario. Oprimir 0,0 para parar. Luego mostrar el total. 
		System.out.println("4.Hacer pedido");// Se seleccion el proveedor---> la ferrater�a pide los productos --> "referencia, cantidad" --> en caso de que no haya referencia se procede a crear el producto en nuestra ferreteria(tendr�a que pedir todos los atributos,automaticamente el precio de venta es 30% m�s caro que el precio de compra), y de esta manera para cada referencia que no est� creada.Al final calcular el valor total del pedido,ver en utilidad si hay plata para cumplir con el pedido, se procede a  crear factura, almacenarla en un arreglo y depositar los productos en el inventario en caso en contrario se cancela el pedido.
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
					devolucion(ferr);
					break;
			case 3: 
					System.out.println("funcionalidad 3");
					VenderProductos(ferr);
					break;
			case 4: 
					System.out.println("funcionalidad 4");
			        pedido(ferr);break;
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
		public static void registrarCliente(Ferreteria f,String fecha1,int cedulaEmpleado,int cedulaCliente,String nombre1,int telefono1,String Direccion1){
			
			//
			Scanner input = new Scanner(System.in);
			
			System.out.println("Digite la fecha en el siguiente formato: DIA/MES/A�O");
			String fecha = fecha1;
			
			System.out.println("digite el n�mero de la c�dula del empleado");
			Empleado empleadoEncargado = null;
			boolean a = true;
			
				int empleado = cedulaEmpleado;
				a = Empleado.buscarCedulaEmpleado(empleado);
				empleadoEncargado = f.buscarEmpleado(empleado);
				if (a == false || empleadoEncargado instanceof  Empleado) {
					System.out.println("Empleado no encontrado, digite otra cedula");
				}
			
			
			System.out.println("digite el n�mero de la c�dula del nuevo cliente");
			int cedula = 0;
			Cliente clienteBuscar = null;
			boolean a1 = true;
			
				cedula = cedulaCliente;
				a = Cliente.buscarCedula(cedula);
				clienteBuscar = Cliente.buscarCedula((long)cedula);  //sobrecarga
				//System.out.println("entro");
				//System.out.println(clienteBuscar);
				if (a == true) {
					System.out.println("Cliente ya registrado, digite otra cedula");
				}
			
			
			
			System.out.println("digite el nombre completo del nuevo cliente");
			//input.nextLine();
			String nombre = nombre1;
			
			System.out.println("digite el tel�fono del nuevo cliente,cero en caso contrario");
			int telefono = telefono1;
			
			System.out.println("digite la direcci�n del nuevo cliente,cero en caso contrario");
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
					System.out.println("Direcci�n Ferreteria: " + f.getDireccion());
					System.out.println("N�mero factura: " + facturaNueva.getNumerofactura());
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
		static void devolucion(Ferreteria f) {
			Scanner input = new Scanner(System.in);
			
				System.out.println("DEVOLUCI�N");
				System.out.println("----------");
			
				
				System.out.println("digite el n�mero de la factura:");
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
					   double devolver =0;
					   System.out.println("Digite la referencia del producto que se desea devolver o 0 para finalizar");
					   referencia = input.nextInt();
					   System.out.println("Digite la cantidad de productos que se desean devolver");
						int cantidad = input.nextInt();
						
						devolver = facturabuscar.RetirarProducto(referencia, cantidad);
						System.out.println(" ");
						System.out.println("valor a devolver al cliente: " + devolver);	
				   }
				   
				   
				   System.out.println("proceso finalizado");
				   for(Object[] p: facturabuscar.getProductosFactura()) {
						Producto producto = (Producto) p[0];
						System.out.println(producto.getReferencia()+"           "+producto.getNombre()+"                     "+p[1]);
				   }
				break;
				}
				
				
				else if( facturabuscar== (null) ) {
					System.out.println("La factura no existe en el sistema, por favor ingrese un numero de factura v�lido");
					
				}
				
				 
				 
			
				
				
				
				
				
		    }
				
				System.out.println("Dijite el c�digo de otra funcionalidad");

		}


	// Funcionalidad 3
	// Funcionalidad 3
	static void VenderProductos(Ferreteria f) {
		Scanner input = new Scanner(System.in);

		System.out.println("Digite la cedula del comprador");
		int cedulaComprador = input.nextInt();

		if (Cliente.buscarCedula(cedulaComprador) == true) {
			System.out.println("Digite la cedula del empleado que lo atendi�"); 
			Empleado empleadoEncargado = null;
			boolean a = true;
			do {
				int empleado = input.nextInt();
				a = Empleado.buscarCedulaEmpleado(empleado);
				empleadoEncargado = f.buscarEmpleado(empleado);
				if (a == false) {
					System.out.println("Empleado no encontrado, digite otra cedula");
				}
			} while (!a);

			System.out.println("Digite la fecha en el siguiente formato: DIA/MES/A�O");
			String fecha = input.next();
			String producto = "hola";

			ArrayList<Object[]> productosPedidos = new ArrayList<Object[]>();
			do {
				System.out.println("Digite el producto de la siguiente manera: referencia,cantidad");
				producto = input.next();

				String producto2[] = producto.split(",");
				int referencia = Integer.parseInt(producto2[0]);
				int cantidadPedida = Integer.parseInt(producto2[1]);

				// este if se encarga de determinar de parar la funcionalidad (de que ya no se
				// pida m�s productos para vender)
				if (producto.equals("0,0")) {

					Factura facturaNueva = new Factura(fecha, productosPedidos, "Venta", empleadoEncargado,Cliente.buscarCedula((long)cedulaComprador));   //sobrecarga
					System.out.println("-----------FACTURA-----------");
					System.out.println("Fecha: " + facturaNueva.getFecha());
					System.out.println("Direcci�n Ferreteria: " + f.getDireccion());
					System.out.println("N�mero factura: " + facturaNueva.getNumerofactura());
					System.out.println("Cedula Cliente: " + facturaNueva.getCliente().getCedula());
					System.out.println("Nombre Cliente: " + facturaNueva.getCliente().getNombre());
					System.out.println("Productos comprados:");
					System.out.println("Referencia    Nombre    Cantidad   PrecioUnidad");
					for (Object[] p : productosPedidos) {
						
						System.out.println(facturaNueva.Mostrar(p));
					}

					//f.getFacturas().add(facturaNueva); //<---- posiblemente tenga que quitar esta linea

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

					// se a�ade la facutara del compradaor a la lista de facturas de la ferreteria

				}

				else {

					System.out.println("No se puede el producto no existe");

					// este for se encarga de buscar las cantidades disponibles del producto

				}

			} while (true);
		}

		else {
			System.out.println("Cliente no registrado, precione la opcion 1");

		}
		System.out.println("Dijite el c�digo de otra funcionalidad");
	}


	// Funcionalidad 4
	


	
	   static void pedido (Ferreteria f) {
		   
		   Scanner input = new Scanner(System.in);
		   System.out.println("HACER PEDIDO");
			System.out.println("------------");
			
			System.out.println("Digite la fecha en el siguiente formato: DIA/MES/A�O");
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
		    		
		    System.out.println("Digite el c�digo de cada producto y la cantidad a pedir,finalice su pedido digitando los dos valores en 0");
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
		    System.out.println("N�mero de factura:"+ facturaNueva.getNumerofactura());
		    System.out.println("fecha: "+ fechaf);
		    System.out.println("Productos comprados:");
			System.out.println("Referencia   Cantidad   valor");
			for(Object[] p : lista) {
				
				
				System.out.println( (((Producto)p[0]).getReferencia()) + "            "+ p[1] +" "+((Producto) p[0]).FormadeVenta()+"         "+ ((((Producto)p[0]).getPrecio()/10)*7));
			 }
			
			}
		    
		    else {
			    System.out.println("No se realiz� ninguna compra");
		    }
				
			 
		    System.out.println( "-------------------------------");
					System.out.println( "total                   "+ acumulado);
					
					System.out.println("Dijite el c�digo de otra funcionalidad");
   
	   }

   
 //funcionalidad 5
	
 	public static void GananciasNetasMensuales(Ferreteria f,int a�o) {
 		
 	
 		
 		
 		
 		
 		//ir a facturas, ordenarlas por mes, buscar el cliente que m�s se repite,, usar un metodo de la clase cliente
 		
 		
 		
 		Scanner input = new Scanner(System.in);
 		
 		System.out.println("Dijite el a�o de consulta");
 		resultado = resultado + "                                    " + a�o + "\n";
 		resultado = resultado +  "Mes"+ "        " +"Ganancias Totales"+ "        " +"Gastos Totales"+ "        " + "Ganancias Netas" + "        " + "Cliente con m�s compras" + "\n";
 		resultado = resultado +  "----------------------------------------------------------------------------------------------------" + "\n";
 		
 		
 		System.out.println("                                    " + a�o);
 		System.out.println("Mes"+ "        " +"Ganancias Totales"+ "        " +"Gastos Totales"+ "        " + "Ganancias Netas" + "        " + "Cliente con m�s compras");
 		System.out.println("----------------------------------------------------------------------------------------------------");
 		
 		for(int i = 1; i<=12 ;i++){
 			resultado = resultado + i + "               " + f.VentasMensuales(i,a�o)+ "                   " + (Empleado.SueldoMensualEmpleados() + f.ComprasMensuales(i, a�o))+ "                " + (f.VentasMensuales(i,a�o) - (Empleado.SueldoMensualEmpleados() + f.ComprasMensuales(i, a�o)) ) + "                "  + f.ClienteMayorCompras(i, a�o).getCedula() + "\n";
 			System.out.println(i + "               " + f.VentasMensuales(i,a�o)+ "                   " + (Empleado.SueldoMensualEmpleados() + f.ComprasMensuales(i, a�o))+ "                " + (f.VentasMensuales(i,a�o) - (Empleado.SueldoMensualEmpleados() + f.ComprasMensuales(i, a�o)) ) + "                "  + f.ClienteMayorCompras(i, a�o).getCedula());
 			
 			
 			
 			
 		}
 		
 		
 		 //resultado = "";
 		System.out.println("Dijite el c�digo de otra funcionalidad");

 		
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