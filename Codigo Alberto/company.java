import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class company {

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

    private static void crearBD() throws Exception {
        PreparedStatement pst = conn.prepareStatement("DROP SCHEMA company CASCADE;");
        pst.executeUpdate();
        PreparedStatement pst100 = conn.prepareStatement("CREATE SCHEMA company;");
        pst100.executeUpdate();
        System.out.println("¡Base de datos Creada!");

        //creacion de las tablas
        PreparedStatement pst1 = conn.prepareStatement(
                "CREATE TABLE company.transportista (" +
                        "transportista_cif VARCHAR(45) NOT NULL ," +
                        "empresa_transporte VARCHAR(45) NOT NULL, " +
                        "PRIMARY KEY (transportista_cif)) ;"
        );
        pst1.executeUpdate();

        PreparedStatement pst2 = conn.prepareStatement(
                "CREATE TABLE company.almacenMateriasPrimas (" +
                        "idAlmacenMateriasPrimas INT NOT NULL, " +
                        "capacidad FLOAT NULL, " +
                        "maltaPilsner FLOAT NULL, " +
                        "maltaCaramelo FLOAT NULL, " +
                        "maltaBasePalida FLOAT NULL, " +
                        "maltaMunich FLOAT NULL, " +
                        "maltaNegra FLOAT NULL, " +
                        "maltaCrystal FLOAT NULL, " +
                        "maltaChocolate FLOAT NULL, " +
                        "cebadaTostada FLOAT NULL, " +
                        "lupuloPerle FLOAT NULL, " +
                        "lupuloTettnanger FLOAT NULL, " +
                        "lupuloCentennial FLOAT NULL, " +
                        "levaduraAle FLOAT NULL, " +
                        "levaduraLager FLOAT NULL, " +
                        "maxCapacidad FLOAT NULL, " +
                        "maxMaltaPilsner FLOAT NULL, " +
                        "maxMaltaCaramelo FLOAT NULL, " +
                        "maxMaltaBasePalida FLOAT NULL, " +
                        "maxMaltaMunich FLOAT NULL, " +
                        "maxMaltaNegra FLOAT NULL, " +
                        "maxMaltaCrystal FLOAT NULL, " +
                        "maxMaltaChocolate FLOAT NULL, " +
                        "maxCebadaTostada FLOAT NULL, " +
                        "maxLupuloPerle FLOAT NULL, " +
                        "maxLupuloTettnanger FLOAT NULL, " +
                        "maxLupuloCentennial FLOAT NULL, " +
                        "maxLevaduraAle FLOAT NULL, " +
                        "maxLevaduraLager FLOAT NULL, " +
                        "PRIMARY KEY (idalmacenMateriasPrimas));"
        );
        pst2.executeUpdate();

        PreparedStatement pst3 = conn.prepareStatement(
                "CREATE TABLE company.lote (" +
                        "idLote INT NOT NULL ," +
                        "tipo VARCHAR(45) NOT NULL, " +
                        "pedido VARCHAR(45) NOT NULL ," +
                        "fecha_inicio TIMESTAMP NOT NULL ," +
                        "fecha_final TIMESTAMP NOT NULL, " +
                        "PRIMARY KEY (idLote));"
        );
        pst3.executeUpdate();

        PreparedStatement pst4 = conn.prepareStatement(
                "CREATE TABLE company.almacenLotes (" +
                        "idAlmacenLotes INT NOT NULL ," +
                        "ocupado INT NOT NULL, " +
                        "maxCapacidad INT NOT NULL ," +
                        "lotes SERIAL NOT NULL, " +
                        "PRIMARY KEY (idAlmacenLotes));"
        );
        pst4.executeUpdate();

        PreparedStatement pst5 = conn.prepareStatement(
                "CREATE TABLE company.fabrica (" +
                        "fabrica_cif VARCHAR(45) NOT NULL ," +
                        "direccion VARCHAR(250) NOT NULL, " +
                        "idAlmacenMaterias INT NOT NULL, " +
                        "idAlmacenLotes INT NOT NULL, " +
                        "PRIMARY KEY (fabrica_cif), " +
                        "CONSTRAINT fk_fabrica_1 " +
                        "  FOREIGN KEY (idAlmacenMaterias) " +
                        "  REFERENCES company.almacenMateriasPrimas(idAlmacenMateriasPrimas) " +
                        "  ON DELETE NO ACTION " +
                        "  ON UPDATE NO ACTION, " +
                        "CONSTRAINT fk_fabrica_2 " +
                        "  FOREIGN KEY (idAlmacenLotes) " +
                        "  REFERENCES company.almacenLotes(idAlmacenLotes) " +
                        "  ON DELETE NO ACTION " +
                        "  ON UPDATE NO ACTION " +
                        ");"
        );
        pst5.executeUpdate();

        PreparedStatement pst6 = conn.prepareStatement(
                "CREATE TABLE company.bloque (" +
                        "hashPrevio VARCHAR(250) NOT NULL ," +
                        "tipoBloque INT NOT NULL, " +
                        "numBloque INT NOT NULL ," +
                        "codLote INT NOT NULL, " +
                        "datos SERIAL NOT NULL, " +
                        "PRIMARY KEY (hashPrevio))"
        );
        pst6.executeUpdate();

        PreparedStatement pst7 = conn.prepareStatement(
                "CREATE TABLE company.agricultor (" +
                        "cif VARCHAR(45) NOT NULL ," +
                        "nombre VARCHAR(45) NOT NULL, " +
                        "direccion VARCHAR(250) NOT NULL ," +
                        "cifCooperativa INT NOT NULL, " +
                        "PRIMARY KEY (cif));"
        );
        pst7.executeUpdate();

        PreparedStatement pst8 = conn.prepareStatement(
                "CREATE TABLE company.cooperativa (" +
                        "cif VARCHAR(45) NOT NULL ," +
                        "nombre VARCHAR(45) NOT NULL, " +
                        "direccion VARCHAR(250) NOT NULL ," +
                        "PRIMARY KEY (cif));"
        );
        pst8.executeUpdate();

        PreparedStatement pst9 = conn.prepareStatement(
                "CREATE TABLE company.retailer (" +
                        "cif VARCHAR(45) NOT NULL ," +
                        "nombre VARCHAR(45) NOT NULL, " +
                        "direccion VARCHAR(250) NOT NULL ," +
                        "PRIMARY KEY (cif));"
        );
        pst9.executeUpdate();

        PreparedStatement pst10 = conn.prepareStatement(
                "CREATE TABLE company.actor (" +
                        "nombreUsuario VARCHAR(45) NOT NULL ," +
                        "passwdPlana VARCHAR(45)  NULL, " +
                        "passwdSalt VARCHAR(45) NOT NULL ," +
                        "email VARCHAR(250)  NULL, " +
                        "usuarioPrevio SERIAL NULL, " +
                        "tipoActor INT  NULL, " +
                        "PRIMARY KEY (nombreUsuario))"
        );
        pst10.executeUpdate();
    }


    public static void insercionActor(Actor actor) throws SQLException, ClassNotFoundException {
        conectar();
        String query = "INSERT INTO company.actor (nombreUsuario, passwordPlana, passwordSalt, email, usuarioPrevio, tipoActor) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
        pst.setString(1, actor.getNombreUsuario());
        pst.setString(2, actor.getpasswordSalt());
        pst.setString(3, actor.getEmail());
        pst.setObject(4, actor.getUsuarioPrevio());
        pst.setInt(5, actor.getTipoActor());
        pst.executeUpdate();
        pst.close();
    }

    public Actor getActor(String nombreUsuario) throws SQLException, ClassNotFoundException {
        if(nombreUsuario!= null) {
            conectar();
            Actor actor = new Actor();
            String query = "SELECT * FROM company.actor WHERE actor.nombreUsuario = " + nombreUsuario;
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery(query);
            rs.next();
            ActorBBDD buscado = new ActorBBDD(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            pst.close();
            rs.close();
            actor.setEmail(buscado.getEmail());
            actor.setNombreUsuario(buscado.getNombreUsuario());
            actor.setPasswordPlana(buscado.getPasswordPlana());
            actor.setPasswordSalt(buscado.getPasswordSalt());
            actor.setTipoActor(buscado.getTipoActor());
            actor.setUsuarioPrevio(getActor(buscado.getUsuarioPrevio()));
            return actor;
        }
        else return null;
    }

    public Actor getActores() throws SQLException, ClassNotFoundException {
        conectar();
        Actor actor = new Actor();
        String query = "SELECT * FROM company.actor ";
        PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery(query);
        rs.next();
        ActorBBDD buscado = new ActorBBDD(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
        pst.close();
        rs.close();
        actor.setEmail(buscado.getEmail());
        actor.setNombreUsuario(buscado.getNombreUsuario());
        actor.setPasswordPlana(buscado.getPasswordPlana());
        actor.setPasswordSalt(buscado.getPasswordSalt());
        actor.setTipoActor(buscado.getTipoActor());
        actor.setUsuarioPrevio(getActor(buscado.getUsuarioPrevio()));
        return actor;
    }

    private void insertarRetailer(Retailer retailer) throws SQLException, ClassNotFoundException {
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

    private void insertarFabrica(Fabrica fabrica) throws SQLException, ClassNotFoundException {
        conectar();
        String query = "INSERT INTO company.fabrica (fabrica_cif, direccion, idAlmacenMaterias, idAlmacenLotes) VALUES (?, ?, ?, ?);";
        PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
        pst.setString(1, fabrica.getCIF());
        pst.setString(2, fabrica.getDireccion());
        pst.setString(3, fabrica.getIdAlmacenMaterias());
        pst.setString(4, fabrica.getIdAlmacenLotes());
        pst.executeUpdate();
        pst.close();
        conn.close();
    }

    private void insertarBloqueOrden(Bloque orden) throws SQLException, ClassNotFoundException {
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
        conn.close();
    }

    private static void insertarAlMMPP(AlmacenMMPP almacen) throws SQLException, ClassNotFoundException {
        conectar();
        String query = "INSERT INTO company.almacenMateriasPrimas (idAlmacenMateriasPrimas, capacidad, maltaPilsner, maltaCaramelo, "
                + "maltaBasePalida, maltaMunich, maltaNegra , maltaCrystal, maltaChocolate ,cebadaTostada , lupuloPerle, lupuloTettnanger,  lupuloCentennial,  "
                + "levaduraAle,  levaduraLager,  maxcapacidad, maxmaltaPilsner, maxmaltaCaramelo, maxmaltaBasePalida, "
                + "maxmaltaMunich, maxmaltaNegra, maxmaltaCrystal, maxmaltaChocolate, maxcebadaTostada, maxlupuloPerle, maxlupuloTettnanger,maxlupuloCentennial,"
                + " maxlevaduraAle, maxlevaduraLager ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);

        pst.setInt(1, almacen.getId());
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
        conn.close();
    }

    private Retailer getRetailer(String CIF) throws SQLException {
        String query = "SELECT * FROM company.retailer WHERE retailer.CIF = " + CIF;
        PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery(query);
        Retailer buscado = new Retailer(rs.getString(1), rs.getString(2), rs.getString(3));
        pst.close();
        rs.close();
        conn.close();
        return buscado;
    }

    private Fabrica getFabrica(String CIF) throws SQLException {
        String query = "SELECT * FROM company.fabrica WHERE fabrica.fabrica_cif = " + CIF;
        PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery(query);
        Fabrica buscado = new Fabrica(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
        pst.close();
        rs.close();
        conn.close();
        return buscado;
    }

    private Bloque getBloqueOrden(Bloque orden) throws SQLException, ClassNotFoundException {
        conectar();
        String query = "SELECT * FROM company.bloqueOrden WHERE bloqueOrden.CodLote = " + orden.getCodLote();
        PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery(query);
        Bloque buscado = new Bloque(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
                (DatosContainer) rs.getObject(6));
        pst.close();
        rs.close();
        conn.close();
        return buscado;
    }

    private static AlmacenMMPP getAlmacenMMPP(int id) throws SQLException, ClassNotFoundException {
        conectar();
        String query = "SELECT * FROM company.almacenMateriasPrimas WHERE almacenMateriasPrimas.idAlmacenMateriasPrimas = " + id;
        Statement pst = conn.createStatement();
        ResultSet rs = pst.executeQuery(query);
        while (rs.next()) {
            AlmacenMMPP buscado = new AlmacenMMPP(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4),
                    rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10),
                    rs.getDouble(11), rs.getDouble(12), rs.getDouble(13), rs.getDouble(14), rs.getDouble(15));
            pst.close();
            rs.close();
            conn.close();
            return buscado;
        }
        return null;

    }

    private static void pruebas() {
        AlmacenMMPP almacenPruebas = new AlmacenMMPP();
        try {
            conectar();
            insertarAlMMPP(almacenPruebas);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        try {
            conectar();
            crearBD();
            //pruebas();
            //conectar();
            Actor actor = new Actor("root", "root");
            insercionActor(actor);
            //System.out.println(getAlmacenMMPP(89).getMaxmaltaCrystal());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}