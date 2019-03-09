
// CIF, nombre, direccion

package company;

public class Cooperativa {
	private String cif;
	private String nombre;
	private String direccion;
	
	public Cooperativa(String cif, String nombre, String direccion){
		this.cif = cif;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public String getCif(){
		return this.cif;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getDireccion(){
		return this.direccion;
	}
	
	public void setCif(String cif){
		this.cif = cif;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public void setDireccion(String direccion){
		this.direccion = direccion;		
	}

}
