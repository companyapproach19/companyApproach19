package equipo6.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import equipo6.otros.BlockchainServices;
import equipo6.objetosTemporales.BBDDTemporal;
import equipo6.objetosTemporales.Traspaso;

class TestTrazabilidad {

	@Test
	void test() {
		BBDDTemporal bd = new BBDDTemporal();
		bd.createCadena(0);
		
		BlockchainServices bcs = new BlockchainServices();
		bcs.init(bd);
		
		Traspaso t = new Traspaso(0,"Bloque 1");
		bcs.guardarTraspaso(t);
		Traspaso t2=new Traspaso(0, "Bloque 2");
		bcs.guardarTraspaso(t2);
		Traspaso t3=new Traspaso(0, "Bloque 3");
		bcs.guardarTraspaso(t3);
		System.out.println(bcs.checkConsistencia(0));
		Traspaso t1 = bcs.getTraspaso(0);
		
		
		System.out.println(t1.getInfo());
	}

}
