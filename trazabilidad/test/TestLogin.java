package trazabilidad.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import trazabilidad.UsuariosService;
import trazabilidad.model.Actor;
import trazabilidad.model.CadenaActores;
import trazabilidad.objetosTemporales.BBDDTemporal;

class TestLogin {

	@Test
	void test() {
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
		
		
		Actor acCorrecto=new Actor("jorge","jorge");		
		Actor resp=usrv.logUsuario(acCorrecto);
		if(resp!=null)System.out.println(resp.getNombreUsuario());
		
		Actor acIncorrecto=new Actor("jorge4","jorge4");		
		resp=usrv.logUsuario(acIncorrecto);
		if(resp!=null)System.out.println(resp.getNombreUsuario());
	}

}
