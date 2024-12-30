package cabs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cabs.Pos;
import cabs.MultiCab;
import cabs.ICab;
import cabs.IPos;
import cabs.Cab;
import cabs.CabFullException;

public class MultiCabTest {
	
	@Test 
	public void testCapacity() {
		ICab c1 = new Cab(2, new Pos(1,2));
		ICab c2= new Cab(2, new Pos(1,2));
		MultiCab m = new MultiCab();
		m.addCab(c1);
		m.addCab(c2);
		assertEquals(4, m.getCapacity());
	}

	@Test 
	public void testPos() {
		IPos p = new Pos(3,4);
		ICab c1 = new Cab(2, new Pos(1,2));
		ICab c2= new Cab(2, new Pos(1,2));
		MultiCab m = new MultiCab();
		m.addCab(c1);
		m.addCab(c2);
		m.setPos(p);		
		assertEquals(p, m.getPos());
		assertEquals(p, c1.getPos());
		assertEquals(p, c2.getPos());
	}

	@Test 
	public void testGetPassengers() throws CabFullException {
		ICab c1 = new Cab(2, new Pos(1,2));
		ICab c2= new Cab(2, new Pos(1,2));
		MultiCab m = new MultiCab();
		m.addCab(c1);
		m.addCab(c2);
		c1.addPassenger("A");
		c2.addPassenger("B");
		assertEquals(2, m.getPassengers().size());
		assertTrue(m.getPassengers().contains("A"));
		assertTrue(m.getPassengers().contains("B"));
		assertFalse(m.getPassengers().contains("C"));
	}

	@Test 
	public void testAddPassenger() throws CabFullException {
		ICab c1 = new Cab(1, new Pos(1,2));
		ICab c2= new Cab(1, new Pos(1,2));
		MultiCab m = new MultiCab();
		m.addCab(c1);
		m.addCab(c2);
		m.addPassenger("A");
		m.addPassenger("B");
		assertEquals(2, m.getPassengers().size());
		assertTrue(m.getPassengers().contains("A"));
		assertTrue(m.getPassengers().contains("B"));
		assertTrue(c1.getPassengers().contains("A"));
		assertFalse(c1.getPassengers().contains("B"));
		assertFalse(c2.getPassengers().contains("A"));
		assertTrue(c2.getPassengers().contains("B"));
		assertThrows(CabFullException.class, () -> m.addPassenger("C"));
	}
	
	@Test 
	public void testRemovePassenger() throws CabFullException {
		ICab c1 = new Cab(1, new Pos(1,2));
		ICab c2= new Cab(1, new Pos(1,2));
		MultiCab m = new MultiCab();
		m.addCab(c1);
		m.addCab(c2);
		c1.addPassenger("A");
		c2.addPassenger("B");
		m.removePassenger("A");
		assertFalse(m.getPassengers().contains("A"));
		assertFalse(c1.getPassengers().contains("A"));
		assertTrue(m.getPassengers().contains("B"));
		assertTrue(c2.getPassengers().contains("B"));
		assertFalse(m.getPassengers().contains("C"));
	}
}
