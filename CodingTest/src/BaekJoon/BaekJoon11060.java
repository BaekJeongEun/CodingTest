package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon11060 { // 점프 점프 (S2)
	static int N, arr[], dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		dp = new int[N];
		Arrays.fill(dp, -1);
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = 0;
		for (int i = 0; i < N - 1; i++) {
			if (dp[i] == -1)
				continue;
			for (int j = 1; j < arr[i]; j++) {
				if (i + j < N) {
					if (dp[i + j] == -1 || dp[i + j] > dp[i] + 1) {
						dp[i + j] = dp[i] + 1;
					}
				}
			}
		}
	}

}
