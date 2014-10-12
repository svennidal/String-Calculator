// Sveinn Dal Bjornsson - 10/11/2014 -- SvenniDal.com
package is.ru.stringcalculator;

public class Calculator {

	// The add function of the calculator.
	public static int add(String text) {
		// Empty string.
		if(text.equals("")) { return 0; }
		// Adding two or more numbers together.
		if(!customDelimiter(text)) {
			if(text.contains(",")) { return sum(splitNosOnComma(text)); }
			else if(text.contains("\n")) { return sum(splitNosOnNewLine(text)); }
			// If it's not an empty string and if it's not several numbers.
			else if((!text.equals("")) && (!text.contains(","))) { return strInt(text); }
		} else {
			return sum(splitOnCustom(text));
		}

		// Just so we don't get a error for not returning anything..
		return 69;
	}

	// Parse the string as an integer.
	private static int strInt(String no) {
		return Integer.parseInt(no);
	}

	// Split string int an array of string, splitting elements at ",". 
	private static String[] splitNosOnComma(String nos) {
		return nos.split(",");
	}
	
	// Split string int an array of string, splitting elements at "\n". 
	private static String[] splitNosOnNewLine(String nos) {
		return nos.split("\n");
	}

	// Return a sum of all elements in an array
	private static int sum(String[] nos) {
		int total = 0;
		for(String no : nos) {
			total += strInt(no);
		}
		return total;
	}

	private static boolean customDelimiter(String nos) {
		return nos.startsWith("//");
	}

	private static String[] splitOnCustom(String nos) {
		String deli = nos.substring(2, nos.indexOf('\n'));
		String input = nos.substring(nos.indexOf('\n') + 1, nos.length());
		return input.split(deli);
	}







}
