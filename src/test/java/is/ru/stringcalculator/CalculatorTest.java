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

}
