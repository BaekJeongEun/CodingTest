package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11724 {
	static int arr[][], N, cnt;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점 개수
		int M = Integer.parseInt(st.nextToken()); // 간선 개수
		arr = new int[N + 1][N + 1];
		visited = new boolean[N+1];
		for (int tc = 0; tc < M; tc++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			arr[i][j] = 1;
			arr[j][i] = 1;
		}
		for (int i = 1; i < N+1; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;
			}

		}
		System.out.println(cnt);
	}

	static void dfs(int i) {
		visited[i] = true;
		for (int k = 1; k <= N; k++) {
			if (arr[i][k] == 1 && !visited[k])
				dfs(k);
		}
	}
}