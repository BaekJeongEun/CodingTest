package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon14940 { // 쉬운 최단거리 (S1)
	static int N, M;
	static int[][] arr, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		int sX = 0, sY = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					sX = i;
					sY = j;
					arr[i][j] = 0;
				} else if (arr[i][j] == 1) {
					arr[i][j] = -1;
				}
			}
		}
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { sX, sY, 0 });
		visit[sX][sY] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			int cost = now[2];
			for (int d = 0; d < 4; d++) {
				int nX = nowX + dir[d][0];
				int nY = nowY + dir[d][1];
				if (nX < 0 || nY < 0 || nX >= N || nY >= M || visit[nX][nY] || arr[nX][nY] == 0)
					continue;
				q.offer(new int[] { nX, nY, cost + 1 });
				visit[nX][nY] = true;
				arr[nX][nY] = cost + 1;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
