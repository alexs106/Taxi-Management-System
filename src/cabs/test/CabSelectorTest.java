package cabs.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

import cabs.ICabRoute;
import cabs.CabRoute;
import cabs.CabSelector;
import cabs.Pos;
import cabs.Request;

public class CabSelectorTest {

	@Test
	public void test1() {
		ICabRoute a = new CabRoute(2, new Pos(1, 1));
		ICabRoute b = new CabRoute(2, new Pos(2, 2));
		Collection<ICabRoute> cabs = new ArrayList<>();
		cabs.add(a);
		cabs.add(b);
		Request r = new Request(2, new Pos(0,0), new Pos(10,10));
		assertEquals(a, CabSelector.findCabRequest(cabs, r));
	}
	
	@Test
	public void test2() {
		ICabRoute a = new CabRoute(2, new Pos(1, 1));
		ICabRoute b = new CabRoute(2, new Pos(2, 2));
		Collection<ICabRoute> cabs = new ArrayList<>();
		cabs.add(a);
		cabs.add(b);
		Request r = new Request(4, new Pos(0,0), new Pos(10,10));
		assertNull(CabSelector.findCabRequest(cabs, r));
	}	
}
