package ISO;

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
	// Las levaduras no tienen cantidad, es un error???????????????????????????
	private boolean levaduraAle;
	private int id;

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

}
