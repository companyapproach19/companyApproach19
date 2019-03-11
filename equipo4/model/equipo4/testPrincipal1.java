package equipo4;

import static org.junit.Assert.*;

import java.util.Date;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class testPrincipal1 {
	@Test
	void test1() throws InterruptedException {
		Lote lote= new Lote(new Pilsner(), new Date());
		int result = Principal.moler(lote);
		assertEquals(result, 0);
	}
	@Test
	void test2() throws InterruptedException {
		int result = Principal.cocinar(new Lote(new Pilsner(), new Date()));
		assertEquals(result, 0);
	}
	@Test
	void test3() throws InterruptedException {
		Lote lote = new Lote(new Stout(), new Date());
		int result = Principal.cocinar(lote);
		assertEquals(result, 0);
	}
	void test4() throws InterruptedException {
		Lote lote= new Lote(new Stout(), new Date());
		int result = Principal.moler(lote);
		assertEquals(result, 0);
	}
	
	
	
}
