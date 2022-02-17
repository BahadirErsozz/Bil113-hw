
import java.util.Scanner;

public class Distance3D {


	public static void main(String[] args){


		double x1, y1, z1, x2, y2, z2, ManhattanDistance, EuclideanDistance, CosineDistance;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter two points:");
		x1 = scan.nextDouble();        
       	        y1 = scan.nextDouble();
       	        z1 = scan.nextDouble();
        	x2 = scan.nextDouble();
        	y2 = scan.nextDouble();
		z2 = scan.nextDouble();

		//Doing all the math
		ManhattanDistance =(Math.abs(x1-x2) + Math.abs(y1-y2) + Math.abs(z1-z2)) ;
		
		EuclideanDistance =(Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2), 2) + Math.pow((z1-z2), 2)));
		
		CosineDistance = (1 - ( (x1*x2 + y1*y2 + z1*z2 ) / (Math.sqrt(x1*x1 + y1*y1 + z1*z1) * Math.sqrt(x2*x2 + y2*y2 + z2*z2) )   )  );
		
		System.out.println("Manhattan distance is equal to:" + ManhattanDistance);
		
		System.out.println("Euclidean distance is equal to:" + EuclideanDistance);
		
		System.out.println("Cosine distance is equal to:" + CosineDistance);


	}

}
