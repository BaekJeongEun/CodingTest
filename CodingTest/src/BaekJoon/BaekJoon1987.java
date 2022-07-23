package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1987 {
	static int R, C;
	static char[][] arr;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[] alphabet = new int[26];
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];

		for (int r = 0; r < R; r++) {
			char[] chars = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				arr[r][c] = chars[c];
			}
		}

		dfs(0, 0, 0);

		System.out.println(answer);
	}

	private static void dfs(int x, int y, int cnt) {
		if (alphabet[arr[x][y] - 65] == 1) {
			answer = Math.max(answer, cnt);
			return;
		}
		alphabet[arr[x][y] - 65] = 1;
		for (int i = 0; i < 4; i++) {
			int nextX = x + dir[i][0];
			int nextY = y + dir[i][1];

			if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C) {
				dfs(nextX, nextY, cnt + 1);
			}
		}
		alphabet[arr[x][y] - 65] = 0;

	}

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
