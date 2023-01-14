package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon14442 { // 벽 부수고 이동하기 2 (G3)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Point> q = new ArrayDeque<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int[][][] visit = new int[N][M][K + 1];
		int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j] = temp[j] - 48;
			}
		}
		q.offer(new Point(0, 0, 0));
		visit[0][0][0] = 1;
		while (!q.isEmpty()) {
			Point now = q.poll();
			int x = now.x;
			int y = now.y;
			int k = now.k;
			if (x == N - 1 && y == M - 1) {
				System.out.println(visit[x][y][k]);
				System.exit(0);
			}
			for (int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				// 벽 안 부수고 갈 수 있음
				if (arr[nx][ny] == 0 && visit[nx][ny][k] == 0) {
					visit[nx][ny][k] = visit[x][y][k] + 1;
					q.offer(new Point(nx, ny, k));
				} else if (arr[nx][ny] == 1 && k+1<=K && visit[nx][ny][k + 1] == 0) {
					visit[nx][ny][k + 1] = visit[x][y][k] + 1;
					q.offer(new Point(nx, ny, k + 1));
				}

			}
		}
		System.out.println("-1");
	}

	static class Point {
		int x, y, k;

		public Point(int x, int y, int k) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
}
