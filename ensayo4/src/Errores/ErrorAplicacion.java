package Errores;

public class ErrorAplicacion extends Exception {
	private static final long serialVersionUID = 1L;

	public ErrorAplicacion(String Error){
		super("Manejo de errores de la Aplicación:" + Error);
	}
}
