package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon16234 { // 인구 이동 (G5)
	static int N, L, R;
	static int[][] arr, dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };;
	static boolean[][] visit = null;
	static Queue<Point> queue = null;
	static ArrayList<Point> list = null;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(move());
	}

	private static int move() {
		int day = 0;

		while (true) {
			visit = new boolean[N][N];
			boolean exit = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) { // 현재 위치에서 연합 가능한 곳 찾기
						int sum = bfs(i, j);
						if (list.size() > 1) {
							int avg = sum / list.size();
							for (Point p : list) {
								arr[p.x][p.y] = avg;
							}
							exit = true; // 연합할 수 있는 곳 찾을 수 있게 하루 더 연장
						}
					}
				}
			}

			if (!exit) {// 현재 위치뿐이라면 연합 가능한 곳 없다는 의미
				return day;
			}
			day++;
		}
	}

	private static int bfs(int i, int j) {
		queue = new LinkedList<>();
		list = new ArrayList<>();

		queue.offer(new Point(i, j));
		list.add(new Point(i, j));
		visit[i][j] = true;

		int sum = arr[i][j];
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int x = now.x + dir[d][0];
				int y = now.y + dir[d][1];
				if (x >= 0 && y >= 0 && x < N && y < N && !visit[x][y] && Math.abs(arr[now.x][now.y] - arr[x][y]) >= L
						&& Math.abs(arr[now.x][now.y] - arr[x][y]) <= R) {
					visit[x][y] = true;
					queue.offer(new Point(x, y));
					sum += arr[x][y];
					list.add(new Point(x, y));
				}
			}
		}
		return sum;
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
