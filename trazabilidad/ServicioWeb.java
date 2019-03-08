package trazabilidad;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import main.Traductor;
import trazabilidad.model.Actor;
import trazabilidad.model.CadenaActores;
import trazabilidad.objetosTemporales.BBDDTemporal;

public class ServicioWeb {
	public static void main(String[] args)throws Exception {


		//Este codigo solo es necesario para crear un objeto servidor
		//que en este caso escucharia en el puerto 80 (http)
		HttpServer server = HttpServer.create(new InetSocketAddress(80), 0);

		server.createContext("/login", new LoginHandler());

		server.setExecutor(null);

		server.start();



	}
	
	
	static class LoginHandler implements HttpHandler {
	    public void handle(HttpExchange t) throws IOException {
	    	//Leemos la peticion
	    	byte[] request = t.getRequestBody().readAllBytes();
	    	String requestBody = new String(request);
	    	String[] params = requestBody.split(";");
	    	if(params.length!=2) {
	    		//Devolver error de peticion
	    	}else {
	    		String usuario = params[0];
	    		String contra = params[1];
	    		
	    		Actor usuarioLogin = new Actor(usuario,contra);
	    		
	    		BBDDTemporal bd = new BBDDTemporal();
	    		CadenaActores cad = new CadenaActores();
	    		Actor ac=new Actor("jorge","jorge");
	    		cad.addActor(ac);
	    		Actor ac2=new Actor("jorge2","jorge2");
	    		cad.addActor(ac2);
	    		Actor ac3=new Actor("jorge3","jorge3");
	    		cad.addActor(ac3);
	    		bd.guardarCadenaActores(cad);
	    		
	    		UsuariosService usrv = new UsuariosService();
	    		usrv.init(bd);	    		
	    		
	    		
	    		Actor actorRespuesta = usrv.logUsuario(usuarioLogin);
	    		//Pedir al UsuarioService que logee
	    		
	    		//Escribimos respuesta
				byte[] response = getJSONFromActor(actorRespuesta).getBytes();
				t.sendResponseHeaders(200, response.length);
				OutputStream os = t.getResponseBody();
				os.write(response);
				os.close();
				
				t.close();
	    	}
	    }
	    
	    private final String getJSONFromActor(Actor actor) {
    		String salida="";
    		//salida+="{\""+actor.nomUsuario+"\"";
    		return salida;
    	}
	}
}
