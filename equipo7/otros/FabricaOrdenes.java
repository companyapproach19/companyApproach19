package otros;
//CLASE COMPARTIDA CON LARA
import model.*;
public class FabricaOrdenes {
	CooperativaOrdenes receptor;
	OrdenTrazabilidad encargo;
	Transportista transporte;
	boolean aceptaPedido;
	boolean pedidolisto=false;
	String mensaje;

	public FabricaOrdenes(OrdenTrazabilidad encargo) {
		this.receptor = new CooperativaOrdenes(encargo);
		this.encargo=encargo;
	}
	public enum EstadoOrden {
		EN_PROCESO, LISTO_PARA_ENTREGAR, EN_PROCESO_DE_ENTREGA, ENTREGADO
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
			notificacion(7); 
		}
	}
	
     public boolean listo_recoger() {
		return true;
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
		case 7:
			mensaje+="El usuario "+encargo.getActorOrigen()+"desea encargarle el siguiente pedido :"+encargo.getProductos();
			break; 

		}
		encargo.setMensaje(mensaje);
    	CodificadorJSON aviso=new CodificadorJSON();
    	aviso.crearJSON(encargo);

	}

	public boolean getaceptaPedido() {
		notificacion(7);
		return aceptaPedido;
	} 
	public boolean isPedidolisto() {
		return pedidolisto;
	}
}
