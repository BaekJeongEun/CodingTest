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

public class SWExpertAcademy1949_BFS { // 등산로 조성 (sw 역량 테스트)
	static int N, K, max;
	static int map[][], dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<Point> q;
	static ArrayList<Point> list;

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
			map = new int[N][N];
			max = Integer.MIN_VALUE;
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			// 최대 봉우리 찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						boolean visit[][] = new boolean[N][N];
						visit[i][j] = true;
						list.add(new Point(i, j, 0, map[i][j], 1, visit));
					}
				}
			}
			max = Integer.MIN_VALUE;
			for (int s = 0; s < list.size(); s++) {
				bfs(list.get(s), map);
			}
			sb.append("#" + tc + " " + max + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void bfs(Point p, int[][] arr) {
		q = new ArrayDeque<>();
		q.offer(new Point(p.x, p.y, p.crop, arr[p.x][p.y], p.cnt, p.visit));
		while (!q.isEmpty()) {
			Point now = q.poll();
			int x = now.x;
			int y = now.y;
			int crop = now.crop;
			int depth = now.depth;
			int cnt = now.cnt;
			boolean visited[][] = now.visit;
			max = Math.max(max, cnt);

			for (int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])
					continue;
				visited = new boolean[N][N];
				for(int i = 0 ; i < N ; i++) 
					visited[i] = now.visit[i].clone();
				visited[nx][ny] = true;
				if (crop == 0) {
					if (arr[nx][ny] < depth) {
						visited[nx][ny] = true;
						q.offer(new Point(nx, ny, crop, arr[nx][ny], cnt + 1, visited));
					} else { // 커서 못 감
						for (int k = 1; k <= K; k++) {
							if (arr[nx][ny] - k < depth) { // 깎고 나니 나보다 작으면
								visited[nx][ny] = true;
								q.offer(new Point(nx, ny, 1, arr[nx][ny] - k, cnt + 1, visited));
							}
						}
					}
				} else {
					if (arr[nx][ny] < depth) { // 작은 지형이면 깎았던 안 깎았던 상관 없이 갈 수 있음
						visited[nx][ny] = true;
						q.offer(new Point(nx, ny, crop, arr[nx][ny], cnt + 1, visited));
					}
				}

			}
			
		}
	}

	private static class Point {
		int x, y, crop, depth, cnt;
		boolean visit[][];
		public Point(int x, int y, int crop, int depth, int cnt, boolean visit[][]) {
			super();
			this.x = x;
			this.y = y;
			this.crop = crop;
			this.depth = depth;
			this.cnt = cnt;
			this.visit = visit;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", crop=" + crop + ", depth=" + depth + "]";
		}
		
	}
}
