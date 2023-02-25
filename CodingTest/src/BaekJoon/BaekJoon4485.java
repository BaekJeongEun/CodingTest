package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon4485 { // 녹색 옷 입은 애가 젤다지? (G4)

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		int N = Integer.parseInt(br.readLine());
		int tc=1;
		while(N!=0) {
			int[][] arr = new int[N][N];
			int[][] rupee = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<N; i++) {
				Arrays.fill(rupee[i], Integer.MAX_VALUE);
			}
			PriorityQueue<Point> q = new PriorityQueue<>((a, b) -> Integer.compare(a.size, b.size));
			q.offer(new Point(0, 0, arr[0][0]));
			while(!q.isEmpty()) {
				Point now = q.poll();
				int x = now.x;
				int y = now.y;
				int size = now.size;
				for(int d=0; d<4; d++) {
					int nx = x + dir[d][0];
					int ny = y + dir[d][1];
					if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
					if(size+arr[nx][ny] < rupee[nx][ny]) {
						rupee[nx][ny] = size+arr[nx][ny];
						q.offer(new Point(nx, ny, size+arr[nx][ny]));
					}
				}
			}
			sb.append("Problem ").append(tc).append(": ").append(rupee[N-1][N-1]).append("\n");
			N = Integer.parseInt(br.readLine());
			tc++;
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static class Point {
		int x, y;
		int size;
		public Point(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}
}
