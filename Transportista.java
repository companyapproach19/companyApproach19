public class Transportista {

	private String nombre;
	private String empresa;
	private String fecha_recogida;
	private String fecha_entrega;

	public Transportista(String nombre, String empresa, String fecha_recogida, String fecha_entrega) {
		this.nombre = nombre;
		this.empresa = empresa;
		this.fecha_recogida = fecha_recogida;
		this.fecha_entrega = fecha_entrega;
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

}
