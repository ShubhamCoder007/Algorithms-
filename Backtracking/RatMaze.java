class RatMaze
{
	public static int N = 4;
	
	public static boolean isSafe(int[][] maze, int x, int y){
		if(x < N && x >= 0 && y < N && y >= 0 && maze[x][y] == 1)
			return true;
		return false;
	}
	
	public static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol){
		if(x == 3 && y == 3){
			sol[x][y] = 1;
			return true;
		}
		if(isSafe(maze, x, y)){
			sol[x][y] = 1;
			if(solveMazeUtil(maze, x + 1, y, sol))
				return true;
			if(solveMazeUtil(maze, x, y + 1, sol))
				return true;
			sol[x][y] = 0;
			return false;
		}
		return false;
	}
	
	public static void solveMaze(int[][] maze){
		int[][] sol = new int[N][N];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++)
				sol[i][j] = 0;
		}
						
		if(solveMazeUtil(maze, 0, 0, sol)){
			display(sol);
			return;
		}
		System.out.println("No solutions exist!");
	}
	
	public static void display(int[][] a){
		for(int[] b : a){
			for(int c : b)
				System.out.print(c+" ");
			System.out.println();
		}
		System.out.println("\n");
	}
		
	public static void main(String[] args)
	{
		int[][] maze = new int[N][N];
		String s = "1000110101001111";
		
		int k = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(s.charAt(k) == '1'){
					maze[i][j] = 1;
					k++;
					continue;
				}
				maze[i][j] = 0;
				k++;
			}
		}
		
		display(maze);
						
		solveMaze(maze);
	}
}