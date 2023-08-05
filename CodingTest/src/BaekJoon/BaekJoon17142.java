package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon17142 { // 연구소 3(G3)
	static int N, M, min = Integer.MAX_VALUE, total;
	static ArrayList<Point> virus;
	static ArrayList<Point> pick;
	static Queue<Point> q;
	static int[][] arr, dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		virus = new ArrayList<>();
		pick = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 2) {
					virus.add(new Point(i, j, 0));
					arr[i][j] = 2;
				} else {
					arr[i][j] = num;
					if (num == 0)
						total++;
				}
			}
		}
		if (total == 0) {
			System.out.println(0);
			System.exit(0);
		}
		comb(0, 0);
		System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
	}

	private static void comb(int cnt, int idx) {
		if (cnt == M) {
			// 바이러스 놓기
			q = new ArrayDeque();
			visit = new boolean[N][N];
			for (int i = 0; i < pick.size(); i++) {
				Point now = pick.get(i);
				q.offer(now);
				visit[now.x][now.y] = true;
			}
			bfs(total, visit);
			return;
		}
		for (int i = idx; i < virus.size(); i++) {
			pick.add(virus.get(i));
			comb(cnt + 1, i + 1);
			pick.remove(virus.get(i));
		}
	}

	private static void bfs(int origin, boolean[][] visit) {
		while (!q.isEmpty()) {
			Point now = q.poll();
			int x = now.x;
			int y = now.y;
			int time = now.time;
			for (int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny] || arr[nx][ny] == 1)
					continue;

				if (arr[nx][ny] == 0)
					origin--;

				if (origin == 0) {
					min = Math.min(min, time + 1);
					return;
				}

				q.offer(new Point(nx, ny, time + 1));
				visit[nx][ny] = true;
			}

		}
	}

	static class Point {
		int x, y, time;

		public Point(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
}
