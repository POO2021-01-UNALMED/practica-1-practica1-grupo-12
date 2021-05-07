package uiMain;
import java.util.*;

import Almacen.Empleado;
import Almacen.Ferreteria;
import Almacen.Herramienta;
import Almacen.Inventario;
import Almacen.Producto;
import Ventas.Factura;
public class Main {
	
	public static void main(String[] args){
		
		
		
		System.out.println("------------------------------------------");
		System.out.println("//BIENVEDIOS AL SOFTWARE DE LA FERRETERÍA//");
		System.out.println("------------------------------------------");
		System.out.println("Selecciona el número correspondiente a la funcionalidad");
		System.out.println("1.Registrar cliente"); // cuando se crea un cliente se le va a regalar un material de construccion o una herramienta que se le ofrezca de manera aletoria, suponermos que todos los clientes que se vayan a registrar van a comprar otras cosas
		System.out.println("2.Devolver producto"); //tomar numero factura ---> revisar si existe ---> meter productos a inventario ---> verificar si se devuelven todos o no ---> en caso de devolver todos los productos se anula la factura
		System.out.println("3. Vender producto"); // Se pedile la cedula--> en caso de no estar registrado el programa para e imprime "cliente no registrado precione la opcion 1" --->. En caso de estar registrado,escribir el nombre del empleado que lo atendio, pedir los productos de la siguiente manera "referencia, cantidad",revisar en inventario las cantidades si se puede satisfacer el producto imprime ok si no ingrese se imprimira que cantidades insuficientes y cuantas hay en inventario. Oprimir 0,0 para parar. Luego mostrar el total. 
		System.out.println("4.");
		System.out.println("5.");
		System.out.println("Presione  6 para salir");
		
		Scanner input = new Scanner(System.in);
		
		int opcion = 0;
		
		
		do{
			opcion = input.nextInt();
		switch(opcion){
		



			case 1: System.out.println("funcionalidad 1");
					break;
			case 2:devolucion();break;
			case 3: System.out.println("funcionalidad 3");
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
	static void devolucion() {
		Scanner input = new Scanner(System.in);
		
			System.out.println("DEVOLUCIÓN");
			System.out.println("----------");
			
			ArrayList<Object[]> productosPrueba = new ArrayList<Object[]>();
			Herramienta h = new Herramienta(123, "martillo", 20000, true,"grande");
			Herramienta i = new Herramienta(124, "destornillador", 20000, true,"mediano");
			Object[] objeto = {h,2};
			Object[] objeto1 = {i,3};
			productosPrueba.add(objeto);
			productosPrueba.add(objeto1);
			Factura factura1 = new Factura(456,"21 Marzo",productosPrueba,"venta",new Empleado(145,"Juan","vendedor",1000000));
			
			
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
}