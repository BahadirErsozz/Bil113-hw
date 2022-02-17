
import java.util.Scanner;
import java.text.NumberFormat;
public class DeptPayment {

	public static void main(String[] args){
		
		double debt, interestRateYear, interestRateMonth, monthlyPayment, totalPayment = 0, monthlyPaymentAfter;
		
		int  monthCount = 0;
		
		Scanner scan = new Scanner(System.in);
		
		NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
		
		System.out.print("Please enter the initial debt:");
		debt = scan.nextDouble();	
		
		System.out.print("Please enter the yearly interest rate (in percentages):");
		interestRateYear = scan.nextDouble();
		interestRateMonth = interestRateYear / 12;
		
		System.out.print("Please enter the monthly payment you want to make:");
		monthlyPayment = scan.nextDouble();	
	 	// a loop until we pay all the debt
		while (debt > 0){
			//checking if our debt is less than our payment
			if(debt + ((interestRateMonth / 100) * debt) >= monthlyPayment){
				monthlyPaymentAfter = monthlyPayment - ((interestRateMonth / 100) * debt);
				debt = debt - monthlyPaymentAfter;
				monthCount++; 
				totalPayment = totalPayment + monthlyPayment;
			}
			else{ 
				totalPayment = totalPayment + debt + ((interestRateMonth / 100) * debt);
				debt = 0;
				monthCount++;
			}
		}	
		
		System.out.println("It takes " + monthCount + " months to pay the debt and the total payment equals to " + fmt1.format(totalPayment));
	}




}
