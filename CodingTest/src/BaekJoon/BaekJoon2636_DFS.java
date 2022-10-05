package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2636_DFS { // 치즈 (G4)
	static int N, M, answer, time;
	static int[][] arr, dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<Point> air = new ArrayDeque();
	static boolean[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					answer++;
				}
			}
		}
		go();
		System.out.println(time + "\n" + answer);
	}

	private static void go() {
		while (true) {
			int cnt = count();
			if (cnt == 0) {
				break;
			}
			visit = new boolean[N][M];
			countCheese(0, 0);
			answer = cnt;
			time++;
		}
	}

	private static int count() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1)
					cnt++;
			}
		}
		return cnt;
	}

	private static void countCheese(int x, int y) { // 치즈 만나면 2로 바꾸기
		for (int d = 0; d < 4; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue; // 맞닿은 게 치즈가 아니라면 넘어가기

			if (!visit[nx][ny]) {
				visit[nx][ny] = true;
				if (arr[nx][ny] == 0) {
					countCheese(nx, ny);
				}
				else {
					arr[nx][ny] = 0;
				}
			}
		}
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
}