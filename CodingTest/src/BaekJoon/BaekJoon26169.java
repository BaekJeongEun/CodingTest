package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon26169 { // 세 번 이내에 사과를 먹자(S3)
	static boolean[][] visit;
	static int[][] arr, dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int answer;
	static final int N = 5;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		arr = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		dfs(r, c, 0, 0);
		System.out.println(answer);
	}

	private static void dfs(int x, int y, int move, int eat) {
		visit[x][y] = true;
		if (move <= 3 && eat >= 2) {
			answer = 1;
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny] || arr[nx][ny] == -1)
				continue;
			dfs(nx, ny, move + 1, (arr[nx][ny] == 1) ? eat + 1 : eat);
			visit[nx][ny] = false;
		}
	}

}
