package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11558 { // The Game of Death(S4)
	static int N, point[];
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine()); // 총 인원
			point = new int[N+1];
			visited = new boolean[N+1]; // 사이클 방지
			
			for (int j = 1; j <= N; j++) {
				point[j] = Integer.parseInt(br.readLine());
			}
			
			int target = 1;
			int cnt = 0;
			while (!visited[target] && target != N) {
				visited[target] = true;
				target = point[target];
				cnt++;
			}
			
			if(target == N) {
				System.out.println(cnt);
			} else {
				System.out.println(0);
			}

		}

	}

}
