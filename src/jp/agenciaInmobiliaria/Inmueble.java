package jp.agenciaInmobiliaria;

public abstract class Inmueble {
	
	private String direccion;
	private long valorVenta;
	private long valorArriendo;
	private boolean arrendado;
	
	
	
	public Inmueble(String direccion, long valorVenta, long valorArriendo, boolean arrendado) {
		super();
		this.direccion = direccion;
		this.valorVenta = valorVenta;
		this.valorArriendo = valorArriendo;
		this.arrendado = arrendado;
	}

	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public long getValorVenta() {
		return valorVenta;
	}
	
	public void setValorVenta(long valorVenta) {
		this.valorVenta = valorVenta;
	}
	
	public long getValorArriendo() {
		return valorArriendo;
	}
	
	public void setValorArriendo(long valorArriendo) {
		this.valorArriendo = valorArriendo;
	}
	
	public boolean isArrendado() {
		return arrendado;
	}
	
	public void setArrendado(boolean arrendado) {
		this.arrendado = arrendado;
	}
	
	@Override
	public String toString() {
		return "Dirección: " + this.getDireccion() + "\n" + "Valor de venta: " + this.getValorVenta() + "\n"
				+ "Valor de arriendo: " + this.getValorArriendo() + "\n" + "¿Está arrendado?: " + this.isArrendado();
	}
	
	

}
