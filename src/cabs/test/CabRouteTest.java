package cabs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cabs.Pos;
import cabs.IPos;
import cabs.ICabRoute;
import cabs.CabRoute;

public class CabRouteTest {

	@Test 
	public void test() {
		IPos p = new Pos(1,1);
		ICabRoute c = new CabRoute(2, new Pos(0,0));
		c.getRoute().appendPos(p);
		c.getRoute().appendPos(new Pos(2,2));
		assertEquals(2, c.getRoute().getNbPos());
		c.setPos(p);
		assertEquals(p, c.getPos());
		assertEquals(1, c.getRoute().getNbPos());
	}
}
