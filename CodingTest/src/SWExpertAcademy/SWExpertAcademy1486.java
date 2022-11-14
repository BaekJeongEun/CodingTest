package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWExpertAcademy1486 { // 장훈이의 높은 선반

	static int N; // 점원의 수 N
	static int B; // 선반의 높이 B
	static int[] H; // 각 점원의 키 H
	static int gapMin; // 최소 차이 값을 저장할 변수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			gapMin = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			H = new int[N];
			for (int i = 0; i < N; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}
			// --------------Input End------------------

			// 조합 만들기
			combination(0, 0);
			// 부분집합 만들기
			makePowerSet();
			// dfs로 다 해보기
			dfs(0, 0);

			System.out.println("#" + tc + " " + gapMin);
		}

	}

	static void combination(int idx, int sum) {
		// 더한 높이가 선반의 높이보다 높고, 선반의 높이와의 차가 최소차보다 작다면 갱신
		if (sum >= B && sum - B < gapMin) {
			gapMin = sum - B;
			return;
		}

		// N번째 점원에 도달하면 return
		if (idx == N)
			return;

		// idx부터 N-1번째 점원까지 조합 만들기
		for (int i = idx; i < N; i++) {
			combination(i + 1, sum + H[i]);
		}
	}

	// 부분집합 만들기 (feat.비트마스킹)
	static void makePowerSet() {
		// 공집합을 제외한 1~N까지의 경우를 만들기.
		for (int i = 1; i < (1 << N); i++) {
			int sum = 0; // 탑의 높이만 관심 있으므로 sum 변수 선언.
			for (int j = 0; j < N; j++) {// 0~N-1번 점원 선택
				if ((i & (1 << j)) > 0) { // 선택된 점원이 선택된 집합에 속해 있는지 확인
					sum += H[j]; // 탑을 구성하고 있으므로 높이에 더하기.
					if (sum - B > gapMin) {// 선반과 탑의 높이를 비교해서 최솟값 보다 크면
						break;// 더 이상 지속할 필요 없으므로 부분집합 탈출
					}
				}
			}
			if (sum >= B && sum - B < gapMin) { // 최솟값 갱신
				gapMin = sum - B;
			}
		}

	}

	static void dfs(int idx, int sum) {
//			if(sum-B>=gapMin) return;  //백트래킹용 그러나 시간 차이 X
		if (idx == N) { // N번째 도달했으면
			if (sum >= B) { // 탑 높이 합이 선반보다 큰지 확인
				gapMin = Math.min(sum - B, gapMin); // 최솟값 갱신
			}
			return;
		}

		// 현재 점원 탑 높이에 참여
		dfs(idx + 1, sum + H[idx]);
		// 현재 점원 탑 높이에 미참여
		dfs(idx + 1, sum);
	}
}
