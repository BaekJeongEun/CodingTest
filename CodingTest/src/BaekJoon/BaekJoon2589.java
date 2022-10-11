package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2589 { // 보물섬 (G5)
	static int N, M;
	static int[][] dir= {{0,-1}, {0,1}, {-1,0}, {1,0}};
	static char[][] arr;
	static boolean[][] visit;
	static ArrayList<Integer> candiList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for(int i=0; i<N; i++) {
			char[] str = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				arr[i][j] = str[j];
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(Collections.max(candiList));
	}


	private static void bfs(int sx, int sy) {
		int max = Integer.MIN_VALUE;
		Queue<Point> q = new ArrayDeque();
		visit = new boolean[N][M];
		visit[sx][sy] = true;
		q.offer(new Point(sx, sy, 0));
		while(!q.isEmpty()) {
			Point now = q.poll();
			int x = now.x;
			int y = now.y;
			int t = now.t;
			for(int d=0; d<4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny] || arr[nx][ny] == 'W') continue;
				visit[nx][ny] = true;
				q.offer(new Point(nx, ny, t+1));
				max = Math.max(max, t+1);
			}
		}
		candiList.add(max);
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
