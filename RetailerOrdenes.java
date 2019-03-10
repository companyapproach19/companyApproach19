

//CLASE de l'grand emperour
public class RetailerOrdenes {
	FabricaOrdenes receptor;
	OrdenTrazabilidad encargo;
	Transportista transporte;
	boolean aceptaPedido;
	String mensaje;
	boolean pedidolisto=false;
	public RetailerOrdenes(OrdenTrazabilidad encargo) {
		this.encargo = encargo;
		this.receptor = new FabricaOrdenes(encargo); 

	}

	public void crearPedido() {
		notificacion(1);
		if (receptor.getaceptaPedido()) {
			encargo.setEstadoProceso(OrdenTrazabilidad.EstadoOrden.EN_PROCESO);
			notificacion(2);
			while(receptor.listo_recoger()) {}
			encargo.setEstadoProceso(OrdenTrazabilidad.EstadoOrden.LISTO_PARA_ENTREGAR);
			notificacion(3);
			encargo.getTransportista().firma();
			encargo.setFirmadoRecogida(true);
			
			encargo.setEstadoProceso(OrdenTrazabilidad.EstadoOrden.EN_PROCESO_DE_ENTREGA); 
			notificacion(4);
			encargo.getTransportista().firma();
			encargo.setFirmadoEntrega(true);
			// CAMBIAR EL ESTADO A EN PROCESO.
			// comunicacion trazabilidad
			encargo.setEstadoProceso(OrdenTrazabilidad.EstadoOrden.ENTREGADO);
			notificacion(5);

		} else {
			notificacion(7); 
		}
	}
	

	public void notificacion(int cod) {// se notifica un mensaje
		// en funcion del codigo lanzaremos un mensaje u otro
		switch (cod) {
		case 1:
			mensaje+="El pedido ha sido aceptado";
			break;
		case 2:
			mensaje+="Su pedido se encuentra en proceso";
			break;
		case 3:
			mensaje+="Su pedido se encuentra listo para ser recogido";
			break;
		case 4:
			mensaje+="Su producto se encuentra en transporte ";
			break;
		case 5:
			mensaje+="El producto ha sido entregado";
			break; 
		case 6:
			mensaje+="El producto no ha sido aceptado";
			break; 
		case 7:
			mensaje+="El usuario "+encargo.getActorOrigen()+"desea encargarle el siguiente pedido :"+encargo.getProductos();
			break; 

		}
		encargo.setMensaje(mensaje);
    	CodificadorJSON aviso=new CodificadorJSON();
    	aviso.crearJSON(encargo);

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

	public boolean listo_recoger() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isPedidolisto() {
		return pedidolisto;
	}

	/*
	 * esto lo hace el transportista public boolean aceptaPedido(){ //como lo
	 * ponemos return false; }
	 */
}
