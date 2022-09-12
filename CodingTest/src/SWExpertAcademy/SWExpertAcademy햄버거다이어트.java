package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWExpertAcademy햄버거다이어트 {
	static int N, L, max = Integer.MIN_VALUE;
	static int[][] arr;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			isSelected = new boolean[N];
			L = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken()); // 맛 점수
				arr[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
			}

			comb(0);
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void comb(int idx) {

		if (idx == N) {
			int flavor=0, calory=0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					flavor += arr[i][0];
					calory += arr[i][1];
				}
					
			}
			if (calory <= L) { // 칼로리 제한
				max = Math.max(max, flavor);
			}
			return;
		}
		// 원소 선택
		isSelected[idx] = true;
		comb(idx + 1);

		// 원소 미선택
		isSelected[idx] = false;
		comb(idx + 1);
	}

}
