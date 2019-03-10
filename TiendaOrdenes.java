

//CLASE de l'grand emperour
public class TiendaOrdenes {
	RetailerOrdenes receptor;
	OrdenTrazabilidad encargo;
	Transportista transporte;
	boolean aceptaPedido;
	String mensaje;

	public TiendaOrdenes(OrdenTrazabilidad encargo) {
		this.encargo = encargo;
		this.receptor = new RetailerOrdenes(encargo); 

	}

	public void crearPedido() { 
		if (receptor.getaceptaPedido()) {
			encargo.setEstadoProceso(OrdenTrazabilidad.EstadoOrden.EN_PROCESO);
			notificacion(2);
			while(receptor.listo_recoger()) {}
			encargo.setEstadoProceso(OrdenTrazabilidad.EstadoOrden.LISTO_PARA_ENTREGAR);
			notificacion(3);
			encargo.getTransportista().firma(); 
			
			encargo.setEstadoProceso(OrdenTrazabilidad.EstadoOrden.EN_PROCESO_DE_ENTREGA); 
			notificacion(4);
			encargo.getTransportista().firma(); 
			// CAMBIAR EL ESTADO A EN PROCESO.
			// comunicacion trazabilidad
			encargo.setEstadoProceso(OrdenTrazabilidad.EstadoOrden.ENTREGADO);
			notificacion(5);

		} else {
			notificacion(6); 
		}
	}
	public void notificacion(int cod) {
		// todos los mensajes que se han de pasar por pantalla dependiendo del
		// proceso
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
    public void listo_recoger() {
		
	}
	/*
	 * esto lo hace el transportista public boolean aceptaPedido(){ //como lo
	 * ponemos return false; }
	 */
}
