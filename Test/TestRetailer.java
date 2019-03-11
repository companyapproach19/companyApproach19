package beerCompany;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

class TestRetailer {
	private static Connection conn;

    private static String JDBC_DATABASE_URL = "jdbc:postgresql://ec2-54-197-232-203.compute-1.amazonaws.com:5432/da8thb0c81jj6n?user=voamftsogizhrl&password=b92c40a06c23bf20ef80f4270ebf62bd464e9432d65e38458e047b7597bd5446&sslmode=require";

    private static void conectar() {
        try {
            conn = DriverManager.getConnection(JDBC_DATABASE_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Conectado a la base de datos!" + "\n");
    }

//    private static void conectar() throws ClassNotFoundException, SQLException {
//        String drv = "com.mysql.cj.jdbc.Driver";
//        Class.forName(drv);
//        String serverAddress = "localhost:3306";
//        String user = "root";
//        String pass = "root";
//        String url = "jdbc:mysql://"+serverAddress;
//        conn = DriverManager.getConnection(url, user, pass);
//        System.out.println("Conectado a la base de datos!" + "\n");
//    }
//    private void exit() throws Exception {
//        //cierre de la conexion
//        if (conn!=null) this.conn.close();
//        System.out.println("Saliendo.. ¡hasta otra!");
//        System.exit(0);
//    }
	@Test
	public void testR () {
		Retailer retailerPrueba = new Retailer("11111111R", "amazon", "CALLE RAMIREZ DE PRADO");
		assertEquals(retailerPrueba.getCIF(), "11111111R");
		assertEquals(retailerPrueba.getNombre(), "amazon");
		assertEquals(retailerPrueba.getDireccion(), "CALLE RAMIREZ DE PRADO");
		// probamos tambien los setters
		retailerPrueba.setCIF(null);
		retailerPrueba.setNombre("carrefour");
		retailerPrueba.setDireccion(null);
		assertNull(retailerPrueba.getCIF());
		assertEquals(retailerPrueba.getNombre(), "carrefour");
		assertNull(retailerPrueba.getDireccion());
		try {
            conectar();
            insertarRetailer(retailerPrueba);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	}
