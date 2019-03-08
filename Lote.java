package iSoftware;

import java.util.*;

public class Lote {
	public static int code;
	public static String tipo;
	public static LinkedList<String> pedidos;
	private static Date fecha_inicio;

	public Lote(Stout name) {
		Lote.code=name.getId();
		Lote.tipo="Stout";
		pedidos = new LinkedList<String>();
	}
	
	public Lote (Pilsner name) {
		Lote.code=name.getId();
		Lote.tipo="Pilsner";
		pedidos = new LinkedList<String>();
	}

	public static LinkedList<String> getPedidos() {
		return pedidos;
	}

	public static void setPedidos(LinkedList<String> pedidos) {
		Lote.pedidos = pedidos;
	}

	public static int getCode() {
		return code;
	}

	public static void setCode(int code) {
		Lote.code = code;
	}

	public static String getTipo() {
		return tipo;
	}

	public static void setTipo(String tipo) {
		Lote.tipo = tipo;
	}

	public static Date getFecha_inicio() {
		return fecha_inicio;
	}

	public static void setFecha_inicio(Date fecha_inicio) {
		Lote.fecha_inicio = fecha_inicio;
	}
}