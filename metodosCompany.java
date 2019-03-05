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

		String serverAddress = "localhost:3306";
		String db = "company";
		String user = "*******";
		String pass = "*******";
		String url = "http://dlsiisv.fi.upm.es/phpmyadmin/index.php" + serverAddress;
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

public static void main ( String [] args) {
	try {
		conectar();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}





