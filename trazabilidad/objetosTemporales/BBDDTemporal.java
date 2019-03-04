package trazabilidad.objetosTemporales;

import java.util.HashMap;
import java.util.Map;

import trazabilidad.model.Bloque;
import trazabilidad.model.Cadena;

public class BBDDTemporal{
	Map<String, Bloque> mapaBloques = new HashMap<String, Bloque>();
	Map<Integer, Cadena> mapaCadenas = new HashMap<Integer, Cadena>();
	
	public BBDDTemporal() {}
	
	public boolean guardarBloque(Bloque q, String hash) {
		mapaBloques.put(hash,  q);
		return true;
	}
	
	public void guardarCadena(Cadena c, Integer codLote) {
		mapaCadenas.put(codLote, c);
	}
	
	public Bloque getBloque(String n) {
		return mapaBloques.get(n);
	}
	
	public Cadena getCadena(int codLote) {
		return mapaCadenas.get(codLote);
	}
	
	public void createCadena(int codLote) {
		Cadena cadena = new Cadena(codLote);
		cadena.setBBDDTemporal(this);
		mapaCadenas.put(codLote, cadena);
	}
}
