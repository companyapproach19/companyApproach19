package iSoftware;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iSoftware.Principal;
import iSoftware.Lote;

public class testPrincipal {
	@Test
	void test1() {
		Lote lote= new Lote(new Pilsner());
		int result = Principal.moler(lote);
		assertEquals(result, 0);
	}
	@Test
	void test2() {
		int result = Principal.cocinar(new Lote(new Pilsner()));
		assertEquals(result, 0);
	}
	@Test
	void test3() {
		Lote lote = new Lote(new Stout());
		int result = Principal.cocinar(lote);
		assertEquals(result, 0);
	}
	void test4() {
		Lote lote= new Lote(new Stout());
		int result = Principal.moler(lote);
		assertEquals(result, 0);
	}
	
	
	
}
