package beerCompany;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestRetailer {

	@Test
	public void testR () throws InterruptedException {
		Retailer retailer = new Retailer("11111111R", "amazon", "CALLE RAMIREZ DE PRADO");
		assertEquals(retailer.getCIF(), "11111111R");
		assertEquals(retailer.getNombre(), "amazon");
		assertEquals(retailer.getDireccion(), "CALLE RAMIREZ DE PRADO");
		// probamos tambien los setters
		retailer.setCIF(null);
		retailer.setNombre("carrefour");
		retailer.setDireccion(null);
		assertNull(retailer.getCIF());
		assertEquals(retailer.getNombre(), "carrefour");
		assertNull(retailer.getDireccion());
		
	}
}
