import java.io.Serializable;

//package trazabilidad.model;

public class CadenaActores implements Serializable{
    public List<Actores> listaUsuarios;

    //Constructor generico, inicializar lista
    //TODO gonzalo
    public CadenaActores(){}

    //Añadir nuevo actor a la cadena. Recuerda que el nuevo tiene que tener referencia
    //al ultimo de la lista.
    //Devuelve id de usuario
    //TODO gonzalo
    public int addActor(Actor nuevoActor){

    }

    //Método que llama al metodo logMe del ultimo Actor de la lista, y reenvia lo que le
    //devuelva.
    public Actor logeaUsuario(Actor usuarioLogin){

    }
}