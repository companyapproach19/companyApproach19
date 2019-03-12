
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class casosprubea {
	private List<String> list_bien ;
	private List<String> list_mal ;
	public OrdenTrazabilidad.Actor sacar(int a){
		OrdenTrazabilidad.Actor es;
		switch(a) {
		case 1:es=OrdenTrazabilidad.Actor.PRODUCTOR;break;
		case 2:es=OrdenTrazabilidad.Actor.COOPERATIVA;break;
		case 3:es=OrdenTrazabilidad.Actor.FABRICA;break;
		case 4: es=OrdenTrazabilidad.Actor.RETAILER;break;
		case 5:es=OrdenTrazabilidad.Actor.TIENDA;break;
		default:es=OrdenTrazabilidad.Actor.PRODUCTOR;break;
		}
		return es;
	}
	public enum Actor {
	    PRODUCTOR, COOPERATIVA, FABRICA, RETAILER, TIENDA
	} 
	public void casosdeprueba() {
	//generamos distintos casos de prueba
	int id=0;

    Productos productos = new Productos(20, 40, 0, 0, 0, 0, 0, 0, 0);
	Transportista transportistaPrueba = new Transportista(
            "Juan Jose Romagosa", "Povas",
            "08-03-2019", "13-03-2019"); 
	
	OrdenTrazabilidad.Actor emisor ;
	OrdenTrazabilidad.Actor receptor;
	list_bien = new ArrayList<String>();
	list_mal = new ArrayList<String>();
    for(int i=1;i<=5;i++) {
    	emisor=sacar(i);
    	 for(int j=1;j<=5;j++) {
    		
    		 OrdenTrazabilidad pedidoPrueba = new OrdenTrazabilidad(id, "Petici�n de prueba.",
    				  emisor, sacar(j),
    		            transportistaPrueba, productos);
    			 String json=CodificadorJSON.crearJSON(pedidoPrueba); 
    			 if(i-j==1) {list_bien.add(json);}
    			 else {list_mal.add(json);}
    	}
    }
}
	/*
	 * 
	 * 
	 * 
	 * VERIFICAMOS QUE LAS PETICIONES SEAN CORRECTAS.
	 * 
	 * 
	 */
		  @Test
		  public void test_peticionesmal() {
			  casosdeprueba();
			  for(String a:list_mal) {
				  Main_pedidos aa= new Main_pedidos(a);
		    boolean resultadoReal = aa.verificar_pedido();
		    boolean resultadoEsperado = false;
		    assertEquals(resultadoEsperado, resultadoReal);
			  }}
		  
		  
		  @Test  
		public void test_peticionesbien() {
				  casosdeprueba();
				  for(String a:list_bien) {
					  Main_pedidos aa= new Main_pedidos(a);
			    boolean resultadoReal = aa.verificar_pedido();
			    boolean resultadoEsperado = true;
			    assertEquals(resultadoEsperado, resultadoReal);
				  }}
		 @Test   
			public void test_proceso() {
			  casosdeprueba();
			  for(String a:list_bien) {
				  Main_pedidos aa= new Main_pedidos(a);
				  aa.crear_pedido_pedido();
				  boolean resultadoReal = aa.OrdenTrazabilidad.isFirmadoEntrega();
		    boolean resultadoEsperado = true;
		    assertEquals(resultadoEsperado, resultadoReal);
			  }
	
}
		  /*
		   * 
		   * 
		   * 
		   * 
		   * 
		   */
		  
}
	
