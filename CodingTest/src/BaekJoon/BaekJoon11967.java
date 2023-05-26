package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon11967 { // 불켜기(G2)
	static int N, M;
	static ArrayList<int[]> arr[][];
	static boolean[][] visit, light;
	static int[][] dir = { { 0, 1 }, { 0, -1, }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N][N];
		light = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = new ArrayList<>();
			}
		}
		int x, y, a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;
			arr[x][y].add(new int[] { a, b });
		}

		System.out.println(bfs()+1);
	}

	public static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0 });
		visit = new boolean[N][N];
		light[0][0] = true;
		visit[0][0] = true;
		boolean exit = false;
		int count = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			for (int d = 0; d < 4; d++) {
				int nx = nowX + dir[d][0];
				int ny = nowY + dir[d][1];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny] || !light[nx][ny])
					continue;
				q.offer(new int[] { nx, ny });
				visit[nx][ny] = true;
			}
			for (int i = 0; i < arr[nowX][nowY].size(); i++) {
				int nx = arr[nowX][nowY].get(i)[0];
				int ny = arr[nowX][nowY].get(i)[1];
				if (light[nx][ny])
					continue;
				count++;
				light[nx][ny] = true;
				exit = true;
			}
		}
		if (exit) {
			return count + bfs();
		}
		return count;
	}
}
