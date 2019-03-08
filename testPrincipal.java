package iSoftware;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iSoftware.Principal;

public class testPrincipal {
	@Test
	void test1() {
		int result = Principal.moler();
		assertEquals(result, 0);
	}
	@Test
	void test2() {
		int result = Principal.cocinar();
		assertEquals(result, 0);
	}
	
	
}
