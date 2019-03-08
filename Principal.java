package iSoftware;

import java.util.Scanner;

public class Principal {

	@SuppressWarnings("deprecation")
	private static void moler() throws InterruptedException {
		java.util.Date fechaActual = new java.util.Date();
		System.out.println("D�a: " + fechaActual.getDate());
		System.out.println("Moliendo...");
		Thread.sleep(3000);
		fechaActual.setDate(fechaActual.getDate() + 1);
		System.out.println("Proceso de molienda finalizado. D�a: " + fechaActual.getDate());
	}
	
	@SuppressWarnings("deprecation")
	private static void cocinar() throws InterruptedException {
		java.util.Date fechaActual = new java.util.Date();
		System.out.println("D�a: "+fechaActual.getDate());
		System.out.println("Moliendo...");
		Thread.sleep(3000);
		fechaActual.setDate(fechaActual.getDate()+1); 
		System.out.println("Proceso de molienda finalizado. D�a: "+fechaActual.getDate());
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("�Desea generar un lote? (s/n)");
		Scanner sc = new Scanner(System.in);
		String answ = sc.nextLine();
		switch(answ.toLowerCase()) {
		case "s":
			if(AlmacenLotes.getLista().size()==AlmacenLotes.getMaxCapacidad()) {
				System.err.println("Alerta: El almacen de lotes esta completo. Recuerde que no podra almacenar el lote que va a producir si no vacia el almacen");
			}
			else {
			System.out.println("Comienza la fase de molienda.");
			moler();
			System.out.println("Comienza la fase de cocinado.");
			cocinar();
			/*System.out.println("Comienza la fase de fermentación.");
			fermentar();
			System.out.println("Comienza la segunda fase de fermentación.");
			fermentar();
			System.out.println("Comienza la fase de embotellado.");
			embotellar();
			*/
			}
			break;
		case "n":
			Scanner sca = new Scanner(System.in);
			System.out.println("Inserte el lote sobre el que desea consultar: ");
			String lote = sca.nextLine();
			int id = Integer.parseInt(lote);
			if (id > AlmacenLotes.id) System.err.println("Lote introducido incorrecto.");
			break;
		}

	}

}