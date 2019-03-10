package model;

public class Transportista {
	//en esta clase he añadido los atributos para aceptar el pedido 
	//y los atributos para las firmas de recogida y entrega del pedido

	private String nombre;
	private String empresa;
	private String fecha_recogida;
	private String fecha_entrega;

	//aceptacion del pedido
	private boolean aceptaPedido;
	//firma cuando recoge el pedido en el origen
	private boolean firmadoRecogida;
	//firma cuando entrega el pedido en el destino)
	private boolean firmadoEntrega;

	public Transportista(String nombre, String empresa, String fecha_recogida, String fecha_entrega) {
		this.nombre = nombre;
		this.empresa = empresa;
		this.fecha_recogida = fecha_recogida;
		this.fecha_entrega = fecha_entrega;
		this.aceptaPedido=false;
		this.firmadoRecogida=false;
		this.firmadoEntrega=false;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmpresa() {
		return empresa;
	}

	public String getFecha_recogida() {
		return fecha_recogida;
	}

	public String getFecha_entrega() {
		return fecha_entrega;
	}
	
	public void firma() {
		if(firmadoRecogida==false) {firmadoRecogida=true;}
		if(firmadoEntrega==false) {firmadoEntrega=true;}
		
	}
public void inicia_firma_agricultor() {
		
	}
	public boolean isFirmadoRecogida() {
	return firmadoRecogida;
}

public void setFirmadoRecogida(boolean firmadoRecogida) {
	this.firmadoRecogida = firmadoRecogida;
}

public boolean isFirmadoEntrega() {
	return firmadoEntrega;
}

public void setFirmadoEntrega(boolean firmadoEntrega) {
	this.firmadoEntrega = firmadoEntrega;
}

	public boolean getaceptaPedido() {
		return aceptaPedido;
	}
	
	public void aceptarPedido() {
		this.aceptaPedido = true;
	}

	public void rechazarPedido() {
		this.aceptaPedido = false;
	}
	

	public boolean firmaRecogida() {
		return firmadoRecogida;
	}

	public boolean firmaEntrega() {
		return firmadoEntrega;
	}

}