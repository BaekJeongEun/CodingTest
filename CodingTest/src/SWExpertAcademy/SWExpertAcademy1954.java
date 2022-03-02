package SWExpertAcademy;

import java.util.Scanner;

public class SWExpertAcademy1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			arr[0][0] = 1;
			
			int x = 0, y = 0;
			int num = 1, step = n-1;
			
			while(true) {
				if(num == n*n) break;
				if(num==1) {
					for (int i =0; i < step; i++)
						arr[x][++y] = ++num;
				} 
				for (int i = 0; i < step; i++)
					arr[++x][y] = ++num;
				for (int i = 0; i < step; i++)
					arr[x][--y] = ++num;
				step--;
				for (int i = 0; i < step; i++)
					arr[--x][y] = ++num;
				for (int i =0; i < step; i++)
					arr[x][++y] = ++num;
				step--;
			}
			System.out.println("#" + tc);
			for (int[] is : arr) {
				for (int i : is) {
					System.out.print(i + " ");
				}
				System.out.println();
			}

		}
		sc.close();
	}
}