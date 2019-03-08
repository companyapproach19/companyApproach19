import java.io.Serializable;
//NECESARIO PARA TRAZABILIDAD:
//import equipo6.model.DatosContainer.java;

public class OrdenTrazabilidad //extends DatosContainer
{

	/*
	 * Los objetos que hay que pasar al grupo de trazabilidad seran de esta clase
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
		
		//El transportista firma en dos ocasiones del pedido:
		//en la recogida del pedido (llegada al origen)
		private boolean firmadoRecogida;
		//en la entrega del pedido (llegada al destino)
		private boolean firmadoEntrega;
		
		//TRANSPORTISTA
		private Transportista transportista;
		//TODO:El formato de la lista
		//Dependera de la descodificacion de los json
		private String[] productos ;
		//TODO: int o float
		private int[] cantidad ;
		
		
		public OrdenTrazabilidad(int identificador,String mensaje, Actor emisor, Actor receptor,
								 Transportista transportista, String[] productos, int[] cantidad) {
			this.id = identificador;
			this.mensaje=mensaje;
			this.actorOrigen=emisor;
			this.destinatario=receptor;
			this.estado=null;
			this.firmadoRecogida=false;
			this.firmadoEntrega=false;
			this.transportista=transportista;
			this.cantidad=cantidad;
			this.productos=productos;
			
		}
		
		public void setEstadoProceso(EstadoOrden nuevo) {
			this.estado=nuevo;
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
		
		public String[] getProductos() {
			return productos;
		}
		
		public int[] getCantidades() {
			return cantidad;
		}

		public enum Actor{
		    PRODUCTOR, COOPERATIVA, FABRICA, RETAILER, TIENDA
		}
		
		public enum EstadoOrden{
			EN_PROCESO, LISTO_PARA_ENTREGAR, EN_PROCESO_DE_ENTREGA, ENTREGADO
		}
}