package Taxes.brackets;

public class runner {

	public static void main(String[] args) {
		
		TaxCalc calc = new TaxCalc(); 
		
		System.out.println(calc.taxable(25000));
		
	}

}
