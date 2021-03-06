package cadenaSensor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Clase donde se simulan posibles llamadas al método "buscar" que se encuentra en la clase"sensorPrueba"
public class PruebasSensor extends DatosContainer{
	
	//Se crea un nuevo sensor
	private static Sensor sensorPrueba= new Sensor();
	
	public static void main (String args[]) throws IOException {
		
		// El método "buscar" recibe como parámetros fechas ficticias, que serán buscadas dentro de un log real
		System.out.println("Prueba 1   Fecha correcta Temperatura:"+sensorPrueba.buscar("2019","3","10","16","15","12"));
		System.out.println("Prueba 2   Fecha correcta Temperatura:"+sensorPrueba.buscar("2019","3","10","16","15","33"));
		System.out.println("Prueba 3   Fecha incorrecta Temperatura:"+sensorPrueba.buscar("2019","4","10","16","15","53"));
		System.out.println("Prueba 4   Fecha incorrecta Temperatura:"+sensorPrueba.buscar("2029","3","04","12","33","45"));
		System.out.println("Prueba 5   Parámetros incorrectos :"+sensorPrueba.buscar("dd","0d3","0d4","1v2","33v","4v5"));
		System.out.println("Prueba 6   Sin Parámetros:"+sensorPrueba.buscar("","","","","",""));


	}
}
