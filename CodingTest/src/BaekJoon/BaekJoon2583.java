package BaekJoon;

import java.util.*;
import java.io.*;
public class BaekJoon2583 {
	static int M, N;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int[][] arr;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new int[M][N];
		for(int k=0; k<K; k++) { // 사각형 갯수만큼
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int yE = Integer.parseInt(st.nextToken());
			int xE = Integer.parseInt(st.nextToken());
			for(int i=x; i<xE; i++) {
				for(int j=y; j<yE; j++) {
					arr[i][j] = 1;
				}
			}
		}
		System.out.println("================");
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]==0) {
					bfs(i, j);
					System.out.println("i "+i +"  j "+j);
				}
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for(Integer i : list) {
			System.out.print(i+" ");
		}
	}

	private static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		
		int nowX = x;
		int nowY = y;
		int cnt=0;
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			nowX = now.x;
			nowY = now.y;
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX>=0 && nextX<M && nextY>=0 && nextY<N && arr[nextX][nextY]==0) {
					cnt++;
					arr[nextX][nextY] = 1;
					queue.add(new Point(nextX, nextY));
				}
			}
			
		}
		list.add((cnt==0)?1:cnt);
	}
	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
