package equipo6.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import equipo6.model.Actor;
import equipo6.otros.*;

@SpringBootApplication
@Controller
public class LoginController {
	
	@Scope("request")
	@ResponseBody
	@RequestMapping("/loginUser")
	public Actor loginUser(
			@RequestParam(name="usuario", required=true) String usuario,
			@RequestParam(name="pwd", required=true) String pwd,
			Model model) {
		
		//Obtiene los datos del usuario que se quiere logear
		Actor usuarioLogin = new Actor(usuario,pwd);
		
		//Mandamos a nuestras clases que haga la logica de negocio
		UsuariosService usrv = new UsuariosService();
		Actor actorRespuesta = usrv.logUsuario(usuarioLogin);		
		
		//Devuelve el actor logeado como JSON
		return actorRespuesta;
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
