package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWExpertAcademy1952 {

	static int T, min, feeDay, feeMonth, fee3Month, feeYear;
	static int[] plan = new int[12];

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
			// 완탐 dfs
			// 1년치 제회한 3가지 사용료 방법을 모두 ㄸ지는 방식 진행, 각각 min 값 갱신
			min = feeYear;
			dfs(0, 0); // dfs() 끝나고 나면 min과 1년치 사용료와 비교해서 최소값 갱신

			sb.append("#" + tc + " " + min + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void dfs(int cnt, int sum) {
		// 기저 조건
		if (cnt >= 12) {
			min = Math.min(min, sum);
			return;
		}

		// 이용하지 않는 월에 대한 처리
		if (plan[cnt] == 0) {
			dfs(cnt + 1, sum);
		} else {

			// cnt + 1 번째 달에 대해
			// 1. 일 계산
			dfs(cnt + 1, sum + feeDay * plan[cnt]);
			// 2. 월 계산
			dfs(cnt + 1, sum + feeMonth);
			// 3. 3개월 계산
			dfs(cnt + 3, sum + fee3Month);
		}

	}

}
