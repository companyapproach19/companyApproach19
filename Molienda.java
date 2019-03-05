package ISO;
import java.lang.Thread;

public class Molienda {

@SuppressWarnings("deprecation")
private static void moler() throws InterruptedException {
	java.util.Date fechaActual = new java.util.Date();
	System.out.println("Día: "+fechaActual.getDate());
	System.out.println("Moliendo...");
	Thread.sleep(3000);
	fechaActual.setDate(fechaActual.getDate()+1); 
	System.out.println("Proceso de molienda finalizado. Día: "+fechaActual.getDate());
}
		
public static void main (String[]args) throws InterruptedException {
	moler();
}	
	
}
