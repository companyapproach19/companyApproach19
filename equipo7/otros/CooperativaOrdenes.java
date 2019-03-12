package otros;
//clase de le grand empereur
import model.*;
public class CooperativaOrdenes  extends Orden {
	
	AgricultoresOrdenes receptor;
	
	public CooperativaOrdenes(OrdenTrazabilidad peticion) {
		super(peticion);
	}
	
	public void crearPedido() {
		receptor = new AgricultoresOrdenes(super.getPedido());
	}

	public void notificacion(int cod) {// se notifica un mensaje
		// en funcion del codigo lanzaremos un mensaje u otro
		String mensaje="";
		switch (cod) {
		case 2:
			mensaje+="Su pedido ha sido aceptado y se encuentra en proceso";
			break;
		case 3:
			mensaje+="Su pedido ha sido entregado";
			break;
		case 4:
			mensaje+="El usuario "+this.getPedido().getActorOrigen()+"desea encargarle el siguiente pedido :"+this.getPedido().getProductos();
			break;
		case 5:
			mensaje+="El producto no ha sido aceptado";
			break; 

		}
		this.getPedido().setMensaje(mensaje);
	}
	public boolean listo_recoger() {
		return true;
	}


}