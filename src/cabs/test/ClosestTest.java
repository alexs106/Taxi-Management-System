package cabs.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import cabs.ICabRoute;
import cabs.Pos;
import cabs.Request;
import cabs.CabRoute;
import cabs.ClosestCabComparator;

public class ClosestTest {

	@Test
	public void test() {
		ICabRoute a = new CabRoute(2, new Pos(1, 1));
		ICabRoute b = new CabRoute(2, new Pos(2, 2));
		Request r = new Request(1, new Pos(0,0), new Pos(10,10));
		Comparator<ICabRoute> cmp = new ClosestCabComparator(r);
		assertTrue(cmp.compare(a,b) < 0);
		assertTrue(cmp.compare(a,a) == 0);
		assertTrue(cmp.compare(b,a) > 0);
	}	
}
