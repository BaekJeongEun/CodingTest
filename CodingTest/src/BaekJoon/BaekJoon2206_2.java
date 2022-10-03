package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2206_2 { // 벽 부수고 이동하기 (G4)
	static int N, M;
	static int[][] arr, dir= {{0,1}, {0,-1}, {1,0}, {-1,0}};
	static boolean visit[][][];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M][2];
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split("");
			for(int j=0; j<M; j++)
				arr[i][j] = Integer.parseInt(str[j]);
		}
		System.out.println(bfs());
	}
	private static int bfs() {
		Queue<Point> q = new ArrayDeque();
		q.offer(new Point(0,0,1,1));
		visit[0][0][1] = true;
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(now.x == N-1 && now.y == M-1) {
				return now.t;
			}
			for(int d=0; d<4; d++) {
				int nextX = now.x + dir[d][0];
				int nextY = now.y + dir[d][1];
				if(nextX<0 || nextY<0 || nextX>=N || nextY >=M) continue;
				if(arr[nextX][nextY] == 1  && !visit[nextX][nextY][0] && now.crush == 1) { // 벽이고 한 번도 안 부쉈다면
					visit[nextX][nextY][0] = true;
					q.offer(new Point(nextX, nextY, now.t+1, 0));
				}else if((arr[nextX][nextY] == 0  && !visit[nextX][nextY][now.crush])) { // 벽도 아니거나 벽 부순 적 있다면
					visit[nextX][nextY][now.crush] = true;
					q.offer(new Point(nextX, nextY, now.t+1, now.crush));
				}
			}
		}
		return -1;
	}

	static class Point{
		int x, y, t, crush;
		
		public Point(int x, int y, int t, int crush) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
			this.crush = crush;
		}
	}
}
