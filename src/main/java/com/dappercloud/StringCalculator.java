package com.dappercloud;

public class StringCalculator {

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
		return input.split("[\\\n,]");
	}

	public static int parse(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

}
