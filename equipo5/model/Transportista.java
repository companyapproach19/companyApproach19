package company;

public class Transportista {
	private String transportista_cif;
	private String empresa_transporte;

	public Transportista (String transportista_cif, String empresa_transporte){
		this.transportista_cif = transportista_cif;
		this.empresa_transporte = empresa_transporte;
	}
	
	public String getTransportistaCif (){
		return this.transportista_cif;
	}
	public String getEmpresaTransporte (){
		return this.empresa_transporte;
	}
}
