public class CooperativaOrdenes{
    AgricultoresOrdenes receptor;
    Pedido pedido;
    Persona cooperativa; 
    public CooperativaOrdenes(Persona emisor,Pedido pedido,Persona receptor){//persona y pedido
    	if(emisor==null) {
    	this.cooperativa=receptor;
    	}
    	else { 
    		this.receptor=new AgricultoresOrdenes(receptor);
        	this.pedido=pedido;
        	this.cooperativa=cooperativa;
    	}
    }
    public void Hacerpedido(){
        boolean respuesta =receptor.Agricultoraceptapedido();
        if(respuesta){
        notificacion(1); 
        firma(receptor.getactor());
        pedidook();
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
    public void firma(Persona agricultor){

    }
    
    
    /*
     * 
     * 
     * 
     * 
     */
    
    public boolean  aceptapedido(){ 
        //miramos si el agricultor acepta el pedido
		return false;
    }
    public Persona getactor(){//la cooperativa con la que firma
        return cooperativa;
    }   
}