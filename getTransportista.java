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
	conn.close();
	return buscado;
    }
