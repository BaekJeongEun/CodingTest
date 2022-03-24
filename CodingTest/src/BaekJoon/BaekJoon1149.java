package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1149 {
	static int N, arr[][], dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		dp = new int[N][3];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		
		int temp1 = rec(N-1,0);
		int temp2 = rec(N-1,1);
		int temp3 = rec(N-1,2);
		System.out.print(Math.min(temp1, Math.min(temp2, temp3)));
		
	}
	private static int rec(int x, int choice) {
		if(dp[x][choice]==0) {
			if(choice == 0) {
				dp[x][0] = Math.min(rec(x-1,1), rec(x-1,2))+arr[x][0];
			}
			else if(choice == 1) {
				dp[x][1] = Math.min(rec(x-1,2), rec(x-1,0))+arr[x][1];
			}
			else{
				dp[x][2] = Math.min(rec(x-1,1), rec(x-1,0))+arr[x][2];
			}
		}
		return dp[x][choice];
	}
}
