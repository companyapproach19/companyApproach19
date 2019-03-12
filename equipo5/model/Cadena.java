package company;
import java.util.LinkedList;
import java.util.List;


public class Cadena{
    private String hashUltimoBloque;
    private int codLote;
    private int numBloques; //Cuenta el numero de bloques que hay en la Cadena


    //Temporal para pruebas
//    private BBDDTemporal BBDD = new BBDDTemporal();
//    public void setBBDDTemporal(BBDDTemporal bd) {
//    	this.BBDD=bd;
//    }

    //Constructor por defecto
    //TODO alejandro
    public Cadena(int codLote){
        this.codLote=codLote;
        this.numBloques=0;
        this.hashUltimoBloque="INICIO";
    }
    public Cadena(int codLote, String hashUltimoBloque, int numBloques){
        this.codLote=codLote;
        this.numBloques=numBloques;
        this.hashUltimoBloque=hashUltimoBloque;
    }

    public String getHashUltimoBloque() {
        return hashUltimoBloque;
    }

    //Recorre toda la cadena y devuelve una lista con todos los bloques del tipo especificado.
    //Hay que pedirle a BBDD que nos de los bloques
    //TODO alejandro
//    public List<Bloque> getBloque(int tipoBloque){
//        List<Bloque> lista = new LinkedList<Bloque>();
//        Bloque anadir = company.getBloqueOrden(hashUltimoBloque) ;
//        for (int j=0;j<numBloques;j++) {
//            if (anadir.getTipoBloque()==tipoBloque) {
//                lista.add(anadir);
//            }
//            anadir = company.getBloqueOrden(anadir.getHashPrevio());
//        }
//        return lista;
//    }
//
//
//    //Recorre toda la cadena y devuelve una lista con todos los bloques
//    //TODO alejandro
//    public List<Bloque> getCadena(){
//        List<Bloque> lista = new LinkedList<Bloque>();
//        Bloque anadir = company.getBloqueOrden(hashUltimoBloque) ;
//        for (int j=0;j<numBloques;j++){
//            lista.add(anadir);
//            anadir = company.getBloqueOrden(anadir.getHashPrevio());
//        }
//        return lista;
//    }


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
//    public boolean checkConsistencia(){
//        Bloque anadir = equipo5.getBloqueOrden(hashUltimoBloque) ;
//        for (int j=0;j<numBloques-1;j++){
//            anadir = equipo5.getBloqueOrden(anadir.getHashPrevio());
//        }
//        if(anadir.getHashPrevio().equals("INICIO")){
//            return true;
//        }
//        return false;
//    }


    //Metodo que a partir de un DatosContainer que contiene informacion de lo que se quiere añadir
    // (clase generica que encapsula todo lo que nos quieran pasar los grupos) y el tipo de informacion
    //añade el bloque a la cadena, haciendo todas las funciones criptográficas correspondientes.
    //TODO jorge
//    public void incorporarBloque(DatosContainer dc, int tipoBloque){
//        /*
//        1. Obtener la info que se tiene que poner de cabecera en el nuevo bloque:
//            -hashPrevio a partir de la variable hashUltimoBloque
//            -codLote
//            -tipoBloque
//            -numBloque a partir de numBloques++
//
//        2. Instanciar objeto Bloque con estos datos
//        3. Obtener hash del bloque nuevo
//        4. Llamar a BBDD para almacenar bloque
//        5. Actualizar tabla de referencia de hash+
//        6. LLamar a BBDD para almacenar la tabla de referencia
//        */
//
//        Bloque nuevoBloque = new Bloque(this.hashUltimoBloque,tipoBloque, this.numBloques++, this.codLote, dc);
//        nuevoBloque.setTimeStamp();
//        String hashNuevo = nuevoBloque.getHashCode();
//        boolean insercionCorrecta = equipo5.insertarBloqueOrden(nuevoBloque);
//        if(insercionCorrecta){
//            this.hashUltimoBloque=hashNuevo;
//            equipo5.guardarCadena(this, this.codLote);
//        }
//
//    }
}
