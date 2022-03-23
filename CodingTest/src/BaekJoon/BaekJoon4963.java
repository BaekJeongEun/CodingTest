package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon4963 {
	static int cnt, arr[][], h, w;
	static int dx[] = {-1,-1,-1,0,0,1,1,1};
	static int dy[] = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String escape = br.readLine();
		while(!escape.equals("0 0")) {
			StringTokenizer st = new StringTokenizer(escape);
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			arr = new int[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(arr[i][j]==1) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			escape = br.readLine();
		}

	}
	static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i , j));
		arr[i][j] = 2;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			int nowx = now.x;
			int nowy = now.y;
			
			for(int k=0; k<8; k++) {
				int nextX = nowx + dx[k];
				int nextY = nowy + dy[k];
				
				if(nextX>=0 && nextY>=0 && nextX<h && nextY<w && arr[nextX][nextY]==1) {
					arr[nextX][nextY] = 2;
					q.add(new Point(nextX, nextY));
				}
			}
		}
	}
	
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
