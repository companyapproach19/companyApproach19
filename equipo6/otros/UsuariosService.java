package equipo6.otros;

import equipo6.model.*;
import equipo6.objetosTemporales.BBDDTemporal;

//Esta es la clase a la que van a llamar el resto de grupos para hacer sus
//gestiones con respecto a los usuarios
public class UsuariosService{
	
	//Temporal
//	BBDDTemporal BBDD;
//	public void init(BBDDTemporal bd) {
//		this.BBDD=bd;
//	}
	public UsuariosService() {}
	

    //Funcion para logear usuarios
    //Obtiene la cadena de BBDD, y utiliza el metodo logIn de la cadena
    //TODO anton (habla con gonzalo si necesitas entender como funciona su clase modelo)
    public Actor logUsuario(Actor usuarioIntentaLogin){
    	Actor actor = metodosCompany.getActor(usuarioIntentaLogin.getNombreUsuario());
    	if(actor!=null) {
    		if(actor.actor_compare(usuarioIntentaLogin)) {
    			return actor;
    		}else {
    			return new Actor();
    		}
    	}else {
    		return new Actor();
    	}
    	
//    	try {
//			return cad.logeaUsuario(usuarioIntentaLogin);
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//			return null;
//		}
    }

    
}
