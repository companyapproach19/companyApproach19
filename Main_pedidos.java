
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
 

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Main_pedidos {
	   static OrdenTrazabilidad OrdenTrazabilidad; 
	   private static int codorigen;//
	   private static int  coddestino;//  	
	
	  public static void crear_pedido_pedido (String json) { 
		
		if(verificar_pedido()) {//simulacion pedido a fabrica para una cooperativa
			switch(codorigen) {
			case 2:
				CooperativaOrdenes cooperativa = new CooperativaOrdenes(OrdenTrazabilidad);
				cooperativa.Hacerpedido();//creamos el pedido
				break;
			case 3:
				FabricaOrdenes fabrica = new FabricaOrdenes(OrdenTrazabilidad);
				fabrica.CrearPedido();//creamos el pedido
				break;
			case 4:
				RetailerOrdenes retailer=new RetailerOrdenes(OrdenTrazabilidad);
				retailer.Hacerpedido();//creamos el pedido
				break;
			case 5:
				FabricaOrdenes tienda=new FabricaOrdenes(OrdenTrazabilidad);
				tienda.CrearPedido();//creamos el pedido
				break;
			}
		}
		else {
			System.out.println("<--- pedido incorrecto :El sistema verifica que el pedido sea correcto");
		}
	}	    
	
	private static boolean verificar_pedido() {
		System.out.println("---->El sistema verifica que el pedido sea correcto" );
		boolean valido=false; 
		sacarCodigoOrigenDestino();
		if((codorigen-coddestino)==1) {valido=true;} 
		return valido;
	}
	
	private static void sacarCodigoOrigenDestino() {
		int contador=0;
		String tipo="";
		int codigo;
		while(contador<2) {
			if(contador==0) {
				tipo=OrdenTrazabilidad.getActorOrigen().name();	
			}
			else {
				tipo=OrdenTrazabilidad.getDestinatario().name();
			}
			switch(tipo) {
				case "PRODUCTOR":codigo=1;break;
				case "COOPERATIVA":codigo=2;break;
				case "FABRICA":codigo=3;break;
				case "RETAILER":codigo=4;break;
				case "TIENDA":codigo=5;break;
				default:codigo=100;break;//caso error no existe dicho usuario anomalia
			}
			if(contador==0) codorigen=codigo;
			else coddestino=codigo;
			contador++;
		}
	}
	
}
