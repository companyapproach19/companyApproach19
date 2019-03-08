package iSoftware;

import java.util.Scanner;

public class Principal {
	
	private static java.util.Date fechaActual = new java.util.Date();

	@SuppressWarnings("deprecation")
	public static int moler(Lote lote) throws InterruptedException {
		//java.util.Date fechaActual = new java.util.Date();
		//lote.setFecha_inicio(fechaActual);
		System.out.println("Día: " + fechaActual.getDate());
		System.out.println("Moliendo...");
		Thread.sleep(3000);
		fechaActual.setDate(fechaActual.getDate() + 1);
		System.out.println("Proceso de molienda finalizado. Día: " + fechaActual.getDate());
		return 0;
	}
	
	@SuppressWarnings("deprecation")
	public static int cocinar(Lote lote) throws InterruptedException {
		System.out.println("Día: "+fechaActual.getDate());
		System.out.println("Cociendo...");
		Thread.sleep(3000);
		fechaActual.setDate(fechaActual.getDate()+1); 
		System.out.println("Proceso de molienda finalizado. Día: "+fechaActual.getDate());
		return 0;
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("¿Desea generar un lote? (s/n)");
		Scanner sc = new Scanner(System.in);
		String answ = sc.nextLine();
		switch(answ.toLowerCase()) {
		case "s":
			if(AlmacenLotes.getOcupado()==AlmacenLotes.getMaxCapacidad()) {
				System.err.println("Alerta: El almacen de lotes esta completo. Recuerde que no podra almacenar el lote "+
			"que va a producir si no vacia el almacen");
			}
			else {
				Pilsner a; Stout b;
				System.out.println("¿Desea generar un pedido de tipo Pilsner? (s/n)" );
				String pilsner = sc.nextLine();
				Lote lote = null;
				switch(pilsner.toLowerCase()) {
				case "s":
					a = new Pilsner();
					lote = new Lote(a, fechaActual);
					AlmacenLotes.almacenarLote(lote);
					//System.out.println("Se está empezando a moler su lote de cerveza Pilsner.");
					break;
				case "n":
					System.out.println("¿Desea generar un pedido de tipo Stout? (s/n)");
					String stout = sc.nextLine();
					switch(stout.toLowerCase()) {
					case "s":
						b = new Stout();
						lote = new Lote(b, fechaActual);
						//System.out.println("Se está empezando a moler su lote de cerveza Stout.");
					case "n":
						break;
					default:
						System.err.println("Por favor, introduzca una 's' o una 'n'.");
						break;
					
					}
					break;
				default:
					System.err.println("Por favor, introduzca una 's' o una 'n'.");
					break;
				}
				
				try {
					if (lote != null) {
						System.out.println("Comienza la fase de molienda.");
						moler(lote);
						System.out.println("Comienza la fase de cocinado.");
						cocinar(lote);
						/*System.out.println("Comienza la fase de fermentación.");
						fermentar();
						System.out.println("Comienza la segunda fase de fermentación.");
						fermentar();
						System.out.println("Comienza la fase de embotellado.");
						embotellar();
						 */
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			break;
		case "n":
			Scanner sca = new Scanner(System.in);
			System.out.println("Inserte el lote sobre el que desea consultar: ");
			String lote = sca.nextLine();
			int id = Integer.parseInt(lote);
			if (id > AlmacenLotes.id) {
				System.err.println("Lote introducido incorrecto.");
				break;
			} else {
				
			}
			break;
		default:
			System.err.println("Por favor, introduzca una 's' o una 'n'.");
			break;
		}
		sc.close();
		

	}

}