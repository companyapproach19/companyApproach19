package equipo6.objetosTemporales;

import equipo6.model.*;

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
