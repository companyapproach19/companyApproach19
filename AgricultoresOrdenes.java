
public class AgricultoresOrdenes{
    Persona agricultor;
    public AgricultoresOrdenes(Persona agricultor){//una persona
    	this.agricultor=agricultor;
    }

    public boolean  Agricultoraceptapedido(){ 
        //miramos si el agricultor acepta el pedido
		return false;
    }
    public Persona getactor(){//la cooperativa con la que firma
        return agricultor;
    }
    public void notificacion(int cod){//se notifica un mensaje
        //en funcion del codigo lanzaremos un mensaje u otro
    } 

}