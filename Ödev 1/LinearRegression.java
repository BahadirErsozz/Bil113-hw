//***************************************************************************************************************************
//   LinearRegression.java                                       Author:Bahadır Ersöz
//
//   takes 4 points as input and outputs the line that minimizes the sum of squared distances between the line and the points
//***************************************************************************************************************************
import java.util.Scanner;

public class LinearRegression {



  public static void main (String [] args ){

  Scanner scan = new Scanner(System.in);
    
  double x1, y1, x2, y2, x3, y3, x4, y4;
  
  System.out.println("Please enter 4 points:");

// point a = xa,ya  
  x1 = scan.nextDouble();
  y1 = scan.nextDouble();  
  x2 = scan.nextDouble();
  y2 = scan.nextDouble();  
  x3 = scan.nextDouble();
  y3 = scan.nextDouble();  
  x4 = scan.nextDouble();
  y4 = scan.nextDouble();
  
  
// calculates a in "ax +b = line"
  double a = (4 * (x1*y1 + x2*y2 + x3*y3 + x4*y4) - (x1 + x2 + x3 + x4) * (y1 + y2 + y3 + y4)) / (4 * (x1 * x1 + x2 * x2 + x3 * x3 + x4 * x4) - (x1 + x2 + x3 +x4) * (x1 + x2 + x3 + x4)); 
  
// calculates b in "ax + b = line"
  double b = ((y1 + y2 + y3 + y4) - a * (x1 + x2 + x3 + x4))/4;
  
  
  System.out.print("a:"+ a);
  System.out.print(" b:"+ b);

}

}
