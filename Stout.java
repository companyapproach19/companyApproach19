package ISO;

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
		id = AlmacenMMPP.getId();
		AlmacenMMPP.setId(AlmacenMMPP.getId() + 1);
		agua = 24;
		maltaBasePalida = 5500;
		AlmacenMMPP.setMaltaBasePalida(AlmacenMMPP.getMaltaBasePalida() - 5500);
		maltaMunich = 1300;
		AlmacenMMPP.setMaltaMunich(AlmacenMMPP.getMaltaMunich() - 1300);
		cebadaTostada = 450;
		AlmacenMMPP.setCebadaTostada(AlmacenMMPP.getCebadaTostada() - 450);
		maltaNegra = 225;
		AlmacenMMPP.setMaltaNegra(AlmacenMMPP.getMaltaNegra() - 225);
		maltaCrystal = 140;
		AlmacenMMPP.setMaltaCrystal(AlmacenMMPP.getMaltaCrystal() - 140);
		maltaChocolate = 120;
		AlmacenMMPP.setMaltaChocolate(AlmacenMMPP.getMaltaChocolate() - 120);
		maltaCaramelo = 90;
		AlmacenMMPP.setMaltaCaramelo(AlmacenMMPP.getMaltaCaramelo() - 90);
		lupuloCentennial = 70;
		AlmacenMMPP.setLupuloCentennial(AlmacenMMPP.getLupuloCentennial() - 70);
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
