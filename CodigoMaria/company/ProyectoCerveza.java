
//BloqueFbrica, Actor, Agricultor, Cooperativa

package company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ProyectoCerveza{
	private Connection conn;
	
	private void conectar() throws ClassNotFoundException, SQLException{
		String drv = "com.mysql.jdbc.Driver"; 
		Class.forName(drv);
		String serverAddress = ":3306";
		String db = "company";
		String user = "******";
		String pass = "******";
		String url = "jdbc:mysql://dlsiisv.fi.upm.es" + serverAddress + "/" + db;
		conn = DriverManager.getConnection(url, user, pass);
		System.out.println("!Te has conectado!" + "\n");
	}
	
	private void insercionBloqueFabrica (Bloque bloqueFabrica) throws SQLException, ClassNotFoundException{
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
	    conn.close();
    }
	
	private void insercionAgricultor (Agricultor agricultor) throws SQLException, ClassNotFoundException{
		conectar();
	    String query = "INSERT INTO company.agricultor (cif, nombre, direccion, cifCooperativa) VALUES (?, ?, ?, ?);"; 
	    PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
	    pst.setString(1, agricultor.getCif());
	    pst.setString(2, agricultor.getNombre());
	    pst.setString(3, agricultor.getDireccion());
	    pst.setInt(4, agricultor.getCifCooperativa());
	    pst.executeUpdate();
	    pst.close();
	    conn.close();
    }
  
    private void insercionCooperativa (Cooperativa cooperativa) throws SQLException, ClassNotFoundException{
    	conectar();
	    String query = "INSERT INTO company.cooperativa (cif, nombre, direccion) VALUES (?, ?, ?);"; 
	    PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
	    pst.setString(1, cooperativa.getCif());
	    pst.setString(2, cooperativa.getNombre());
	    pst.setString(3, cooperativa.getDireccion());
	    pst.executeUpdate();
	    pst.close();
	    conn.close();
    }
    
    private void insercionActor (Actor actor) throws SQLException, ClassNotFoundException{
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
	    conn.close();
    }
       
    private Agricultor getAgricultor(String cif) throws SQLException, ClassNotFoundException{
    	conectar();  
    	String query = "SELECT * FROM company.agricultor WHERE agricultor.cif = " + cif;
    	PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
    	ResultSet rs = pst.executeQuery(query);
    	Agricultor buscado = new Agricultor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
    	pst.close();
    	rs.close();
    	conn.close();
    	return buscado;
    }
  
    private Bloque getBloqueFabrica(int tipoBloque) throws SQLException, ClassNotFoundException{
    	conectar();  
    	String query = "SELECT * FROM company.bloqueFabrica WHERE bloqueFabrica.tipoBloque = " + tipoBloque;
    	PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
    	ResultSet rs = pst.executeQuery(query);
    	Bloque buscado = new Bloque(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), (DatosContainer) rs.getObject(5));
    	pst.close();
    	rs.close();
    	conn.close();
    	return buscado;
    }
    
    private Actor getActor(String nombreUsuario) throws SQLException, ClassNotFoundException{
    	conectar();
    	String query = "SELECT * FROM company.actor WHERE actor.nombreUsuario = " + nombreUsuario;
    	PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
    	ResultSet rs = pst.executeQuery(query);
    	Actor buscado = new Actor(rs.getString(1), rs.getString(2), rs.getString(3), (Actor) rs.getObject(4), rs.getInt(5));
    	pst.close();
    	rs.close();
    	conn.close();
    	return buscado;
    }
    
    private Cooperativa getCooperativa(String cif) throws SQLException, ClassNotFoundException{
    	conectar();
    	String query = "SELECT * FROM company.actor WHERE cooperativa.cif = " + cif;
    	PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
    	ResultSet rs = pst.executeQuery(query);
    	Cooperativa buscado = new Cooperativa(rs.getString(1), rs.getString(2), rs.getString(3));
    	pst.close();
    	rs.close();
    	conn.close();
    	return buscado;
    }

}
