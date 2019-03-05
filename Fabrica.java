package company;

public class Fabrica {
	private String CIF;
	private String direccion;
	private String idAlmacenMaterias;
	private String idAlmacenLotes;
	
	public Fabrica(String CIF,String direccion,String idAlmacenMaterias,String idAlmacenLotes) {
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
	public void setCIF(String CIF) {
		CIF = CIF;
	}

	public String getIdAlmacenMaterias() {
		return idAlmacenMaterias;
	}

	public void setIdAlmacenMaterias(String idAlmacenMaterias) {
		this.idAlmacenMaterias = idAlmacenMaterias;
	}

	public String getIdAlmacenLotes() {
		return idAlmacenLotes;
	}

	public void setIdAlmacenLotes(String idAlmacenLotes) {
		this.idAlmacenLotes = idAlmacenLotes;
	}
	

}
