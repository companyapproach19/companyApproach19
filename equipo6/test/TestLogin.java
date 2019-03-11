package equipo6.test;

import static org.junit.jupiter.api.Assertions.*;

import java.net.HttpURLConnection;

import org.junit.jupiter.api.Test;

import equipo6.otros.UsuariosService;
import equipo6.model.Actor;
import equipo6.model.CadenaActores;
import equipo6.objetosTemporales.BBDDTemporal;

class TestLogin {
	@Test
	void test() {
		testInterno();
		testServicioWeb();
	}
	
	void testInterno() {
		BBDDTemporal bd = new BBDDTemporal();
		CadenaActores cad = new CadenaActores();
		Actor ac=new Actor("jorge","jorge","jorge@gmail.com",new Actor(),0,0);
		cad.addActor(ac);
		Actor ac2=new Actor("jorge2","jorge2","jorge@gmail.com",ac,1,0);
		cad.addActor(ac2);
		Actor ac3=new Actor("jorge3","jorge3","jorge@gmail.com",ac,2,0);
		cad.addActor(ac3);
		bd.guardarCadenaActores(cad);
		
		UsuariosService usrv = new UsuariosService();
		usrv.init(bd);
		
		
		Actor acCorrecto=new Actor("jorge","jorge");		
		Actor resp=usrv.logUsuario(acCorrecto);
		if(resp!=null)System.out.println(resp.getNombreUsuario());
		
		Actor acIncorrecto=new Actor("jorge4","jorge4");		
		resp=usrv.logUsuario(acIncorrecto);
		if(resp!=null)System.out.println(resp.getNombreUsuario());
	}
	
	void testServicioWeb() {
//		URL url = new URL("http://example.com");
//		HttpURLConnection con = (HttpURLConnection) url.openConnection();
//		con.setRequestMethod("GET");
//		
//		con.getOutputStream()
	}

}
