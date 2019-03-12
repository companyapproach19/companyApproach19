package company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sensor extends DatosContainer{
	
	//Aquí se encuentra el .txt con el registro
  	private static BufferedReader log; 
  	
  	private static int id;
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
  	private static String temperatura ;

  	
  	// Cambiar por la ruta donde esté el log que se quiera probar
  	private static String ruta="C:\\Users\\Laura Colomer\\Documents\\datosSensor.txt" ;
  	
  	//Permite buscar la temperatura ó humedad de una determinada fecha y hora dentro del registro
	public String buscar(String anioParam, String mesParam, String diaParam, String horaParam, String minParam, String secParam) throws IOException {
		log = new BufferedReader(new FileReader(ruta)); 
		
		// Va leyendo línea por línea...
		while ((linea = log.readLine()) != null) {
			if(!linea.isEmpty()){
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
													if(sec.equals(secParam)){
														if(partes[2].contains("ºC")){
															return partes[2];
														}
													}
																				
											}
										}
							}
					}
				}
			}
		}
		log.close();
		return "-1";
	}

	public static String getTemperatura() {
		return temperatura;
	}

	public static void setTemperatura(String temperatura) {
		Sensor.temperatura = temperatura;
	}


	public static String getAnio() {
		return anio;
	}

	public static void setAnio(String anio) {
		Sensor.anio = anio;
	}


	public static String getMes() {
		return mes;
	}

	public static void setMes(String mes) {
		Sensor.mes = mes;
	}


	public static String getDia() {
		return dia;
	}

	public static void setDia(String dia) {
		Sensor.dia = dia;
	}


	public static String getHora() {
		return hora;
	}

	public static void setHora(String hora) {
		Sensor.hora = hora;
	}


	public static String getMin() {
		return min;
	}

	public static void setMin(String min) {
		Sensor.min = min;
	}


	public static String getSec() {
		return sec;
	}

	public static void setSec(String sec) {
		Sensor.sec = sec;
	}

	
	public static void setID (int id){
		   Sensor.id = id;
		}
		public static int getID (){
		 return id;
		}
	
	

}
