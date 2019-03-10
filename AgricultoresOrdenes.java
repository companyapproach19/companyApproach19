

public class AgricultoresOrdenes{
	
	
	OrdenTrazabilidad encargo;
	boolean aceptaPedido;
	
    public AgricultoresOrdenes(OrdenTrazabilidad encargo){//una String
    	this.encargo=encargo;
    }

    
    public void notificacion(int cod){//se notifica un mensaje
        //en funcion del codigo lanzaremos un mensaje u otro
    	switch (cod) {
		case 1:
			System.out.println("---->El sistema contacta con el" + " que suministrara el producto para ver si acepta ");
			break;
		case 2:
			System.out.println("<----El pedido ha sido aceptado");
			break;
		case 3:
			System.out.println("Producto ha cambiado de estado a 'EN_PROCESO_DE_ENTREGA' ");
			break;
		case 4:
			System.out.println("El producto no ha sido entregado");
			break;
		case 5:
			System.out.println("Producto no ha sido firmado");
			break;

		}
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