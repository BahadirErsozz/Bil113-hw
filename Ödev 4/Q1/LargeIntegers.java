
import java.util.Scanner;

public class LargeIntegers {	
	
	static int elde = 0, elde2 = 0;
	
	public static void main (String [] args){
		int i = 0; 
		boolean running = true;
		String firstNumber, secondNumber, operation, result ="";
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter two numbers. First number:");
		firstNumber = scan.nextLine();
		
		System.out.print("Second number:");
		secondNumber = scan.nextLine();
		
		System.out.print("Please enter 1 for addition or 2 for subtraction:");
		operation = scan.nextLine();
		int diff1 = firstNumber.length() - secondNumber.length(), diff2 = secondNumber.length() - firstNumber.length();
		
								
		while (running) {
			// checking if the numbers have the same length if not adding zeros until they are
			if(secondNumber.length() < firstNumber.length()){
				while (i < diff1){
					secondNumber = "0" + secondNumber;
					i++;		
				}
			}
			else if(firstNumber.length() < secondNumber.length()){
				while (i < diff2){
					firstNumber = "0" + firstNumber;
					i++;
				}
			
			}
			else {
				// checking if you input 1 or two
				if (operation.equals("1")){
					result = add(firstNumber, secondNumber);
					System.out.println("Result:" + result);
					running = false;
		   		}
				else if (operation.equals("2")){
					result = substract(firstNumber, secondNumber);
					System.out.println("Result:" + result);
					running = false;
				}
			}
		}	
	}
	public static String add(String input1, String input2){
		int i = 0, digitOne, digitTwo, sumOfTwo = 0;
		String lastSum = "";
		// adding all the digits one by one then putting them together
		while (i < input1.length()){
			digitOne = (int)input1.charAt((input1.length() - i) - 1) - '0';
			digitTwo = (int)input2.charAt((input2.length() - i) - 1) - '0';
			sumOfTwo = 0;
			if(elde == 1){
				if(digitOne + digitTwo >= 9){
					sumOfTwo = (digitOne + digitTwo) % 10 + 1;
				}
				else{
					sumOfTwo = digitOne + digitTwo + 1;
					elde = 0;
				}
			}
			else if(elde == 0){
				if (digitOne + digitTwo >= 10){
					sumOfTwo = (digitOne + digitTwo) % 10;
					elde = 1;
				}
				else{
					sumOfTwo = digitOne + digitTwo;
				}
			}
			lastSum =  (char)(sumOfTwo + '0') + lastSum;
			i++;
		}
		if (elde == 1)
			lastSum = elde  + lastSum;
			elde = 0;
		return lastSum ;
	}

	public static String substract(String input1, String input2){
		int i = 0, digitOne, digitTwo, diffOfTwo = 0;
		String lastSub = "";	
		// substracting all the digits one by one then putting them together
		while (i < input1.length()){
			digitOne = (int)input1.charAt((input1.length() - i) - 1) - '0';
			digitTwo = (int)input2.charAt((input2.length() - i) - 1) - '0';
			diffOfTwo = 0;
			if(elde2 == 1){
				digitOne = digitOne - 1;
				if(digitOne >= digitTwo){
					diffOfTwo = digitOne - digitTwo;
					elde2 = 0;
				}
				else{
					diffOfTwo = digitOne - digitTwo + 10;
					elde = 1;
				}
			}
			else if(elde2 == 0){
				if (digitOne >= digitTwo){
					diffOfTwo = digitOne - digitTwo;
					
				}
				else{
					diffOfTwo = digitOne - digitTwo + 10;
					elde2 = 1;
				}
			}
			lastSub =  (char)(diffOfTwo + '0') + lastSub;
			i++;
		}
		while (lastSub.charAt(0) == '0'){
			lastSub = lastSub.substring(1, lastSub.length());
		
		}
		return lastSub;
	}	
}	

