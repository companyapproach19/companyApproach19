package ISO;
public class Pilsner {
	public static double maltaPilsner;
	public static double maltaCaramelo;
	public static double lupuloPerle;
	public static double lupuloTettnanger;
	//Las levaduras no tienen cantidad, es un error???????????????????????????
	public static boolean levaduraLager;
	public static double agua;
	public static int id;
	
	public Pilsner() {
	id=AlmacenMMPP.getId();
	AlmacenMMPP.setId(AlmacenMMPP.getId()+1);
	agua=27.5;
	maltaPilsner = 4000;
	AlmacenMMPP.setMaltaPilsner(AlmacenMMPP.getMaltaPilsner()-4000);
	maltaCaramelo = 500;
	AlmacenMMPP.setMaltaCaramelo(AlmacenMMPP.getMaltaCaramelo()-500);
	lupuloPerle = 20;
	AlmacenMMPP.setLupuloPerle(AlmacenMMPP.getLupuloPerle()-20);
	lupuloTettnanger = 40;
	AlmacenMMPP.setLupuloTettnanger(AlmacenMMPP.getLupuloTettnanger()-40);
	//Falta la levadura
	}

	public static double getMaltaPilsner() {
		return maltaPilsner;
	}

	public static void setMaltaPilsner(double maltaPilsner) {
		Pilsner.maltaPilsner = maltaPilsner;
	}

	public static double getMaltaCaramelo() {
		return maltaCaramelo;
	}

	public static void setMaltaCaramelo(double maltaCaramelo) {
		Pilsner.maltaCaramelo = maltaCaramelo;
	}

	public static double getLupuloPerle() {
		return lupuloPerle;
	}

	public static void setLupuloPerle(double lupuloPerle) {
		Pilsner.lupuloPerle = lupuloPerle;
	}

	public static double getLupuloTettnanger() {
		return lupuloTettnanger;
	}

	public static void setLupuloTettnanger(double lupuloTettnanger) {
		Pilsner.lupuloTettnanger = lupuloTettnanger;
	}

	public static boolean isLevaduraLager() {
		return levaduraLager;
	}

	public static void setLevaduraLager(boolean levaduraLager) {
		Pilsner.levaduraLager = levaduraLager;
	}

	public static double getAgua() {
		return agua;
	}

	public static void setAgua(double agua) {
		Pilsner.agua = agua;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Pilsner.id = id;
	}	
		
}
