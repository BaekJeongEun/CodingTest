package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2206 {
	static int N, M, arr[][], cnt = Integer.MAX_VALUE;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		ArrayList<Point> wall = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		boolean[][][] visited = new boolean[2][N][M];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 1, 0));
		visited[0][0][0] = true;
		while (!q.isEmpty()) {

			Point now = q.poll();
			int nowX = now.x;
			int nowY = now.y;
			int wall = now.wall;
			int cnt = now.cnt;
			if (nowX == N - 1 && nowY == M - 1) {
				return now.cnt;
			}
			for (int i = 0; i < 4; i++) {
				int newX = nowX + dx[i];
				int newY = nowY + dy[i];
				
				if (newX < 0 || newY < 0 || newX >= N || newY >= M || visited[wall][newX][newY]) {
					continue;
				}
				if(arr[newX][newY] == 0) {
					visited[wall][newX][newY] = true;
                    q.add(new Point(newX, newY, cnt + 1, wall));
				}else if(arr[newX][newY] == 1 && wall == 0) {	// 벽(1)이지만 부순 적 없기 때문에 한 번은 봐준다~!
					visited[wall][newX][newY] = true;
					q.add(new Point(newX, newY, cnt+1, wall+1));
				}
			}

		}
		return -1;
	}

	static class Point {
		int x, y, cnt;
		int wall;

		public Point(int x, int y, int cnt, int wall) {
			this.x = x;
			this.y = y;
			this.wall = wall; // 벽 부순 횟수
			this.cnt = cnt; // 이동 경로
		}
	}
}