package cabs.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import cabs.App;

public class AppTest {

	ByteArrayOutputStream out;

	public AppTest() {
		out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
	}

	private String getOut() {
		System.out.flush();
		return out.toString().replaceAll("\\s+","");
	}
	
	@Test 
	public void test() {
		App.main(new String[] {} );
		assertEquals("8.0,8.0-5.0,5.0", getOut());
	}
}
