package cabs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cabs.Pos;
import cabs.IPos;
import cabs.ICab;
import cabs.Cab;
import cabs.CabFullException;

public class CabTest {

	@Test 
	public void testException() {
		assertThrows(CabFullException.class, () -> { throw new CabFullException(); });
	}

	@Test 
	public void testConstruct() {		
		IPos p = new Pos(1, 2);
		ICab c = new Cab(2, p);
		assertEquals(2, c.getCapacity());
		assertEquals(p, c.getPos());
	}

	@Test 
	public void testSetPos() {		
		IPos p = new Pos(3, 4);
		ICab c = new Cab(2, new Pos(1,2));
		c.setPos(p);
		assertEquals(p, c.getPos());
	}

	@Test 
	public void testAddPassenger() throws CabFullException {		
		ICab c = new Cab(2, new Pos(1,2));
		c.addPassenger("A");
		c.addPassenger("B");
		assertEquals(2, c.getPassengers().size());
		assertTrue(c.getPassengers().contains("A"));
		assertTrue(c.getPassengers().contains("B"));
		assertFalse(c.getPassengers().contains("C"));
		assertThrows(CabFullException.class, () -> c.addPassenger("Z"));
	}
	
	@Test 
	public void testRemovePassenger() throws CabFullException {		
		ICab c = new Cab(2, new Pos(1,2));
		c.addPassenger("A");
		c.addPassenger("B");
		c.removePassenger("A");
		assertEquals(1, c.getPassengers().size());
		assertFalse(c.getPassengers().contains("A"));
		assertTrue(c.getPassengers().contains("B"));
		assertFalse(c.getPassengers().contains("C"));
	}
}
