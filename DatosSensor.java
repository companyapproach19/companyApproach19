import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DatosSensor {
	
	
		//Aquí se encuentra el .txt con el registro
	  	private static BufferedReader log; 
	  	
	  	
	  	private static String linea;
	  	private static String fecha;
	  	private static String anio;
	  	private static String mes;
	  	private static String dia;
	  	private static String partes [];
	  	private static String partesFecha [] ;
	 	private static String partesHora [];
	  	private static String hora ;
	  	private static String min ;
	  	private static String sec ;
	  	
	  	
	  	// Cambiar por la ruta donde esté el log que se quiera probar
	  	private static String ruta="/home/marisol/log.txt" ;

	  	
	  
	  	
	  	
	  	
	  	//Permite buscar la temperatura ó humedad de una determinada fecha y hora dentro del registro
		public static String buscar(String anioParam, String mesParam, String diaParam, String horaParam, String minParam, String secParam, boolean temperatura) throws IOException {
			log = new BufferedReader(new FileReader(ruta)); 
			
			// Va leyendo línea por línea...
			while ((linea = log.readLine()) != null) {
				partes  = linea.split(" ");
				fecha = partes[0];
				partesFecha  = fecha.split("-");
				anio=partesFecha [0];
				if(anio.equals(anioParam)) {
					mes=partesFecha [1];
					if(mes.equals(mesParam)) {
						dia=partesFecha [2];
							if(dia.equals(diaParam)) {
								hora = partes[1];
										partesHora = hora.split(":");
										hora=partesHora[0];
										if(hora.equals(horaParam)){
											min=partesHora[1];
											if(min.equals(minParam)){
												sec=partesHora[2];
													if(sec.equals(secParam))
														// Si queremos mostrar temperatura el boolean valdrá "true"
														log.close();
														if(temperatura)
															return partes[2];
														return partes[3];
													
													
											}
										}
							}
					}
				}
			}
			log.close();
			return "-1";
		}
	
		
		public static void main (String args[]) throws IOException {
			
			System.out.println("Prueba 1   Fecha correcta Humedad:"+buscar("2019","03","04","12","33","45",false));
			System.out.println("Prueba 2   Fecha correcta Temperatura:"+buscar("2018","03","04","12","33","45",true));
			System.out.println("Prueba 3   Fecha incorrecta Humedad:"+buscar("2019","04","04","12","33","45",false));
			System.out.println("Prueba 4   Fecha incorrecta Temperatura:"+buscar("2029","03","04","12","33","45",true));
			System.out.println("Prueba 5   Parámetros incorrectos :"+buscar("dd","0d3","0d4","1v2","33v","4v5",true));
			System.out.println("Prueba 6   Sin Parámetros:"+buscar("","","","","","",true));


		}
	
	

}
