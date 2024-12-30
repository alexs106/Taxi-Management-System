package cabs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cabs.Pos;
import cabs.State;
import cabs.ICabRoute;
import cabs.CabRoute;
import cabs.CabFullException;

public class StateTest {

	@Test 
	public void testChangePos() {
		State s = new State();
		ICabRoute c = new CabRoute(1, new Pos(1,2));
		Pos p = new Pos(3,4);
		s.addCab(c);
		assertTrue(s.getCabs().contains(c));
		s.handleChangePos(c, p);
		assertEquals(p, c.getPos());
	}

	@Test 
	public void testEnter() {
		State s = new State();
		ICabRoute c = new CabRoute(1, new Pos(1,2));
		s.addCab(c);
		s.handleEnter(c, "A");
		assertEquals(1, c.getPassengers().size());
		assertTrue(c.getPassengers().contains("A"));
		assertFalse(c.getPassengers().contains("B"));
	}

	@Test 
	public void testExit() throws CabFullException {
		State s = new State();
		ICabRoute c = new CabRoute(2, new Pos(1,2));
		s.addCab(c);
		c.addPassenger("A");
		c.addPassenger("B");
		s.handleExit(c, "A");
		assertEquals(1, c.getPassengers().size());
		assertFalse(c.getPassengers().contains("A"));
		assertTrue(c.getPassengers().contains("B"));
	}

	@Test 
	public void testNoCab() {
		State s = new State();
		ICabRoute c = new CabRoute(1, new Pos(1,2));
		s.handleEnter(c, "A");
		assertEquals(0, c.getPassengers().size());
	}
}
