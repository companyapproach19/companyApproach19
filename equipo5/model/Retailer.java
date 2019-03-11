package company;

public class Retailer {
	
	private String nombre;
	private String CIF;
	private String direccion;
	
	public Retailer(String CIF, String nombre, String direccion) {
		this.CIF = CIF;
		this.nombre=nombre;
		this.direccion=direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCIF() {
		return CIF;
	}
	public void setCIF(String cIF) {
		CIF = cIF;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
