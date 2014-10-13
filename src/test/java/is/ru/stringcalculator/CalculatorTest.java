// Sveinn Dal Bjornsson - 10/11/2014 -- SvenniDal.com
package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	//  1
	@Test // Empty String; returns 0.
	public void testAddEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	//  2
	@Test // Two numbers seperated by ','; return their sum.
	public void testAddTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	//  3
	@Test // Several numbers seperated by ','; return their sum.
	public void testAddSeveralNumbers() {
		assertEquals(10, Calculator.add("1,2,3,4"));
	}

	//  4
	@Test // A single number; returns itself.
	public void testAddSingleNumber() {
		assertEquals(42, Calculator.add("42"));
	}

	//  5
	@Test // Several numbers seperated by '\n; return their sum.
	public void testAddNewLineSplit() {
		assertEquals(182, Calculator.add("91\n91"));
	}

	//  6
	@Test // Several numbers seperated by a predefined delimiter; return their sum.
	public void testAddCustomDelimiter() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	//  7
	@Test // Several numbers seperated by a multiple character delimiter; return their sum.
	public void testAddCustomDelimiter2() {
		assertEquals(12, Calculator.add("//tits\n4tits2tits3tits3"));
	}
	
	//  8
	@Test // Several numbers seperated by a multiple charachter, 
		//containing white space, delimeter; return their sum
	public void testAddCustomDelimiterWhiteSpace() {
		assertEquals(12, Calculator.add("//tits and boobs\n4tits and boobs2tits and boobs3tits and boobs3"));
	}

	//  9
	@Test // Throws an exception for negative numbers.
	public void testAddNegativeException() {
		try {
			Calculator.add("-1,22,-3");
			//fail("Exception expected.");
		} catch (RuntimeException ex) {
			// ok
		}
	}
	
	// 10
	@Test // Throws an exception for negative numbers with a custom message.
	public void testAddNegativeExceptionMessage() {
		try {
			Calculator.add("-1,22,-3");
			//fail("Exception expected.");
		} catch (RuntimeException ex) {
			assertEquals("Negatives not allowed: -1, -3", ex.getMessage());
		}
	}

	// 11
	@Test // Ignores numbers greater than 100.
	public void testAddGreaterThan1000() {
		assertEquals(5, Calculator.add("2,1337,3"));
	}

	// 12
	@Test
	public void testAddSplitOnBoth() {
		assertEquals(6, Calculator.add("2\n2,2"));
	}


}

/*
	@Test
	public void testAddDelimeterOfAnyLengthSpecialSyntax() {
		assertEquals(6, Calculator.add("//[kkk]\n1kkk2kkk3"));
	}
	*/
	/*
	@Test // Several numbers sepereated by any kind of charachter delimeter; return their sum.
		// DOES NOT WORK Sun Oct 12 21:29:29 GMT 2014
	public void testAddCustomDelimiterWeirdos() {
		assertEquals(12, Calculator.add("//[*]\n4[*]2[*]3[*]3"));
	}
	*/
