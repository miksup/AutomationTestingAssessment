package Taxes.brackets;

public class TaxCalc {
	

	private double percentage(double salary) {
		double percent = 0.0;
		
		
		if (salary < 15000) {
			
			percent = 0;
			
		} else if ((salary >= 15000) && (salary < 20000)) {
			
			percent = 10;
			
		} else if ((salary >= 20000) && (salary < 30000)) {
			
			percent = 15;
			
		} else if ((salary >= 30000) && (salary < 45000)) {
			
			percent = 20;
			
		} else {
			
			percent = 25;
			
		}

		return percent;
	}
	
	
	
	public double taxable(double salary) {
		
		double total = 0.0;
		double perc = percentage(salary);
		
		total = salary - salary*(perc/100);
		return total;
		
	}
	

	
	
}
