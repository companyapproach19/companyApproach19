
public class RetailerOrdenes {
    FabricaOrdenes receptor;
    Pedido pedido;
    Persona retailer; 
    Persona transportista;
    Transportista transporte;
    public RetailerOrdenes(Persona emisor,Pedido pedido,Persona transporte,Persona receptor){ 
    	if(emisor==null&&transporte==null) {
    		retailer=receptor;
    		this.pedido=pedido;
    	}
    	else {
    		this.receptor=new FabricaOrdenes(null,pedido,null,receptor);
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
        return retailer;
    }  
}
