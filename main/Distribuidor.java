package main;

//package distribuidor;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;

import com.sun.net.httpserver.HttpHandler;

import com.sun.net.httpserver.HttpServer;

import trazabilidad.model.Actor;







public class Distribuidor {



	//Este objeto se encargar de procesar la informacion de la peticion
	//solicitada por el usuario extrayendo la informacion, (cookies, parametros), relevate
	//y generando un json con la misma. La finalidad de este objeto es proporcionar un conjunto
	//de metodos para que cada grupo pueda obtener lo que le resulte necesario en cada peticion.
	//Un ejemplo claro seria en el login ya que cuando un usuario quiere logearse rellena un formulario
	//con su nombre de usuario y contraseña y lo envia al servidor. Cuando la peticion llega al servidor se
	//ejecuta la funcion public void handle(HttpExchange t) y en el objeto 'HttpExchange t' esta toda informacion pero 
	//parte de esta informacion como pueden ser las cookies o los parametros vienen codificadas en una cadena
	//de texto siendo precisamente necesario una conversion de esta cadena a un objeto mas manejable como puede
	//ser un jsonObject. Para este caso tras recibir en el servidor la petion login del usuario los parametros
	//del mismo formulario se procesaran generandose un jsonObject de los mismos y asi nos resultara facil
	//acceder al contenido de dichos parametros y realizar las conprobaciones que sean necesarias.
	//Ademas tambien podremos usar ciertos campos para pasarle informacion al siguiente nivel. Siguiendo
	//con el ejemplo del login, esta claro que se pueden dar dos situaciones tras realizar la comprobaciones
	//necesarias de los parametros, o bien el usuario es correcto o bien el usuario es incorrecto. Bien ahora 
	//supongamos que de esta comprobacion se encarga un grupo 'A' y de la vista o del html que debe
	//ser enviado un grupo 'B'. Claro esta que en funcion de lo que A obtenga B debera enviar uno y otro html,
	//En el caso de que no ser un usuario correcto se debera devolver el html del login con el correspondiente
	//mensaje de error y en el caso contrario se debera devolver html de la pagina de inicio o home. Seria justo
	//en esta situcion donde tendria sentido pasar informacion atraves del objeto del grupo A al grupo B
	//con el resultado de la comprobacion del login y en base a esta informacion el grupo B decidiria que
	//documento html enviar.
	public static Traductor traductor;



	public static void main(String[] args)throws Exception {


		//Este codigo solo es necesario para crear un objeto servidor
		//que en este caso escucharia en el puerto 80 (http)
		HttpServer server = HttpServer.create(new InetSocketAddress(80), 0);

		traductor = new Traductor();

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
	    		Actor actorRespuesta = UsuariosService.logMe(usuarioLogin);
	    		//Pedir al UsuarioService que logee
	    		
	    		//Escribimos respuesta
				byte[] response = "Welcome Real's HowTo test page".getBytes();
				t.sendResponseHeaders(200, response.length);
				OutputStream os = t.getResponseBody();
				os.write(response);
				os.close();
				
				t.close();
	    	}
	    	
	    	private String getJSONFromActor(Actor actor) {
	    		
	    		return null;
	    	}
	    	
	    	
	    	
	    	
	    }
	}



//	static class Handler_Req implements HttpHandler {
//		//esta funcion es a la que se llama de manera automatica
//		//cada vez que llega una peticion al servidor
//		public void handle(HttpExchange t) throws IOException {
//			Trad_Res_Req res;
//
//			try{
//				//aqui se procesa la peticion obtteniendose los correspondientes
//				//jsonObject
//				res = traductor.traducir(t);	
//				
//				//Respuesta a la peticion
//				byte [] response = "Welcome Real's HowTo test page".getBytes();
//			    t.sendResponseHeaders(200, response.length);
//			    OutputStream os = t.getResponseBody();
//			    os.write(response);
//			    os.close();
//			    
//			    
//				//Aqui se cierra la conexion.
//				t.close();
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//			
//			
//			
//			
//		}
//	}
}
