package iSoftware;

import java.util.LinkedList;

//se implementa una pila FIFO : first in first out 
/*
 * Es más útil sacar los lotes por el id que para algo está
 */
public class AlmacenLotes{
	public static final int maxCapacidad=7;
	public static LinkedList<Lote> lista  = new LinkedList<Lote>();
	public static int ocupado=0;
	public static int id=1;
	
    public static int getId() {
		return id;
	}

	public static int getMaxCapacidad() {
		return maxCapacidad;
	}

	/*public static void setMaxCapacidad(int maxCapacidad) {
		AlmacenLotes.maxCapacidad = maxCapacidad;
	}*/

	/*public static Lote[] getLista() {
		return lista;
	}
	public static void setLista(Lote[] lista) {
		AlmacenLotes.lista = lista;
	}*/

	public static void setId(int id) {
		AlmacenLotes.id = id;
	}

	public static int getOcupado() { return ocupado; }
	
	public AlmacenLotes() {//7 lotes simult�neamente   
//		for (int i=0; i<maxCapacidad; i++) {
//			lista.add(new Lote(new Stout())); //
//			
//		}
		
    }
    
	/*
	 * Introduce un nuevo lote a la lista.
	 * Devuelve 0 si se realiza con éxito
	 * y 1 si el almacén está lleno o el lote que se intenta introducir 
	 * tiene errores.
	 */
	public static void almacenarLote(Lote name) {
    	if (lista.size()<=6) {
    	lista.addFirst(name);
    	}
    	else {
    		System.err.println("error de capacidad en AlmacenLotes: no caben más lotes.");
    	}
   
}
    public static Lote sacarLote() {
    	//devuelve el lote  almacenado hace más tiempo -- pila FIFO
    	
    	if( lista.size() !=0 ) { 
    		return lista.getLast();
    		}
    	else {
    		System.err.println("No se puede sacar un lote, el almacén de lotes está vacío o contiene un número de lotes que"
    				+ "excede la capacidad del almacén.");
    		return null;
    	}
	}
}