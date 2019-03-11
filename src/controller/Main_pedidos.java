package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
 

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import otros.*;
import model.*;
public class Main_pedidos {
	   public static OrdenTrazabilidad OrdenTrazabilidad; 
	   public static int codorigen;//
	   public static int  coddestino;//  	
	   
	   public Main_pedidos(String pedido) {
		   DescodificadorJson este=new DescodificadorJson();
		   OrdenTrazabilidad=este.DescodificadorJson(pedido);
	   }
	  
	   public Orden crear_pedido () { 
		  sacarCodigoOrigenDestino();
		  Orden devolver = new Orden(OrdenTrazabilidad);
			switch(codorigen) {
			case 2:
				devolver = new CooperativaOrdenes(OrdenTrazabilidad);
				break;
			case 3:
				devolver = new FabricaOrdenes(OrdenTrazabilidad);
				break;
			case 4:
				devolver = new RetailerOrdenes(OrdenTrazabilidad);
				break;
			case 5:
				devolver = new TiendaOrdenes(OrdenTrazabilidad);
				break;
			}
			devolver.crearPedido();
			return devolver;
	}	    
	
	public static boolean verificar_pedido() {
		//System.out.println("---->El sistema verifica que el pedido sea correcto" );
		boolean valido=false; 
		sacarCodigoOrigenDestino();
		if((codorigen-coddestino)==1) {valido=true;} 
		return valido;
	}
	
	public static void sacarCodigoOrigenDestino() {
		int contador=0;
		OrdenTrazabilidad.Actor tipo;
		int codigo;
		while(contador<2) {
			if(contador==0) {
				tipo=OrdenTrazabilidad.getActorOrigen();
			}
			else {
				tipo=OrdenTrazabilidad.getDestinatario();
			}
			switch(tipo) {
				case PRODUCTOR:codigo=1;break;
				case COOPERATIVA:codigo=2;break;
				case FABRICA:codigo=3;break;
				case RETAILER:codigo=4;break;
				case TIENDA:codigo=5;break;
				default:codigo=100;break;//caso error no existe dicho usuario 
			}
			if(contador==0) codorigen=codigo;
			else coddestino=codigo;
			contador++;
		}
	} 
}
