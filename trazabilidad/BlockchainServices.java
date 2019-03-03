package trazabilidad;

import trazabilidad.model.*;

//Esta es la clase a la que van a llamar el resto de grupos para hacer sus
//gestiones con respecto a añadir cosas al blockchain
public class BlockchainServices{
	
	//Temproal
	BBDDTemporal BBDD;

    //Aun tienen que definir los otros grupos cual va a ser la clase
    //que nos van a pasar de con la informacion del traspaso. No se si sera
    //este nombre u otro, pero en cualquier caso podemos tratarlo como si fuera lo mismo.
    //Recibe un objeto contenedor con la informacion del traspaso, y tenemos que encapsularlo
    //en DatosContainer, y guardarlo en la cadena con los metodos de la clase Cadena correspondientes
    //TODO alejandro
    public void guardarTraspaso(Traspaso traspaso){
        //encapsularlo, sin tener los datos de la clase Traspaso no podemos encapsularlo
        DatosContainer dc = traspaso;
        int codLote = traspaso.getCodLote();

        Cadena cadena = BBDD.getCadena(codLote);

        cadena.incorporarBloque(dc, 0); //Cambiar cuando asignemos cada entero a cada tipo de bloque
        /* Bloque bloque = new Bloque();

    	Bloque bloque = null;
    	
    	Cadena cadena = new Cadena(0);    	
    	
    	//meterlo a la cadena
    	cadena.incorporarBloque(dc,bloque.getTipoBloque()); */
    	
    	
    }


    //Funcion que devuelve la informacion de un traspaso. 
    //Aun por concretar como se va a identificar al traspaso, si por un id_traspaso o como. 
    //en cualquier caso, nos pasan siempre el codLote, nosotros cogemos la cadena asociada
    //a ese lote y a partir de ahi vamos tirando. 

    //Obtiene bloque adecuado utilizando los metodos de clase Cadena, y una vez lo tiene 
    //extrae la informacion del traspaso y la devuelve.
    //TODO anton
    public Traspaso getTraspaso(int codLote){
    	Cadena cadena = BBDD.getCadena(codLote);
	List<Bloque> bloques = cadena.getCadena();
	int i =0;
	while(i<bloques.size()){
		if(bloques.get(i).getCodLote() == codLote){
			return bloques.get(i).getDatos() //habria que convertirlos a traspaso
		}
	}
	return null;
    }
}




//Temporal
class Traspaso extends DatosContainer{
	public int getCodLote() {
		return 0;
	}
}
class BBDDTemporal{
	public boolean guardarBloque(Bloque q, String hash) {
		return true;
	}
	
	public void guardarCadena(Cadena c) {
		
	}
	
	public Bloque getBloque(String n) {
		return null;
	}
	
	public Cadena getCadena(int codLote) {
		return null;
	}
}
