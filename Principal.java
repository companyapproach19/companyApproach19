//package iSoftware;
import java.util.Scanner;
public class Principal {
	
	private int contadorLote; //se debe actualizar para crear cada lote
	
	/*public Lote generarPedido(String tipo){
		if (tipo.equals("Stout")) {
			Lote lote = new Lote(contadorLote);
			contadorLote++;
			return lote;
		} else if (tipo.equals("Pilsner")) {
			Lote lote = new Lote(contadorLote);
			contadorLote++;
			return lote;
		} else return null;
		
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sca = new Scanner(System.in);
		System.out.println("Inserte el pedido sobre el que desea consultar: ");
		String lote = sca.nextLine();
		int id = Integer.parseInt(lote);
		
	}

}
