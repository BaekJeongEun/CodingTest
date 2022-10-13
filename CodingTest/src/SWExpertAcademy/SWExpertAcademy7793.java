package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWExpertAcademy7793 { // 오! 나의 여신님 (D5)
	static char arr[][];
	static int N, M;
	static int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static Queue<Point> devilQ; // 악마
	static Queue<Point> suyeonQ; // 수연
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC= Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new char[N][M];
			devilQ = new ArrayDeque(); // 악마
			suyeonQ = new ArrayDeque(); // 수연
			for(int i=0; i<N; i++) {
				arr[i] = br.readLine().toCharArray();
				for(int j=0; j<M; j++) {
					if(arr[i][j] == 'S') {
						suyeonQ.offer(new Point(i, j));
					}else if(arr[i][j] == '*') {
						devilQ.offer(new Point(i, j));
					}
				}
			}
			int result = bfs();
			System.out.println("#"+tc+" "+ (result==-1?"GAME OVER":result));
		}
	}
	static int bfs() {
		int cnt = 0;
		boolean suc = true;
		A: while(true) {
			cnt++;
			// 악마 퍼지기
			int size = devilQ.size();
			for(int s=0; s<size; s++) {
				Point now = devilQ.poll();
				for(int d=0; d<4; d++) {
					int nextX = now.x+dir[d][0];
					int nextY = now.y+dir[d][1];
					if(nextX<0 || nextY<0 || nextX>=N || nextY>=M) continue;
					if(arr[nextX][nextY] == '.') {
						arr[nextX][nextY] = '*';
						devilQ.offer(new Point(nextX, nextY));
					}
				}
			}
			// 수연이 움직이기
			size = suyeonQ.size();
			for(int s=0; s<size; s++) {
				Point now = suyeonQ.poll();
				for(int d=0; d<4; d++) {
					int nextX = now.x+dir[d][0];
					int nextY = now.y+dir[d][1];
					if(nextX<0 || nextY<0 || nextX>=N || nextY>=M || arr[nextX][nextY] == '*' || arr[nextX][nextY] == 'X') continue;
					if(arr[nextX][nextY] == 'D') {
						break A;
					}
					if(arr[nextX][nextY] == '.') {
						arr[nextX][nextY] = 'S';
						suyeonQ.offer(new Point(nextX, nextY));
					}
				}
			}
			if(suyeonQ.isEmpty()) {
				suc = false;
				break A;
			}
		}
		return suc?cnt:-1;
	}
	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
