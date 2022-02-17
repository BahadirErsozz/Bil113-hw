import java.util.Scanner;
import java.util.Random;
public class MineSweeper{
	
	public static String[][] realBoard;
	public static String[][] boardToDisplay;
	public static int cellsToOpen;
	public static boolean lost = false;
	public static boolean searching = false; 	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter the sizes of the board(m x n):");
		// taking height 
		int height = scan.nextInt();
		// to dispose x 
		scan.next();
		// taking widht
		int widht = scan.nextInt();
		System.out.print("Please select the difficulty(E,M,H):");
		char difficulty = scan.next().charAt(0);
		scan.nextLine();		// hocaya sor! eğer buraya bu nextline ı koymazsam aşşağıda move u alırken sormadan hata veriyor
		createBoard(height, widht, difficulty);
		while(cellsToOpen != 0 && !lost){
			for(int a = 0; a < realBoard.length; a++){
				for(int b = 0; b < realBoard[a].length; b++){
					System.out.print(boardToDisplay[a][b] + "\t");
				}
				System.out.println(); 
			}
			
			System.out.print("Please make a move:");    // 2,2 F(U, )
			String move = scan.nextLine();
			if (move.contains("F") || move.contains("U"))
				makeMove(Integer.parseInt(move.substring(0, move.indexOf(","))), Integer.parseInt(move.substring(move.indexOf(",") + 1, move.indexOf(" "))), move.substring(move.indexOf(" ") + 1));
			else
				makeMove(Integer.parseInt(move.substring(0, move.indexOf(","))), Integer.parseInt(move.substring(move.indexOf(",") + 1, move.length())) ,"");        
		
		}
		if (cellsToOpen == 0){
			for(int a = 0; a < realBoard.length; a++){
				for(int b = 0; b < realBoard[a].length; b++){
					System.out.print(boardToDisplay[a][b] + "\t");
				}
			System.out.println(); 
			}
			System.out.println("Congratulations, you won.");
		}
	}
	
	public static void makeMove(int a, int b, String moveType){
	
		if (moveType.equals("F")){   // boardToDisplay.length - a][b - 1] finds the right cordinates a,b
			if(boardToDisplay[boardToDisplay.length - a][b - 1].equals("F"))  // checking if the cell is already flagged   
				System.out.println("The cell is already flagged.");		
			else if(!boardToDisplay[boardToDisplay.length - a][b - 1].equals("o"))   // checking if the cell is open
				System.out.println("Open cells cannot be flagged");
			else
				boardToDisplay[boardToDisplay.length - a][b - 1] = "F";		
		}
		else if (moveType.equals("U")){
			if(boardToDisplay[boardToDisplay.length - a][b - 1].equals("F"))    // checking if the cell is flagged
				boardToDisplay[boardToDisplay.length - a][b - 1] = "o";     
			else
				System.out.println("Only flagged cells can be unflagged");
		
		}
		else if (moveType.equals("")){
			if(boardToDisplay[boardToDisplay.length - a][b - 1].equals("F"))        // checking if the cell is F 
				System.out.println("Flagged cells cannot be opened");
			else if(!boardToDisplay[boardToDisplay.length - a][b - 1].equals("o") && !searching)  // checking if the cell is open
				System.out.println("Cell is already open");
			else if(realBoard[realBoard.length - a][b - 1].equals("X")){
				
				lost = true;
				for(int k =0; k < boardToDisplay.length; k++)
					for(int l = 0; l <boardToDisplay[k].length; l++)
						if(realBoard[k][l].equals("X"))
							boardToDisplay[k][l] = "X";
				for(int e = 0; e < realBoard.length; e++){
					for(int f = 0; f < realBoard[a].length; f++){
						System.out.print(boardToDisplay[e][f] + "\t");
					}
				System.out.println(); 
				}
				System.out.println("You lost, better luck next time.");
			}	
			else{
				if(realBoard[realBoard.length - a][b - 1].equals("0")){
					searching = true;    // searching = true because dont want to get "cell is already open warning"
					for(int s = realBoard.length - a - 1; s <= realBoard.length - a + 1; s++){
						for(int t = b - 2; t <= b; t++){ // from a-1,b-1 to a+1,b+1
							if(s >= 0 && s < realBoard.length && t >= 0 && t < realBoard[0].length) // if s,t is a valid point
								if(boardToDisplay[s][t].equals("o") && !realBoard[s][t].equals("X"))    //if that cell is not open and not mine
									if(realBoard[s][t].equals("0")){       // if that cell is 0
										boardToDisplay[s][t] = "-";
										cellsToOpen--;
										makeMove(realBoard.length - s, t + 1, "");
									}
									else{
										boardToDisplay[s][t] = realBoard[s][t];
										cellsToOpen--;
									}	 
						}
					}
				}
				else{
					boardToDisplay[boardToDisplay.length - a][b - 1] = realBoard[boardToDisplay.length - a][b - 1];
					cellsToOpen--;
					searching = false;
				}

			}
				 
		
		}
	
	}
	 
	public static void createBoard(int height, int widht, char difficulty){
		int mineCount = 0;
		realBoard = new String[height][widht];
		boardToDisplay = new String[height][widht];
		
		switch (difficulty){	// finding the mine count based on difficulty
			case 'E':
				mineCount = height * widht * 15 / 100;
				break;
			case 'M':
				mineCount = height * widht / 4;
				break;
			case 'H':
				mineCount = height * widht * 40 / 100;
				break;
			default:
				break;
		}
		Random rand = new Random();
		cellsToOpen = height * widht - mineCount;
		
		for(int i = 0; i < mineCount; i++){    // placing mines                                 3 4    5.      
			int randomNumber = rand.nextInt(height * widht) + 1;
			if(realBoard[(randomNumber - 1)  / widht][(randomNumber - 1) % widht] != null && realBoard[(randomNumber - 1)  / widht][(randomNumber - 1) % widht].equals("X"))  // realBoard[(randomNumber - 1)  / widht][(randomNumber - 1) % widht] finds n th cell
				i--;
			else{
				realBoard[(randomNumber - 1)  / widht][(randomNumber - 1) % widht] = "X";
			}
		}	
		for(int j = 0; j < height; j++){ // placing the numbers based on the mine count on their neighbor cells 
			for(int k = 0; k < widht; k++){
				if(realBoard[j][k] == null ){           // checking if there is a mine
					int neighborMineCount = 0;
					for(int l = j - 1; l <= j + 1; l++){       // for [a][b], scanning  [a-1][b-1] to [a+1][b+1]
						for(int m  = k - 1; m <= k +1; m++){
							if(l >= 0 && l < height && m >= 0 && m < widht){ // checking if [l][m] is a valid point
								if(realBoard[l][m] != null && realBoard[l][m].equals("X")) // if there is a mine adding 1 to neighborMineCount
									neighborMineCount++;
							
							}
						}
					}	
					realBoard[j][k] = "" + neighborMineCount; 
				}
			}	 
		}
		for(int n = 0; n < height; n++)		// creating boardToDisplay
			for(int o = 0; o < widht; o++)
				boardToDisplay[n][o] = "o";
	}

}
