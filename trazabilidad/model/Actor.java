import java.io.Serializable;

//package trazabilidad.model;

public class Actor implements Serializable{
    String nombreUsuario;
    String contraseñaPlana;
    String contraseñaSalt;
    String email;
    Actor usuarioPrevio;
    int tipoActor; //0->4 para Productor, Cooperativa, Transportista, Fabrica y Retailer

    public Actor(){}

    //Constructor utilizado por la vista para pasarnos los datos
    //TODO gonzalo
    public Actor(String nombreUsuario, String contraseñaPlana){

    }

    //Constructor usado por la BBDD para instanciar el objeto que nos va a devolver
    //TODO gonzalo
    public Actor(String nombreUsuario, String contraseñaSalt, String email, Actor usuarioPrevio, int tipoActor){

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

        return null;
    }

    //GETTERS
    //TODO gonzalo
}