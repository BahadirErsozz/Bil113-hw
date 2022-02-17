import java.util.Scanner;

public class TowerOfHanoi {
	public static int aHeight = 3, bHeight = 0, cHeight = 0, aHeight1 = 3, bHeight1 = 0, cHeight1 = 0, illegalCount= 0, legalCount = 0;
	public static String a1 = "3" , a2 = "2", a3 = "1", b1 =" ", b2 =" " , b3 =" " , c1 =" ", c2 =" ", c3 =" ", a11 = "1" , a21 = "2", a31 = "3", b11 =" ", b21 =" " , b31 =" " , c11 =" ", c21 =" ", c31 =" ";
	
	public static void main(String[] args){
		
		char b, c;
		boolean gameRunning = true;
		Scanner scan = new Scanner(System.in);
		TowerOfHanoi obj = new TowerOfHanoi();
		String board = makeBoard(a1, a2, a3, b1, b2, b3, c1, c2, c3);
		System.out.println("Welcome to the Game of Hanoi!..");
		System.out.println(board);
		// games main loop
		while (gameRunning) {
			// checking if the player has won, if not then asks for another move
			if (c1.equals("3") && c2.equals("2") && c3.equals("1")){
				gameRunning = false;
				System.out.println("Congratulations you won!..");
				System.out.println("You made " + legalCount +" legal moves to win.");
				System.out.println("Also you tried to make " + illegalCount + " illegal moves.");
			}
			else{
				System.out.print("Please make a move:");
				String a = scan.nextLine();
				b = a.charAt(0);
				c = a.charAt(2);
				board = obj.makeMove(b, c);
				System.out.println(board);
			}
			
		}
		
		
		
	
	}
	// a method which returns the board with the changes
	public static String makeBoard(String a1, String a2,String a3,String b1,String b2,String b3,String c1,String c2,String c3){
	
	String BoardLast = (a3 + "\t\t" + b3 + "\t\t" + c3 + "\n" +
	         	    a2 + "\t\t" + b2 + "\t\t" + c2 + "\n" +
	       	    a1 + "\t\t" + b1 + "\t\t" + c1 + "\n"  );
	return BoardLast;
	}
	// checks every single possibility then changes the board
	public String makeMove(char a, char b){
		
		
		// storing the old coordinates of the disks so if the player makes a mistake we can fix the board
		a11 = a1;
		a21 = a2;
		a31 = a3;
		b11 = b1;
		b21 = b2;
		b31 = b3;
		c11 = c1;
		c21 = c2;
		c31 = c3;
		// storing how many disks are in the specific column
		aHeight1 = aHeight;
		bHeight1 = bHeight;
		cHeight1 = cHeight;
		// checking every single possibility (A-B, A-C, etc.)
		if (a == "A".charAt(0)){
			if (b == "B".charAt(0)){
				if (aHeight == 3){
					if (bHeight == 2){
						b3 = a3;
						bHeight++;
					}
					else if (bHeight == 1){
						b2 = a3;
						bHeight++;
					}
					
					else if (bHeight == 0){
						b1 = a3;
						bHeight++;
					}					
					a3 = "";
					aHeight--;
				}
				else if (aHeight == 2){
					if (bHeight == 2){
						b3 = a2;
						bHeight++;
					}
					else if (bHeight == 1){
						b2 = a2;
						bHeight++;
					}
					
					else if (bHeight == 0){
						b1 = a2;
						bHeight++;
					}					
					a2 = "";
					aHeight--;
				}
				else if (aHeight == 1){
					if (bHeight == 2){
						b3 = a1;
						bHeight++;
					}
					else if (bHeight == 1){
						b2 = a1;
						bHeight++;
					}
					
					else if (bHeight == 0){
						b1 = a1;
						bHeight++;
					}					
					a1 = "";
					aHeight--;
				}
				else if (aHeight == 0){
					System.out.println("Illegal move: peg is empty.");
					illegalCount++;
					legalCount--;
				
				}
			
			}
			
			else if (b == "C".charAt(0)){
				if (aHeight == 3){
					if (cHeight == 2){
						c3 = a3;
						cHeight++;
					}
					else if (cHeight == 1){
						c2 = a3;
						cHeight++;
					}
					
					else if (cHeight == 0){
						c1 = a3;
						cHeight++;
					}					
					a3 = "";
					aHeight--;
				}
				else if (aHeight == 2){
					if (cHeight == 2){
						c3 = a2;
						cHeight++;
					}
					else if (cHeight == 1){
						c2 = a2;
						cHeight++;
					}
					
					else if (cHeight == 0){
						c1 = a2;
						cHeight++;
					}					
					a2 = "";
					aHeight--;
				}
				else if (aHeight == 1){
					if (cHeight == 2){
						c3 = a1;
						cHeight++;
					}	
					else if (cHeight == 1){
						c2 = a1;
						cHeight++;
					}
					
					else if (cHeight == 0){
						c1 = a1;
						cHeight++;
					}					
					a1 = "";
					aHeight--;
				}
				else if (aHeight == 0){
					System.out.println("Illegal move: peg is empty.");
					illegalCount++;
					legalCount--;	
				}	
			
			}
			
		}
		else if (a == "B".charAt(0)){
			if (b == "A".charAt(0)){
				if (bHeight == 3){
					if (aHeight == 2){
						a3 = b3;
						aHeight++;
					}
					else if (aHeight == 1){
						a2 = b3;
						aHeight++;
					}
					
					else if (aHeight == 0){
						a1 = b3;
						aHeight++;
					}					
					b3 = "";
					bHeight--;
				}
				else if (bHeight == 2){
					if (aHeight == 2){
						a3 = b2;
						aHeight++;
					}
					else if (aHeight == 1){
						a2 = b2;
						aHeight++;
					}
					
					else if (aHeight == 0){
						a1 = b2;
						aHeight++;
					}					
					b2 = "";
					bHeight--;
				}
				else if (bHeight == 1){
					if (aHeight == 2){
						a3 = b1;
						aHeight++;
					}
					else if (aHeight == 1){
						a2 = b1;
						aHeight++;
					}
					
					else if (aHeight == 0){
						a1 = b1;
						aHeight++;
					}					
					b1 = "";
					bHeight--;
				}
				else if (bHeight == 0){
					System.out.println("Illegal move: peg is empty.");
					illegalCount++;
					legalCount--;	
				}
			
			}
			else if (b == "C".charAt(0)){
				if (bHeight == 3){
					if (cHeight == 2){
						c3 = b3;
						cHeight++;
					}
					else if (cHeight == 1){
						c2 = b3;
						cHeight++;
					}
					
					else if (cHeight == 0){
						c1 = b3;
						cHeight++;
					}					
					b3 = "";
					bHeight--;
				}
				else if (bHeight == 2){
					if (cHeight == 2){
						c3 = b2;
						cHeight++;
					}
					else if (cHeight == 1){
						c2 = b2;
						cHeight++;
					}
					
					else if (cHeight == 0){
						c1 = b2;
						cHeight++;
					}					
					b2 = "";
					bHeight--;
				}
				else if (bHeight == 1){
					if (cHeight == 2){
						c3 = b1;
						cHeight++;
					}
					else if (cHeight == 1){
						c2 = b1;
						cHeight++;
					}
					
					else if (cHeight == 0){
						c1 = b1;
						cHeight++;
					}					
					b1 = "";
					bHeight--;
				}
				else if (bHeight == 0){
					System.out.println("Illegal move: peg is empty.");
					illegalCount++;
					legalCount--;	
				}
			
			}
		
		}
		
		else if (a == "C".charAt(0)){
			if (b == "B".charAt(0)){
				if (cHeight == 3){
					if (bHeight == 2){
						b3 = c3;
						bHeight++;
					}
					else if (bHeight == 1){
						b2 = c3;
						bHeight++;
					}
					
					else if (bHeight == 0){
						b1 = c3;
						bHeight++;
					}					
					c3 = "";
					cHeight--;
				}
				else if (cHeight == 2){
					if (bHeight == 2){
						b3 = c2;
						bHeight++;
					}
					else if (bHeight == 1){
						b2 = c2;
						bHeight++;
					}
					
					else if (bHeight == 0){
						b1 = c2;
						bHeight++;
					}					
					c2 = "";
					cHeight--;
				}
				else if (cHeight == 1){
					if (bHeight == 2){
						b3 = c1;
						bHeight++;
					}
					else if (bHeight == 1){
						b2 = c1;
						bHeight++;
					}
					
					else if (bHeight == 0){
						b1 = c1;
						bHeight++;
					}					
					c1 = "";
					cHeight--;
				}
				else if (cHeight == 0){
					System.out.println("Illegal move: peg is empty.");
					illegalCount++;
					legalCount--;	
				}
			
			}
			else if (b == "A".charAt(0)){
				if (cHeight == 3){
					if (aHeight == 2){
						a3 = c3;
						aHeight++;
					}
					else if (aHeight == 1){
						a2 = c3;
						aHeight++;
					}
					
					else if (aHeight == 0){
						a1 = c3;
						aHeight++;
					}					
					c3 = "";
					cHeight--;
				}
				else if (cHeight == 2){
					if (aHeight == 2){
						a3 = c2;
						aHeight++;
					}
					else if (aHeight == 1){
						a2 = c2;
						aHeight++;
					}
					
					else if (aHeight == 0){
						a1 = c2;
						aHeight++;
					}					
					c2 = "";
					cHeight--;
				}
				else if (cHeight == 1){
					if (aHeight == 2){
						a3 = c1;
						aHeight++;
					}
					else if (aHeight == 1){
						a2 = c1;
						aHeight++;
					}
					
					else if (aHeight == 0){
						a1 = c1;
						aHeight++;
					}					
					c1 = "";
					cHeight--;
				}
				else if (cHeight == 0){
					System.out.println("Illegal move: peg is empty.");
					illegalCount++;
					legalCount--;	
				}
				
			
			}
		}
		// checking if the player made any illegal moves
		if (aHeight == 2 && (a1.equals("1") && (a2.equals("2") || a2.equals("3")) || a1.equals("2") && a2.equals("3") )){
			illegalCount++;
			System.out.println("Illegal move: bigger disk cannot be placed on top of smaller disk");
			a1 = a11;
			a2 = a21;
			a3 = a31;
			b1 = b11;
			b2 = b21;
			b3 = b31;
			c1 = c11;
			c2 = c21;
			c3 = c31;
			aHeight = aHeight1;
			bHeight = bHeight1;
			cHeight = cHeight1;
			return makeBoard(a1, a2, a3, b1, b2, b3, c1, c2, c3);} 
		else if (aHeight == 3 && (a2.equals("1") && (a3.equals("3") || a3.equals("2")) )) {
			illegalCount++;
			System.out.println("Illegal move: bigger disk cannot be placed on top of smaller disk");
			a1 = a11;
			a2 = a21;
			a3 = a31;
			b1 = b11;
			b2 = b21;
			b3 = b31;
			c1 = c11;
			c2 = c21;
			c3 = c31;
			aHeight = aHeight1;
			bHeight = bHeight1;
			cHeight = cHeight1;
			return makeBoard(a1, a2, a3, b1, b2, b3, c1, c2, c3);}
		else if (bHeight == 2 && (b1.equals("1") && ((b2.equals("2") || b2.equals("3"))) || b1.equals("2") && b2.equals("3")) ){
			illegalCount++;
			System.out.println("Illegal move: bigger disk cannot be placed on top of smaller disk");
			a1 = a11;
			a2 = a21;
			a3 = a31;
			b1 = b11;
			b2 = b21;
			b3 = b31;
			c1 = c11;
			c2 = c21;
			c3 = c31;
			aHeight = aHeight1;
			bHeight = bHeight1;
			cHeight = cHeight1;
			return makeBoard(a1, a2, a3, b1, b2, b3, c1, c2, c3);}
		else if (bHeight == 3 && (b2.equals("1") && (b3.equals("3") || b3.equals("2")) )){ 
			illegalCount++;
			System.out.println("Illegal move: bigger disk cannot be placed on top of smaller disk");
			a1 = a11;
			a2 = a21;
			a3 = a31;
			b1 = b11;
			b2 = b21;
			b3 = b31;
			c1 = c11;
			c2 = c21;
			c3 = c31;
			aHeight = aHeight1;
			bHeight = bHeight1;
			cHeight = cHeight1;
			return makeBoard(a1, a2, a3, b1, b2, b3, c1, c2, c3);}
		else if (cHeight == 2 && (c1.equals("1") && (c2.equals("2") || c2.equals("3")) || c1.equals("2") && c2.equals("3") )){
			illegalCount++;
			System.out.println("Illegal move: bigger disk cannot be placed on top of smaller disk");
			a1 = a11;
			a2 = a21;
			a3 = a31;
			b1 = b11;
			b2 = b21;
			b3 = b31;
			c1 = c11;
			c2 = c21;
			c3 = c31;
			aHeight = aHeight1;
			bHeight = bHeight1;
			cHeight = cHeight1;
			return makeBoard(a1, a2, a3, b1, b2, b3, c1, c2, c3);}
		else if (cHeight == 3 && (c2.equals("1") && (c3.equals("3") || c3.equals("2")) )){ 
			illegalCount++;
			System.out.println("Illegal move: bigger disk cannot be placed on top of smaller disk");
			a1 = a11;
			a2 = a21;
			a3 = a31;
			b1 = b11;
			b2 = b21;
			b3 = b31;
			c1 = c11;
			c2 = c21;
			c3 = c31;
			aHeight = aHeight1;
			bHeight = bHeight1;
			cHeight = cHeight1;
			return makeBoard(a1, a2, a3, b1, b2, b3, c1, c2, c3);}
		else {
			legalCount++;
			return makeBoard(a1, a2, a3, b1, b2, b3, c1, c2, c3);
		}
			
		
		
	}
	
}
