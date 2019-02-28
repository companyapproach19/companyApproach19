package trazabilidad.model;

public class DatosContainer implements Serializable{
    //Dependemos del resto de grupos que nos digan que va a haber dentro
    Object datos;

    //Serializa el objeto a bytes y devuelve el SHA256 hash del contenido serializado
    public String getDigest(){

    }
}