package cabs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cabs.Route;
import cabs.IRoute;
import cabs.Pos;

public class RouteTest {

	@Test 
	public void testNb() {
		IRoute r = new Route();
		assertEquals(0, r.getNbPos());
		r.appendPos(new Pos(0,0));
		assertEquals(1, r.getNbPos());
	}

	@Test 
	public void testGet() {
		Pos p = new Pos(0,0);
		IRoute r = new Route();
		r.appendPos(p);
		r.appendPos(new Pos(1,1));
		assertEquals(p, r.getFirst());
		assertEquals(2, r.getNbPos());
	}


	@Test 
	public void testRemove() {
		IRoute r = new Route();
		r.appendPos(new Pos(0,0));
		r.appendPos(new Pos(1,1));
		r.removeFirst();
		assertEquals(1, r.getNbPos());
	}

	@Test 
	public void testLength() {
		IRoute r = new Route();
		assertEquals(0, r.getLength());
		r.appendPos(new Pos(0,0));
		assertEquals(0, r.getLength());
		r.appendPos(new Pos(2,0));
		assertEquals(2, r.getLength());
	}
}
