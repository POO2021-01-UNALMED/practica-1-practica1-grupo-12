package Errores;

public class ExceptionC1 extends ErrorAplicacion {
	String tipoError;
	private static final long serialVersionUID = 1L;

	public ExceptionC1(String e){
		super(e);
		
	}
	
	public ExceptionC1(String e,String d){
		super(e);
		this.tipoError=d;
	}

	public String getTipoError() {
		return tipoError;
	}

	public void setTipoError(String tipoError) {
		this.tipoError = tipoError;
	}	
	
	
	
}
