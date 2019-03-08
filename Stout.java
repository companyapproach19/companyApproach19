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
		//id = AlmacenMMPP.getId();
		//AlmacenMMPP.setId(AlmacenMMPP.getId() + 1);
		agua = 11428571.4286;
		maltaBasePalida = 2619047619.05;
		AlmacenMMPP.setMaltaBasePalida(AlmacenMMPP.getMaltaBasePalida() - 2619047619.05);
		maltaMunich = 619047619.048;
		AlmacenMMPP.setMaltaMunich(AlmacenMMPP.getMaltaMunich() - 619047619.048);
		cebadaTostada = 214285714.286;
		AlmacenMMPP.setCebadaTostada(AlmacenMMPP.getCebadaTostada() - 214285714.286);
		maltaNegra = 107142857.143;
		AlmacenMMPP.setMaltaNegra(AlmacenMMPP.getMaltaNegra() - 107142857.143);
		maltaCrystal = 66666666.6667;
		AlmacenMMPP.setMaltaCrystal(AlmacenMMPP.getMaltaCrystal() - 66666666.6667);
		maltaChocolate = 57142857.1429;
		AlmacenMMPP.setMaltaChocolate(AlmacenMMPP.getMaltaChocolate() - 57142857.1429);
		maltaCaramelo = 42857142.8571;
		AlmacenMMPP.setMaltaCaramelo(AlmacenMMPP.getMaltaCaramelo() - 42857142.8571);
		lupuloCentennial = 33333333.3333;
		AlmacenMMPP.setLupuloCentennial(AlmacenMMPP.getLupuloCentennial() - 33333333.3333);
		// Falta la levadura
	}

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
