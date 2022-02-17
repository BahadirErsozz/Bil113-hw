import java.util.Scanner;

public class JumpIt{

	public static void main(String[] args){
	 	
	  	int[] lisst = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
	  		    //{0,1,1,2,2,3,4,5}
	  	calculate(lisst);
	  	
	}
		
	public static void calculate(int[] list){
	
		int minValue = Integer.MAX_VALUE;	
		
		int[] leastCount = new int[list.length];   // finding the min moves to move to a cell
		leastCount[0] = 0;
		
		// {5,3,1,2,3,4,5,6}
		// {0,1,1,1,1,1,2,2}      =      leastCount
		
		for (int i = 0; i < list.length; i++){        // going through the list
			for (int j = i + 1; j < list[i] + i + 1 && j < list.length; j++){     // a. indexteki b sayısı için a + 1 ve a + 1 + b arasını geziyor (liste uzunluğunu geçmeden) 
				if(leastCount[i] + 1 < leastCount[j] || leastCount[j] == 0){  // int listte default değer 0 olduğu için 0'sa veya gitmeye başladığımız yerin bir fazlası önceden oraya ulaşılmış değerden daha azsa 
					leastCount[j] = leastCount[i] + 1;        
				}		
			}
		}
		
		System.out.println("Answer is: " + leastCount[leastCount.length - 1]);								
		
	}
	
}

