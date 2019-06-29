#include<stdio.h>
#include<stdbool.h>
#define N 8

void display(int sol[N][N]){
	printf("\nDisplaying:\n");
	int i = 0, j;
	for(; i < N; i++){
		printf("[");
		for(j = 0; j < N; j++)
			printf("%d ",sol[i][j]);
		printf("]\n");
	}
}

bool check(int sol[N][N], int x, int y){
	if(sol[x][y] == -1 && x >= 0 && x < N && y >= 0 && y < N)
		return true;
	return false;
}

bool tKUtil(int sol[N][N], int x, int y, int xmoves[N], int ymoves[N], int movenum){
	if(movenum == N*N)
		return true;
	
	int k = 0, new_x, new_y;
	for(; k < N; k++){
		new_x = x + xmoves[k];
		new_y = y + ymoves[k];
		
		if(check(sol, new_x, new_y)){
			sol[new_x][new_y] = movenum;
			if(tKUtil(sol, new_x, new_y, xmoves, ymoves, movenum + 1))
				return true;
			
			sol[new_x][new_y] = -1;
		}
	}
	
	return false;
}
		
	

void tK(){
	int sol[N][N];
	int i = 0, j = 0;
	
	for(; i < N; i++){
		for(j = 0; j < N; j++)
			sol[i][j] = -1;
	}
	
	//taking i,j th position as the first move
	int x,y;
	printf("\nEnter the starting coordinates: ");
	scanf("%d%d",&x,&y);
	sol[x][y] = 0;
	
	//set of x-moves and y-moves
	int xmoves[8] = {  2, 1, -1, -2, -2, -1,  1,  2 }; 
    int ymoves[8] = {  1, 2,  2,  1, -1, -2, -2, -1 };
	
	if(!tKUtil(sol, x, y, xmoves, ymoves, 1)){
		printf("Solution at (%d,%d) doesn't exist!",x,y);
		return;
	}
	
	display(sol);
}
	
	

int main()
{
	tK();
	
	return 0;
}