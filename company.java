package beerCompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class company {

    private static Connection conn;

/*    private String dbUrl = "jdbc:postgresql://ec2-54-197-232-203.compute-1.amazonaws.com:5432/da8thb0c81jj6n?user=voamftsogizhrl&password=b92c40a06c23bf20ef80f4270ebf62bd464e9432d65e38458e047b7597bd5446&sslmode=require";
    private static String dbUrl= System.getenv("dburl");
    private static Connection connection= null;
    private static void conectar(){
        try {
            connection= DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Conectado a la base de datos!"+ "\n");
    }*/

    private static void conectar() throws ClassNotFoundException, SQLException {
        String drv = "com.mysql.cj.jdbc.Driver";
        Class.forName(drv);
        String serverAddress = "localhost:3306";
        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://"+serverAddress;
        conn = DriverManager.getConnection(url, user, pass);
        System.out.println("Conectado a la base de datos!" + "\n");
    }
    private  void exit() throws Exception {
        //cierre de la conexion
        if (conn!=null) this.conn.close();
        System.out.println("Saliendo.. ¡hasta otra!");
        System.exit(0);
    }

    private static void crearBD()   throws Exception {
        PreparedStatement pst = conn.prepareStatement("CREATE SCHEMA `company`;");
        pst.executeUpdate();
        System.out.println("¡Base de datos Creada!");

        //creacion de las tablas
        PreparedStatement pst1 = conn.prepareStatement(
                "CREATE TABLE `company`.`transportista` (" +
                        "`transportista_cif` VARCHAR(45) NOT NULL ," +
                        "`empresa_transporte` VARCHAR(45) NOT NULL, " +
                        "PRIMARY KEY (`transportista_cif`)) ENGINE=InnoDB;"
        );
        pst1.executeUpdate();

        PreparedStatement pst2 = conn.prepareStatement(
                "CREATE TABLE `company`.`almacenMateriasPrimas` (" +
                        "`idAlmacenMateriasPrimas` INT NOT NULL, " +
                        "`capacidad` DOUBLE NULL, " +
                        "`maltaPilsner` DOUBLE NULL, " +
                        "`maltaCaramelo` DOUBLE NULL, " +
                        "`maltaBasePalida` DOUBLE NULL, " +
                        "`maltaMunich` DOUBLE NULL, " +
                        "`maltaNegra` DOUBLE NULL, " +
                        "`maltaCrystal` DOUBLE NULL, " +
                        "`maltaChocolate` DOUBLE NULL, " +
                        "`cebadaTostada` DOUBLE NULL, " +
                        "`lupuloPerle` DOUBLE NULL, " +
                        "`lupuloTettnanger` DOUBLE NULL, " +
                        "`lupuloCentennial` DOUBLE NULL, " +
                        "`levaduraAle` DOUBLE NULL, " +
                        "`levaduraLager` DOUBLE NULL, " +
                        "`maxCapacidad` DOUBLE NULL, " +
                        "`maxMaltaPilsner` DOUBLE NULL, " +
                        "`maxMaltaCaramelo` DOUBLE NULL, " +
                        "`maxMaltaBasePalida` DOUBLE NULL, " +
                        "`maxMaltaMunich` DOUBLE NULL, " +
                        "`maxMaltaNegra` DOUBLE NULL, " +
                        "`maxMaltaCrystal` DOUBLE NULL, " +
                        "`maxMaltaChocolate` DOUBLE NULL, " +
                        "`maxCebadaTostada` DOUBLE NULL, " +
                        "`maxLupuloPerle` DOUBLE NULL, " +
                        "`maxLupuloTettnanger` DOUBLE NULL, " +
                        "`maxLupuloCentennial` DOUBLE NULL, " +
                        "`maxLevaduraAle` DOUBLE NULL, " +
                        "`maxLevaduraLager` DOUBLE NULL, " +
                        "PRIMARY KEY (`idalmacenMateriasPrimas`));"
        );
        pst2.executeUpdate();

        PreparedStatement pst3 = conn.prepareStatement(
                "CREATE TABLE `company`.`lote` (" +
                        "`idLote` INT NOT NULL ," +
                        "`tipo` VARCHAR(45) NOT NULL, " +
                        "`pedido` VARCHAR(45) NOT NULL ," +
                        "`fecha_inicio` DATETIME NOT NULL ," +
                        "`fecha_final` DATETIME NOT NULL, " +
                        "PRIMARY KEY (`idLote`)) ENGINE=InnoDB;"
        );
        pst3.executeUpdate();

        PreparedStatement pst4 = conn.prepareStatement(
                "CREATE TABLE `company`.`almacenLotes` (" +
                        "`idAlmacenLotes` INT NOT NULL ," +
                        "`ocupado` INT NOT NULL, " +
                        "`maxCapacidad` INT NOT NULL ," +
                        "`lotes` BLOB NOT NULL, " +
                        "PRIMARY KEY (`idAlmacenLotes`)) ENGINE=InnoDB;"
        );
        pst4.executeUpdate();

        PreparedStatement pst5 = conn.prepareStatement(
                "CREATE TABLE `company`.`fabrica` (" +
                        "`fabrica_cif` VARCHAR(45) NOT NULL ," +
                        "`direccion` VARCHAR(250) NOT NULL, " +
                        "`idAlmacenMaterias` INT NOT NULL, " +
                        "`idAlmacenLotes` INT NOT NULL, " +
                        "PRIMARY KEY (`fabrica_cif`), " +
                        "CONSTRAINT `fk_fabrica_1` " +
                        "  FOREIGN KEY (`idAlmacenMaterias`) " +
                        "  REFERENCES `company`.`almacenMateriasPrimas`(`idAlmacenMateriasPrimas`) " +
                        "  ON DELETE NO ACTION " +
                        "  ON UPDATE NO ACTION, " +
                        "CONSTRAINT `fk_fabrica_2` " +
                        "  FOREIGN KEY (`idAlmacenLotes`) " +
                        "  REFERENCES `company`.`almacenLotes`(`idAlmacenLotes`) " +
                        "  ON DELETE NO ACTION " +
                        "  ON UPDATE NO ACTION " +
                        ") ENGINE=InnoDB;"
        );
        pst5.executeUpdate();
        
        PreparedStatement pst6 = conn.prepareStatement(
                "CREATE TABLE `company`.`bloque` (" +
                        "`hashPrevio` VARCHAR(250) NOT NULL ," +
                        "`tipoBloque` INT NOT NULL, " +
                        "`numBloque` INT NOT NULL ," +
                        "`codLote` INT NOT NULL, " +
                        "`datos` BLOB NOT NULL, " +
                        "PRIMARY KEY (`hashPrevio`)) ENGINE=InnoDB;"
        );
        pst6.executeUpdate();
        
        PreparedStatement pst7 = conn.prepareStatement(
                "CREATE TABLE `company`.`agricultor` (" +
                        "`cif` VARCHAR(45) NOT NULL ," +
                        "`nombre` VARCHAR(45) NOT NULL, " +
                        "`direccion` VARCHAR(250) NOT NULL ," +
                        "`cifCooperativa` INT NOT NULL, " +
                        "PRIMARY KEY (`cif`)) ENGINE=InnoDB;"
        );
        pst7.executeUpdate();
        
        PreparedStatement pst8 = conn.prepareStatement(
                "CREATE TABLE `company`.`cooperativa` (" +
                		"`cif` VARCHAR(45) NOT NULL ," +
                        "`nombre` VARCHAR(45) NOT NULL, " +
                        "`direccion` VARCHAR(250) NOT NULL ," +
                        "PRIMARY KEY (`cif`)) ENGINE=InnoDB;"
        );
        pst8.executeUpdate();
        
        PreparedStatement pst9 = conn.prepareStatement(
                "CREATE TABLE `company`.`retailer` (" +
                        "`cif` VARCHAR(45) NOT NULL ," +
                        "`nombre` VARCHAR(45) NOT NULL, " +
                        "`direccion` VARCHAR(250) NOT NULL ," +
                        "PRIMARY KEY (`cif`)) ENGINE=InnoDB;"
        );
        pst9.executeUpdate();
        
        PreparedStatement pst10 = conn.prepareStatement(
                "CREATE TABLE `company`.`actor` (" +
                        "`nombreUsuario` VARCHAR(45) NOT NULL ," +
                        "`passwdPlana` VARCHAR(45) NOT NULL, " +
                        "`passwdSalt` VARCHAR(45) NOT NULL ," +
                        "`email` VARCHAR(250) NOT NULL, " +
                        "`usuarioPrevio` BLOB NOT NULL, " +
                        "`tipoActor` INT NOT NULL, " +
                        "PRIMARY KEY (`nombreUsuario`)) ENGINE=InnoDB;"
        );
        pst10.executeUpdate();
    }

        public  void main (String[]args){
            try {
                conectar();
                crearBD();
                exit();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}