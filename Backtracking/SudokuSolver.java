package backtrack;

public class Sudoku {

	final static int N = 9;
	final static int sub = (int) Math.sqrt(N);
	
	public static boolean isSafe(int[][] board, int row, int col, int rowS, int colS, int digit) {
		if(row < rowS + sub && col < colS + sub && row >= 0 && col >= 0) {
			for(int i = rowS; i < rowS + sub; i++) {
				for(int j = colS; j < colS + sub; j++) {
					if(i == row && j == col)
						continue;
					if(board[i][j] == digit)
						return false;
				}
			}
		}
		return true;
	}
	
	public static boolean solveSub(int[][] board, int row, int col, int rowS, int colS) {
		if(row >= N-1 && col >= N-1)
			return true;
		
		if(row >= rowS + sub-1 && col >= colS + sub-1)
			return true;
		
		if(row != rowS + sub && col == colS + sub) {
			row = row + 1;
			col = colS;
		}
		
		if(board[row][col] != 0)
			solveSub(board, row, col + 1, rowS, colS);
				
		for(int k = 1; k <= 9; k++) {
			if(isSafe(board, row, col, rowS, colS, k)) {
				board[row][col] = k;
						
				if(solveSub(board, row, col + 1, rowS, colS))
					return true;
						
				board[row][col] = -1;
			}
		}
			
		return false;
				
	}

	
	public static void solve(int[][] board) {
		for(int i = 0; i < N; i+=sub) {
			for(int j = 0; j < N; j+=sub) {
				
				if(!solveSub(board, i, j, i, j))
					return;
				
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] board = new int[][] 
			    { 
			            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
			            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
			            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
			            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
			            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
			            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
			            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
			            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
			            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
			    }; 
		
		solve(board);
		
		display(board);
	}

	private static void display(int[][] board) {
		for(int[] a : board) {
			for(int i : a)
				System.out.print(i+" ");
			System.out.println();
		}
		
	}

}
