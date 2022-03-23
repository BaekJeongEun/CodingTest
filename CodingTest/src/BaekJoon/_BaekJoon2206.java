package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _BaekJoon2206 {
	static int N, M, arr[][], cnt = -1;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { -1, 1, 0, 0 };
	static boolean crash = true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(str[j-1]);
			}
		}

		bfs(1, 1, 1);
		System.out.println(cnt);
	}

	private static void bfs(int x, int y, int crash) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		while(!q.isEmpty()) {
			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];

				if (newX >= 1 && newY >= 1 && newX <= N && newY <= M && arr[newX][newY] != 1) {
					System.out.println("pass 1 "+ newX+" "+newY);
					q.add(new Point(newX, newY));
					
				}
				else if(newX >= 1 && newY >= 1 && newX <= N && newY <= M && arr[newX][newY] == 1 && crash==1) {



				}

			}
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}