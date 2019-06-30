#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<stdbool.h>
#define N 8

void delay(int number_of_seconds) 
{ 
    // Converting time into milli_seconds 
    int milli_seconds = 1000 * number_of_seconds; 
  
    // Stroing start time 
    clock_t start_time = clock(); 
  
    // looping till required time is not acheived 
    while (clock() < start_time + milli_seconds); 
}


void display(int a[N][N]){
	int i = 0, j;
	printf("\nDisplaying:\n");
	for(; i < N; i++){
		for(j = 0; j < N; j++)
			printf("%d ",a[i][j]);
		printf("\n");
	}
}
	
bool rowColCheck(int a[N][N], int row, int col){
	int i, j;
 
    /* Check this row on left side */
    for (i = 0; i < row; i++)
        if (a[i][col])
            return false;
		
	for (i = 0; i < col; i++)
        if (a[row][i])
            return false;
 
    /* Check upper diagonal on left side */
    for (i=row, j=col; i>=0 && j>=0; i--, j--)
        if (a[i][j])
            return false;
		
	for (i=row, j=col; i>=0 && j<N; i--, j++)
        if (a[i][j])
            return false;
 
    /* Check lower diagonal on left side */
    for (i=row, j=col; j>=0 && i<N; i++, j--)
        if (a[i][j])
            return false;
		
	for (i=row, j=col; j<N && i<N; i++, j++)
        if (a[i][j])
            return false;
		
 
    return true;
}
	

bool check(int a[N][N], int x, int y){
	if(x >= 0 && x < N && y >= 0 && y < N && a[x][y] == 0)
		return rowColCheck(a, x, y);
	return false;
}

bool nQueenUtil(int sol[N][N], int x, int y, int queen_num){
	
	int i = 0;
	
	if(queen_num == N + 1)
		return true;
	
		for(i = 0; i < N; i++){

			if(check(sol, x, y + i)){
				
				//printf("\nComputing for (%d,%d)\n",x,y+i);
				//display(sol);
				
				sol[x][y + i] = 1;
				
				if(nQueenUtil(sol, x + 1, 0, queen_num + 1))
					return true;

				sol[x][y + i] = 0;
			}
		}
	return false;
}


void nQueen(){
	time_t start, end;
	int sol[N][N] =  {{0,0,0,0,0,0,0,0},
					  {0,0,0,0,0,0,0,0},
					  {0,0,0,0,0,0,0,0},
					  {0,0,0,0,0,0,0,0},
					  {0,0,0,0,0,0,0,0},
					  {0,0,0,0,0,0,0,0},
					  {0,0,0,0,0,0,0,0},
					  {0,0,0,0,0,0,0,0}};
					  
	start = time(NULL);
	
	if(!nQueenUtil(sol, 0, 0, 1)){
		printf("\nNo solutions exists!");
		return;
	}
	
	end = time(NULL);
	
	printf("\n\nHere's the solution: \ntime taken: %ld seconds\n",end-start);
	display(sol);
	delay(3);
}

int main()
{	
	nQueen();
	
	return 0;
}