package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon14502_2 { // 연구소 (G4)
	static int N, M, max = Integer.MIN_VALUE;
	static int[][] arr, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[] visit;
	static ArrayList<Point> virusList;
	static ArrayList<Point> safeList;
	static ArrayList<Point> pickList;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		virusList = new ArrayList<>();
		pickList = new ArrayList<>();
		safeList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					safeList.add(new Point(i, j));
				}
				else if(arr[i][j] == 2) {
					virusList.add(new Point(i, j));
				}
			}
		}
		visit = new boolean[safeList.size()];
		comb(0, 0);
		System.out.println(max);
	}

	private static void comb(int idx, int cnt) {
		if (cnt == 3) {
			bfs();
			return;
		}
		for (int i = idx; i < safeList.size(); i++) {
			if (visit[i])
				continue;
			Point now = safeList.get(i);
			visit[i] = true;
			pickList.add(now);
			comb(i + 1, cnt + 1);
			visit[i] = false;
			pickList.remove(now);
		}
	}

	private static void bfs() {
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = arr[i].clone();
        }

		Queue<Point> q = new ArrayDeque<>();

		for (int i = 0; i < pickList.size(); i++) {
			Point now = pickList.get(i);
			map[now.x][now.y] = 1;
		}
		for (int i = 0; i < virusList.size(); i++) {
			q.offer(virusList.get(i));
		}
		while (!q.isEmpty()) {
			Point now = q.poll();
			int x = now.x;
			int y = now.y;
			for (int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != 0)
					continue;
				map[nx][ny] = 2;
				q.offer(new Point(nx, ny));
			}

		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					sum++;
			}
		}
		max = Math.max(max, sum);
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
