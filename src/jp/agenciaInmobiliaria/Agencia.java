package jp.agenciaInmobiliaria;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
	
	private String nombre;
	private List<Inmueble> inmuebles;
	
	
	
	public Agencia(String nombre, List<Inmueble> inmuebles) {
		super();
		this.nombre = nombre;
		this.inmuebles = inmuebles;
	}


	public void agregarInmueble(Inmueble i) {
		this.inmuebles.add(i);
	}
	

	public boolean arrendar(Inmueble inmueble) {
		boolean seArrendo = false;
		if(inmueble instanceof Arrendable) {
			if(!inmueble.isArrendado()) {
				inmueble.setArrendado(true);
				seArrendo = true;
			}
		}
		return seArrendo;
	}
	
	public boolean devolver(Inmueble inmueble) {
		boolean seDevolvio = false;
		if(inmueble instanceof Arrendable) {
			if(inmueble.isArrendado()) {
				inmueble.setArrendado(false);
				seDevolvio = true;
			}
		}
		return seDevolvio;
	}
	
	public boolean vender(Inmueble inmueble) {
		boolean seVendio = false;
		Inmueble inmuebleAVender = null;
		for (Inmueble inm : inmuebles) {
			if(inm.getDireccion().equals(inmueble.getDireccion())) {
				if(!inmueble.isArrendado()) {
					inmuebleAVender = inm;
					seVendio = true;
				}
			}
		}
		inmuebles.remove(inmuebleAVender);
		return seVendio;
	}
	
	public List<Inmueble> getArrendablesDisponibles(){
		List<Inmueble> disponibles = new ArrayList<>();
		for (Inmueble inmueble : this.inmuebles) {
			if(inmueble instanceof Arrendable) {
				if(!inmueble.isArrendado()) {
					disponibles.add(inmueble);
				}
			}
		}
		return disponibles;
	}
	
	public List<Inmueble> getArrendados(){
		List<Inmueble> arrendados = new ArrayList<>();
		for (Inmueble inmueble : this.inmuebles) {
			if(inmueble.isArrendado()) {
				arrendados.add(inmueble);
			}
		}
		return arrendados;
	}
	
	public boolean existeInmueble(String direccion) {
		boolean existe = false;
		for (Inmueble inmueble : inmuebles) {
			if(inmueble.getDireccion().equals(direccion)) {
				existe = true;
			}
		}
		return existe;
	}
	
	public Inmueble obtenerInmueble(String direccion) {
		Inmueble inmuebleAObtener = null;
		for (Inmueble inmueble : inmuebles) {
			if(inmueble.getDireccion().equals(direccion)) {
				inmuebleAObtener = inmueble;
			}
		}
		return inmuebleAObtener;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}


	public void setInmuebles(List<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}
}
