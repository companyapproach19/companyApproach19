package trazabilidad.model;

public class Cadena{
    private String hashUltimoBloque;
    private int codLote;
    private int numBloques; //Cuenta el numero de bloques que hay en la Cadena

    //LEEME
    //Supongamos que tenemos una clase DDBB.operaciones con el método getBloque(String hash) que 
    //devuelve un Bloque con el hash indicado.

    //Tambien tenemos otro metodo en esa clase guardarBloque(Bloque b) que guarda el bloque asociandolo
    //al hash que lleve en su propiedad.




    //Constructor por defecto
    //TODO alejandro
    public Cadena(int codLote){

    }

    //Recorre toda la cadena y devuelve una lista con todos los bloques del tipo especificado.
    //Hay que pedirle a BBDD que nos de los bloques
    //TODO alejandro
    public List<Bloque> getBloque(int tipoBloque){

    }


    //Recorre toda la cadena y devuelve una lista con todos los bloques
    //TODO alejandro
    public List<Bloque> getCadena(){

    }


    //Devuelve el codLote
    public int getCodLote(){
        return this.codLote;
    }


    //Devuelve numero de bloques
    public int getNumBloques(){
        return this.numBloques;
    }


    //Checkea que la consistencia es correcta. Es decir, que podamos ir llendo hacia atras
    // de un bloque a otro hasta llegar a un bloque cuyo valor de hashPrevio sea "INICIO"
    //TODO alejandro
    public boolean checkConsistencia(){
        

        return null;
    }


    //Metodo que a partir de un DatosContainer que contiene informacion de lo que se quiere añadir
    // (clase generica que encapsula todo lo que nos quieran pasar los grupos) y el tipo de informacion
    //añade el bloque a la cadena, haciendo todas las funciones criptográficas correspondientes.
    //TODO jorge
    private void incorporarBloque(DatosContainer dc, int tipoBloque){
        /*
        1. Obtener la info que se tiene que poner de cabecera en el nuevo bloque: 
            -hashPrevio a partir de la variable hashUltimoBloque
            -codLote
            -tipoBloque
            -numBloque a partir de numBloques++
        
        2. Instanciar objeto Bloque con estos datos
        3. Obtener hash del bloque nuevo
        4. Llamar a BBDD para almacenar bloque
        5. Actualizar tabla de referencia de hash+
        6. LLamar a BBDD para almacenar la tabla de referencia
        */
    }
}