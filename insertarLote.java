    private void insertarLote (Lote lote) throws SQLException, ClassNotFoundException{
    	conectar();
    	String query = "INSERT INTO company.lote (code, tipo) VALUES (?, ?);"
    	PreparedStatement pst = conn.prepareStatement(query);
    	pst.setInt(1, lote.getCode());
    	pst.setString(2, lote.getTipo());
    	pst.executeUpdate();
 	    pst.close();
    	conn.close();
    }
