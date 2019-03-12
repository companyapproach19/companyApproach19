//hashPrevio, tipoBloque, numBloque, codBloque, datos

package company;

public class BloqueFabrica{
	private String hashPrevio;
	private int tipoBloque;
	private int numBloque;
	private int codLote;
	DatosContainer datos;
	
	public BloqueFabrica(String hashPrevio, int tipoBloque, int numBloque, int codLote, DatosContainer datos){
		this.hashPrevio = hashPrevio;
		this.tipoBloque = tipoBloque;
		this.numBloque = numBloque;
		this.codLote = codLote;
		this.datos = datos;
	}
	
	public String getHashPrevio(){
		return this.hashPrevio;
	}
	
	public int getTipoBloque(){
		return this.tipoBloque;
	}
	
	public int getNumBloque(){
		return this.numBloque;
	}
	
	public int getCodLote(){
		return this.codLote;
	}
	
	public DatosContainer getDatos(){
		return this.datos;
	}
	
	public void setHashPrevio(String hashPrevio){
		this.hashPrevio = hashPrevio;
	}
	
	public void setTipoBloque(int tipoBloque){
		this.tipoBloque = tipoBloque;
	}
	
	public void setNumBloque(int numBloque){
		this.numBloque = numBloque;
	}
	
	public void setCodLote(int codLote){
		this.codLote = codLote;
	}
	
	public void setDatos(DatosContainer datos){
		this.datos = datos;
	}

}
