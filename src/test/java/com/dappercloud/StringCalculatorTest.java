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
	
	@Test
	public void addTwoFirstEmptyStringTest() {
		int result = StringCalculator.addString(",2");
		assertEquals("String input ,2 is 2", 2, result);
	}
	
	@Test
	public void addTwoSecondEmptyStringTest() {
		int result = StringCalculator.addString("5,");
		assertEquals("String input 5, is 5", 5, result);
	}
	
	@Test
	public void addMultipleNumbersStringTest() {
		int result = StringCalculator.addString("5,2,3");
		assertEquals("String input 5,2,3 is 10", 10, result);
	}
	
	
	@Test
	public void addMultipleNumbersNewLineStringTest() {
		int result = StringCalculator.addString("5\n2\n3");
		assertEquals("String input 5,2,3 is 10", 10, result);
	}
	
	@Test
	public void addMultipleNumbersNewLineAndCommaStringTest() {
		int result = StringCalculator.addString("5,2\n3");
		assertEquals("String input 5,2,3 is 10", 10, result);
	}
	
	@Test
	public void parseEmptyTest() {
		int result = StringCalculator.parse("");
		assertEquals("String input blank is 0", 0, result);
	}
	
	@Test
	public void parseEmptyWhiteSpaceTest() {
		int result = StringCalculator.parse(" ");
		assertEquals("String input white space is 0", 0, result);
	}
	
	@Test
	public void parseNumberTest() {
		int result = StringCalculator.parse("5");
		assertEquals("String input 5 is 5", 5, result);
	}
	
	@Test
	public void parseNegativeNumberTest() {
		int result = StringCalculator.parse("-5");
		assertEquals("String input -5 is -5", -5, result);
	}
	
	@Test
	public void splitEmptyStringTest() {
		String[] result = StringCalculator.split("");
		assertEquals("Empty input will have a size of 1", 1, result.length);
		assertEquals("Empty input only value will be blank", "", result[0]);
	}
	
	@Test
	public void splitSingleStringTest() {
		String[] result = StringCalculator.split("5");
		assertEquals("Single input will have a size of 1", 1, result.length);
		assertEquals("Single input only value will be it", "5", result[0]);
	}
	
	@Test
	public void splitTwoStringTest() {
		String[] result = StringCalculator.split("5,2");
		assertEquals("Two inputs will have a size of 2", 2, result.length);
		assertEquals("Input[0] value will be it", "5", result[0]);
		assertEquals("Input[1] value will be it", "2", result[1]);
	}
	
	@Test
	public void splitTwoOneBlankStringTest() {
		String[] result = StringCalculator.split("5, ");
		assertEquals("Two inputs will have a size of 2", 2, result.length);
		assertEquals("Input[0] value will be it", "5", result[0]);
		assertEquals("Input[1] value will be it", " ", result[1]);
	}
	
	@Test
	public void splitTwoOneEmptyStringTest() {
		String[] result = StringCalculator.split("25,");
		assertEquals("Two inputs will have a size of 1", 1, result.length);
		assertEquals("Input[0] value will be it", "25", result[0]);
	}
	
	@Test
	public void splitMoreThanTwoStringTest() {
		String[] result = StringCalculator.split("25,55,16");
		assertEquals("Two inputs will have a size of 3", 3, result.length);
		assertEquals("Input[0] value will be it", "25", result[0]);
		assertEquals("Input[1] value will be it", "55", result[1]);
		assertEquals("Input[2] value will be it", "16", result[2]);
	}
	
	@Test
	public void splitMoreThanTwoOneEmptyStringTest() {
		String[] result = StringCalculator.split("25,,16");
		assertEquals("Two inputs will have a size of 3", 3, result.length);
		assertEquals("Input[0] value will be it", "25", result[0]);
		assertEquals("Input[1] value will be it", "", result[1]);
		assertEquals("Input[2] value will be it", "16", result[2]);
	}
	
	@Test
	public void splitWithNewLineStringTest() {
		String[] result = StringCalculator.split("25\n16");
		assertEquals("Two inputs will have a size of 2", 2, result.length);
		assertEquals("Input[0] value will be it", "25", result[0]);
		assertEquals("Input[1] value will be it", "16", result[1]);
	}
	@Test
	public void splitWithNewLineAndCommaStringTest() {
		String[] result = StringCalculator.split("25\n16,12");
		assertEquals("Two inputs will have a size of 3", 3, result.length);
		assertEquals("Input[0] value will be it", "25", result[0]);
		assertEquals("Input[1] value will be it", "16", result[1]);
		assertEquals("Input[2] value will be it", "12", result[2]);
	}

}
