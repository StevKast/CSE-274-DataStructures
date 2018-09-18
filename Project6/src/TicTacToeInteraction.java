
//Steven Kast, kastsm
//CSE 274, Norm Krumpe

import java.util.Scanner;

public class TicTacToeInteraction {

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		Scanner in = new Scanner(System.in);

		while (game.isOver()) {
			System.out.println(game.formatBoard());
			System.out.println("Please enter a move (0-8): ");
			int humanMove = Integer.parseInt(in.next());
			game.playMove(humanMove);
			game.playMove(-1); //AI Move
		}
		
		System.out.println("Game over! " + game.getWinner() + " wins!");
		
		System.out.println("Done.");

	}
}
