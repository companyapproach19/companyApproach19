  /**
   * siendo transportista una tabla de company con dos columnas empresa, CIF 
   * @param transportista
   * @throws SQLException
   * @throws ClassNotFoundException
   */
    private void insertarTransportista (Transportista transportista) throws SQLException, ClassNotFoundException{
    	conectar();
	    String query = "INSERT INTO company.transportista (empresa, CIF) VALUES (?, ?);"; 
	    PreparedStatement pst = conn.prepareStatement(query);
	    pst.setString(1, transportista.getEmpresa());
	    pst.setString(2, transportista.getCIF());
	    pst.executeUpdate();
	    pst.close();
	    conn.close();
    }
