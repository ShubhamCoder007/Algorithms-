#include<stdio.h>
#include<stdbool.h>
#define N 4

void solveMaze(int[N][N]);

void display(int a[N][N]){
    int i = 0, j = 0;
    printf("\n\n");
    for(; i < N; i++){
        for(j = 0; j < N; j++)
            printf(" %d ",a[i][j]);
        printf("\n");
    }
}

bool isSafe(int maze[N][N], int row, int col){
    if(maze[row][col] == 1 && row < N && col < N)
        return true;
    return false;
}

bool solveMazeUtil(int maze[N][N], int row, int col, int sol[N][N]){
    if(row == N - 1 && col == N - 1 && maze[row][col] == 1){
        sol[row][col] = 1;
        return true;
    }

    if(isSafe(maze, row, col)){
        //include the decision in our solution
        sol[row][col] = 1;

        if(solveMazeUtil(maze, row, col + 1, sol))
            return true;
        if(solveMazeUtil(maze, row + 1, col, sol))
            return true;

        //if the above decision didn't work then backtrack and reset the decision taken
        sol[row][col] = 0;
        return false;
    }

    return false;
}

void moreSol(int maze[N][N], int sol[N][N]){
    int blockX = -1, blockY = -1;
    int i, j;
    for(i = 0; i < N; i++){
        for(j = 0; j < N; j++){
            if(i == 0 && j == 0)
                continue;

            if(sol[i][j] == 1){
                blockX = i;
                blockY = j;
                maze[i][j] = 0;
                printf("Blocking %d,%d\n",i,j);
                printf("Updated maze:\n");
                display(maze);
            }
            if(blockX != -1){
                printf("\nNow call solve again\n");
                solveMaze(maze[N][N]);
                maze[blockX][blockY] = 1;
                blockX = -1;
                blockY = -1;
            }
        }
    }
}

int** solveMaze(int maze[N][N]){
    printf("\nMaze Func\n");
    int sol[N][N] = { { 0, 0, 0, 0 },
                      { 0, 0, 0, 0 },
                      { 0, 0, 0, 0 },
                      { 0, 0, 0, 0 } };

    if(solveMazeUtil(maze, 0, 0, sol)){
        display(sol);
        return sol;
    }
    printf("No Sol Exists!");
}

int main()
{
    int maze[N][N] = { { 1, 1, 1, 1 },
                       { 1, 1, 0, 1 },
                       { 0, 1, 0, 1 },
                       { 1, 1, 1, 1 } };

    printf("Maze: \n");
    display(maze);
    solveMaze(maze);
    return 0;
}
