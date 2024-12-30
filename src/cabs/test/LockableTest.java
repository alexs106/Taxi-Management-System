package cabs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cabs.Pos;
import cabs.Lockable;
import cabs.ICab;
import cabs.Cab;
import cabs.CabFullException;

public class LockableTest {

	@Test 
	public void testNolocked() throws CabFullException {
		ICab c = new Cab(2, new Pos(1,2));
		Lockable l = new Lockable(c);
		l.addPassenger("A");
		assertEquals(2, l.getCapacity());
		assertEquals(1, l.getPassengers().size());
		assertTrue(l.getPassengers().contains("A"));
		assertFalse(l.getPassengers().contains("B"));
		assertEquals(1, c.getPassengers().size());
		assertTrue(c.getPassengers().contains("A"));
		assertFalse(c.getPassengers().contains("B"));
	}

	@Test 
	public void testLocked() throws CabFullException {
		ICab c = new Cab(2, new Pos(1,2));
		Lockable l = new Lockable(c);
		l.setLocked(true);
		assertEquals(0, l.getCapacity());
		assertThrows(CabFullException.class, () -> l.addPassenger("A"));
	}
}
