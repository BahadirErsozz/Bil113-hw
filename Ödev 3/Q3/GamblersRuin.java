import java.util.Scanner;
import java.util.Random;

public class GamblersRuin {


	public static void main(String[] args){
	
		double probabiltyOfWinning;
		int timesSimulated, i = 0, winCount = 0,  loseCount = 0, initialMoney, goalMoney, inGameMoney;
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
	
		System.out.print("Initial money:");
		initialMoney = scan.nextInt();
		
		System.out.print("Goal:");
		goalMoney = scan.nextInt();
		
		System.out.print("Probability of winning in a round:");
		probabiltyOfWinning = scan.nextDouble();
		
		System.out.print("Number of times the game will be simulated:");
		timesSimulated = scan.nextInt();
		
		//playing the game timeSimulated times
		while (i < timesSimulated){
			inGameMoney = initialMoney;
			while (inGameMoney < goalMoney && inGameMoney != 0){
				double sonuc = rand.nextDouble();
				if (probabiltyOfWinning > sonuc) 
					inGameMoney++;
							
				else 
					inGameMoney--;					
			}
			if (inGameMoney == goalMoney){
				winCount++;
			}
			else if (inGameMoney == 0){
				loseCount++;
			}
			i++;
		}
				
		System.out.println("Win:" + winCount);
		System.out.println("Lose:" + loseCount);
	}






}
