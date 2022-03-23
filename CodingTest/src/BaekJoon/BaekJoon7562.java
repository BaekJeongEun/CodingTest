package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import BaekJoon.BaekJoon7576.Point;

public class BaekJoon7562 {
	static int I, arr[][], cnt, end_x, end_y;
	static int dx[] = {-1,-2,-2,-1,1,2,2,1};
	static int dy[] = {-2,-1,1,2,2,1,-1,-2};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<TC; tc++) {
			I = Integer.parseInt(br.readLine());
			arr = new int[I][I];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			end_x = Integer.parseInt(st.nextToken());
			end_y = Integer.parseInt(st.nextToken());

			System.out.println(bfs(start_x, start_y)-1);
		}
		
		
		
	}
	private static int bfs(int start_x, int start_y) {
		Queue<Point> q = new LinkedList<BaekJoon7562.Point>();
		q.add(new Point(start_x, start_y));
		arr[start_x][start_y] = 1;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			int nowX = now.x;
			int nowY = now.y;
			for(int i=0; i<8; i++) {
				int new_x = nowX+dx[i];
				int new_y = nowY+dy[i];
				
				if(new_x>=0 && new_x<I && new_y>=0 && new_y<I && arr[new_x][new_y]==0) {
					q.add(new Point(new_x, new_y));
					arr[new_x][new_y] = arr[nowX][nowY]+1;
				}
			}
		}
		return arr[end_x][end_y];
	}
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
