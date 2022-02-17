
import java.util.Scanner;

public class VolumeFinder {


	public static void main (String[] args){
		
		double lengthOfCube, cubeVolume, cylinderHeight, cylinderRadius, cylinderVolume, sphereRadius, sphereVolume, rectLength, rectHeight, rectWidht, rectVolume;
		
		Scanner scan = new Scanner(System.in);
	 
		System.out.print("Please enter the geometric shape which you wish to compute its volume:"); 
		String geometricShape = scan.nextLine();
		
		//checking if geometricShape is valid if so calculating its volume and printing it out
		if (geometricShape.equals("cube")){
			System.out.print("Please enter the length of the cube:");
			lengthOfCube = scan.nextDouble();
			cubeVolume = Math.pow(lengthOfCube,3); 
			System.out.print("Volume of the cube is " + cubeVolume);	
			
		}
		
	 	else if (geometricShape.equals("cylinder")){
	 	System.out.print("Please enter the height and radius of the cylinder:");
	 	cylinderHeight = scan.nextDouble();
	 	cylinderRadius = scan.nextDouble();
	 	cylinderVolume = cylinderHeight * Math.PI * Math.pow(cylinderRadius, 2);
	 	System.out.println("Volume of the cylinder is " + cylinderVolume);
	 	
	 	}
	 	
	 	else if (geometricShape.equals("sphere")){
	 			
	 	System.out.print("Please enter the radius of the sphere:");
	 	sphereRadius = scan.nextDouble();
	 	sphereVolume = 4 * Math.PI * Math.pow(sphereRadius, 3) * 1 / 3;
	 	System.out.println("Volume of the sphere is " + sphereVolume);
		 	
	 	
	 	}
	 	
	 	else if (geometricShape.equals("rectangular prism")){
	 	
	 	System.out.print("Please enter the length, height, and width of the rectangular prism:");
	 	rectLength = scan.nextDouble();
	 	rectHeight = scan.nextDouble();
	 	rectWidht = scan.nextDouble();
	 	rectVolume = rectLength * rectHeight * rectWidht;
	 	System.out.println("Volume of the rectangular prism is " + rectVolume);

	 	
	 	
	 	}
				 	
	 	
	}

}
