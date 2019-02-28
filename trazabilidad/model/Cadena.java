package trazabilidad.model;

public class Cadena{
    private String hashUltimoBloque;
    private int codLote;
    private int numBloques: //Cuenta el numero de bloques que hay en la Cadena

    //Constructor por defecto
    public Cadena(int codLote){

    }

    //Recorre toda la cadena y devuelve una lista con todos los bloques del tipo especificado
    public List<Bloque> getBloque(int tipoBloque){

    }


    //Recorre toda la cadena y devuelve una lista con todos los bloques
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
    public boolean checkConsistencia(){

    }


    //Metodo que a partir de un DatosContainer que contiene informacion de lo que se quiere añadir
    // (clase generica que encapsula todo lo que nos quieran pasar los grupos) y el tipo de informacion
    //añade el bloque a la cadena, haciendo todas las funciones criptográficas correspondientes.
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