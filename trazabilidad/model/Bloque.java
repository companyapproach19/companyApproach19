package trazabilidad.model;

public class Bloque implements Serializable{
    private String hashPrevio;
    private int tipoBloque;
    private int numBloque;
    private int codLote;
    DatosContainer datos;

    //Constructor por defecto. Asignar tal cual
    //TODO anton
    public Bloque(String hashPrevio, int tipoBloque, int numBloque, int codLote, DatosContainer datos){
        this.hashPrevio = hashPrevio;
        this.tipoBloque = tipoBloque;
        this.numBloque = numBloque;
        this.codLote = codLote;
        this.datos = datos;
    }
    
    //Getters para todos los campos
    //TODO anton
    
    public  String getHashPrevio(){
        return this.hashPrevio;
    }
    
    public  int getTipoBloque(){
        return this.tipoBloque;
    }
    
    public  int getNumBloque(){
        return this.numBloque;
    }
    
    public  int getCodLote(){
        return this.codLote;
    }
    
    public  DatosContainer getDatos(){
        return this.datos;
    }

}
