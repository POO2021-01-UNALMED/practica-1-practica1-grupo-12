package Almacen;

public class Domiciliario extends Empleado {
  private String TipoVeiculo;
  private String PlacaVeiculo;
  private int NumeroPedidos;
  
  public Domiciliario(int cedula,String nombre,String cargo,
       int sueldo,String TipoVeiculo,String PlacaVeiculo,int NumeroPedidos) {
	   super(cedula, nombre,cargo,sueldo);
	   this.TipoVeiculo = TipoVeiculo;
	   this.PlacaVeiculo = PlacaVeiculo;
	   this.NumeroPedidos = NumeroPedidos;
  }
  
}
