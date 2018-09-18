//Steven Kast, kastsm
//CSE 274, Norm Krumpe

//The getBestMove method is pretty dumb in that it
//typically doesn't win. The dictionary sometimes breaks
//but it's not always. On my desktop it works fine but on my
//lap top is doesn't work. Generation of boards works every time


public class TicTacToe {

	private LinkedDictionary<Board, Integer> dict;
	private char[] chars = "XO-".toCharArray();
	private int len = 9;
	private Board b;

	//Constructs a TicTacToe object.
	public TicTacToe() {
		dict = new LinkedDictionary<Board, Integer>();

		b = new Board();
		generateMoves(chars, len, new char[len], 0);
		b = new Board();

		//Debugging
		//System.out.println("Total Generated: " + countOfBoards);
		//System.out.println("Dictionary Size: " + dict.getSize());
	}

	int countOfBoards = 1; // TODO: Remove

	// Generates all possible moves. It does so by treating the board as a
	// string
	// and finding all permeations of it using the characters 'O', 'X', and '-'.
	public void generateMoves(char[] chars, int len, char[] build, int pos) {
		if (pos == len) {
			String word = new String(build);
			b.setBoard(word);
			dict.add(b, getBestMove(word)); //Adding fails a lot
			//It doesn't work but I doesn't make sense to because the hashCode
			//Method for Board works fine.
			countOfBoards++;
			return; // Pull out of method
		}
		for (int i = 0; i < chars.length; i++) {
			build[pos] = chars[i];
			generateMoves(chars, len, build, pos + 1);
		}
	}// end generateMoves

	//Finds the best move for the current board.
	public int getBestMove(String board) {
		for (int i = 0; i < board.length(); i++) {
			if (board.charAt(i) == '-') {
				return i;
			}
		}

		return -1;
	}

	//Adds a move to the board when given a position as an int (0-8).
	public boolean playMove(int move) {
		if (move == -1) {
			int moveAI = dict.getValue(b); //Something definitely broke here
			b.move(moveAI, checkTurn(b));
			return true;
		}else if(b.toString().charAt(move) == '-' && checkTurn(b) == 'X'){
			b.move(move, checkTurn(b));
			return true;
		}
		return false;
	}

	//Displays the board in the console as a nice and pretty 3x3 grid.
	public String formatBoard() {
		String ret = "";
		String current = b.toString();

		for (int i = 0; i < current.length(); i++) {
			ret += current.charAt(i);
			if (i % 3 == 2 && i != 0) {
				ret += "\n";
			}
		}
		return ret;

	}
	
	//Determines who won the game.
	public char getWinner(){
		if(isOver()){
			if(checkTurn(b) == 'O'){
				return 'X';
			}else{
				return 'O';
			}
		}else{
			return '-';
		}
	}

	//Check to see if the game is over.
	public boolean isOver() {
		Character[][] board = b.getData();
		return (board[0][0] == board[0][1] && board[0][0] == board[0][2])
				|| (board[0][0] == board[1][1] && board[0][0] == board[2][2])
				|| (board[0][0] == board[1][0] && board[0][0] == board[2][0])
				|| (board[2][0] == board[2][1] && board[2][0] == board[2][2])
				|| (board[2][0] == board[1][1] && board[0][0] == board[0][2])
				|| (board[0][2] == board[1][2] && board[0][2] == board[2][2])
				|| (board[0][1] == board[1][1] && board[0][1] == board[2][1])
				|| (board[1][0] == board[1][1] && board[1][0] == board[1][2]);
	}

	//Checks to see who's turn it is and return that players character.
	private char checkTurn(Board board) {
		int xCount = 0;
		int oCount = 0;

		for (char element : board.toString().toCharArray()) {
			if (element == 'X') {
				xCount++;
			} else if (element == 'O') {
				oCount++;
			}
		}
		if (xCount > oCount) {
			return 'O';
		} else {
			return 'X';
		}
	}

}
