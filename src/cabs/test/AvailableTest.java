package cabs.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import cabs.ICabRoute;
import cabs.CabRoute;
import cabs.CabFullException;
import cabs.Pos;
import cabs.Request;
import cabs.AvailableCabCheck;

public class AvailableTest {

	@Test
	public void test() throws CabFullException {
		ICabRoute a = new CabRoute(4, new Pos(1, 1));
		ICabRoute b = new CabRoute(2, new Pos(2, 2));
		Request r = new Request(3, new Pos(0,0), new Pos(10,10));
		Predicate<ICabRoute> pred = new AvailableCabCheck(r);
		assertTrue(pred.test(a));
		assertFalse(pred.test(b));
		a.addPassenger("A");
		assertFalse(pred.test(a));
	}	
}
