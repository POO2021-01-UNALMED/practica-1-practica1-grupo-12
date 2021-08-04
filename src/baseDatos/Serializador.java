package baseDatos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicación.Almacen.Empleado;
import gestorAplicación.Almacen.Ferreteria;
import gestorAplicación.Almacen.Inventario;
import gestorAplicación.Almacen.Proveedores;
import gestorAplicación.Ventas.Cliente;
import gestorAplicación.Ventas.Factura;
public class Serializador {

	private static File rutaTemp = new File("src\\baseDatos\\temp\\");
	
	public static void serializar(Ferreteria ferr) {
		
		//System.out.println("entrooo");
		
		
		
		
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		File[] docs = rutaTemp.listFiles();
		PrintWriter pw;
		
		// aca se borra el contenido de los documentos antes de guardar
		for(File f : docs) {
			try{
				pw = new PrintWriter(f);
				
			}
			catch(FileNotFoundException e){
				
				e.printStackTrace();
				
			}
			
		}  
		
		
		//
		
		for (File file : docs) {
			 if (file.getAbsolutePath().contains("facturas")) {
			 try { 
			fos = new FileOutputStream(file);
			 oos = new ObjectOutputStream(fos); 
			
		
			 
			 oos.writeObject(ferr.getFacturas()); 
			
			} 
			catch (FileNotFoundException e) {

			 e.printStackTrace();
			 } 
			catch (IOException e) {
			 
			e.printStackTrace(); 
			} 
			}else if (file.getAbsolutePath().contains("clientes")) {
			 try {
			 fos = new FileOutputStream(file); 
			oos = new ObjectOutputStream(fos); 
			oos.writeObject(Cliente.getClientes()); 
			} 
			catch (FileNotFoundException e) {
			  e.printStackTrace();
			 } 
			catch (IOException e) {

			 e.printStackTrace();
			}
		}
		else if (file.getAbsolutePath().contains("proveedores")) {
			 try {
			 fos = new FileOutputStream(file); 
			oos = new ObjectOutputStream(fos); 
			oos.writeObject(Proveedores.getProveedores()); 
			} 
			catch (FileNotFoundException e) {
			  e.printStackTrace();
			 } 
			catch (IOException e) {

			 e.printStackTrace();
			}
		}
		else if (file.getAbsolutePath().contains("empleados")) {
			 try {
			 fos = new FileOutputStream(file); 
			oos = new ObjectOutputStream(fos); 
			oos.writeObject(Empleado.getEmpleados()); 
			} 
			catch (FileNotFoundException e) {
			  e.printStackTrace();
			 } 
			catch (IOException e) {

			 e.printStackTrace();
			}
		}
		else if (file.getAbsolutePath().contains("productos")) {
			 try {
			 fos = new FileOutputStream(file); 
			oos = new ObjectOutputStream(fos); 
			oos.writeObject(Inventario.getProductos()); 
			} 
			catch (FileNotFoundException e) {
			  e.printStackTrace();
			 } 
			catch (IOException e) {

			 e.printStackTrace();
			}
		}	 
			 
			 
		}
	}
}
