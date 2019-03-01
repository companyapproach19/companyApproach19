import java.io.Serializable;

//package trazabilidad.model;

public class CadenaActores implements Serializable{
    private Actor cabeza; //Inicio de a list
    private Actor cola; ////Fin de a list
    //Constructor generico, inicializar lista
    //TODO gonzalo
    public CadenaActores()
    {
        this.cabeza = null;
        this.cola = null;
    }

    private add_firts_actor(Actor e)
    {
        e.usuarioPrevio = null;
        e.usuarioNext = null;
        this.cabeza = e;
        this.cola = e;
    }

    private boolean actor_compare(Actor a1,Actor a2)
    {
        return (
                    a1.nombreUsuario.equals(a2.nombreUsuario) &&
                    a1.contraseñaPlana.equals(a2.contraseñaPlana)
                );
    }

    private boolean is_user_val(Actor e)
    {
        return usuarioLogin.contraseñaPlana != null && usuarioLogin.nombreUsuario != null;
    }

    //Añadir nuevo actor a la cadena. Recuerda que el nuevo tiene que tener referencia
    //al ultimo de la lista.
    //Devuelve id de usuario
    //TODO gonzalo
    public int addActor(Actor nuevoActor){
        if(this.cabeza == null)
        {
            add_firts_actor(nuevoActor);
        }
        else
        {
            this.cola.usuarioNext = nuevoActor;
            nuevoActor.usuarioPrevio = this.cola;
            nuevoActor.usuarioNext = null;
            this.cola = nuevoActor;
        }
    }

    //Método que llama al metodo logMe del ultimo Actor de la lista, y reenvia lo que le
    //devuelva.
    public Actor logeaUsuario(Actor usuarioLogin){
        Actor actor_hit;

        actor_hit = this.cabeza;

        if(!is_user_val(usuarioLogin)) return null;

        while(actor_hit != null)
        {
            if(actor_compare(actor_hit,usuarioLogin))
            {
                return actor_hit;
            }
            actor_hit = actor_hit.usuarioNext;
        }

        return actor_hit;
    }

    
}