package uiMain;
import java.util.*;
public class Main {
	public static void main(String[] args){
		
		
		
		System.out.println("------------------------------------------");
		System.out.println("//BIENVEDIOS AL SOFTWARE DE LA FERRETERÍA//");
		System.out.println("------------------------------------------");
		System.out.println("Selecciona el número correspondiente a la funcionalidad");
		System.out.println("1.Vender producto"); //Inventario productos domiciliario cliente factura
		System.out.println("2.Devolver producto"); //tomar numero factura ---> revisar si existe ---> meter productos a inventario ---> verificar si se devuelven todos o no ---> en caso de devolver todos los productos se anula la factura
		System.out.println("3. Mostrar ranking empleados"); //
		System.out.println("4. funcionalidad");
		System.out.println("5. funcionalidad");
		System.out.println("Presione  6 para salir");
		
		Scanner input = new Scanner(System.in);
		
		int opcion = 0;
		
		do{
			opcion = input.nextInt();
		switch(opcion){
		



			case 1: System.out.println("funcionalidad 1");
					break;
			case 2: System.out.println("funcionalidad 2");
					break;
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
}
