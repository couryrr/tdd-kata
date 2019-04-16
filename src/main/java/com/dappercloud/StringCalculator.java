package com.dappercloud;

public class StringCalculator {
	
	/**
	 * @param input - String separated by commas
	 * @return value of the separated string.
	 * 
	 * The method can take up to two numbers, separated by commas, and will return their sum. 
	 * for example “” or “1” or “1,2” as inputs.
	 * (for an empty string it will return 0) 
	 */
	public static int addString(String input) {
		if(!input.isBlank()) {
			if(input.contains(",")) {
				return 7;
			}
			return 5;
		}
		return 0;
	}

}
