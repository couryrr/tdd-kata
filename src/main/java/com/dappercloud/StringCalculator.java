package com.dappercloud;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

	private static final String BASE_DELIMITOR_GROUP = "[\\n,]";

	private static final String DELIMITOR_INDICATOR = "//";

	private static final String DELIMITOR_GROUP_START = "[";
	private static final String DELIMITOR_GROUP_END = "]";

	private static final String DELIMITOR_END = "\n";

	private static final int ADD_LIMIT = 1000;

	/**
	 * @param input - String separated by commas
	 * @return value of the separated string.
	 * 
	 *         The method can take up to two numbers, separated by commas, and will
	 *         return their sum. for example “” or “1” or “1,2” as inputs. (for an
	 *         empty string it will return 0)
	 *         
	 * @throws Exception - negative numbers are not allowed
	 */
	public static int addString(String input) throws Exception {

		int result = 0;
		List<Integer> negatives = new ArrayList<Integer>();

		String delimitor = getDelimitor(input);

		String values = input.startsWith(DELIMITOR_INDICATOR) ? getValues(input) : input;

		for (String value : split(values, delimitor)) {
			int num = parse(value);
			if (num <= ADD_LIMIT) {
				result += num;
			}
			if (num < 0) {
				negatives.add(num);
			}
		}
		if (negatives.size() > 0) {
			String message = negatives.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(",", "[", "]"));
			throw new Exception("Negatives not allowed " + message);
		}

		return result;
	}

	public static String[] split(String input, String delimitor) {
		return input.split(delimitor);
	}

	public static String getDelimitor(String input) {
		String delimitor = "";
		if (input.startsWith(DELIMITOR_INDICATOR)) {
			delimitor = "|\\Q"
					+ input.substring(input.indexOf(DELIMITOR_GROUP_START) + 1, input.indexOf(DELIMITOR_GROUP_END))
					+ "\\E";
		}
		return BASE_DELIMITOR_GROUP + delimitor;
	}

	public static int parse(String value) {
		int result = 0;
		try {
			result = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			// Just catching
		}

		return result;
	}

	public static String getValues(String input) {
		return input.substring(input.indexOf(DELIMITOR_GROUP_END + DELIMITOR_END) + DELIMITOR_GROUP_END.length()
				+ DELIMITOR_END.length());
	}

}
