package company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class metodosCompany {
	
	private static Connection conn;
	//No funciona la conexión todavía
	private static void conectar() throws ClassNotFoundException, SQLException {
		String drv = "com.mysql.jdbc.Driver"; 
		Class.forName(drv);

		String serverAddress = ":3306";
		String db = "company";
		String user = "******";
		String pass = "******";
		String url = "jdbc:mysql://dlsiisv.fi.upm.es" + serverAddress + "/" + db;
		conn = DriverManager.getConnection(url, user, pass);
		System.out.println("Conectado a la base de datos!" + "\n");
	}

	private void insertarRetailer (Retailer retailer) throws SQLException, ClassNotFoundException {
		conectar();
	    String query = "INSERT INTO company.retailer (CIF, nombre, direccion) VALUES (?, ?, ?);"; 
	    PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
	    pst.setString(1, retailer.getCIF());
	    pst.setString(2, retailer.getNombre());
	    pst.setString(3, retailer.getDireccion());
	    pst.executeUpdate();
	    pst.close();
	    conn.close();
    }
	
	private void insertarFabrica (Fabrica fabrica) throws SQLException, ClassNotFoundException {
		conectar();
	    String query = "INSERT INTO company.fabrica (CIF,direccion, idAlmacenMaterias, idAlmacenLotes) VALUES (?, ?, ?, ?);"; 
	    PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
	    pst.setString(1, fabrica.getCIF());
	    pst.setString(2, fabrica.getDireccion());
	    pst.setString(3, fabrica.getIdAlmacenMaterias());
	    pst.setString(4, fabrica.getIdAlmacenLotes());
	    pst.executeUpdate();
	    pst.close();
	    conn.close();
    }

	private void insertarBloqueOrden (Bloque orden) throws SQLException, ClassNotFoundException{
		conectar();
		String query = "INSERT INTO company.bloqueOrden (hashPrevio, tipoBloque, numBloque, codLote, datos) VALUES (?, ?, ?, ?, ?);"; 
	    PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
	    pst.setString(1, orden.getHashPrevio());
	    pst.setInt(2, orden.getTipoBloque());
	    pst.setInt(3, orden.getNumBloque());
	    pst.setInt(4, orden.getCodLote());
	    pst.setObject(5, orden.getDatos());
	    pst.executeUpdate();
	    pst.close();
		conn.close();
	}
	
	private Retailer getRetailer (String CIF) throws SQLException{
	    	String query = "SELECT * FROM company.retailer WHERE retailer.CIF = " + CIF; 
	    	PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
	    	ResultSet rs = pst.executeQuery(query);
	    	Retailer buscado = new Retailer(rs.getString(1), rs.getString(2), rs.getString(3));
	    	pst.close();
		rs.close();
		conn.close();
		return buscado;
	    }

	private Fabrica getFabrica (String CIF) throws SQLException{
	    	String query = "SELECT * FROM company.fabrica WHERE fabrica.CIF = " + CIF; 
	    	PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
	    	ResultSet rs = pst.executeQuery(query);
	    	Fabrica buscado = new Fabrica(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
	    	pst.close();
		rs.close();
		conn.close();
		return buscado;
	    }

	private Bloque getBloqueOrden (Bloque orden) throws SQLException, ClassNotFoundException{
		conectar();
		String query = "SELECT * FROM company.bloqueOrden WHERE bloqueOrden.CodLote = " + orden.getCodLote(); 
    		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
    		ResultSet rs = pst.executeQuery(query);
    		Bloque buscado = new Bloque(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), (DatosContainer) rs.getObject(5));
    		pst.close();
    		rs.close();
    		conn.close();
    		return buscado;
	}

	private void insertarAlMMPP(AlmacenMMPP almacen) throws SQLException, ClassNotFoundException {
		conectar();
	    String query = "INSERT INTO company.almacenMMPP (id, maxcapacidad, maxmaltaPilsner, maxmaltaCaramelo, maxmaltaBasePalida, maxmaltaCrystal, maxmaltaMunich, maxcebadaTostada, maxmaltaNegra, maxmaltaChocolate, maxlupuloPerle, maxlupuloCentennial, capacidad, maltaPilsner, maltaCaramelo, maltaBasePalida, maltaMunich, maltaNegra , maltaCrystal, maltaChocolate ,cebadaTostada , lupuloPerle, lupuloTettnanger,  lupuloCentennial,  levaduraAle,  levaduraLager) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);"; 
	    PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
	    
	    pst.setString(1, almacen.getId());
	    pst.setInt(2, almacen.getMaxcapacidad());
	    pst.setDouble(3, almacen.getMaxmaltaPilsner());
	    pst.setDouble(4, almacen.getMaxmaltaCaramelo());
	    pst.setDouble(5, almacen.getMaxmaltaBasePalida());
	    pst.setDouble(6, almacen.getMaxmaltaCrystal());
	    pst.setDouble(7, almacen.getMaxmaltaMunich());
	    pst.setDouble(8, almacen.getMaxcebadaTostada());
	    pst.setDouble(9, almacen.getMaxmaltaNegra());
	    pst.setDouble(10, almacen.getMaxmaltaChocolate());
	    pst.setDouble(11, almacen.getMaxlupuloPerle());
	    pst.setDouble(12, almacen.getMaxlupuloCentennial());
	    pst.setInt(13, almacen.getCapacidad());
	    pst.setDouble(14, almacen.getMaltaPilsner());
	    pst.setDouble(15, almacen.getMaltaCaramelo());
	    pst.setDouble(16, almacen.getMaltaBasePalida());
	    pst.setDouble(17, almacen.getMaltaMunich());
	    pst.setDouble(18, almacen.getMaltaNegra());
	    pst.setDouble(19, almacen.getMaltaCrystal());
	    pst.setDouble(20, almacen.getMaltaChocolate());
	    pst.setDouble(21, almacen.getCebadaTostada());
	    pst.setDouble(22, almacen.getLupuloPerle());
	    pst.setDouble(23, almacen.getLupuloTettnanger());
	    pst.setDouble(24, almacen.getLupuloCentennial());
	    pst.setDouble(25, almacen.getLevaduraAle());
	    pst.setDouble(26, almacen.getLevaduraLager());
	    

	    pst.executeUpdate();
	    pst.close();
	    conn.close();
    }
	
	private AlmacenMMPP  getAlmacenMMPP(String id) throws SQLException, ClassNotFoundException {
		conectar();
		String query = "SELECT * FROM company.almacenMMPP WHERE almacenMMPP.id = " + id; 
    		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
    		ResultSet rs = pst.executeQuery(query);
    		AlmacenMMPP buscado = new AlmacenMMPP(rs.getString(1), rs.getInt(13), rs.getDouble(14), rs.getDouble(15), rs.getDouble(16),rs.getDouble(17),rs.getDouble(18),rs.getDouble(19),rs.getDouble(20),
    				rs.getDouble(21),rs.getDouble(22),rs.getDouble(23),rs.getDouble(24), rs.getDouble(25), rs.getDouble(26));
    		pst.close();
    		rs.close();
    		conn.close();
    		return buscado;
		
	}
	
}





