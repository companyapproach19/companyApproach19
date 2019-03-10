package company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class metodosCompany {

	private static Connection conn;
	
	 public static void conectar() throws ClassNotFoundException, SQLException {
	        String drv = "com.mysql.cj.jdbc.Driver";
	        Class.forName(drv);
	        String serverAddress = "localhost:3306";
	        String user = "root";
	        String pass = "root";
	        String url = "jdbc:mysql://"+serverAddress;
	        conn = DriverManager.getConnection(url, user, pass);
	        System.out.println("Conectado a la base de datos!" + "\n");
	    }
	    public  void exit() throws Exception {
	        //cierre de la conexion
	        if (conn!=null) conn.close();
	        System.out.println("Saliendo.. ¡hasta otra!");
	        System.exit(0);
	    }

	public void insertarRetailer(Retailer retailer) throws SQLException, ClassNotFoundException {
		conectar();
		String query = "INSERT INTO company.retailer (CIF, nombre, direccion) VALUES (?, ?, ?);";
		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
		pst.setString(1, retailer.getCIF());
		pst.setString(2, retailer.getNombre());
		pst.setString(3, retailer.getDireccion());
		pst.executeUpdate();
		pst.close();
		try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertarFabrica(Fabrica fabrica) throws SQLException, ClassNotFoundException {
		conectar();
		String query = "INSERT INTO company.fabrica (CIF,direccion, idAlmacenMaterias, idAlmacenLotes) VALUES (?, ?, ?, ?);";
		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
		pst.setString(1, fabrica.getCIF());
		pst.setString(2, fabrica.getDireccion());
		pst.setString(3, fabrica.getIdAlmacenMaterias());
		pst.setString(4, fabrica.getIdAlmacenLotes());
		pst.executeUpdate();
		pst.close();
		try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertarBloqueOrden(Bloque orden) throws SQLException, ClassNotFoundException {
		conectar();
		String query = "INSERT INTO company.bloqueOrden (hashCode, hashPrevio, tipoBloque, numBloque, codLote, datos) VALUES (?, ?, ?, ?, ?);";
		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
		pst.setString(1, orden.getHashCode());
		pst.setString(2, orden.getHashPrevio());
		pst.setInt(3, orden.getTipoBloque());
		pst.setInt(4, orden.getNumBloque());
		pst.setInt(5, orden.getCodLote());
		pst.setObject(6, orden.getDatos());
		pst.executeUpdate();
		pst.close();
		try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertarAlMMPP(AlmacenMMPP almacen) throws SQLException, ClassNotFoundException {
		conectar();
		String query = "INSERT INTO almacenMateriasPrimas (idAlmacenMateriasPrimas, capacidad, maltaPilsner, maltaCaramelo, "
				+ "maltaBasePalida, maltaMunich, maltaNegra , maltaCrystal, maltaChocolate ,cebadaTostada , lupuloPerle, lupuloTettnanger,  lupuloCentennial,  "
				+ "levaduraAle,  levaduraLager,  maxcapacidad, maxmaltaPilsner, maxmaltaCaramelo, maxmaltaBasePalida, "
				+ "maxmaltaMunich, maxmaltaNegra, maxmaltaCrystal, maxmaltaChocolate, maxcebadaTostada, maxlupuloPerle, maxlupuloTettnanger,maxlupuloCentennial,"
				+ " maxlevaduraAle, maxlevaduraLager ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);

		pst.setString(1, almacen.getId());
		pst.setInt(2, almacen.getCapacidad());
		pst.setDouble(3, almacen.getMaltaPilsner());
		pst.setDouble(4, almacen.getMaltaCaramelo());
		pst.setDouble(5, almacen.getMaltaBasePalida());
		pst.setDouble(6, almacen.getMaltaMunich());
		pst.setDouble(7, almacen.getMaltaNegra());
		pst.setDouble(8, almacen.getMaltaCrystal());
		pst.setDouble(9, almacen.getMaltaChocolate());
		pst.setDouble(10, almacen.getCebadaTostada());
		pst.setDouble(11, almacen.getLupuloPerle());
		pst.setDouble(12, almacen.getLupuloTettnanger());
		pst.setDouble(13, almacen.getLupuloCentennial());
		pst.setDouble(14, almacen.getLevaduraAle());
		pst.setDouble(15, almacen.getLevaduraLager());

		pst.setInt(16, almacen.getMaxcapacidad());
		pst.setDouble(17, almacen.getMaxmaltaPilsner());
		pst.setDouble(18, almacen.getMaxmaltaCaramelo());
		pst.setDouble(19, almacen.getMaxmaltaBasePalida());
		pst.setDouble(20, almacen.getMaxmaltaMunich());
		pst.setDouble(21, almacen.getMaxmaltaNegra());
		pst.setDouble(22, almacen.getMaxmaltaCrystal());
		pst.setDouble(23, almacen.getMaxmaltaChocolate());
		pst.setDouble(24, almacen.getMaxcebadaTostada());
		pst.setDouble(25, almacen.getMaxlupuloPerle());
		pst.setDouble(26, almacen.getMaxlupuloTettnanger());
		pst.setDouble(27, almacen.getMaxlupuloCentennial());
		pst.setDouble(28, almacen.getMaxlevaduraAle());
		pst.setDouble(29, almacen.getMaxlevaduraLager());

		pst.executeUpdate();
		pst.close();
		try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Retailer getRetailer(String CIF) throws SQLException {
		String query = "SELECT * FROM company.retailer WHERE retailer.CIF = " + CIF;
		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
		ResultSet rs = pst.executeQuery(query);
		Retailer buscado = new Retailer(rs.getString(1), rs.getString(2), rs.getString(3));
		pst.close();
		rs.close();
		try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buscado;
	}

	public Fabrica getFabrica(String CIF) throws SQLException {
		String query = "SELECT * FROM company.fabrica WHERE fabrica.CIF = " + CIF;
		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
		ResultSet rs = pst.executeQuery(query);
		Fabrica buscado = new Fabrica(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		pst.close();
		rs.close();
		try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buscado;
	}

	public Bloque getBloqueOrden(Bloque orden) throws SQLException, ClassNotFoundException {
		conectar();
		String query = "SELECT * FROM company.bloqueOrden WHERE bloqueOrden.CodLote = " + orden.getCodLote();
		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
		ResultSet rs = pst.executeQuery(query);
		Bloque buscado = new Bloque(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
				(DatosContainer) rs.getObject(6));
		pst.close();
		rs.close();
		try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buscado;
	}

	public AlmacenMMPP getAlmacenMMPP(String id) throws SQLException, ClassNotFoundException {
		conectar();
		String query = "SELECT * FROM company.almacenMMPP WHERE idAlmacenMateriasPrimas = " + id;
		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
		ResultSet rs = pst.executeQuery(query);
		AlmacenMMPP buscado = new AlmacenMMPP(rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4),
				rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10),
				rs.getDouble(11), rs.getDouble(12), rs.getDouble(13), rs.getDouble(14), rs.getDouble(15));
		pst.close();
		rs.close();
		try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buscado;

	}
	public void insercionBloqueFabrica (Bloque bloqueFabrica) throws SQLException, ClassNotFoundException{
		conectar();
	    String query = "INSERT INTO company.bloqueFabrica (hashCode, hashPrevio, tipoBloque, numBloque, codLote, datos) VALUES (?, ?, ?, ?, ?);"; 
	    PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
	    pst.setString(1, bloqueFabrica.getHashPrevio());
	    pst.setInt(2, bloqueFabrica.getTipoBloque());
	    pst.setInt(3, bloqueFabrica.getNumBloque());
	    pst.setInt(4, bloqueFabrica.getCodLote());
	    pst.setObject(5, bloqueFabrica.getDatos());
	    pst.executeUpdate();
	    pst.close();
	    try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void insercionAgricultor (Agricultor agricultor) throws SQLException, ClassNotFoundException{
		conectar();
	    String query = "INSERT INTO company.agricultor (cif, nombre, direccion, cifCooperativa) VALUES (?, ?, ?, ?);"; 
	    PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
	    pst.setString(1, agricultor.getCif());
	    pst.setString(2, agricultor.getNombre());
	    pst.setString(3, agricultor.getDireccion());
	    pst.setInt(4, agricultor.getCifCooperativa());
	    pst.executeUpdate();
	    pst.close();
	    try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
  
	public void insercionCooperativa (Cooperativa cooperativa) throws SQLException, ClassNotFoundException{
    	conectar();
	    String query = "INSERT INTO company.cooperativa (cif, nombre, direccion) VALUES (?, ?, ?);"; 
	    PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
	    pst.setString(1, cooperativa.getCif());
	    pst.setString(2, cooperativa.getNombre());
	    pst.setString(3, cooperativa.getDireccion());
	    pst.executeUpdate();
	    pst.close();
	    try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	public void insercionActor (Actor actor) throws SQLException, ClassNotFoundException{
		conectar();
	    String query = "INSERT INTO company.actor (nombreUsuario, passwordSalt, email, usuarioPrevio, tipoActor) VALUES (?, ?, ?, ?, ?, ?);"; 
	    PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
	    pst.setString(1, actor.getNombreUsuario());
	    pst.setString(2, actor.getpasswordSalt());
	    pst.setString(3, actor.getEmail());
	    pst.setObject(4, actor.getUsuarioPrevio());
	    pst.setInt(5, actor.getTipoActor());
	    pst.executeUpdate();
	    pst.close();
	    try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
       
	public Agricultor getAgricultor(String cif) throws SQLException, ClassNotFoundException{
    	conectar();  
    	String query = "SELECT * FROM company.agricultor WHERE agricultor.cif = " + cif;
    	PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
    	ResultSet rs = pst.executeQuery(query);
    	Agricultor buscado = new Agricultor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
    	pst.close();
    	rs.close();
    	try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return buscado;
    }
  
	private Bloque getBloqueFabrica(int numBloque) throws SQLException, ClassNotFoundException{
    	conectar();  
    	String query = "SELECT * FROM company.bloqueFabrica WHERE bloqueFabrica.numBloque = " + numBloque;
    	PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
    	ResultSet rs = pst.executeQuery(query);
    	Bloque buscado = new Bloque(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), (DatosContainer) rs.getObject(5));
    	pst.close();
    	rs.close();
    	try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return buscado;
    }
    
	public Actor getActor(String nombreUsuario) throws SQLException, ClassNotFoundException{
    	conectar();
    	String query = "SELECT * FROM company.actor WHERE actor.nombreUsuario = " + nombreUsuario;
    	PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
    	ResultSet rs = pst.executeQuery(query);
    	Actor buscado = new Actor(rs.getString(1), rs.getString(2), rs.getString(3), (Actor) rs.getObject(4), rs.getInt(5));
    	pst.close();
    	rs.close();
    	try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return buscado;
    }
    
	public Cooperativa getCooperativa(String cif) throws SQLException, ClassNotFoundException{
    	conectar();
    	String query = "SELECT * FROM company.actor WHERE cooperativa.cif = " + cif;
    	PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
    	ResultSet rs = pst.executeQuery(query);
    	Cooperativa buscado = new Cooperativa(rs.getString(1), rs.getString(2), rs.getString(3));
    	pst.close();
    	rs.close();
    	try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return buscado;
    }
    /**
     * Obtiene el bloque de tipo sensor buscado
     * @param tipo de bloque y numero 
     * @return bloque 
     */
	public Bloque getBloqueSensor (int tipoBloque, int numBloque) throws SQLException, ClassNotFoundException{
    	conectar();
    	String query = "SELECT * FROM company.bloqueSensor WHERE tipoBloque = " + tipoBloque + " AND numBloque = " + numBloque + ";";
    	PreparedStatement pst = conn.prepareStatement(query);
    	ResultSet rs = pst.executeQuery(query);
    	Bloque buscado = new Bloque(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), (DatosContainer) rs.getObject(5));
    	pst.close();
	rs.close();
    	try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return buscado;
    }
    
	public Lote getLote (int code) throws SQLException, ClassNotFoundException {
    	conectar();
    	String query = "SELECT * FROM company.lote WHERE code  = " + code + ";";
    	PreparedStatement pst = conn.prepareStatement(query);
    	ResultSet rs = pst.executeQuery(query);
    	Lote buscado = new Lote(rs.getInt(1), rs.getString(2));
    	pst.close();
	rs.close();
    	try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return buscado;
    }
	  /** 
     *Obtiene el transportista con el CIF buscado 
     *@param CIF del transportisa
     *@return transportista
     */
   private Transportista getTransportista (String transportista_cif) throws SQLException{
   	String query = "SELECT * FROM company.transportista WHERE transportista.transportista_cif = " + transportista_cif + ";"; 
   	PreparedStatement pst = conn.prepareStatement(query);
   	ResultSet rs = pst.executeQuery(query);
   	Transportista buscado = new Transportista(rs.getString(1), rs.getString(2));
   	pst.close();
	rs.close();
	try {
		exit();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return buscado;
   }
   /**
	 * @param bloque
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void insertarBloqueSensor (Bloque sensor) throws SQLException, ClassNotFoundException {
	    conectar();
	    String query = "INSERT INTO company.bloqueSensor (hashPrevio, tipoBloque, numBloque, codLote, datos) VALUES (?, ?, ?, ?, ?);"; 
	    PreparedStatement pst = conn.prepareStatement(query);
	    pst.setString(1, sensor.getHashPrevio());
	    pst.setInt(2, sensor.getTipoBloque());
	    pst.setInt(3, sensor.getNumBloque());
	    pst.setInt(4, sensor.getCodLote());
	    pst.setObject(5, sensor.getDatos());
	    pst.executeUpdate();
	    pst.close();
	    try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
	public void insertarLote (Lote lote) throws SQLException, ClassNotFoundException{
	    	conectar();
	    	String query = "INSERT INTO company.lote (code, tipo) VALUES (?, ?);";
	    	PreparedStatement pst = conn.prepareStatement(query);
	    	pst.setInt(1, lote.getCode());
	    	pst.setString(2, lote.getTipo());
	    	pst.executeUpdate();
	 	    pst.close();
	    	conn.close();try {
				exit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
	 /**
	   * siendo transportista una tabla de company con dos columnas empresa, CIF 
	   * @param transportista
	   * @throws SQLException
	   * @throws ClassNotFoundException
	   */
	/**
	   * siendo transportista una tabla de company con dos columnas empresa, CIF 
	   * @param transportista
	   * @throws SQLException
	   * @throws ClassNotFoundException
	   */
	    private void insertarTransportista (Transportista transportista) throws SQLException, ClassNotFoundException{
	    	    conectar();
		    String query = "INSERT INTO company.transportista (transportista_cif, empresa_transporte) VALUES (?, ?);"; 
		    PreparedStatement pst = conn.prepareStatement(query);
		    pst.setString(1, transportista.getTransportistaCif ());
		    pst.setString(2, transportista.getEmpresaTransporte ());
		    pst.executeUpdate();
		    pst.close();
		    try {
				exit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }


        private void insertarAlmacenLotes(AlmacenLotes almacen) throws SQLException, ClassNotFoundException {
	    conectar();
	    String query = "INSERT INTO company.almacenLotes (idAlmacenLotes, ocupado, maxCapacidad, lotes) VALUES (?, ?, ?, ?);";
	    PreparedStatement pst = conn.prepareStatement(query);
	    pst.setInt(1, almacen.getIdAlmacenLotes());
	    pst.setInt(2, almacen.getOcupado());
	    pst.setInt(3, almacen.getMaxCapacidad());
	    pst.setBlob(4, almacen.getLotes());
	    pst.executeUpdate();
	    pst.close();
	    try {
			exit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
           }
       }

       
	
     private AlmacenLotes consultarAlmacenLotes (int idAlmacenLotes) throws SQLException, ClassNotFoundException {
	conectar();
	String query = "SELECT * FROM company.almacenLotes WHERE almacenLotes.idAlmacenLotes =" + idAlmacenLotes + ";";	
	PreparedStatement pst = conn.prepareStatement(query);
   	ResultSet rs = pst.executeQuery(query);
   	AlmacenLotes buscado = new AlmacenLotes(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getBlob(4));
   	pst.close();
	rs.close();
	try {
		exit();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return buscado;	
    }
	
}





