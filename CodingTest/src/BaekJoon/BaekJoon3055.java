package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon3055 { // 탈출 (G4)
	static int R, C, dir[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	static char arr[][];
	static boolean visit[][];
	static int kakX, kakY, caveX, caveY;
	static Queue<Point> waterQ;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		waterQ = new LinkedList<>();
		visit = new boolean[R][C];
		for(int r=0; r<R; r++) {
			char arrC[] = br.readLine().toCharArray();
			for(int c=0; c<C; c++) {
				arr[r][c] = arrC[c];
				if(arr[r][c]=='D') {
					caveX = r; caveY = c;
				}else if(arr[r][c]=='S') {
					kakX = r; kakY = c;
				}else if(arr[r][c]=='*') {
					waterQ.add(new Point(r, c));
				}
			}
		}
		bfs(kakX, kakY);
	}
	private static void bfs(int kakX, int kakY) {
		Queue<Point> q = new LinkedList<>();
		Queue<Point> water = new LinkedList<>(waterQ);
		q.offer(new Point(kakX, kakY));
		visit[kakX][kakY] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int wSize = water.size();
			for(int w=0; w<wSize; w++) {
				Point p = water.poll();
				for(int d=0; d<4; d++) {
					int x = p.x+dir[d][0];
					int y = p.y+dir[d][1];
					if(x >=0 && y>=0 && x<R && y<C && arr[x][y]=='.') {
						water.offer(new Point(x,y));
						arr[x][y]='*';
					}
				}
			}
			int size = q.size();
			for(int s=0; s<size; s++) {
				Point p = q.poll();
				int X = p.x;
				int Y = p.y;
				if(X==caveX && Y==caveY) {
					System.out.println(cnt);
					return;
				}
				for(int d=0; d<4; d++) {
					int x = X+dir[d][0];
					int y = Y+dir[d][1];
					if(x >=0 && y>=0 && x<R && y<C && !visit[x][y] && arr[x][y]!='*' && arr[x][y]!='X') {
						visit[x][y] = true;
						q.offer(new Point(x, y));
						
					}
				}
			}
			cnt++;
		}
		
		System.out.println("KAKTUS");
		
	}
	private static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
