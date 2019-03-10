package otros;
import model.*;


public class AgricultoresOrdenes{
	
	
	OrdenTrazabilidad encargo;
	boolean aceptaPedido;
	String mensaje;
	
    public AgricultoresOrdenes(OrdenTrazabilidad encargo){//una String
    	this.encargo=encargo;
    }

    
    public void notificacion(int cod){//se notifica un mensaje
        //en funcion del codigo lanzaremos un mensaje u otro
    	switch (cod) {
		case 1:
			mensaje+="El usuario "+encargo.getActorOrigen()+"desea encargarle el siguiente pedido :"+encargo.getProductos();
			break;  
		}
    	encargo.setMensaje(mensaje);
    	CodificadorJSON aviso=new CodificadorJSON();
    	aviso.crearJSON(encargo);
    	//enviar el Json
    } 

    public boolean getaceptaPedido() {
    	notificacion(1);
		return aceptaPedido;
	} 
    
}