package baseDatos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import Almacen.*;
import Ventas.*;

public class Deserializador {
	
	private static File rutaTemp = new File("src\\basedatos\\temp");
	
	public static void deserializar(Ferreteria f) {
		File[] docs = rutaTemp.listFiles();
		FileInputStream fis;
		ObjectInputStream ois;
		
		for (File file : docs) {
			if (file.getAbsolutePath().contains("facturas")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					f.setFacturas((ArrayList<Factura>) ois.readObject());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (file.getAbsolutePath().contains("clientes")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);

					Cliente.setClientes((ArrayList<Cliente>) ois.readObject());
				}

				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
			else if (file.getAbsolutePath().contains("proveedores")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);

					Proveedores.setProveedores((ArrayList<Proveedores>) ois.readObject());
				}

				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else if (file.getAbsolutePath().contains("empleados")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);

					Empleado.setEmpleados((ArrayList<Empleado>) ois.readObject());
				}

				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else if (file.getAbsolutePath().contains("productos")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);

					Inventario.setProductos((ArrayList<Object[]>) ois.readObject());
				}

				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
	}
}