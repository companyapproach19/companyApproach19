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
	    conn.close();
    }
