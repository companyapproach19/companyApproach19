// CIF, nombre, direccion, cifCooperativa

package company;

public class Agricultor {
	private String cif;
	private String nombre;
	private String direccion;
	private int cifCooperativa;
	
	public Agricultor(String cif, String nombre, String direccion, int cifCooperativa){
		this.cif = cif;
		this.nombre = nombre;
		this.direccion = direccion;
		this.cifCooperativa = cifCooperativa;
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
	
	public int getCifCooperativa(){
		return this.cifCooperativa;
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
	
	public void setCifCooperativa(int cifCooperativa){
		this.cifCooperativa = cifCooperativa;
	}

}
