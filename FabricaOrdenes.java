
public class FabricaOrdenes {
    CooperativaOrdenes receptor;
    Pedido pedido;
    Persona fabrica; 
    Transportista transporte ;
    public FabricaOrdenes(Persona emisor,Pedido pedido,Persona transporte,Persona receptor){ 
    	if(emisor==null&&transporte==null) {
    		fabrica=receptor;
    		this.pedido=pedido;
    	}
    	else {
    		this.fabrica=emisor;
    		this.pedido=pedido;
    		this.receptor=new CooperativaOrdenes(null,pedido,receptor);
    		this.transporte=new Transportista(emisor,pedido,transporte,receptor);
    	}
    } 
    public void Hacerpedido(){
        boolean respuesta =receptor.aceptapedido();
        if(respuesta){
        notificacion(1); 
        transporte.inicia();
        //notificamos cambio de estado
    	//comunicacion trazabilidad
        }
        else{
notificacion(1);
        }
        //creamos objeto 
    }
    public void notificacion(int cod){//se notifica un mensaje
        //en funcion del codigo lanzaremos un mensaje u otro
    }
    public void pedidook(){//se notifica un mensaje
        //en funcion del codigo lanzaremos un mensaje u otro
    }
    
    
    
    /*
     * 
     * 
     * 
     * ffffff
     * 
     */
    public boolean  aceptapedido(){ 
        //miramos si el agricultor acepta el pedido
		return false;
    }
    public Persona getactor(){//la cooperativa con la que firma
        return fabrica;
    }  
}
