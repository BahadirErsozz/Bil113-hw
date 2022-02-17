import java.util.Scanner;

public class Bil113NumberDecider {

	public static void main(String [] args){
	
		Scanner scan = new Scanner(System.in);
		
		int fourDigitNumber, firstDigit, secondDigit, thirdDigit, fourthDigit;
		
		System.out.print("Please enter a 4-digit number:");
		
		fourDigitNumber = scan.nextInt();
		
		//finding all the digits of the number
		firstDigit = fourDigitNumber % 10;
		secondDigit = (fourDigitNumber / 10) % 10;
		thirdDigit = (fourDigitNumber / 100) % 10;
		fourthDigit = (fourDigitNumber / 1000) % 10;
		
		if ((firstDigit + secondDigit) % (thirdDigit + fourthDigit) == 0){
		
			System.out.println(fourDigitNumber + " is a Bil113 Number.");
		
		}
	
		else {
		
			System.out.println(fourDigitNumber + " is not a Bil113 Number.");
		
		}
	
	}

}
