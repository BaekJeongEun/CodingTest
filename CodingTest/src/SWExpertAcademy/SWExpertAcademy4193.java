package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWExpertAcademy4193 { // 수영대회 결승전 ( 완전 탐색 + 구현 )
	static int N, ans;
	static int[][] arr, dir= {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			arr= new int[N][N];
			visit = new boolean[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			ans = -1;
			bfs(startX, startY, endX, endY);
			sb.append("#"+tc+" "+ans+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void bfs(int startX, int startY, int endX, int endY) {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(startX, startY, 0));
		visit[startX][startY] = true;
		while(!q.isEmpty()) {
			Point now = q.poll();
			int x = now.x;
			int y = now.y;
			int t = now.t;
			if(x == endX && y == endY) {
				ans = t;
				break;
			}
			for(int d=0; d<4; d++) {
				int nx = x+ dir[d][0];
				int ny = y+ dir[d][1];
				if(nx<0 || ny<0 || nx>=N || ny>= N || visit[nx][ny]) continue;
				if(arr[nx][ny] == 0 || (arr[nx][ny] == 2 && t%3==2)) {
					q.offer(new Point(nx, ny, t+1));
					visit[nx][ny] = true;
				}else if(arr[nx][ny] == 2){
					q.offer(new Point(x, y, t+1));
				}
			}
		}
	}
	private static class Point{
		int x,y, t;
		public Point(int x, int y, int t) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
}
