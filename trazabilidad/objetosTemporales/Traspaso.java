package trazabilidad.objetosTemporales;

import trazabilidad.model.DatosContainer;

public class Traspaso extends DatosContainer {
	int codLote;
	String info;
	
	public Traspaso(int codLote,String info) {
		this.codLote=codLote;
		this.info=info;
	}
	
	public int getCodLote() {
		return this.codLote;
	}
	
	public String getInfo() {
		return this.info;
	}
}
