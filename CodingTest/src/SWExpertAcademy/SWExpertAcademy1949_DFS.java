package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWExpertAcademy1949_DFS { // 등산로 조성 (sw 역량 테스트)
	static int N, K, max;
	static int arr[][], dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static ArrayList<Point> list;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			visit = new boolean[N][N];
			max = Integer.MIN_VALUE;
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, arr[i][j]);
				}
			}
			// 최대 봉우리 찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == max) {
						visit[i][j] = true;
						list.add(new Point(i, j));
					}
				}
			}
			max = Integer.MIN_VALUE;
			for (int s = 0; s < list.size(); s++) {
				visit[list.get(s).x][list.get(s).y] = true;
				dfs(list.get(s).x, list.get(s).y, 1, arr[list.get(s).x][list.get(s).y], false); // 좌표, 경로 길이, 현재 내 높이,
																								// 자른 경험
				visit[list.get(s).x][list.get(s).y] = false;
			}
			sb.append("#" + tc + " " + max + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void dfs(int x, int y, int cnt, int depth, boolean crop) {
		max = Math.max(max, cnt);
		for (int d = 0; d < 4; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny])
				continue;

			if (arr[nx][ny] < depth) { // 다음이 나보다 작으면 무조건 go
				visit[nx][ny] = true;
				dfs(nx, ny, cnt + 1, arr[nx][ny], crop);
				visit[nx][ny] = false;
			} else {
				if (!crop) {
					boolean exit = false;
					for (int i = 1; i <= K && !exit; i++) {
						if (arr[nx][ny] - i < depth) { // 잘랐더니 작아졌어! go
							exit = true;
							visit[nx][ny] = true;
							dfs(nx, ny, cnt + 1, arr[nx][ny] - i, true);
							visit[nx][ny] = false;
							break;
						}
					}
				}

			}
		}
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}
}
