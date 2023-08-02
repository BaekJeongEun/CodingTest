package Softeer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
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
					moveRobot(d, i, j, area);
				}
			}
		}
		sb.append(q.peek().x + 1).append(" ").append(q.peek().y + 1).append("\n").append(news[q.peek().direction])
				.append("\n").append(q.peek().route);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void moveRobot(int di, int sx, int sy, int area) {
		Queue<Plan> queue = new ArrayDeque<Plan>();
		queue.offer(new Plan(sx, sy, di, "", area));
		while(!queue.isEmpty()) {
			Plan now = queue.poll();
			int x = now.x;
			int y = now.y;
			int direction = now.direction;
			int remain = now.remain;
			String route = now.route;
			if(remain == 0) {
				q.offer(new Plan(x, y, direction, route, 0));
				return;
			}
			int nD = (direction + 1) % 4;
			int nx = x + dir[nD][0];
			int ny = y + dir[nD][1];
			if(!isArea(nx, ny)) {
				visit[nx][ny] = true;
				queue.offer(new Plan(nx, ny, direction, route+"R", area));
			}
			nD = (direction + 3) % 4;
			nx = x + dir[nD][0];
			ny = y + dir[nD][1];
			if(!isArea(nx, ny)) {
				visit[nx][ny] = true;
				queue.offer(new Plan(nx, ny, direction, route+"L", area));
			}

			nx = x + dir[direction][0]*2;
			ny = y + dir[direction][1]*2;
			if(!isArea(nx, ny)) {
				visit[nx][ny] = true;
				queue.offer(new Plan(nx, ny, direction, route+"A", area-2));
			}
		}
	}

	private static boolean isArea(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny] || arr[nx][ny] != '#';
	}

	public static class Plan {
		int x, y;
		int direction, remain;
		String route;

		public Plan(int x, int y, int direction, String route, int remain) {
			super();
			this.x = x;
			this.y = y;
			this.direction = direction;
			this.route = route;
			this.remain = remain;
		}

		@Override
		public String toString() {
			return "Plan [x=" + x + ", y=" + y + ", direction=" + direction + ", route=" + route + "]";
		}

	}
}
