package backtrack;

public class NQueen {

	final static int N = 4;
	
	public static boolean isSafe(int[][] board, int row, int col) {
		if(row < N && col < N && row >= 0 && col >= 0)
				return !checkAttack(board, row, col);
		return false;
	}
	
	private static boolean checkAttack(int[][] board, int row, int col) {
		if(row == 0 && col == 0)
			return false;
		
		for(int i = 1; i < N; i++) {
			if(row - i >= 0 && col - i >= 0) {
				if(board[row-i][col-i] == 1)
					return true;
			}
			if(row - i >= 0 && col + i < N) {
				if(board[row-i][col+i] == 1)
					return true;
			}
			if(row - i >= 0 && col < N) {
				if(board[row-i][col] == 1)
					return true;
			}
			if(row < N && col - i >= 0) {
				if(board[row][col-i] == 1)
					return true;
			}
		}
		return false;
	}

	public static boolean nQueenUtil(int[][] board, int row, int moves) {
		if(moves == N)
			return true;
		
			for(int i = 0; i < N; i++) {
				if(isSafe(board, row, i)) {
					board[row][i] = 1; 
					//System.out.printf("\ntaking coordinate %d,%d",row,i);
					if(nQueenUtil(board, row + 1, moves + 1))
						return true;
			}
			board[row][i] = 0;
			//System.out.printf("\nreverting coordinate %d,%d",row,i);
		}
		
		return false;
	}
	
	public static void nQueen() {
		int[][] board = new int[N][N];
		
		if(nQueenUtil(board, 0, 0)) {
			display(board);
			return;
		}
		
		System.out.println("No Solutions could be found!");
	}
	
	private static void display(int[][] board) {
		System.out.println("Displaying:\n");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				System.out.print(board[i][j]+"  ");
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		
		nQueen();

	}

}
