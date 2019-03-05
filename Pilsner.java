
public class Pilsner {

public class Pilsner {
	private double maltaPilsner;
	private double maltaCaramelo;
	private double lupuloPerle;
	private double lupuloTettnanger;
	//Las levaduras no tienen cantidad, es un error???????????????????????????
	private boolean levaduraLager;
	private double agua;
	
	public Pilsner() {
	agua=27.5;
	maltaPilsner = 4000;
	AlmacenMMMPP.setMaltaPilsner(AlmacenMMMPP.getMaltaPilsner-4000);
	maltaCaramelo = 500;
	AlmacenMMMPP.setMaltaCaramelo(AlmacenMMMPP.getMaltaCaramelo-500);
	lupuloPerle = 20;
	AlmacenMMMPP.setLupuloPerle(AlmacenMMMPP.getLupuloPerle-20);
	lupuloTettnanger = 40;
	AlmacenMMMPP.setLupuloTettnanger(AlmacenMMMPP.getLupuloTettnanger-40);
	//Falta la levadura
	}	
		
}
}
