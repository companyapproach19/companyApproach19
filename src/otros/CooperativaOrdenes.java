package otros;
//clase de le grand empereur
import model.*;
public class CooperativaOrdenes {
	AgricultoresOrdenes receptor;
	OrdenTrazabilidad encargo;
	Transportista transporte;
	boolean aceptaPedido;
	boolean pedidolisto;
	String mensaje;

	public CooperativaOrdenes(OrdenTrazabilidad encargo) {// String y pedido
		this.receptor = new AgricultoresOrdenes(encargo);
		this.encargo=encargo;
		aceptaPedido=true;
		pedidolisto=false;
		// aqui no hace falta transportista
	}

	public void crearPedido() {
		if (receptor.getaceptaPedido()) {
			encargo.setEstadoProceso(OrdenTrazabilidad.EstadoOrden.EN_PROCESO);
			notificacion(1);
			encargo.getTransportista().firma(); 
			encargo.setEstadoProceso(OrdenTrazabilidad.EstadoOrden.ENTREGADO);
			notificacion(3);

		} else {
			notificacion(5); 
		}

	}

	public void notificacion(int cod) {// se notifica un mensaje
		// en funcion del codigo lanzaremos un mensaje u otro
		switch (cod) {
		case 2:
			mensaje+="Su pedido ha sido aceptado y se encuentra en proceso";
			break;
		case 3:
			mensaje+="Su pedido ha sido entregado";
			break;
		case 4:
			mensaje+="El usuario "+encargo.getActorOrigen()+"desea encargarle el siguiente pedido :"+encargo.getProductos();
			break;
		case 5:
			mensaje+="El producto no ha sido aceptado";
			break; 

		}
		encargo.setMensaje(mensaje);
    	CodificadorJSON aviso=new CodificadorJSON();
    	aviso.crearJSON(encargo);
	}
	public boolean listo_recoger() {
		return true;
	}

	/*
	 * esto lo hace el transportista public void firma(){ //todavia no se sabe }
	 */
	public boolean getaceptaPedido() {
		notificacion(4);
		return aceptaPedido;
	}

	public boolean isPedidolisto() {
		return pedidolisto;
	}
 

}