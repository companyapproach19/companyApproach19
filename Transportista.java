public class Transportista {
	private String empresa;
	private String CIF;

	public Transportista (String empresa, String CIF){
		this.empresa = empresa;
		this.CIF = CIF;
	}
	
	public String getEmpresa (){
		return this.empresa;
	}
	public String getCIF (){
		return this.CIF;
	}
}
