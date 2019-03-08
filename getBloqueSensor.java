    /**
     * Obtiene el bloque de tipo sensor buscado
     * @param tipo de bloque y numero 
     * @return bloque 
     */
    private Bloque getBloqueSensor (int tipoBloque, int numBloque) throws SQLException, ClassNotFoundException{
    	conectar();
    	String query = "SELECT * FROM company.bloqueSensor WHERE tipoBloque = " + tipoBloque + " AND numBloque = " + numBloque + ";");
    	PreparedStatement pst = conn.prepareStatement(query);
    	ResultSet rs = pst.executeQuery(query);
    	Bloque buscado = new Bloque(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getObject(5));
    	pst.close();
		rs.close();
    	conn.close();
    	return buscado;
    }
