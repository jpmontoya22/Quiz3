package jp.agenciaInmobiliaria;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class Aplicación {

	public static void main(String[] args) {
		
		List<Inmueble> inmuebles = new ArrayList<>();
		Agencia agencia = new Agencia("LOS OLIVOS", inmuebles);
		
		String menu = "               BIENVENIDO A NUESTRA AGENCIA INMOBILIARIA                  "
				+ "\n¿Qué desea hacer? (Digite una opción)"
				+ "\n1. Registrar un nuevo inmueble."
				+ "\n2. Arrendar un inmueble."
				+ "\n3. Devolver un inmueble ya arrendado."
				+ "\n4. Vender un inmueble."
				+ "\n5. Mostrar los inmuebles disponibles para su arriendo."
				+ "\n6. Mostrar los inmuebles que se encuentran arrendados."
				+ "\n7. Salir.";
		
		@SuppressWarnings("resource")
		Scanner lector = new Scanner(System.in);
		
		int opcion = 0;
		
		do {
			
			System.out.println(menu);
			opcion = lector.nextInt();
			
			switch (opcion) {
			case 1:
				
				System.out.println("¿Qué tipo de inmueble desea agregar?"
						+ "\n1. Apartamento"
						+ "\n2. Casa"
						+ "\n3. Lote");
				int tipoInmueble = lector.nextInt();
				
				
				System.out.println("Ingrese la dirección del inmueble.");
				String direccion = lector.next();
				
				System.out.println("Ingrese el valor de venta del inmueble.");
				long valorVenta = lector.nextLong();
				
				System.out.println("Ingrese el valor de arriendo del inmueble.");
				long valorArriendo = lector.nextLong();
				
				boolean arrendado = false;
				
				switch (tipoInmueble) {
				case 1:
					Apartamento apto = new Apartamento(direccion, valorVenta, valorArriendo, arrendado);
					agencia.getInmuebles().add(apto);
					break;
				case 2:
					Casa casa = new Casa(direccion, valorVenta, valorArriendo, arrendado);
					agencia.getInmuebles().add(casa);
					break;
				case 3:
					Lote lote = new Lote(direccion, valorVenta, valorArriendo, arrendado);
					agencia.getInmuebles().add(lote);
					break;
				}
		
				break;
			case 2:
				System.out.println("Ingrese la dirección del inmueble que desea arrendar");
				String direccionInmuebleAArrendar = lector.next();
				if(agencia.existeInmueble(direccionInmuebleAArrendar)) {
					if(agencia.arrendar(agencia.obtenerInmueble(direccionInmuebleAArrendar))) {
						System.out.println("Se ha arrendado el inmueble con dirección " + direccionInmuebleAArrendar);
					} else {
						System.out.println("No se puede arrendar el inmueble pues ya está arrendado o no es un inmueble arrendable.");
					}
				} else {
					System.out.println("No existe ningún inmueble con la dirección " + direccionInmuebleAArrendar + "en nuestra base de datos");
				}
				
				break;
			case 3:
				System.out.println("Ingrese la dirección del inmueble que desea devolver");
				String direccionInmuebleADevolver = lector.next();
				if(agencia.existeInmueble(direccionInmuebleADevolver)) {
					if(agencia.devolver(agencia.obtenerInmueble(direccionInmuebleADevolver))) {
						System.out.println("Se ha devuelto el inmueble con dirección " + direccionInmuebleADevolver);
					} else {
						System.out.println("No se puede devolver el inmueble pues no está arrendado o no es un inmueble arrendable.");
					}
				} else {
					System.out.println("No existe ningún inmueble con la dirección " + direccionInmuebleADevolver + "en nuestra base de datos");
				}
				
				break;
			case 4:
				System.out.println("Ingrese la dirección del inmueble que desea vender");
				String direccionInmuebleAVender = lector.next();
				if(agencia.existeInmueble(direccionInmuebleAVender)) {
					if(agencia.vender(agencia.obtenerInmueble(direccionInmuebleAVender))) {
						System.out.println("Se ha vendido el inmueble con dirección " + direccionInmuebleAVender);
					} else {
						System.out.println("No se puede vender el inmueble pues  está arrendado.");
					}
				} else {
					System.out.println("No existe ningún inmueble con la dirección " + direccionInmuebleAVender + "en nuestra base de datos");
				}
				
				break;
			case 5:
				for (Inmueble inmueble : agencia.getArrendablesDisponibles()) {
					System.out.println(inmueble.toString() + "\n");
				}
				
				break;
			case 6:
				for (Inmueble inmueble : agencia.getArrendados()) {
					System.out.println(((Apartamento) inmueble).toString() + "\n");
				}
			}
		} while (opcion != 7);
		

	}

}
