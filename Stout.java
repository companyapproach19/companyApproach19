
public class Stout {
	private double maltaCaramelo;
	private double maltaBasePalida;
	private double maltaMunich;
	private double maltaNegra;
	private double maltaCrystal;
	private double agua;
	private double maltaChocolate;
	private double cebadaTostada;
	private double lupuloCentennial;
	//Las levaduras no tienen cantidad, es un error???????????????????????????
	private boolean levaduraAle;
	
	public Stout() {
	agua=24;
	maltaBasePalida = 5500;
	AlmacenMMMPP.setMaltaBasePalida(AlmacenMMMPP.getMaltaBasePalida-5500);
	maltaMunich = 1300;
	AlmacenMMMPP.setMaltaMunich(AlmacenMMMPP.getMaltaMunich-1300);
	cebadaTostada = 450;
	AlmacenMMMPP.setCebadaTostada(AlmacenMMMPP.getCebadaTostada-450);
	maltaNegra = 225;
	AlmacenMMMPP.setMaltaNegra(AlmacenMMMPP.getMaltaNegra-225);
	maltaCrystal = 140;
	AlmacenMMMPP.setMaltaCrystal(AlmacenMMMPP.getMaltaCrystal-140);
	maltaChocolate = 120;
	AlmacenMMMPP.setMaltaChocolate(AlmacenMMMPP.getMaltaChocolate-120);
	maltaCaramelo = 90;
	AlmacenMMMPP.setMaltaCaramelo(AlmacenMMMPP.getMaltaCaramelo-90);
	lupuloCentennial= 70;
	AlmacenMMMPP.setLupuloCentennial(AlmacenMMMPP.getLupuloCentennial-70);
	//Falta la levadura
	}	
		
}
