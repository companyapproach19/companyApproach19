package iSoftware;

import java.util.*;

//se implementa una pila FIFO : first in first out 
/*
 * Es m�s �til sacar los lotes por el id que para algo est�
 */
public class AlmacenLotes{
	public static final int maxCapacidad=7;
	public static LinkedList<Lote> lista  = new LinkedList<Lote>();
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


	public AlmacenLotes() {
	}

	public static void almacenarLote(Lote name) {
		if (lista.size()<=6) {
			lista.addFirst(name);
		}
		else {
			System.err.println("error de capacidad en AlmacenLotes: no caben m�s lotes.");
		}

	}
	public static Lote sacarLote() {
		//devuelve el lote  almacenado hace m�s tiempo -- pila FIFO

		if( lista.size() !=0 ) { 
			return lista.pollLast();
		}
		else {
			System.err.println("No se puede sacar un lote, el almac�n de lotes est� vac�o o contiene un n�mero de lotes que"
					+ "excede la capacidad del almac�n.");
			return null;
		}
	}
	public static boolean existeLoteId(int id) {
		Iterator it = lista.iterator();
		Lote resultado = (Lote) it.next();
		while(it.hasNext()){
			if (resultado.getCode() == id) {
				return true;
			}
			else {
				it.next();
				continue;
			}
		}
		System.out.println("No se ha podido encontrar el lote con el id introducido.");
		return false;
	}

	public static Lote sacarLoteId(int id){
		Iterator it = lista.iterator();
		Lote resultado = (Lote) it.next();
		while(it.hasNext()){
			if (resultado.getCode() == id) {
				return resultado;
			}
			else {
				it.next();
			}
		}
		System.out.println("No se ha podido encontrar el lote con el id introducido.");
		return null;

	}
}