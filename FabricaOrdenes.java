//CLASE COMPARTIDA CON LARA
public class FabricaOrdenes {
	CooperativaOrdenes receptor;
	OrdenTrazabilidad encargo;
	Transportista transporte;
	boolean aceptaPedido;

	public FabricaOrdenes(OrdenTrazabilidad encargo) {
		this.receptor = new CooperativaOrdenes(encargo);
		this.transporte = new Transportista(encargo);
	}

	public void crearPedido() {
		notificacion(1);
		if (receptor.getaceptaPedido()) {
			notificacion(2);
			notificacion(3);
			transporte.inicia();
			// CAMBIAR EL ESTADO A EN PROCESO.
			// comunicacion trazabilidad
			encargo.setEstadoProceso(EN_PROCESO_DE_ENTREGA);
			notificacion(4);

		} else {
			notificacion(5);
			notificacion(6); // ey, por si acaso
		}
	}

	public void notificacion(int cod) {
		// todos los mensajes que se han de pasar por pantalla dependiendo del
		// proceso
		switch (cod) {
		case 1:
			System.out.println("---->El sistema contacta con el" + " que suministrara el producto para ver si acepta ");
			break;
		case 2:
			System.out.println("<----El pedido ha sido aceptado");
			break;
		case 3:
			System.out.println("El transportista ha firmado");
			break;
		case 4:
			System.out.println("Producto ha cambiado de estado a 'EN_PROCESO_DE_ENTREGA' ");
			break;
		case 5:
			System.out.println("El producto no ha sido aceptado");
			break;
		case 6:
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
