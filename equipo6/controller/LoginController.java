package equipo6.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import equipo6.model.Actor;
import equipo6.model.CadenaActores;
import equipo6.objetosTemporales.BBDDTemporal;
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
		
		//Lineas de codigo temporales hasta que tengamos lo de BBDD. Comentar cuando enlacemos.
//		BBDDTemporal bd = new BBDDTemporal();
//		CadenaActores cad = new CadenaActores();
//		Actor ac=new Actor("jorge","jorge","jorge@gmail.com",new Actor(),0,0);
//		cad.addActor(ac);
//		Actor ac2=new Actor("jorge2","jorge2","jorge@gmail.com",ac,1,0);
//		cad.addActor(ac2);
//		Actor ac3=new Actor("jorge3","jorge3","jorge@gmail.com",ac,2,0);
//		cad.addActor(ac3);
//		bd.guardarCadenaActores(cad);
		
//		UsuariosService usrv = new UsuariosService();
//		usrv.init(bd);
		//Hasta aqui las lineas temporales
		
		
		//Obtiene los datos del usuario que se quiere logear
		Actor usuarioLogin = new Actor(usuario,pwd);
		
		//Mandamos a nuestras clases que haga la logica de negocio
		UsuariosService usrv = new UsuariosService(); //Descomentar cuando enlacemos con BBDD
		Actor actorRespuesta = usrv.logUsuario(usuarioLogin);		
		
		//Devuelve el actor logeado como JSON
		return getJSONFromActor(actorRespuesta);
	}
	
	
	private final String getJSONFromActor(Actor actor) {
		String salida="";
		//si el actor no esta en la cadena nos llega un actor con todos sus campos a null
		String tipo = "";
		switch (actor.getTipoActor()) {
		case 0:
			tipo = "Agricultores";
			break;
		case 1:
			tipo = "Cooperativa";
			break;
		case 2:
			tipo = "Transportista";
			break;
		case 3:
			tipo = "Fabrica";
			break;
		case 4:
			tipo = "Retailer";
			break;
		default:
			tipo="LoginError";
			break;
		}
		salida += "{\n \"nomUsuario\":\"" + actor.getNombreUsuario();
		salida += "\" , \n \"email\":\"" + actor.getEmail();
		salida += "\" , \n \"tipoActor\":\"" + tipo;
		salida += "\" , \n \"redirect\":\""+tipo+".html\"\n}";

		//si no esta el actor en la cadena devolvemos ""
		return salida;
	}
}
