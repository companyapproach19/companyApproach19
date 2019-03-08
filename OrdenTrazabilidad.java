import java.io.Serializable;

public class OrdenTrazabilidad implements Serializable{

	/*
	 * Esta es la clase que hay que pasar 
	 * al grupo de trazabilidad
	 * 
	 * Estado del proceso
	 * Emisor
	 * Destino
	 * Mensaje
	 * TODO:Firma?
	 * 
	 * */
	/*
	- ID (número)
	- Destinatario: (productor, cooperativa, fábrica, retailer, tienda)
	- Actor: (productor, cooperativa, fábrica, retailer, tienda)
	- Transportista:
	  +Empresa:
	  +Nombre:
	  +Fecha de recogida:
	  +Fecha de entrega:
	- Mensaje:
	- Estado:
	- Firmado (boolean): (editado) 
	*/
		//Es necesario un identificador por cada pedido
		private int id;
		//No esta seguro que sea necesario el mensaje
		private String mensaje;
		//Actor que realiza el pedido
		private Actor actorOrigen;
		//Actor que recibe la peticion
		private Actor destinatario;
		//Estado del pedido
		private EstadoProceso estado;
		private boolean firmado;
		
		//TRANSPORTISTA
		private Actor transportista;
		private String empresa;
		private String fechaRecogida;
		private String fechaEntrega;
		
		
		public void OrdenTrazabilidad(int identificador,String mensaje, Actor emisor, Actor receptor) {
			this.id = identificador;
			this.mensaje=mensaje;
			this.actorOrigen=emisor;
			this.destinatario=receptor;
			this.estado=null;
			this.firmado=false;
			this.transportista=Actor.TRANSPORTISTA;
			
		}
		
		public void actualizarEstado(EstadoProceso nuevo) {
			this.estado=nuevo;
		}
		
		
		public enum Actor{
		    PRODUCTOR, COOPERATIVA, FABRICA, RETAILER, TIENDA, TRANSPORTISTA
		}
		
		public enum EstadoProceso{
			EN_PROCESO, LISTO_PARA_ENTREGAR, EN_PROCESO_DE_ENTREGA, ENTREGADO
		}
}