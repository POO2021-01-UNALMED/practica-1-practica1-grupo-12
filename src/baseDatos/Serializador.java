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

import Almacen.*;
public class Serializador {

	private static File rutaTemp = new File("src\\baseDatos\\temp\\testLista.txt");
	
	public static void serializar(Ferreteria ferr) {
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
			}else if (file.getAbsolutePath().contains("invetario")) {
			 try {
			 fos = new FileOutputStream(file); 
			oos = new ObjectOutputStream(fos); 
			oos.writeObject(ferr.getInventario().getProductos()); 
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
