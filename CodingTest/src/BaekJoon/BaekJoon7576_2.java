package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon7576_2 { // 토마토 (G5)
	static int N, M, total;
	static Queue<Point> q = new ArrayDeque<>();
	static int[][] dir= {{1,0},{-1,0},{0,1},{0,-1}}, arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		total = N*M;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1 || arr[i][j]==1)
					total--;
				if(arr[i][j]==1)
					q.offer(new Point(i, j, 0));
			}
		}
		if(total == 0) 
			System.out.println("0");
		else
			System.out.println(bfs());
	}
	private static int bfs() {
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int d=0; d<4; d++) {
				int nx = now.x + dir[d][0];
				int ny = now.y + dir[d][1];
				if(nx<0 || ny<0 || nx>=M || ny>=N || arr[nx][ny]!=0) continue;
				
				arr[nx][ny] = 1;
				total--;
				if(total == 0) {
					return now.t+1;
				}
				q.offer(new Point(nx, ny, now.t + 1));
			}
		}
		return -1;
	}
	private static class Point{
		int x, y, t;

		public Point(int x, int y, int t) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
}
