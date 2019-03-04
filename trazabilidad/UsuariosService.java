package trazabilidad;

import trazabilidad.model.*;
import trazabilidad.objetosTemporales.BBDDTemporal;

//Esta es la clase a la que van a llamar el resto de grupos para hacer sus
//gestiones con respecto a los usuarios
public class UsuariosService{
	
	//Temporal
	BBDDTemporal BBDD;
	public void init(BBDDTemporal bd) {
		this.BBDD=bd;
	}
	public UsuariosService() {}
	

    //Funcion para logear usuarios
    //Obtiene la cadena de BBDD, y utiliza el metodo logIn de la cadena
    //TODO anton (habla con gonzalo si necesitas entender como funciona su clase modelo)
    public Actor logUsuario(Actor usuarioIntentaLogin){
    	CadenaActores cad = BBDD.getCadenaActores();
    	
    	try {
			return cad.logeaUsuario(usuarioIntentaLogin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Usuario no encontrado.");
			return null;
		}
    }

    
}