// Sveinn Dal Bjornsson - 10/17/2014 -- SvenniDal.com
package is.ru.stringcalculator;
import java.util.ArrayList;

public class Calculator {

	// Gets a string with numbers and returns their sum
	public static int add(String text) {
		if(!text.equals("")) {	
			return sum(split(text)); }
		return 0;
	}

	// Splits a string on any charachter that is not a number or a minus symbol
	private static String[] split(String nos) {
		if(nos.contains("\n") && nos.startsWith("//")) {
			nos = nos.substring(nos.indexOf('\n') + 1, nos.length()); }
		return nos.split("[^0-9&^-]+");
	}

	// Sums up all the numbers, ignoring numbers bigger than 1000 and throws an
	// exception if a number or more are negative
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

	// Parse the string as an integer, makes the code more readable
	private static int strInt(String no) {
		return Integer.parseInt(no);
	}
}
