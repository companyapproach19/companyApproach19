package equipo6.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import equipo6.model.*;
import equipo6.objetosTemporales.*;
import equipo6.otros.*;

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
	    		
	    		//Escribimos respuesta
				byte[] response = "{\"error\":\"true\",\"mensaje\":\"Peticion incorrecta\"}".getBytes();
				t.sendResponseHeaders(400, response.length);
				OutputStream os = t.getResponseBody();
				os.write(response);
				os.close();
				
				t.close();
	    		
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
		//si el actor no esta en la cadena nos llega un actor con todos sus campos a null
		if (actor.tipoActor != null){
			String tipo ="";
			switch (actor.tipoActor){
			case 0: tipo="Productor";break;
			case 1: tipo="Coperativa";break;
			case 2: tipo="Transportista";break;
			case 3: tipo="Fabrica";break;
			case 4: tipo="Retailer";break;
			}
			salida+="{\n"+actor.getNombreUsuario+"\n"+actor.getEmail+"\n"+tipo+"}";
		}
		//si no esta el actor en la cadena devolvemos ""
		return salida;
    	}
	}
}
