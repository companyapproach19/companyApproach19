package iSoftware;

public class Stout {
	public static double maltaCaramelo;
	public static double maltaBasePalida;
	public static double maltaMunich;
	public static double maltaNegra;
	public static double maltaCrystal;
	public static double agua;
	public static double maltaChocolate;
	public static double cebadaTostada;
	public static double lupuloCentennial;
	// Las levaduras no tienen cantidad, es un error???????????????????????????
	public static boolean levaduraAle;
	public static int id;


	public Stout() {
		id = Principal.getid();
		id++;
		Principal.setid(id);
		agua = 11428571.428571428571428571428571; //litros por cada 10.000.000 litros cerveza
		maltaBasePalida = 2619047619.0476190476190476190476; //gramos por cada ...
		AlmacenMMPP.setMaltaBasePalida(AlmacenMMPP.getMaltaBasePalida() - 2619047619.0476190476190476190476);
		maltaMunich = 619047619.04761904761904761904762;
		AlmacenMMPP.setMaltaMunich(AlmacenMMPP.getMaltaMunich() - 619047619.04761904761904761904762);
		cebadaTostada = 214285714.28571428571428571428571;
		AlmacenMMPP.setCebadaTostada(AlmacenMMPP.getCebadaTostada() - 214285714.28571428571428571428571);
		maltaNegra = 107142857.14285714285714285714286;
		AlmacenMMPP.setMaltaNegra(AlmacenMMPP.getMaltaNegra() - 107142857.14285714285714285714286);
		maltaCrystal = 66666666.666666666666666666666667;
		AlmacenMMPP.setMaltaCrystal(AlmacenMMPP.getMaltaCrystal() - 66666666.666666666666666666666667);
		maltaChocolate = 57142857.142857142857142857142857; //120
		AlmacenMMPP.setMaltaChocolate(AlmacenMMPP.getMaltaChocolate() - 57142857.142857142857142857142857);
		maltaCaramelo = 42857142.857142857142857142857143; // 90
		AlmacenMMPP.setMaltaCaramelo(AlmacenMMPP.getMaltaCaramelo() - 42857142.857142857142857142857143);
		lupuloCentennial = 33333333.333333333333333333333333; // 70
		AlmacenMMPP.setLupuloCentennial(AlmacenMMPP.getLupuloCentennial() - 33333333.333333333333333333333333);
		// Falta la levadura
		//método setLevadura

	}
	
	/*public static boolean setLevadura () {
		return levaduraAle = true;
	}
	public static boolean hayLevadura (boolean lleva) {
		if (lleva == true){
		return true;
		}
		else{
		return false
		}
	}
	Si las levaduras no tienen cantidades se me ocurren éstos dos metodos bool para saber si el lote lleva o no 
	levaduraAle
	*/


	public static double getMaltaCaramelo() {
		return maltaCaramelo;
	}

	public static void setMaltaCaramelo(double maltaCaramelo) {
		maltaCaramelo = maltaCaramelo;
	}

	public static double getMaltaBasePalida() {
		return maltaBasePalida;
	}

	public static void setMaltaBasePalida(double maltaBasePalida) {
		maltaBasePalida = maltaBasePalida;
	}

	public static double getMaltaMunich() {
		return maltaMunich;
	}

	public static void setMaltaMunich(double maltaMunich) {
		maltaMunich = maltaMunich;
	}

	public static double getMaltaNegra() {
		return maltaNegra;
	}

	public static void setMaltaNegra(double maltaNegra) {
		maltaNegra = maltaNegra;
	}

	public static double getMaltaCrystal() {
		return maltaCrystal;
	}

	public static void setMaltaCrystal(double maltaCrystal) {
		maltaCrystal = maltaCrystal;
	}

	public static double getAgua() {
		return agua;
	}

	public static void setAgua(double agua) {
		agua = agua;
	}

	public static double getMaltaChocolate() {
		return maltaChocolate;
	}

	public static void setMaltaChocolate(double maltaChocolate) {
		maltaChocolate = maltaChocolate;
	}

	public static double getCebadaTostada() {
		return cebadaTostada;
	}

	public static void setCebadaTostada(double cebadaTostada) {
		cebadaTostada = cebadaTostada;
	}

	public static double getLupuloCentennial() {
		return lupuloCentennial;
	}

	public static void setLupuloCentennial(double lupuloCentennial) {
		lupuloCentennial = lupuloCentennial;
	}

	public static boolean isLevaduraAle() {
		return levaduraAle;
	}

	public static void setLevaduraAle(boolean levaduraAle) {
		levaduraAle = levaduraAle;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		id = id;
	}

}