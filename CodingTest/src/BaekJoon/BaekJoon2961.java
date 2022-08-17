package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2961 { // 도영이가 만든 맛있는 음식 (S2)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()), min= Integer.MAX_VALUE;
		StringTokenizer st;
		int[][] arr = new int[N][2];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			arr[n][0] = Integer.parseInt(st.nextToken());
			arr[n][1] = Integer.parseInt(st.nextToken());
		}
		int cnt = 1 << N;
		for (int flag = 0; flag < cnt; flag++) {
			int sour = 1, bitter = 0;
			for (int i = 0; i < N; i++) {
				if ((flag & (1 << i)) != 0) { // i 원소가 부분집합에 포함
					sour *= arr[i][0];
					bitter += arr[i][1];
				}
			}
			if(bitter!=0)
				min = Math.min(min, Math.abs(sour - bitter));
		}
		System.out.println(min);
	}

}
