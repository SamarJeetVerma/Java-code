package com.samar1mvc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddServiceTest {
	
	
	AddService ads = new AddService();

	@Test
	void testAdd() {
		float expect = 20;
		float actual = ads.add(10, 10);
		assertEquals(expect,actual);
		
	}

	@Test
	void testSubtract() {
		float expect1 = 0;
		float actual1 = ads.subtract(10, 10);
		assertEquals(expect1,actual1);
	}

	@Test
	void testMultiply() {
		float expect2 = 100;
		float actual2 = ads.multiply(10, 10);
		assertEquals(expect2,actual2);
	}

	@Test
	void testDivide() {
		float expect3 = 1;
		float actual3 = ads.divide(10, 10);
		assertEquals(expect3,actual3);
	}

}
