package iSoftware;

import java.util.*;

public class Lote {
	public static int code;
	public static String tipo;
	public static LinkedList<String> pedidos;
	private static Date fecha_inicio;
	private static Date fecha_final;

	@SuppressWarnings({ "deprecation", "static-access" })
	public Lote(Stout name, Date fecha_inicio) {
		Lote.code=name.getId();
		Lote.tipo="Stout";
		Lote.fecha_inicio = fecha_inicio;
		Date aux = (Date) fecha_inicio.clone();
		aux.setDate(fecha_inicio.getDate()+12);
		Lote.fecha_final = aux;
		pedidos = new LinkedList<String>();
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public Lote (Pilsner name, Date fecha_inicio) {
		Lote.code=name.getId();
		Lote.tipo="Pilsner";
		Lote.fecha_inicio = fecha_inicio;
		Date aux = (Date) fecha_inicio.clone();
		aux.setDate(fecha_inicio.getDate()+12);
		Lote.fecha_final = aux;
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
		/*
		 * Aquí deberíamos inicializar la fecha final
		 */
	}
	
	public static void setFecha_final(Date fecha_final) {
		Lote.fecha_final = fecha_final;
	}
	
	public static Date getFecha_final() {
		return Lote.fecha_final;
	}
}