public class Transportista{
	Persona Transporte;
	Persona receptor;
	Persona emisor;
	Pedido pedido;
    public Transportista(Persona emisor,Pedido pedido,Persona transporte,Persona receptor) {
    	Transporte=transporte;
    	this.pedido=pedido;
    }
    public boolean aceptapedido() {
		return false;
    	
    }
    public void firma() {
    	
    }
    public 	Persona buscarnuevorepartidor() {
    	return null;
    }
    public void inicia() {
    	boolean respuesta=aceptapedido();
    	while(!respuesta) {
    		//notificamos
    		Transporte=buscarnuevorepartidor();
    		respuesta=aceptapedido();
    	}
    	listopararecoger();
    }
    public void listopararecoger() {
    	
    	//notificamos
    	//comunicacion trazabilidad
    	//esperamos firma
    	firma();
    	entransporte();
    } 
    public void entransporte() {
    	//notificamos
    	//comunicacion trazabilidad
    	//esperamos firma
    	firma(); 
    } 
}