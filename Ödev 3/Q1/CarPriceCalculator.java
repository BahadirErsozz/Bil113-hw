import java.util.Scanner;
import java.text.NumberFormat;

public class CarPriceCalculator {


	public static void main (String[] args){
	
		double basePrice, engineCapacity, SCTaxRate, totalPrice, totalTax = 0, SCTax, VATax, VATaxInTotal, SCTaxInTotal ;
		final double VATaxRate = 18;
		
		Scanner scan = new Scanner(System.in);
		
		NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
		NumberFormat fmt2 = NumberFormat.getPercentInstance();
		
		System.out.print("Please enter the base price of the car:");
		basePrice = scan.nextDouble();
		
		System.out.print("Please enter the engine capacity:");
		engineCapacity = scan.nextDouble();
		
		if (engineCapacity <= 1600)
			if (basePrice <=10625)
				SCTaxRate = 45;
			else if (10625 < basePrice && basePrice < 16250)
				SCTaxRate = 50;
			else 
				SCTaxRate = 80;
			
		else if (1600 < engineCapacity && engineCapacity< 2000)
			if(basePrice < 21250)
				SCTaxRate = 130;
			else
				SCTaxRate = 150;
		else 
			SCTaxRate = 220;
		
		//calculating everything that needs to be calculated
		SCTax = basePrice * SCTaxRate/100;
		totalPrice = basePrice + SCTax;
		VATax = totalPrice * VATaxRate/100;
		totalPrice = totalPrice + VATax;
		totalTax = SCTax + VATax;
		VATaxInTotal = VATax / totalPrice;
		SCTaxInTotal = SCTax / totalPrice;
		
		System.out.println("Base price:" + fmt1.format(basePrice));
		System.out.println("Special Consumption Tax:" + fmt1.format(SCTax));
		System.out.println("Value Added Tax:" + fmt1.format(VATax));
		System.out.println("Total Tax:" + fmt1.format(totalTax));
		System.out.println("Final Price:" + fmt1.format(totalPrice));
		System.out.println("Approximately " + fmt2.format(SCTaxInTotal) + " of the final price is Special Consumption Tax");
		System.out.println("Approximately " + fmt2.format(VATaxInTotal) + " of the final price is Value Added Tax");
	}


}
