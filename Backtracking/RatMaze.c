#include<stdio.h>
#include<stdbool.h>

bool isSafe(int maze[4][4], int x, int y){
	if(maze[x][y] == 1 && x < 4 && x >= 0 && y < 4 && y >= 0)
		return true;
	return false;
}

bool solveMazeUtil(int maze[4][4], int x, int y, int sol[4][4]){
	if(x == 3 && y == 3){
		sol[x][y] = 1;
		return true;
	}
	
	if(isSafe(maze, x, y)){
		sol[x][y] = 1;
		if(solveMazeUtil(maze, x + 1, y, sol))	
			return true;
		if(solveMazeUtil(maze, x , y + 1, sol))
			return true;
		
		sol[x][y] = 0;
		return false;
	}
	return false;
}

void display(int sol[4][4]){
	int i = 0, j = 0;
	for(; i < 4; i++){
		for(; j < 4; j++)
			printf("%d ",sol[i][j]);
		printf("\n");
	}
}
	

bool solveMaze(int maze[4][4]){
	int sol[4][4] = 	{{0,0,0,0},
						{0,0,0,0},
						{0,0,0,0},
						{0,0,0,0}};
						
	if(solveMazeUtil(maze, 0, 0, sol)){
		display(sol);
		return true;
	}
	printf("No Solutions exist!");
	return false;
}


int main()
{
	int maze[4][4] = 	{{1,0,0,0},
						{1,1,0,1},
						{0,1,0,0},
						{1,1,1,1}};
						
	solveMaze(maze);
						
	return 0;
}