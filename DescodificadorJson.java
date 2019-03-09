import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
 

public class DescodificadorJson {
	
	public OrdenTrazabilidad DescodificadorJson(String pedido) {
		 Gson gson=new Gson();
		 Type tipoObjeto = new TypeToken<OrdenTrazabilidad>(){}.getType();
		 return gson.fromJson(pedido, tipoObjeto);  
	}

	
	/*La clase OrdenTrazabilidad necesita de esta clase:
	 * 
	 * Toda la informacion inicial del pedido :)
	 * Modificaciones del estado del proceso
	 * Fecha de entrega (cuando el transportista firme la entrega)
	 * 
	 */
	
	/*Las clases individuales de los actores necesitaran de esta clase:
	 * 
	 * Agricultor:
	 * Boolean de si se ha aceptado el pedido o no
	 * Boolean de si le da al boton de: listo
	 * ...
	 * 
	 * Resto de actores:
	 * Boolean de si le da al boton de: listo para entregar
	 * Los actores que puedan hacer peticiones necesitaran saber el mensaje
	 * ...
	 * 
	 */
	
	
	
}
