//clase de le grand empereur
public class CooperativaOrdenes {
	AgricultoresOrdenes receptor;
	OrdenTrazabilidad encargo;
	Transportista transporte;
	boolean aceptaPedido;

	public CooperativaOrdenes(OrdenTrazabilidad encargo) {// String y pedido
		this.receptor = new AgricultoresOrdenes(encargo);
		// aqui no hace falta transportista
	}

	public void crearPedido() {
		notificacion(1);
		if (receptor.getaceptaPedido()) {
			notificacion(2);
			// que se llama
			transporte.inicia();
			// porque ojo dentro del metodo inicia es cuando se firmma
			notificacion(3);
		} else {

			notificacion(5);
			notificacion(6);// ey, por si acaso
		}

	}

	public void notificacion(int cod) {// se notifica un mensaje
		// en funcion del codigo lanzaremos un mensaje u otro
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

	/*
	 * esto lo hace el transportista public void firma(){ //todavia no se sabe }
	 */
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