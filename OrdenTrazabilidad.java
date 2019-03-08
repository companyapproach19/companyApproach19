import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

public class OrdenTrazabilidad implements Serializable{

	/*
	 * Los objetos que hay que pasar al grupo de trazabilidad seran de esta clase
	 * 
	 * Contienen la siguiente informacion:
	 * Identificador(id) para cada pedido
	 * Origen del pedido(quien hace la orden): (productor, cooperativa, fábrica, retailer, tienda)
	 * Destino del pedido(a quien le hacen la peticion): (productor, cooperativa, fábrica, retailer, tienda)
	 * Datos del transportista solicitado: 
	 * nombre o identificador del transportista, empresa, fecha de recogida y fecha de entrega, firmado
	 * Mensaje del pedido
	 * Estado del pedido (definidos los estados en el ENUM EstadoOrden)
	 * 
	*/
		//Es necesario un identificador por cada pedido
		private int id;
		private String mensaje;
		//Actor que realiza el pedido
		private Actor actorOrigen;
		//Actor que recibe la peticion
		private Actor destinatario;
		//Estado del pedido
		private EstadoOrden estado;
		//Si el transportista firma
		private boolean firmado;
		
		//TRANSPORTISTA
		private Actor transportista;
		private String empresa;
		//Date(int year, int month, int date)
		private Date fechaRecogida;
		private Date fechaEntrega;
		//TODO:El formato de la lista
		//Dependera de la descodificacion de los json
		private LinkedList productos ;
		
		
		public OrdenTrazabilidad(int identificador,String mensaje, Actor emisor, Actor receptor, LinkedList productos) {
			this.id = identificador;
			this.mensaje=mensaje;
			this.actorOrigen=emisor;
			this.destinatario=receptor;
			this.estado=null;
			this.firmado=false;
			this.transportista=Actor.TRANSPORTISTA;
			this.productos=productos;
		}
		
		public void setEstadoProceso(EstadoOrden nuevo) {
			this.estado=nuevo;
		}
		
		public void setFechaEntrega(Date entregado) {
			this.fechaEntrega=entregado;
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

		public boolean isFirmado() {
			return firmado;
		}

		public Actor getTransportista() {
			return transportista;
		}

		public String getEmpresa() {
			return empresa;
		}

		public Date getFechaRecogida() {
			return fechaRecogida;
		}

		public Date getFechaEntrega() {
			return fechaEntrega;
		}
		
		public LinkedList getProductos() {
			return productos;
		}

		public enum Actor{
		    PRODUCTOR, COOPERATIVA, FABRICA, RETAILER, TIENDA, TRANSPORTISTA
		}
		
		public enum EstadoOrden{
			EN_PROCESO, LISTO_PARA_ENTREGAR, EN_PROCESO_DE_ENTREGA, ENTREGADO
		}
}