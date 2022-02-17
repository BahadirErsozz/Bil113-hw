
import java.util.Scanner;

public class Rephraser2 {


	public static void main(String [] args){
   
   
   		Scanner scan = new Scanner(System.in);
   
   		System.out.print("Please enter the sentence:");
   
   		String sentence = scan.nextLine();
  
   		int ifIndex = sentence.indexOf("if");
   		
		//taking the part before "if" and assiging it to firstHalf then taking the first letter of firstHalf assaging it to firstHalfFirstLetter then making it lowercase, checking if it     			starts with i if so turning it to I then making the firstHalf
   		String firstHalf = (sentence.substring(0,ifIndex-1 ));
   		String firstHalfFirstLetter = firstHalf.substring(0, 1);
   		firstHalfFirstLetter = firstHalfFirstLetter.toLowerCase();
   		firstHalf = firstHalfFirstLetter + firstHalf.substring(1, firstHalf.length());
   		firstHalf = firstHalf.replaceFirst("i " , "I ");
		
		//taking the part after if and assiging it to secondHalf then transforming if to If
   		String secondHalf = (sentence.substring(ifIndex , sentence.length() - 1));
   		secondHalf = secondHalf.replaceFirst("i" , "I");
		   		
		   		
		System.out.println("Repharased sentence: " + secondHalf + ", " + firstHalf + ".");
   
   
   
  




	}

}
