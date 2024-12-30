package cabs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cabs.Pos;
import cabs.StatePos;
import cabs.ICabRoute;
import cabs.CabRoute;

public class StatePosTest {

	@Test
	public void testAdd() {
		StatePos s = new StatePos();
		Pos p = new Pos(3,4);
		ICabRoute c = new CabRoute(1, p);
		s.addCab(c);
		assertEquals(c, s.cabAtPos(p));
	}
	
	@Test 
	public void testChangePos() {
		StatePos s = new StatePos();
		Pos p1 = new Pos(1,2);
		Pos p2 = new Pos(3,4);
		ICabRoute c = new CabRoute(1, p1);
		s.addCab(c);
		s.handleChangePos(c, p2);
		assertNull(s.cabAtPos(p1));
		assertEquals(c, s.cabAtPos(p2));
		assertEquals(p2, c.getPos());
	}

	@Test 
	public void testEnter() {
		StatePos s = new StatePos();
		ICabRoute c = new CabRoute(1, new Pos(1,2));
		s.addCab(c);
		s.handleEnter(c, "A");
		assertEquals(1, c.getPassengers().size());
		assertTrue(c.getPassengers().contains("A"));
		assertFalse(c.getPassengers().contains("B"));
	}
}
