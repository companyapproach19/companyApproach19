package trazabilidad.model;

import java.io.Serializable;

public class Actor implements Serializable{
    static final long serialVersionUID=10L;
    
    private String nombreUsuario;
    private String passwordPlana;
    private String passwordSalt;
    private String email;
    Actor usuarioPrevio;
    private int tipoActor; //0->4 para Productor, Cooperativa, Transportista, Fabrica y Retailer


    private boolean actor_compare(Actor usuarioIntentaAcceder)
    {
        return (
                    this.nombreUsuario.equals(usuarioIntentaAcceder.nombreUsuario) &&
                    this.passwordPlana.equals(usuarioIntentaAcceder.passwordPlana)
                    /*Resto de condiciones que sean necesarias*/
                );
    }

    public Actor(){}

    //Constructor utilizado por la vista para pasarnos los datos
    //TODO gonzalo

    public Actor(String nombreUsuario, String passwordPlana){
            this.nombreUsuario = nombreUsuario;
            this.passwordPlana = passwordPlana;
    }

    //Constructor usado por la BBDD para instanciar el objeto que nos va a devolver
    //TODO gonzalo

    public Actor(String nombreUsuario, String passwordSalt, String email,Actor usuarioPrevio, int tipoActor){
        this.nombreUsuario = nombreUsuario;
        this.passwordSalt = passwordSalt;
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
        	System.out.println("Usuario encontrado.");
        	return this;
        }
        else if(this.usuarioPrevio != null)
        {
        	System.out.println("Usuario NO encontrado. Hemos probado: "+this.getNombreUsuario());
            return this.usuarioPrevio.logMe(usuarioIntentaAcceder);
        }
        else
        {
            throw new Exception
                                (
                                    "Error al logear usuario : " + usuarioIntentaAcceder.nombreUsuario +
                                    " contrase�a : " + usuarioIntentaAcceder.passwordPlana
                                );
        }
    }

    //GETTERS
    //TODO gonzalo

    public String getNombreUsuario()
    {
        return this.nombreUsuario;
    }

    public String getpasswordPlana()
    {
        return this.passwordPlana;
    }

    public String getpasswordSalt()
    {
        return this.passwordSalt;
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