package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Antivirus { // 바이러스 백신
	static int N, M, min = Integer.MAX_VALUE, total;
	static int[][] arr, dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static ArrayList<Hospital> hospitals;
	static int[] pick;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		pick = new int[M];
		hospitals = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					hospitals.add(new Hospital(i, j));
				}else if(arr[i][j] == 0) {
					total++;
				}
			}
		}
		if(total == 0) {
			System.out.println(0);
			System.exit(0);
		}
		comb(0, 0);
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void comb(int idx, int cnt) {
		if (cnt == M) {
			min = Math.min(min, bfs(total));
			return;
		}
		for (int i = idx; i < hospitals.size(); i++) {
			pick[cnt] = i;
			comb(i + 1, cnt + 1);
		}
	}

	private static int bfs(int total) {
		boolean[][] visit = new boolean[N][N];
		PriorityQueue<Hospital> q = new PriorityQueue<>((a, b)->a.time-b.time);
		for (int i = 0; i < M; i++) {
			Hospital now = hospitals.get(pick[i]);
			q.add(new Hospital(now.x, now.y, 0));
			visit[now.x][now.y] = true;
		}
		while (!q.isEmpty()) {
			Hospital now = q.poll();
			int x = now.x;
			int y = now.y;
			int time = now.time;
			for (int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny] || arr[nx][ny] == 1)
					continue;
				if (arr[nx][ny] == 0) {
					total--;
				}
				if(total == 0) {
					return time+1;
				}
				visit[nx][ny] = true;
				q.add(new Hospital(nx, ny, time+1));
			}
		}
		return Integer.MAX_VALUE;
	}

	static class Hospital {
		int x, y, time;

		public Hospital(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Hospital(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}
