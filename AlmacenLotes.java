package iSoftware;
import java.util.*;
//se implementa una pila FIFO : first in first out 
public class AlmacenLotes{
	public static int maxCapacidad=7;
	public static LinkedList<Lote> lista  = new LinkedList<Lote>();
    public AlmacenLotes() {//7 lotes simultáneamente    	
    }
    
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
