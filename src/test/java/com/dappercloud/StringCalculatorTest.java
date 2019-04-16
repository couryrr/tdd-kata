package com.dappercloud;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {
	
	@Test
	public void addEmptyStringTest() {
	
		int result = StringCalculator.addString("");
		assertEquals("String input blank is 0", 0, result);
	}
	
	@Test
	public void addEmptyWhiteSpaceStringTest() {
	
		int result = StringCalculator.addString("  ");
		assertEquals("String input blank is 0", 0, result);
	}
	
	@Test
	public void addSingleStringTest() {
		int result = StringCalculator.addString("5");
		assertEquals("String input 5 is 5", 5, result);
	}
	
	@Test
	public void addTwoStringTest() {
		int result = StringCalculator.addString("5,2");
		assertEquals("String input 5,2 is 7", 7, result);
	}
}
