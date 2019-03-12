package company;

public class Fabrica {
	private String CIF;
	private String direccion;
	private int idAlmacenMaterias;
	private int idAlmacenLotes;
	
	public Fabrica(String CIF,String direccion,int idAlmacenMaterias,int idAlmacenLotes) {
		this.CIF= CIF;
		this.direccion= direccion;
		this.idAlmacenMaterias=idAlmacenMaterias;
		this.idAlmacenLotes=idAlmacenLotes;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCIF() {
		return CIF;
	}
	public void setCIF(String cif) {
		CIF = cif;
	}

	public int getIdAlmacenMaterias() {
		return idAlmacenMaterias;
	}

	public void setIdAlmacenMaterias(int idAlmacenMaterias) {
		this.idAlmacenMaterias = idAlmacenMaterias;
	}

	public int getIdAlmacenLotes() {
		return idAlmacenLotes;
	}

	public void setIdAlmacenLotes(int idAlmacenLotes) {
		this.idAlmacenLotes = idAlmacenLotes;
	}
	

}
