package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon1749 { // 점수따먹기 (G4)

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][M+1];
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				arr[i][j] = arr[i][j-1] + arr[i-1][j] - arr[i-1][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= N; i++) {
	        for (int j = 1; j <= M; j++) {
	            for (int k = i; k <= N; k++) {
	                for (int l = j; l <= M; l++) {
	                    int sum = arr[k][l] - arr[i-1][l] - arr[k][j-1] + arr[i - 1][j - 1];
	                    if (max < sum) max = sum;
	                }
	            }
	        }
	    }
		System.out.println(max);
	}

}
