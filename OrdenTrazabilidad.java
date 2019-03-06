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
	//Es necesario un identificador por cada pedido
		private String id;
		//No esta seguro que sea necesario el mensaje
		private String mensaje;
		//Actor que realiza el pedido
		private Actor emisor;
		//Actor que recibe la peticion
		private Actor receptor;
		//Estado del pedido
		private EstadoProceso estado;
		
		public void OrdenTrazabilidad(String identificador,String mensaje, Actor emisor, Actor receptor) {
			this.id = identificador;
			this.mensaje=mensaje;
			this.emisor=emisor;
			this.receptor=receptor;
			this.estado=null;
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