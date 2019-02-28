package trazabilidad.model;

public class Bloque implements Serializable{
    private String hashPrevio;
    private int tipoBloque;
    private int numBloque;
    private int codLote;
    DatosContainer datos;

    //Constructor por defecto. Asignar tal cual
    public Bloque(String hashPrevio, int tipoBloque, int numBloque, int codLote, DatosContainer datos){
        
    }

    //Getters para todos los campos

}