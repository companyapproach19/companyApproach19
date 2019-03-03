import java.io.Serializable;

//package trazabilidad.model;

public class Actor implements Serializable{
    
    private String nombreUsuario;
    private String contraseñaPlana;
    private String contraseñaSalt;
    private String email;
    Actor usuarioPrevio;
    private int tipoActor; //0->4 para Productor, Cooperativa, Transportista, Fabrica y Retailer


    private boolean actor_compare(Actor usuarioIntentaAcceder)
    {
        return (
                    this.nombreUsuario.equals(usuarioIntentaAcceder.nombreUsuario) &&
                    this.contraseñaPlana.equals(usuarioIntentaAcceder.contraseñaPlana)
                    /*Resto de condiciones que sean necesarias*/
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

    public Actor(String nombreUsuario, String contraseñaSalt, String email,Actor usuarioPrevio, int tipoActor){
        this.nombreUsuario = nombreUsuario;
        this.contraseñaSalt = contraseñaSalt;
        this.email = email;
        this.usuarioPrevio = usuarioPrevio;
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

    public Actor logMe(Actor usuarioIntentaAcceder) throws Exception{
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
            throw new Exception
                                (
                                    "Error al logear usuario : " + usuarioIntentaAcceder.nombreUsuario +
                                    " contraseña : " + usuarioIntentaAcceder.contraseñaPlana
                                );
        }
    }

    //GETTERS
    //TODO gonzalo

    public String getNombreUsuario()
    {
        return this.nombreUsuario;
    }

    public String getContraseñaPlana()
    {
        return this.contraseñaPlana;
    }

    public String getContraseñaSalt()
    {
        return this.contraseñaSalt;
    }

    public String getEmail()
    {
        return this.email;
    }

    public int getTipoActor()
    {
        return this.tipoActor;
    }

}