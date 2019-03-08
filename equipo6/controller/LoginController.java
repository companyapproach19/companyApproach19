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
	public String loginUser(
			@RequestParam(name="usuario", required=true) String usuario,
			@RequestParam(name="pwd", required=true) String pwd,
			Model model) {
		
		//Obtiene los datos del usuario que se quiere logear
		Actor usuarioLogin = new Actor(usuario,pwd);
		
		//Mandamos a nuestras clases que haga la logica de negocio
		UsuariosService usrv = new UsuariosService();
		Actor actorRespuesta = usrv.logUsuario(usuarioLogin);		
		
		//Devuelve el actor logeado como JSON
		return getJSONFromActor(actorRespuesta);
	}
	
	
	private final String getJSONFromActor(Actor actor) {
		String salida="";
		//salida+="{\""+actor.nomUsuario+"\"";
		return salida;
	}
}