public class Transportista {
	private String transportista_cif;
	private String empresa_transporte;

	public Transportista (String transporte_cif, String empresa_transporte){
		this.transporte_cif = transporte_cif;
		this.empresa_transporte = empresa_transporte;
	}
	
	public String getTransporte_cif (){
		return this.transporte_cif;
	}
	public String getEmpresaTransporte (){
		return this.empresa_transporte;
	}
}
