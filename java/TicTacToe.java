/** Title: TicTacToe.java
 * 
 * 	Abstract: this program try is a tictactoe game where the computer 
 * 				gets its moves based on blocking the user or winning
 * 
 * 	Author: Stephan Dubuke
 * 
 * 	ID: 0484
 * 
 * 	Date: 09-9-15
 * 
 * 
 */
package tictactoe.java;

import java.util.Scanner;

public class TicTacToe {
	
		public static Scanner keyboard = new Scanner(System.in);
		public static void main(String[] args)
		{
		int userPick;
		boolean endOfGame = false;
		int userTurn = 0;
		int computer = -1;
		int user = 0;
		String goFirst= " ";
		int [] board = new int [10];
		/*int solution [8][3] =  {{1,2,3},
								{4,5,6},
								{7,8,9},
								{1,3,7},
								{2,5,8},
								{3,6,9},
								{1,5,9},
								{3,5,7}};
								*/
		
		System.out.println("==== Welcome to Tic-Tac-Toe Game ===");
		System.out.println();
		System.out.print("Do you want to start first? (Y/N) ");
		// getting who wants to go first
		goFirst = keyboard.nextLine();
		if(goFirst.equalsIgnoreCase("Y"))
		{
			System.out.println("OK! Your character is X "
					+ "and computer character is O");
			user = 0;
			computer = -1;
			userTurn = 0;
		}
			else if(goFirst.equalsIgnoreCase("N"))
		{
			System.out.println("OK! Your character is O"
					+ " and computer character is X");
			user = -1;
			computer = 0;
			userTurn = -1;
		}
		// sets the board equal to the numbers
		for(int i = 1; i < 10; i++)
		{
			board [i] = i;
		}
		printBoard(board);
		while(endOfGame != true)
		{
			// starts the game untill the game is over
			if(userTurn == 0)
			{
			System.out.println();
			System.out.print("Pick your spot: ");
			userPick = keyboard.nextInt();
			for(int i = 1; i < 10; i++)
			{
				if(board[userPick] == 0 || 
						board[userPick] == -1 )
				{
					System.out.println("this number has already"
							+ " been picked.");
					break;
			}
			}
			board = replaceNumber(board, userPick, user);
			printBoard(board);
			userTurn = -1;
			endOfGame = gameWon(board);
			}
			else{
			System.out.println();
			System.out.print("OK! Computer picks: ");
			int computerPick = computerPicks(board);
			System.out.println(computerPick );
			board = replaceNumber(board, computerPick, computer);
			printBoard(board);
			userTurn = 0;
			endOfGame = gameWon(board);
			}
			
		}
		System.out.println();
		if(userTurn == -1)
			System.out.println("You Won!!");
		else
			System.out.println("computer Won!");
		}
		
		
		public static void printBoard(int [] printBoard)
		{
			// Function for printing out the board
		     System.out.println("-----------");
			for(int i = 1; i < 4; i ++)
			{
				if(printBoard[i] != 0 && printBoard[i] != -1)
				System.out.print("| " + printBoard[i]  + " ");
				else{
					System.out.print("| " + getXO(printBoard[i]) + " ");
				}
			}
			System.out.print("|");
			System.out.println();
		     System.out.println("-----------");
		     for(int i = 4; i < 7 ; i ++)
				{
		    	 if(printBoard[i] != 0 && printBoard[i] != -1)
						System.out.print("| " + printBoard[i]  + " ");
						else{
							System.out.print("| " + getXO(printBoard[i]) + " ");
						}
				}
		     System.out.print("|");
		     System.out.println();
		     System.out.println("-----------");
		     for(int i = 7; i < 10 ; i ++)
				{
		    	 if(printBoard[i] != 0 && printBoard[i] != -1)
						System.out.print("| " + printBoard[i]  + " ");
						else{
							System.out.print("| " + getXO(printBoard[i]) + " ");
						}
				}
		     System.out.print("|");
		}
		
	static int[] replaceNumber(int [] replaceNumber, int number, int turn)
	{
		// this function replaces the number in the board with an x
		//or and O
		for(int i = 1; i < 10; i++)
		{
			if(usersTurn(turn) == 0){
			if(replaceNumber[i] == number)
			{
				
				replaceNumber[i] = 0;
				return replaceNumber;
			}
			}
			else{
				replaceNumber[number] = -1;
				return replaceNumber;
			}
				
		}
		return replaceNumber;
	}
	
	static String getXO(int number)
	{
		// this function get the x's and O's for the board
		if(number == 0){
		return "X";
		}
		else if(number == -1)
			return "O";
		return " ";
	}
	static int usersTurn(int turn)
	{
		// this function helps to find and wtich the users turn
		if(turn == 0){
		return 0;
		}
		return -1;
	}
	public static int computerPicks( int [] numberList)
	{
		int compPick = 5;
		for(int i = 1; i < 10; i++)
		{
		 if(numberList[i] == 0 || numberList[i] == -1)
		 {
			 compPick = bestMove(numberList);
				 return compPick;
		 }
		}
		
		
		return compPick;
	}
	
	
	public static int bestMove(int [] numberList )
	{
		// this functions finds the best move for the computer
		int bestMove = 5;
		if(numberList[5] == 0 || numberList[5] == -1)
		{
			bestMove = 1;
			if(numberList[1] == 0 || numberList[1] == -1)
			{
				bestMove = 3;
				if(numberList[3] == 0 || numberList[3] == -1)
				{
					bestMove = 7;
					if(numberList[7] == 0 || numberList[7] == -1)
					{
						bestMove = 9;
					}
				}
			}
		}
		
		for(int i = 1; i < 10; i++)
		{
			
			if(numberList[1] == 0 && numberList[2] == 0 
					|| numberList[1] == -1 && numberList[2] == -1 )
			{
				if(numberList[3] == 0 || numberList[3] == -1)
				{
					bestMove = getFirst(numberList);
				}
				bestMove = 3;
			}
			if((numberList[4] == 0 && numberList[5] == 0)
					|| (numberList[4] == -1 && numberList[5] == -1 ))
			{
				if(numberList[6] == 0 || numberList[6] == -1)
				{
					bestMove = getFirst(numberList);
				}
				bestMove = 6;
			}
			if(numberList[7] == 0 && numberList[8] == 0
					|| numberList[7] == -1 && numberList[8] == -1 )
			{
				if(numberList[9] == 0 || numberList[9] == -1)
				{
					bestMove = getFirst(numberList);
				}
				bestMove = 9;
			}
			if(numberList[1] == 0 && numberList[4] == 0
					|| numberList[1] == -1 && numberList[4] == -1 )
			{
				if(numberList[7] == 0 || numberList[7] == -1)
				{
					bestMove = getFirst(numberList);
				}
				bestMove = 7;
			}
			if(numberList[2] == 0 && numberList[5] == 0
					|| numberList[2] == -1 && numberList[5] == -1 )
			{
				if(numberList[8] == 0 || numberList[8] == -1)
				{
					bestMove = getFirst(numberList);
				}
				bestMove = 8;
			}
			if(numberList[3] == 0 && numberList[6] == 0
					|| numberList[3] == -1 && numberList[6] == -1 )
			{
				if(numberList[9] == 0 || numberList[9] == -1)
				{
					bestMove = getFirst(numberList);
				}
				bestMove = 9;
			}
			if(numberList[1] == 0 && numberList[5] == 0
					|| numberList[1] == -1 && numberList[5] == -1 )
			{
				if(numberList[9] == 0 || numberList[9] == -1)
				{
					bestMove = getFirst(numberList);
				}
				bestMove = 9;
			}
			if(numberList[3] == 0 && numberList[5] == 0
					|| numberList[3] == -1 && numberList[5] == -1 )
			{
				if(numberList[7] == 0 || numberList[7] == -1)
				{
					bestMove = getFirst(numberList);
				}
				bestMove = 7;
			}
			if(numberList[1] == 0 && numberList[7] == 0
					|| numberList[1] == -1 && numberList[7] == -1 )
			{
				if(numberList[4] == 0 || numberList[4] == -1)
				{
					bestMove = getFirst(numberList);
				}
				bestMove = 4;
			}
			if(numberList[2] == 0 && numberList[8] == 0
					|| numberList[2] == -1 && numberList[8] == -1 )
			{
				if(numberList[4] == 0 || numberList[4] == -1)
				{
					bestMove = getFirst(numberList);
				}
				bestMove = 4;
			}
			if(numberList[3] == 0 && numberList[9] == 0
					|| numberList[3] == -1 && numberList[9] == -1 )
			{
				if(numberList[6] == 0 || numberList[6] == -1)
				{
					bestMove = getFirst(numberList);
				}
				bestMove = 6;
			}
			if(numberList[9] == 0 && numberList[6] == 0
					|| numberList[9] == -1 && numberList[6] == -1 )
			{
				if(numberList[3] == 0 || numberList[3] == -1)
				{
					bestMove = getFirst(numberList);
				}
				bestMove = 3;
			}
			if(numberList[8] == 0 && numberList[5] == 0
					|| numberList[8] == -1 && numberList[5] == -1 )
			{
				if(numberList[2] == 0 || numberList[2] == -1)
				{
					bestMove = getFirst(numberList);
				}
				bestMove = 2;
			}
			
			if(numberList[7] == 0 && numberList[4] == 0
					|| numberList[7] == -1 && numberList[4] == -1 )
			{
				if(numberList[1] == 0 || numberList[1] == -1)
				{
					bestMove = getFirst(numberList);
				}
				bestMove = 1;
			}
			if(numberList[9] == 0 && numberList[5] == 0
					|| numberList[9] == -1 && numberList[5] == -1 )
			{
				if(numberList[1] == 0 || numberList[1] == -1)
				{
					bestMove = getFirst(numberList);
				}
				bestMove = 1;
			}
			if(numberList[7] == 0 && numberList[3] == 0
					|| numberList[7] == -1 && numberList[3] == -1 )
			{
				if(numberList[4] == 0 || numberList[4] == -1)
				{
					bestMove = getFirst(numberList);
				}
				bestMove = 4;
			}
			if(numberList[1] == 0 && numberList[9] == 0
					|| numberList[1] == -1 && numberList[9] == -1 )
			{
				if(numberList[5] == 0 || numberList[5] == -1)
				{
					bestMove = getFirst(numberList);
				}
				bestMove = 5;
			}
		}
		return bestMove;
}
	public static int getFirst(int [] numberList)
	{
		int first = 1; 
		for(int i = 1; i < 10; i++)
		{
			if(numberList[i] != 0 || numberList[i] != -1 )
			{
				first = i;
			}
		}
		return first;
	}
	public static boolean gameWon( int [] numberList)
	{
		for(int i = 1; i < 10; i++)
		{
			if(numberList[1] == 0 && numberList[2] == 0
					&& numberList[3] == 0 || numberList[1] == -1
					&& numberList[2] == -1 && numberList[3] == -1)
				return true;
			else if(numberList[4] == 0 && numberList[5] == 0
					&& numberList[6] == 0 || numberList[4] == -1
					&& numberList[5] == -1 && numberList[6] == -1)
				return true;
			else if(numberList[7] == 0 && numberList[8] == 0
					&& numberList[9] == 0 || numberList[7] == -1
					&& numberList[8] == -1 && numberList[9] == -1)
				return true;
			else if(numberList[1] == 0 && numberList[4] == 0
					&& numberList[7] == 0 || numberList[1] == -1
					&& numberList[4] == -1 && numberList[7] == -1)
				return true;
			else if(numberList[2] == 0 && numberList[5] == 0
					&& numberList[8] == 0 || numberList[2] == -1
					&& numberList[5] == -1 && numberList[8] == -1)
				return true;
			else if(numberList[3] == 0 && numberList[6] == 0
					&& numberList[9] == 0 || numberList[3] == -1
					&& numberList[6] == -1 && numberList[9] == -1)
				return true;
			else if(numberList[1] == 0 && numberList[5] == 0
					&& numberList[9] == 0 || numberList[1] == -1
					&& numberList[5] == -1 && numberList[9] == -1)
				return true;
			else if(numberList[3] == 0 && numberList[5] == 0
					&& numberList[7] == 0 || numberList[3] == -1
					&& numberList[5] == -1 && numberList[7] == -1)
				return true;
		}
		return false;
	}
}