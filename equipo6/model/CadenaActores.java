package equipo6.model;

import java.io.Serializable;

import equipo6.objetosTemporales.*;

//package trazabilidad.model;

public class CadenaActores implements Serializable{
    private Actor cola; //Fin de a list
    private int length; //Tamaño de la lista
  
    
    //Constructor generico, inicializar lista
    //TODO gonzalo
    public CadenaActores()
    {
        this.cola = null;
        this.length = 0;
    }

    //comprueba si el objeto Actor
    private boolean is_user_val(Actor usuarioLogin)
    {
        return 
                (
                    usuarioLogin.getpasswordPlana() != null &&
                    usuarioLogin.getNombreUsuario() != null
                    /*Resto de condiciones que sean necesaria para
                    que el usurio sea valido*/
                );
    }

    //retorna la longitud de la cadena

    public int length()
    {
        return this.length;
    }

    //Añadir nuevo actor a la cadena. Recuerda que el nuevo tiene que tener referencia
    //al ultimo de la lista.
    //Devuelve id de usuario
    //TODO gonzalo

    public int addActor(Actor nuevoActor) {
        this.cola = nuevoActor;
        this.length++;
        return 0/*id del usuario*/;
    }

    //Método que llama al metodo logMe del ultimo Actor de la lista, y reenvia lo que le
    //devuelva, y en caso de no ser un usurario valido segun las condiciones definida en
    //is_user_val se genera una excepcion generia.

    public Actor logeaUsuario(Actor usuarioLogin) throws Exception{
        if(!is_user_val(usuarioLogin))
        {
            throw new Exception("Error al logear usuario, usuario no valido");
        }
        return this.cola.logMe(usuarioLogin);
    }

    
}
