package company;
import company.metodosCompany;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.*;

public class Test extends metodosCompany {

	 public static void main (String[]args){
         try {
             conectar();
             crearBD();
             
            //prueba almacenMMPP
            AlmacenMMPP almacen = new AlmacenMMPP(2,200,2.0,3.0,4.1,5.2,7.2,8.3,8.2,9.5,7.6,10.1,9.9,8.8,14.0);
            insertarAlMMPP(almacen);
          
           
           	//prueba Retailer
             Retailer ret = new Retailer("jkl2", "Carrefour", "avda eruopa");
             insertarRetailer(ret);
            
            
            
            //pruebas lotes
         	Date dateini = new Date(1, 12, 2015);
         	Date datefin = new Date(1, 12, 2019);
         	LinkedList<String> ped = new LinkedList <String>();
         	ped.add("primero");
         	ped.add("segundo");
         	ped.add("tercero");
         	
         	
         	LinkedList<Lote> lotes = new LinkedList();
             Lote lote1 = new Lote(0, 1, "malta", ped, dateini, datefin);
             insertarLote(lote1);
             lotes.add(lote1);
             Lote lote2 = new Lote(0, 2, "cebada", ped, dateini, datefin);
             insertarLote(lote2);
             lotes.add(lote2);	
             getLote(1);
             
             
             //prueba almacen lotes
            AlmacenLotes alm = new AlmacenLotes(0, 1, lotes);
            insertarAlmacenLotes(alm);
            getAlmacenLotes(1).getLista();
           
            //prueba fabrica
            Fabrica fabrica = new Fabrica("lkmn", "avda madrid", 2, 1);
            insertarFabrica(fabrica);
            getFabrica("lkmn");
            
          //prueba transportista
            Transportista a = new Transportista("juan", "apple", "12/11", "13/11");
            a.aceptarPedido();
            a.setFirmadoEntrega(true);
            a.setFirmadoRecogida(true);
            insertarTransportista(a);
            Transportista b = getTransportista("juan");
            Transportista c = getTransportista("pedro");
            
             
            //Prueba Agricultor
            Agricultor agricultor = new Agricultor("evrf", "Juan", "calle España", 76);
            insercionAgricultor(agricultor);
            getAgricultor(agricultor.getCif());
            
            
            //Prueba Cooperativa
            Cooperativa cooperativa = new Cooperativa("rbg", "Cooperativa1", "Avenida de la Hispanidad");
            insercionCooperativa(cooperativa);
            getCooperativa(cooperativa.getCif());
            
            Sensor a1 = new Sensor();
            a1.setID(1);
            a1.setAnio("2019");
            a1.setMes("mayo");
            a1.setDia("12");
            a1.setHora("08");
            a1.setMin("21");
            a1.setSec("47");
            a1.setTemperatura("25");
            insertarSensor(a1);
            Sensor b1 = getSensor(1);
           // System.out.println(a1.equals(b1));
            Sensor c1 = getSensor(4);
            //System.out.println(c1 == null);
             
             //Prueba Productos
             Productos prod = new Productos (1, 12, 5, 0, 4, 7, 8,10, 11, 0, 1, 4);
             insertarProductos(prod);
             getProductos(1);
             //devuelve cantidad de malta palida que es 12
            // System.out.print(getProductos(1).getCant_malta_palida());
             
             //Prueba Actor
             Actor pri = new Actor(0,"pri", "***", "correo@aux.es", 0);
             pri.setPasswordPlana("cont");
             pri.setId(0);
             Actor em = new Actor(1, "lperez", "**********","lperez@gmail.com", 0);
             em.setPasswordPlana("holahola");
             Actor re = new Actor(2, "mlopez", "**********", "mlopez@yahoo.es", 1);
             re.setPasswordPlana("holar");
             insercionActor(pri);
             insercionActor(em);
             insercionActor(re);
             //getActor("lperez");
             
             //prueba orden
             OrdenTrazabilidad orden = new OrdenTrazabilidad(1,"que llegue pronto por favor", em, re,
						 a, prod);
             insertarOrdenTrazabilidad(orden);
             getOrdenTrazabalidad(1);
             
             //prueba bloque --> NO FUNCIONA DA ERROR EL GETHASHCODE
             Bloque bloq = new Bloque("pasGD312463", 1, 2, 1, (DatosContainer) orden);
             insertarBloqueOrden(bloq);
             getBloqueOrden(bloq.getHashCode());
             
             
             System.out.print("Pasados todos los test correctamente");
            
         } catch (Exception e) {
             e.printStackTrace();
         }
     }

}
