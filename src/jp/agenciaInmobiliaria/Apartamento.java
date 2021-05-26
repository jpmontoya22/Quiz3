package jp.agenciaInmobiliaria;

public class Apartamento extends Inmueble implements Arrendable {

	public Apartamento(String direccion, long valorVenta, long valorArriendo, boolean arrendado) {
		super(direccion, valorVenta, valorArriendo, arrendado);
	}

	@Override
	public void arrendar() {

	}

	@Override
	public void devolver() {

	}

	@Override
	public String toString() {
		return "Dirección: " + this.getDireccion() + "\n" + "Valor de venta: " + this.getValorVenta() + "\n"
				+ "Valor de arriendo: " + this.getValorArriendo() + "\n" + "¿Está arrendado?: " + this.isArrendado();
	}

}
