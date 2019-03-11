package company;

public class Lote {
	private int code;
	private String tipo;
	
	public Lote(int code, String tipo){
		this.code=code;
		this.tipo=tipo;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
