
public class AgricultoresOrdenes{
	
	//falta la señal para poder cambiar el estado del pedido
	
	//nombre del Actor
    private String nombre;
    //aceptacion del pedido
    private boolean aceptadoPedido;
    
    //un agricultor
	public AgricultoresOrdenes(String nombre){
    	this.nombre=nombre;
    	this.aceptadoPedido=false;
    }

	public boolean isAceptadoPedido() {
		return aceptadoPedido;
	}
	
    public void notificacion(int cod){//se notifica un mensaje
        //en funcion del codigo lanzaremos un mensaje u otro
    	
    } 
    

}