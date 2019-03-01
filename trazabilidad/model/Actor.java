import java.io.Serializable;

//package trazabilidad.model;

public class Actor implements Serializable{
    String nombreUsuario;
    String contraseñaPlana;
    String contraseñaSalt;
    String email;
    Actor usuarioPrevio;
    Actor usuarioNext;
    int tipoActor; //0->4 para Productor, Cooperativa, Transportista, Fabrica y Retailer


    private boolean actor_compare(Actor usuarioIntentaAcceder)
    {
        return (
                    this.nombreUsuario.equals(usuarioIntentaAcceder.nombreUsuario) &&
                    this.contraseñaPlana.equals(usuarioIntentaAcceder.contraseñaPlana)
                );
    }

    public Actor(){}

    //Constructor utilizado por la vista para pasarnos los datos
    //TODO gonzalo
    public Actor(String nombreUsuario, String contraseñaPlana){
            this.nombreUsuario = nombreUsuario;
            this.contraseñaPlana = contraseñaPlana;
    }

    //Constructor usado por la BBDD para instanciar el objeto que nos va a devolver
    //TODO gonzalo
    public Actor(String nombreUsuario, String contraseñaSalt, String email, int tipoActor){
        this.nombreUsuario = nombreUsuario;
        this.contraseñaSalt = contraseñaSalt;
        this.email = email;
        this.tipoActor = tipoActor;
    }

    //Funcion que, checkea si el Actor pasado como parametro se corresponde con este (this),
    //y si no es asi, llama a este método en el Actor guardado en el campo usuarioPrevio.
    //De esta manera se recorre la lista de Actores desde el final al principio.
    //Si usuario se corresponde, devolverse a si mismo (de momento, ya veremos como lo hacemos con la vista)
    //Si no se corresponde, pero existe usuario previo, devolver lo que devuelva la llamada a logMe del usuario previo
    //Si usuarioPrevio==Actor vacio (campos nombre y mail vacios) (inicio de la lista), se 
    //lanza una excepcion genérica, y devolver null
    //TODO gonzalo
    public Actor logMe(Actor usuarioIntentaAcceder){
        if(actor_compare(usuarioIntentaAcceder))
        {
            return this;
        }
        else if(this.usuarioPrevio != null)
        {
            return this.usuarioPrevio.logMe(usuarioIntentaAcceder);
        }
        else
        {
            return null;
        }
    }

    //GETTERS
    //TODO gonzalo
}