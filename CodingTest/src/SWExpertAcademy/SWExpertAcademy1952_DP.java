package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWExpertAcademy1952_DP {

	static int T, min, feeDay, feeMonth, fee3Month, feeYear;
	static int[] plan = new int[12];
	static int[] dp = new int[12];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 입력 => 변수 및 자료 구조
			st = new StringTokenizer(br.readLine());
			feeDay = Integer.parseInt(st.nextToken());
			feeMonth = Integer.parseInt(st.nextToken());
			fee3Month = Integer.parseInt(st.nextToken());
			feeYear = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			min = feeYear;
			dp[0] = 0;
			dp[1] = Math.min(plan[1]*feeDay, feeMonth); // 일 계산과 월 계산 중 비용이 적은 것 선택
			dp[2] = Math.min(dp[1]+plan[2]*feeDay, dp[1]+feeMonth); // 누적

			// dp[3]
			for(int i=3; i<=12; i++) {
				dp[i] = min(
							(dp[i-1] + plan[i]*feeDay),
							(dp[i-1] + plan[i]*feeDay),
							(dp[i-1] + plan[i]*feeDay)
						);
			}
			sb.append("#" + tc + " " + min + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int min(int a, int b, int c) {
		return Math.min(a, Math.min(c, b));
	}

}
