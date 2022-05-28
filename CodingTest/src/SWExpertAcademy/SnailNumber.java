package SWExpertAcademy;

import java.util.Scanner;

public class SnailNumber {
	static int n;
	static int arr[][];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc=0 ;tc<TC; tc++) {
			n = sc.nextInt();
			arr = new int[n][n];
			int direction = 0, num=1;
			int x=0,y=0;
			arr[x][y] = num++;
			while(num<=n*n) {
				int next_x = x+dx[direction];
				int next_y = y+dy[direction];
				if(next_x<n && next_y<n && next_x>=0 && next_y>=0 && arr[next_x][next_y]==0) {
					x = next_x;
					y = next_y;
					arr[x][y] = num++;
				}
				else
					direction = (direction+1 >= 4)?0:direction+1;
			}
			System.out.println("#"+(tc+1));
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(arr[i][j]+" ");
				}System.out.println();
			}
		}
	}
}