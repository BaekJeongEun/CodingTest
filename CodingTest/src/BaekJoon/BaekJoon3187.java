package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon3187 { // 양치기 꿍(S1)
	static int N, M, wolf, sheep;
	static char[][] arr;
	static boolean[][] visit;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j] = temp[j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == '.' || visit[i][j])
					continue;
				bfs(i, j);
			}
		}
		System.out.println(sheep + " " + wolf);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { i, j });
		visit[i][j] = true;
		int wolfCnt = 0;
		int sheepCnt = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			if (arr[x][y] == 'v')
				wolfCnt++;
			else if (arr[x][y] == 'k')
				sheepCnt++;
			for (int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny] || arr[nx][ny] == '#')
					continue;
				q.offer(new int[] { nx, ny });
				visit[nx][ny] = true;
			}
		}
		if (wolfCnt < sheepCnt) {
			sheep += sheepCnt;
		} else {
			wolf += wolfCnt;
		}
	}

}
