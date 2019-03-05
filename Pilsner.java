package ISO;
public class Pilsner {
	private double maltaPilsner;
	private double maltaCaramelo;
	private double lupuloPerle;
	private double lupuloTettnanger;
	//Las levaduras no tienen cantidad, es un error???????????????????????????
	private boolean levaduraLager;
	private double agua;
	private int id;
	
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
		
}
