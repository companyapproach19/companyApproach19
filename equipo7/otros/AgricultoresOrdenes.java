package otros;
import model.*;


public class AgricultoresOrdenes extends Orden{
	
	public AgricultoresOrdenes(OrdenTrazabilidad peticion) {
		super(peticion);
	}
	
    public void notificacion(int cod){//se notifica un mensaje
        //en funcion del codigo lanzaremos un mensaje u otro
    	String mensaje="";
    	switch (cod) {
		case 1:
			mensaje+="El usuario "+this.getPedido().getActorOrigen()+" desea encargarle el siguiente pedido :"+this.getPedido().getProductos();
			break;  
		}
    	this.getPedido().setMensaje(mensaje);
    } 

}