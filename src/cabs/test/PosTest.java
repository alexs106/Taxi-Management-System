package cabs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cabs.Pos;
import cabs.IPos;

public class PosTest {

	@Test 
	public void testGet() {
		IPos p = new Pos(1, 2);
		assertEquals(1, p.getLat());
		assertEquals(2, p.getLng());
	}

	@Test 
	public void testDist() {
		IPos p1 = new Pos(0, 0);
		IPos p2 = new Pos(3, 4);
		assertEquals(5, p1.distance(p2));
	}

	@Test 
	public void testEqual() {
		IPos p1 = new Pos(0, 0);
		IPos p2 = new Pos(0, 0);
		assertEquals(p1, p2);
	}

	@Test 
	public void testString() {
		IPos p = new Pos(1, 2);
		assertEquals("1.0,2.0", p.toString());
	}
}
