package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon7562_2 { // 나이트의 이동 (S1)
	static int[][] dir= {{-1,-2}, {-2,-1}, {-2,1}, {-1,2}, {1,-2}, {2,-1}, {2,1}, {1,2}};
	static boolean[][] visit;
	static int N;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=0; tc<TC; tc++) {
			N = Integer.parseInt(br.readLine());
			visit = new boolean[N][N];
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			sb.append(bfs(startX, startY, endX, endY)+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static int bfs(int startX, int startY, int endX, int endY) {
		Queue<Point> q = new ArrayDeque();
		visit[startX][startY] = true;
		q.offer(new Point(startX, startY, 0));
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(now.x == endX && now.y == endY) {
				return now.t;
			}
			for(int d=0; d<8; d++) {
				int nextX = now.x + dir[d][0];
				int nextY = now.y + dir[d][1];
				if(nextX<0 || nextY<0 || nextX>=N || nextY>=N || visit[nextX][nextY]) continue;
				visit[nextX][nextY] = true;
				q.offer(new Point(nextX, nextY, now.t+1));
			}
		}
		return 0;
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
