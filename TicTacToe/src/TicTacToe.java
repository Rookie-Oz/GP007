import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> botPositions = new ArrayList<Integer>();
	static Scanner sc = new Scanner(System.in);
	
	
	public static void printGameBoard(char[][] gameBoard){
		for(char[] row : gameBoard) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void enterPos(char[][] gameBoard, int pos, String user) {
		char symbol =' ';
		if(user.equals("player")) {
			symbol='X';
			playerPositions.add(pos);
		} else if(user.equals("bot")) {
			symbol='O';
			botPositions.add(pos);
		}
		
		switch(pos) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;
		default:
			break;
		}
		//printGameBoard(gameBoard);
	}
	
	public static String checkWinner() {
		List topRow =	 Arrays.asList(1,2,3);
		List midRow =	 Arrays.asList(4,5,6);
		List botRow =	 Arrays.asList(7,8,9);
		List leftCol =	 Arrays.asList(1,4,7);
		List midCol = 	 Arrays.asList(2,5,8);
		List rightCol =	 Arrays.asList(3,6,9);
		List cross1 =	 Arrays.asList(1,5,9);
		List cross2 = 	 Arrays.asList(7,5,3);
		
		ArrayList<List> win = new ArrayList<List>();
		win.add(topRow);
		win.add(midRow);
		win.add(botRow);
		win.add(leftCol);
		win.add(midCol);
		win.add(rightCol);
		win.add(cross1);
		win.add(cross2);
		
		for(List l : win) {
			if(playerPositions.containsAll(l)) {
				return("Congratulations! You Won :D");
			} else if(botPositions.containsAll(l)) {
				return("Sorry, You Lost :(");
			} else if(playerPositions.size() + botPositions.size() == 9) {
				return("Whoops! Board Full :|");
			}
		}
		return "";
	}
	
//<-----------------------------------------------Main Function---------------------------------------------->
	public static void main(String[] args) {
		
		char[][] gameBoard = {{' ','|',' ','|',' '},
							  {'-','+','-','+','-'},
						      {' ','|',' ','|',' '},
							  {'-','+','-','+','-'},
							  {' ','|',' ','|',' '}};
		printGameBoard(gameBoard);
		while(true) {	
			System.out.println("Enter Your Position (1-9)");
			int playerPos = sc.nextInt();
			while(playerPositions.contains(playerPos) || botPositions.contains(playerPos)) {
				System.out.println("Position Taken, Enter a new Number");
				playerPos = sc.nextInt();
			}
			enterPos(gameBoard, playerPos, "player");
			
			Random rand = new Random();
			int botPos = rand.nextInt(9)+1;
			while(botPositions.contains(botPos) || playerPositions.contains(botPos)) {
				botPos = rand.nextInt(9)+1;
			}
			enterPos(gameBoard, botPos, "bot");
			
			System.out.println("\n");
			
			printGameBoard(gameBoard);
			String result = checkWinner();
			if(result.length() > 0) {
				System.out.println(result);
				break;
			}
			
		}
		
	}

}
