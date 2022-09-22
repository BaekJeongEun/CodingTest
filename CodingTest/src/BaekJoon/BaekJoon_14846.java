package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon_14846 { // 직사각형과 쿼리 (G4)

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()), x1, y1, x2, y2;
		int[][] arr = new int[N + 1][N + 1];
		int[][][] dp = new int[N + 1][N + 1][11];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= 10; k++) {
					dp[i][j][k] = dp[i][j - 1][k] + dp[i - 1][j][k] - dp[i - 1][j - 1][k];
				}
				dp[i][j][arr[i][j]]++;
			}
		}
		int Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			int[] tmp = new int[11];

			for (int t = 1; t <= 10; t++) 
				tmp[t] = dp[x2][y2][t];
			
			for (int t = 1; t <= 10; t++) {
				tmp[t] += dp[x1-1][y1-1][t];
				tmp[t] -= dp[x1-1][y2][t];
				tmp[t] -= dp[x2][y1-1][t];
			}
			int sum = 0;
			for (int t = 1; t <= 10; t++) 
				if(tmp[t] > 0) sum++;
			
			sb.append(sum + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
