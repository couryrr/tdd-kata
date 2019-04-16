package com.dappercloud;

public class StringCalculator {
	
	 private static final String DELIMITOR_INDICATOR = "//";
	 private static final String DELIMITOR_END = "\n";

	/**
	 * @param input - String separated by commas
	 * @return value of the separated string.
	 * 
	 *         The method can take up to two numbers, separated by commas, and will
	 *         return their sum. for example “” or “1” or “1,2” as inputs. (for an
	 *         empty string it will return 0)
	 */
	public static int addString(String input) {

		int result = 0;
		for (String value : split(input)) {
			result += parse(value);
		}

		return result;
	}

	public static String[] split(String input) {
		String delimitor = checkForDelimitor(input);
		return input.split("[\\\n,"+ delimitor + "]");
	}
	
	public static String checkForDelimitor(String input) {
		String delimitor = "";
		if(input.startsWith(DELIMITOR_INDICATOR)) {
			delimitor = input.substring(DELIMITOR_INDICATOR.length(), input.indexOf(DELIMITOR_END));		
		}
		return delimitor;
	}

	public static int parse(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

}
