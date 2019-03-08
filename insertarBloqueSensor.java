	/**
	 * @param bloque
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private void insertarBloqueSensor (Bloque sensor) throws SQLException, ClassNotFoundException {
		conectar();
	    String query = "INSERT INTO company.bloqueSensor (hashPrevio, tipoBloque, numBloque, codLote, datos) VALUES (?, ?, ?, ?, ?);"; 
	    PreparedStatement pst = conn.prepareStatement(query);
	    pst.setString(1, sensor.getHashPrevio());
	    pst.setInt(2, sensor.getTipoBloque());
	    pst.setInt(3, sensor.getNumBloque());
	    pst.setInt(4, sensor.getCodLote());
	    pst.setObject(5, sensor.getDatos());
	    pst.executeUpdate();
	    pst.close();
	    conn.close();
    }
