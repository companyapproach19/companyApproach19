package iSoftware;
import java.util.*;
//se implementa una pila FIFO : first in first out 
public class AlmacenLotes{
	public static int maxCapacidad=7;
	public static LinkedList<Lote> lista  = new LinkedList<Lote>();
    public AlmacenLotes() {//7 lotes simult�neamente    	
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
    		return lista.getLast();
    		}
    	else {
    		System.err.println("No se puede sacar un lote, el almac�n de lotes est� vac�o o contiene un n�mero de lotes que"
    				+ "excede la capacidad del almac�n.");
    		return null;
    	}
	}
}
