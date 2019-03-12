package otros;
import model.*;
public class RetailerOrdenes  extends Orden {
	
	FabricaOrdenes receptor;
	
	public RetailerOrdenes(OrdenTrazabilidad peticion) {
		super(peticion);
	}
	
	public void crearPedido() {
		receptor = new FabricaOrdenes(super.getPedido());
	}
	
	public void notificacion(int cod) {// se notifica un mensaje
		// en funcion del codigo lanzaremos un mensaje u otro
		String mensaje="";
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
			mensaje+="El usuario "+this.getPedido().getActorOrigen()+"desea encargarle el siguiente pedido :"+this.getPedido().getProductos();
			break; 

		}
		this.getPedido().setMensaje(mensaje);

	}

}
