package Taxes.brackets;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class BracketTests {

	@Parameters
	public static List<Integer[]> data() {
		return Arrays.asList(new Integer[][] { { 21250, 25000 }, { 14999, 14999 } , {0, 0} , { 17999, 19999} });
	}
		
	private double Given;
	private double Expected;

	public BracketTests(double expected, double given) {
		
		Expected = expected;
		Given = given;		
		
	}
	
	@Test
	public void sumTest() {

		TaxCalc calc = new TaxCalc();

		assertEquals(Expected, calc.taxable(Given), 0);

	}
	
	
}
