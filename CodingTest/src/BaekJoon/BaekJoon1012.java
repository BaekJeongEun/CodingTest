package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1012 {
	static int N, M, BaeChu, cnt;
	static int arr[][];
	static boolean visited[][];
	static Queue<Point> queue;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			BaeChu = Integer.parseInt(st.nextToken());
			arr = new int[M][N];
			visited = new boolean[M][N];
			
			for (int i = 0; i < BaeChu; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st1.nextToken());
				int y = Integer.parseInt(st1.nextToken());
				arr[x][y] = 1;
			}

			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j]==1 && !visited[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			cnt = 0;
		}
	}

	static void bfs(int new_x, int new_y) {
		queue = new LinkedList<>();
		Point p1 = new Point(new_x, new_y);
		queue.add(p1);

		while (!queue.isEmpty()) {
			Point new_one = queue.poll();
			int new_one_x = new_one.x;
			int new_one_y = new_one.y;
			visited[new_one_x][new_one_y] = true;
			
			for(int i=0; i<4; i++) {
				int x = new_one_x + dx[i];
				int y = new_one_y + dy[i];
				if(x>=0 && y>=0 && x<M && y<N && !visited[x][y]&&arr[x][y]==1) {
					Point p = new Point(x, y);
					queue.add(p);
					visited[p.x][p.y] = true;
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
