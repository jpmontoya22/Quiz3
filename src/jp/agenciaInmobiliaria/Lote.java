package jp.agenciaInmobiliaria;

public class Lote extends Inmueble {

	public Lote(String direccion, long valorVenta, long valorArriendo, boolean arrendado) {
		super(direccion, valorVenta, valorArriendo, arrendado);
	}

	@Override
	public String toString() {
		return "Direcci�n: " + this.getDireccion() + "\n" + "Valor de venta: " + this.getValorVenta() + "\n"
				+ "Valor de arriendo: " + this.getValorArriendo() + "\n" + "�Est� arrendado?: " + this.isArrendado();
	}
}
