package uiMain;
import java.util.*;

import Almacen.Empleado;
import Almacen.Ferreteria;
import Almacen.Herramienta;
import Almacen.Inventario;
import Almacen.MaterialDeConstruccion;
import Almacen.Producto;
import Ventas.Cliente;
import Ventas.Factura;
public class Main {
	
	public static void main(String[] args){
		
		Cliente jaime = new Cliente(2, "jaime", 31231, "cadca");
		Empleado javier = new Empleado(3,"javier,","cajero",20000);
		Ferreteria ferr =  new Ferreteria();
		
		
		Herramienta b = new Herramienta(2, "Martillo", 23.3, true,"Grande");
		
		MaterialDeConstruccion g = new MaterialDeConstruccion(3, "CEMENTO", 12.3, true,true);
		Object a[] = {b,2};
		Object c[] = {g,3};
		ferr.getInventario().getProductos().add(a);
		ferr.getInventario().getProductos().add(c);
		
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
			case 2:devolucion();break;
			case 3: VenderProductos(ferr);
					break;
			case 4: System.out.println("funcionalidad 4");
					break;
			case 5: System.out.println("funcionalidad 5");
					break;
			
								
			case 6:	System.out.println("salir");
					break;
			 
			
		
			}
		}while(opcion != 6);
	
	}
	
	
	// Funcionalidad 2
	static void devolucion() {
		Scanner input = new Scanner(System.in);
		
			System.out.println("DEVOLUCIÓN");
			System.out.println("----------");
			Cliente jaime = new Cliente(2, "jaime", 31231, "cadca");
			ArrayList<Object[]> productosPrueba = new ArrayList<Object[]>();
			Herramienta h = new Herramienta(123, "martillo", 20000, true,"grande");
			Herramienta i = new Herramienta(124, "destornillador", 20000, true,"mediano");
			Object[] objeto = {h,2};
			Object[] objeto1 = {i,3};
			productosPrueba.add(objeto);
			productosPrueba.add(objeto1);
			Factura factura1 = new Factura("21 Marzo",productosPrueba,"venta",new Empleado(145,"Juan","vendedor",1000000),jaime);
			
			
			System.out.println("digite el número de la factura:");
			int pedido=1;
			while(pedido != 0) {
			 pedido = input.nextInt();	
			for(Factura factura:Ferreteria.facturas) {
				if(factura.getNumerofactura()==pedido) {
					pedido=0;
					System.out.println(" ");
					factura.MostrarProductos();
					System.out.println(" ");
				    int ref=1;
					while(ref != 0) {
					
					System.out.println("Digite la referencia del producto que se desea devolver o 0 para finalizar");
				    ref = input.nextInt();
				    if (ref!=0) {
					System.out.println("Digite la cantidad de productos que se desean devolver");
					int cantidad = input.nextInt();
					
					factura1.RetirarProducto(ref, cantidad);
					System.out.println(" ");
					}
					
					else {
						
						System.out.println("Proceso finalizado, presione 6 para salir");
						break;
						
					}
				}}
				
				else {
					System.out.println("La factura no existe en el sistema, por favor ingrese un numero de factura válido");
					
				}
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






}