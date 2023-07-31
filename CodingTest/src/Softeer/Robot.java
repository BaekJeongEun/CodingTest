package Softeer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Robot { // 로봇이 지나간 경로 (L3)
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 동, 남, 서, 북
	static char[] news = { '>', 'v', '<', '^' };
	static int N, M;
	static boolean[][] visit;
	static char[][] arr;
	static PriorityQueue<Plan> q;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		int area = 0;
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j] = temp[j];
				if (arr[i][j] == '#')
					area++;
			}
		}
		int min = Integer.MAX_VALUE;
		q = new PriorityQueue<>(new Comparator<Plan>() {
			@Override
			public int compare(Plan o1, Plan o2) {
				return o1.route.length() - o2.route.length();
			}
		});
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] != '#')
					continue;
				for (int d = 0; d < 4; d++) {
					visit = new boolean[N][M];
					visit[i][j] = true;
					moveRobot(d, i, j, area - 1, "", new int[] { i, j, d });

				}
			}
		}
		sb.append(q.peek().x + 1).append(" ").append(q.peek().y + 1).append("\n").append(news[q.peek().direction])
				.append("\n").append(q.peek().route);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void moveRobot(int d, int x, int y, int area, String route, int[] origin) {
		visit[x][y] = true;
		if (area == 0) {
			if (route.contains("A")) {
				Plan now = new Plan(origin[0], origin[1], origin[2], route);
				q.offer(now);
			}
			return;
		}

		// L
		int nextDir = (d - 1 + 4) % 4;
		if (!isArea(x, y)) {
			moveRobot(nextDir, x, y, area, route + "L", origin);
		}

		// R
		nextDir = (d + 1) % 4;
		if (!isArea(x, y)) {
			moveRobot(nextDir, x, y, area, route + "R", origin);
		}

		// A
		int nx = x + dir[d][0] * 2;
		int ny = y + dir[d][1] * 2;

		if (!isArea(nx, ny)) {
			moveRobot(d, nx, ny, area - 2, route + "A", origin);
		}
	}

	private static boolean isArea(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny] || arr[nx][ny] != '#';
	}

	public static class Plan {
		int x, y;
		int direction;
		String route;

		public Plan(int x, int y, int direction, String route) {
			super();
			this.x = x;
			this.y = y;
			this.direction = direction;
			this.route = route;
		}

		@Override
		public String toString() {
			return "Plan [x=" + x + ", y=" + y + ", direction=" + direction + ", route=" + route + "]";
		}

	}
}
