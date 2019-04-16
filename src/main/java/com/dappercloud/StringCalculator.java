package com.dappercloud;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
	
	 private static final String DELIMITOR_INDICATOR = "//";
	 private static final String DELIMITOR_END = "\n";
	 private static final int ADD_LIMIT = 1000;

	/**
	 * @param input - String separated by commas
	 * @return value of the separated string.
	 * 
	 *         The method can take up to two numbers, separated by commas, and will
	 *         return their sum. for example “” or “1” or “1,2” as inputs. (for an
	 *         empty string it will return 0)
	 * @throws Exception - negative numbers are not allowed
	 */
	public static int addString(String input) throws Exception {

		int result = 0;
		List<Integer> negatives = new ArrayList<Integer>();
		for (String value : split(input)) {
			int num = parse(value);
			if(num <= ADD_LIMIT) {
				result += num;
			}
			if(num < 0) {
				negatives.add(num);
			}
		}
		if(negatives.size() > 0) {
			String message = negatives.stream()
			      .map(n -> String.valueOf(n))
			      .collect(Collectors.joining(",", "[", "]"));
			throw new Exception("Negatives not allowed " + message);
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

	public static int parse(String value){
		int result = 0; 
		try {
			result = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			//Just catching I guess
		}
		
		return result;
	}

}
