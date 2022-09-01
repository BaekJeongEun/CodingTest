package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1600 { // 말이 되고픈 원숭이 (G3)
	static int K, N, M, arr[][];
	static boolean visit[][][];
	static int dirKnit[][] = {{-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,-1}};
	static int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit = new boolean[N][M][K+1];
		visit[0][0][0] = true;
		System.out.println(bfs(0, 0, 0, 0));
	}
	private static int bfs(int x, int y, int dist, int k) {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(x,y,dist,k));
		ArrayList<Integer> kList = new ArrayList<>();
		while(!q.isEmpty()) {
			Point now = q.poll();
			int nowX = now.x;
			int nowY = now.y;
			int nowDist = now.dist;
			int nowK = now.k;
			int nextX=nowX, nextY=nowY;
			if(nextX == N-1 && nextY == M-1) {
				return nowDist;
			}
			if(nowK< K) { // 나이트 이동 가능 한 경우
				for(int d=0; d<8; d++) {
					nextX = nowX + dirKnit[d][0];
					nextY = nowY + dirKnit[d][1];
					
					if(isArea(nextX, nextY) && !visit[nextX][nextY][nowK+1]) {
						visit[nextX][nextY][nowK+1] = true;
						q.offer(new Point(nextX, nextY, nowDist+1, nowK+1));
					}
				}
			}
			for(int d=0; d<4; d++) {
				nextX = nowX + dir[d][0];
				nextY = nowY + dir[d][1];
				if(isArea(nextX, nextY) && !visit[nextX][nextY][nowK]) {
					visit[nextX][nextY][nowK] = true;
					q.offer(new Point(nextX, nextY, nowDist+1, nowK));
				}
			}
		}
		return -1;
	}
	private static boolean isArea(int x, int y) {
		return (x>=0 && y>=0 && x<N && y<M && arr[x][y]==0);
	}
	private static class Point{
		int x,y,dist,k;

		public Point(int x, int y, int dist, int k) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.k = k;
		}
	}
}