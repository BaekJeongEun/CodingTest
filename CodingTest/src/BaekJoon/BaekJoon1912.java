package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int dp[] = new int[N];
		String line[] = br.readLine().split(" ");

		// 기저 상태 지정
		dp[0] = Integer.parseInt(line[0]);

		// 최대 연속값 미리 지정
		int max_val = dp[0];

		for (int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(line[i]);
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			max_val = Math.max(max_val, dp[i]);
		}
		System.out.println(max_val);
	}
}