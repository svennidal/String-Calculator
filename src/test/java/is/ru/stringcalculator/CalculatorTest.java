// Sveinn Dal Bjornsson - 10/11/2014 -- SvenniDal.com
package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAddEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testAddTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testAddSeveralNumbers() {
		assertEquals(10, Calculator.add("1,2,3,4"));
	}

	@Test
	public void testAddSingleNumber() {
		assertEquals(42, Calculator.add("42"));
	}

	@Test
	public void testAddNewLineSplit() {
		assertEquals(182, Calculator.add("91\n91"));
	}

	@Test
	public void testAddCustomDelimiter() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testAddCustomDelimiter2() {
		assertEquals(12, Calculator.add("//tits\n4tits2tits3tits3"));
	}
	
	@Test
	public void testAddCustomDelimiterWhiteSpace() {
		assertEquals(12, Calculator.add("//tits and boobs\n4tits and boobs2tits and boobs3tits and boobs3"));
	}

	@Test
	public void testAddCustomDelimiterWeirdos() {
		assertEquals(12, Calculator.add("//i\n4i2i3i3"));
	}
	


}
