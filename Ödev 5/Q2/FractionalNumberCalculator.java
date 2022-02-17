import java.util.Scanner;
import java.util.ArrayList;
public class FractionalNumberCalculator{
	public static void main(String[] args){
		ArrayList<String> numbers = new ArrayList<String>();
		ArrayList<String> operators = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		FractionalNumber fn1, fn2, fn3 = new FractionalNumber(5, 4);
		int i = 0, n = 0, a = 0;
			
		boolean isNull = false;
		
		System.out.print("Please enter the formula you want to calculate:");				
		String toCalculate = scan.nextLine();
		
		//5/6 + 7/8 - 5/8 * 7/3
		while(toCalculate.length() > 0){
			int indexOfSpace = toCalculate.indexOf(" ");
			if (indexOfSpace == -1){
				numbers.add(toCalculate);
				toCalculate = "";
			}	
			else{
				numbers.add(toCalculate.substring(0, indexOfSpace));
				toCalculate = toCalculate.substring(indexOfSpace, toCalculate.length());
				
				// + 7/8 - 5/8 * 7/3 
				operators.add("" + toCalculate.charAt(1));
				toCalculate = toCalculate.substring(3,toCalculate.length());
				//7/8 - 5/8 * 7/3	
			}
			
			i++;
		}
		while(operators.size() > 0){
			while(operators.contains("*") || operators.contains("/")){
				
				if (operators.get(n).equals("*")){
					// 1/1 + 5/4 * 7/5 * 5/5
					fn1 = new FractionalNumber(numbers.get(n));		
					fn2 = new FractionalNumber(numbers.get(n+1));
					numbers.remove(n);
					numbers.remove(n);
					operators.remove(n);
					fn3 = FractionalNumber.multiply(fn1, fn2);
					numbers.add(n, fn3.toString());
					
					// 1/1 + 7/4 * 5/5
				}
				else if(operators.get(n).equals("/")){
				
					fn1 = new FractionalNumber(numbers.get(n));		
					fn2 = new FractionalNumber(numbers.get(n+1));
					numbers.remove(n);
					numbers.remove(n);
					operators.remove(n);
					fn3 = FractionalNumber.divide(fn1, fn2);
					if(fn3 == null){
						isNull = true;	
						operators.clear();
					}	
					else
						numbers.add(n, fn3.toString());
				
				}else

					n++;
			}
			while(operators.contains("+") || operators.contains("-")){
				fn1 = new FractionalNumber(numbers.get(0));
				fn2 = new FractionalNumber(numbers.get(1));
				
				if(operators.get(0).equals("+"))
					fn3 = FractionalNumber.add(fn1, fn2);
				else if(operators.get(0).equals("-"))
					fn3 = FractionalNumber.subtract(fn1, fn2);
				operators.remove(0);
				numbers.remove(0);
				numbers.remove(0);
				numbers.add(0, fn3.toString());
			}
		}
		if(isNull)
			System.out.println("Result:null");
		else
			System.out.println("Result:" + numbers.get(0));				
	}

}
