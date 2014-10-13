// Sveinn Dal Bjornsson - 10/11/2014 -- SvenniDal.com
package is.ru.stringcalculator;
import java.util.ArrayList;

public class Calculator {

	// The add function of the calculator.
	public static int add(String text) {

		// Empty string.
		if(text.equals("")) { return 0; }
		// Adding two or more numbers together.
		// When the string does not start with a custom delimeiter
		if(!customDelimiter(text)) {
			if(text.contains(",") && text.contains("\n")) { return sum(splitOnCommaAndNewLine(text)); }
			else if(text.contains(",")) { return sum(splitNosOnComma(text)); }
			else if(text.contains("\n")) { return sum(splitNosOnNewLine(text)); }
			// If it's not an empty string and if it's not several numbers.
			else if((!text.equals("")) && (!text.contains(","))) { return strInt(text); }
		} else {
			// If the string contains a custom delimeter.
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
	
	// Split string on comma and new line. Return array of elements.
	private static String[] splitOnCommaAndNewLine(String nos) {
		return nos.split("\n|\\,");
	}


	// Return a sum of all elements in an array
	private static int sum(String[] nos) {
		int total = 0;
		ArrayList<String> minus = new ArrayList<String>();
		for(String no : nos) {
			if(strInt(no) < 0) { minus.add(no); }
			else if(strInt(no) > 0 && strInt(no) < 1001) { total += strInt(no); }
		}
		if(!minus.isEmpty()) {
			String negatives = "";
			for(String neg : minus) { negatives += neg + ", "; }
			negatives = negatives.substring(0, negatives.length() - 2);
			throw new RuntimeException("Negatives not allowed: " + negatives);
		}
		return total;
	}

	// Returns true if the string starts with '//'.
	private static boolean customDelimiter(String nos) {
		return nos.startsWith("//");
	}

	// We exchange this one for a function that removes all symbols except
	// decimals and minus sign.
	// Split string at a custom delimeter.
	// Return an array of elements from the inserted string.
	/*
	private static String[] splitOnCustom(String nos) {
		String deli = nos.substring(2, nos.indexOf('\n'));
		String input = nos.substring(nos.indexOf('\n') + 1, nos.length());
		return input.split(deli);
	}
	*/

	
	// Split string with regex that changes all symbols that are not a 
	// minus symbol or a decimal, with ','.
	// Return an array of elements from the inserted string.
	private static String[] splitOnCustom(String nos) {
		//String deli = nos.substring(2, nos.indexOf('\n'));
		String afterDelis = nos.substring(nos.indexOf('\n') + 1, nos.length());
		String input = afterDelis.replaceAll("[^0-9&^-]+", ",");

		return input.split(",");
	}





}
