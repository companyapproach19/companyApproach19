package iSoftware;

public class Lote {
	public static int code;
	public static String tipo;
	

	public Lote(Stout name) {
		Lote.code=name.getId();
		Lote.tipo="Stout";
	}
	
	public Lote (Pilsner name) {
		Lote.code=name.getId();
		Lote.tipo="Pilsner";
	}

	public static int getCode() {
		return code;
	}

	public static void setCode(int code) {
		Lote.code = code;
	}

	public static String getTipo() {
		return tipo;
	}

	public static void setTipo(String tipo) {
		Lote.tipo = tipo;
	}
}