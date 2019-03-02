import java.io.Serializable;

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

    private add_firts_actor(Actor e)
    {
        e.usuarioPrevio = null;
        this.cola = e;
    }

    //comprueba si el objeto Actor
    private boolean is_user_val(Actor e)
    {
        return usuarioLogin.contraseñaPlana != null && usuarioLogin.nombreUsuario != null;
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

    public int addActor(Actor nuevoActor){
        
        if(this.cola == null)
        {
            add_firts_actor(nuevoActor);
        }
        else
        {
            nuevoActor.usuarioPrevio = this.cola;
            this.cola = nuevoActor;
        }
        this.length++;
    }

    //Método que llama al metodo logMe del ultimo Actor de la lista, y reenvia lo que le
    //devuelva.

    public Actor logeaUsuario(Actor usuarioLogin){
        return this.cola.logMe(usuarioLogin);
    }

    
}