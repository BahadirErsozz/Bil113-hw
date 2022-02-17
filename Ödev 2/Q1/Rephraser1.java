
import java.util.Scanner;

public class Rephraser1 {


	public static void main(String [] args){
   
   
   		Scanner scan = new Scanner(System.in);
   
   		System.out.print("Please enter the sentence:");
 
   		String sentence = scan.nextLine();
   		
		//transforming If to if   
   		sentence = sentence.replaceFirst("I","i");
   		
		//finding the index of comma
   		int commaIndex = sentence.indexOf(",");
   		
		//taking the part before the comma and assiging it to firstHalf   
   		String firstHalf = (sentence.substring(0,commaIndex));
   		
   		//taking the part after the comma and assiging it to secondHalf
   		String secondHalf = (sentence.substring(commaIndex + 1, sentence.length() - 1));
   		
   		//taking the first letter of the secondHalf and making it uppercase then connecting it with the rest of it
   		String secondHalf2 = secondHalf.substring(1,2);
   		secondHalf2 = secondHalf2.toUpperCase();
   		secondHalf2 = secondHalf2 + secondHalf.substring(2, secondHalf.length());
             
		System.out.println("Repharased sentence: " + secondHalf2 + " " +firstHalf + ".");
   
   
   
  




	}

}
