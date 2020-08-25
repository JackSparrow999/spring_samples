package com.test.JUnitDemo;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCalc {

	Calc c;
	
	@Before
	public void beforeTest() {
		c = new Calc();
	}
	
	@Test
	public void test() {
//		fail("Not yet implemented");
		
		assertEquals(5, c.add(2, 3));
	}
	
	@After
	public void afterTest() {
		c = null;
	}

}
