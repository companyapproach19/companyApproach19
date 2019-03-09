	package equipo4;
	public class Pilsner {
		
		public static double maltaPilsner;
		public static double maltaCaramelo;
		public static double lupuloPerle;
		public static double lupuloTettnanger;
		//Las levaduras no tienen cantidad, es un error???????????????????????????
		public static boolean levaduraLager;
		public static double agua;
		public static int id;
		public static boolean molido;
		public static boolean cocinado;
		public static boolean fermentacion1;
		public static boolean fermentacion2;
		public static boolean embotellado;
		
		public Pilsner() {
			id=AlmacenLotes.getId();
			AlmacenLotes.setId(AlmacenLotes.getId()+1);
			agua=11956521.7391;
			maltaPilsner = 1739130434.78;
			AlmacenMMPP.setMaltaPilsner(AlmacenMMPP.getMaltaPilsner()-1739130434.78);
			maltaCaramelo = 217391304.348;
			AlmacenMMPP.setMaltaCaramelo(AlmacenMMPP.getMaltaCaramelo()-217391304.348);
			lupuloPerle = 8695652.17391;
			AlmacenMMPP.setLupuloPerle(AlmacenMMPP.getLupuloPerle()-8695652.17391);
			lupuloTettnanger = 17391304.3478;
			AlmacenMMPP.setLupuloTettnanger(AlmacenMMPP.getLupuloTettnanger()-17391304.3478);
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