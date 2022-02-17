
import java.util.Scanner;

public class TribeUnifier {


	public static void main(String[] args){
	
	
		double x1, y1, x2, y2, x3, y3, x4, y4, toConvert, a, b, convertedValue;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter 4 observation pairs:");
		x1 = scan.nextDouble();	
		y1 = scan.nextDouble();
		x2 = scan.nextDouble();
		y2 = scan.nextDouble();
		x3 = scan.nextDouble();
		y3 = scan.nextDouble();
		x4 = scan.nextDouble();
		y4 = scan.nextDouble();
		
		System.out.print("Please enter the measurement you want to convert:");
		toConvert = scan.nextDouble();
		
		//Doing all the math and finding ax +b (Linear Regression)
		a = (4 * (x1*y1 + x2*y2 + x3*y3 + x4*y4) - (x1 + x2 + x3 + x4) * (y1 + y2 + y3 + y4)) / (4 * (x1 * x1 + x2 * x2 + x3 * x3 + x4 * x4) - (x1 + x2 + x3 +x4) * (x1 + x2 + x3 + x4));
		
		b = ((y1 + y2 + y3 + y4) - a * (x1 + x2 + x3 + x4))/4;
		
		//using the function to find the convertedValue
		convertedValue = a*toConvert +b;	
		
		System.out.println("Converted measurement is " + convertedValue);
	
	
	
	
	
	
	
	}



}
