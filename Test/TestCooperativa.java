package beerCompany;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCooperativa {

	@Test
	public void testC () throws InterruptedException {
		Cooperativa cooperativa = new Cooperativa("59897659W", "maltaAndaluza", "avenida de las huertas");
		assertEquals(cooperativa.getCif(), "59897659W");
		assertEquals(cooperativa.getNombre(), "maltaAndaluza");
		assertEquals(cooperativa.getDireccion(), "avenida de las huertas");
		// probamos los setters
		cooperativa.setCif(null);
		cooperativa.setNombre(null);
		cooperativa.setDireccion(null);
		assertNull(cooperativa.getCif());
		assertNull(cooperativa.getNombre());
		assertNull(cooperativa.getDireccion());
		
	}
	

}
