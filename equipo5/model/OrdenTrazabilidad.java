package company;
import java.io.Serializable;


public class OrdenTrazabilidad extends DatosContainer
{

	/*
	 * Los objetos que hay que pasar al grupo de trazabilidad seran de esta clase
	 * Contienen la siguiente informacion:
	 * Identificador(id) para cada pedido
	 * Origen del pedido(quien hace la orden): (productor, cooperativa, fabrica, retailer, tienda)
	 * Destino del pedido(a quien le hacen la peticion): (productor, cooperativa, fabrica, retailer, tienda)
	 * Datos del transportista solicitado: 
	 * nombre o identificador del transportista, empresa, fecha de recogida y fecha de entrega, firmado
	 * Mensaje del pedido
	 * Estado del pedido (definidos los estados en el ENUM EstadoOrden)
	 * 
	*/
		//Es necesario un identificador por cada pedido
		private int id;
		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}

		//Actor que realiza el pedido
		private Actor actorOrigen;
		//Actor que recibe la peticion
		private Actor destinatario;
		private Transportista transportista;
		private Productos productos;
		private String mensaje;
		//Estado del pedido
		private EstadoOrden estado;
		//El transportista firma en dos ocasiones del pedido:
		//en la recogida del pedido (llegada al origen)
		private boolean firmadoRecogida;
		//en la entrega del pedido (llegada al destino)
		private boolean firmadoEntrega;

		public OrdenTrazabilidad(int identificador,String mensaje, Actor emisor, Actor receptor,
								 Transportista transportista, Productos productos) {
			this.id = identificador;
			this.destinatario=receptor;
			this.actorOrigen=emisor;
			this.transportista=transportista;
			this.productos=productos;
			this.mensaje=mensaje;
			this.estado=null;
			this.firmadoRecogida=false;
			this.firmadoEntrega=false;
		}
		
		public void setEstadoProceso(EstadoOrden nuevo) {
			this.estado=nuevo;
		}
		
		public void setId(int id) {
			this.id=id;
		}
		
		public int getId() {
			return id;
		}

		public String getMensaje() {
			return mensaje;
		}

		public Actor getActorOrigen() {
			return actorOrigen;
		}

		public Actor getDestinatario() {
			return destinatario;
		}

		public EstadoOrden getEstado() {
			return estado;
		}

		public boolean isFirmadoRecogida() {
			return firmadoRecogida;
		}

		public boolean isFirmadoEntrega() {
			return firmadoEntrega;
		}

		public Transportista getTransportista() {
			return transportista;
		}
		
		public Productos getProductos() {
			return productos;
		}
		/*
		public enum Actor {
		    PRODUCTOR, COOPERATIVA, FABRICA, RETAILER, TIENDA
		}*/
		
		public enum EstadoOrden {
			EN_PROCESO, LISTO_PARA_ENTREGAR, EN_PROCESO_DE_ENTREGA, ENTREGADO
		}

		public void setFirmadoRecogida(boolean firmadoRecogida) {
			this.firmadoRecogida = firmadoRecogida;
		}

		public void setFirmadoEntrega(boolean firmadoEntrega) {
			this.firmadoEntrega = firmadoEntrega;
		}
}