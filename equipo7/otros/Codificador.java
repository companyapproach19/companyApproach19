package otros;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder; 
import model.OrdenTrazabilidad;

public class Codificador {


    /* Esta clase se encarga de pasar de objetos en Java
     * a un archivo JSON, para la interoperabilidad entre
     * el backend y la interfaz (en Javascript) */

    public static String crearJSON(OrdenTrazabilidad pedido) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        return gson.toJson(pedido);
    }
}
