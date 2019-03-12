package company;

public class Retailer {
	
	private String nombre;
	private String cif;
	private String direccion;
	
	public Retailer(String cif, String nombre, String direccion) {
		this.cif = cif;
		this.nombre=nombre;
		this.direccion=direccion;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCif() {
		return this.cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getDireccion() {
		return this.direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
