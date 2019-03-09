    private Lote getLote (int code) {
    	conectar();
    	String query = "SELECT * FROM company.lote WHERE code  = " + code + ";";
    	PreparedStatement pst = conn.prepareStatement(query);
    	ResultSet rs = pst.executeQuery(query);
    	Lote buscado = new Lote(rs.getInt(1), rs.getString(2));
    	pst.close();
	rs.close();
    	conn.close();
    	return buscado;
    }
