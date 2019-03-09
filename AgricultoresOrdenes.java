

public class AgricultoresOrdenes{
	
	
	OrdenTrazabilidad encargo;
	boolean aceptaPedido;
	
    public AgricultoresOrdenes(OrdenTrazabilidad encargo){//una String
    	this.encargo=encargo;
    }

    
    public void notificacion(int cod){//se notifica un mensaje
        //en funcion del codigo lanzaremos un mensaje u otro
    } 

    public boolean getaceptaPedido() {
		return aceptaPedido;
	}

	// si no es ahora luego van a ser necesarios xD
	public void aceptarPedido() {
		this.aceptaPedido = true;
	}

	public void rechazarPedido() {
		this.aceptaPedido = false;
	}
    
}