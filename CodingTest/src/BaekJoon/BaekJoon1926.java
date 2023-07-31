package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1926 { // 그림 (S1)

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[][] visit = new boolean[n][m];
		int max = 0, area = 0, count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1 && !visit[i][j]) {
					Queue<int[]> q = new ArrayDeque();
					visit[i][j] = true;
					q.offer(new int[] { i, j });
					arr[i][j] = 0;
					count++;
					area = 0;
					while (!q.isEmpty()) {
						int[] now = q.poll();
						int x = now[0];
						int y = now[1];
						area++;
						for (int d = 0; d < 4; d++) {
							int nx = x + dir[d][0];
							int ny = y + dir[d][1];
							if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == 0 || visit[nx][ny])
								continue;
							q.offer(new int[] { nx, ny });
							visit[nx][ny] = true;
							arr[nx][ny] = 0;
						}
					}
					max = Integer.max(max, area);
				}
			}
		}
		sb.append(count).append("\n").append(max);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
