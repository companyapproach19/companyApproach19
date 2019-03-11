package beerCompany;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAgricultor {
	@Test
	public void testA() throws InterruptedException {
		Agricultor agricultor= new Agricultor("53939470P", "felipe", "avenida de europa", 11111111);
		assertEquals(agricultor.getCif(), "53939470P");
		assertEquals(agricultor.getNombre(), "felipe");
		assertEquals(agricultor.getDireccion(), "avenida de europa");
		assertEquals(agricultor.getCifCooperativa(), 11111111);
		// probamos los setters
		agricultor.setCif(null);
		agricultor.setNombre("juan");
		agricultor.setDireccion(null);
		agricultor.setCifCooperativa(0);
		assertNull(agricultor.getCif());
		assertEquals(agricultor.getNombre(), "juan");
		assertNull(agricultor.getDireccion());
		assertEquals(agricultor.getCifCooperativa(), 0);
		
	}

}
