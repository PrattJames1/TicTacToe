import java.util.Scanner;

public class TicTacToe {
	public static char[][] board = new char[3][3];
	public static int col, row;
	public static boolean playing;
	public static Scanner scan = new Scanner(System.in);
	public static char turn = 'X';
	
	public static void main(String args[]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '_';
			}
		}	
		play();
	}

	public static void play() {
		boolean playing = true;
		while (playing) {
			System.out.println("Please enter a row and column: ");
			row = scan.nextInt() - 1;
			col = scan.nextInt() - 1;
			board[row][col] = turn;

			if (GameOver(row,col)) {
				playing = false;
				System.out.println("Game over! Player " + turn + " wins!");
			}

			printBoard();
			if (turn == 'X') {
				turn = 'O';
			}
			else
				turn = 'X';
		}
	}

	public static boolean GameOver(int rMove, int cMove) {
		// Horizontal and Vertical checks
		if (board[0][cMove] == board[1][cMove] && board[0][cMove] == board[2][cMove])
			return true;
		if (board[rMove][0] == board[rMove][1] && board[rMove][0] == board[rMove][2])
			return true;
		// Diagonal checks
		if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board [1][1] != '_')
			return true;
		if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board [1][1] != '_')
			return true;
		else 
			return false;
	}

	public static void printBoard() {
		for (int i = 0; i < 3; i++) {
			System.out.println();
			for (int j = 0; j < 3; j++) {
				if (j == 0){
					System.out.print("| ");
				}
				System.out.print(board[i][j] + " | ");
			}
		}
		System.out.println();
	}
}