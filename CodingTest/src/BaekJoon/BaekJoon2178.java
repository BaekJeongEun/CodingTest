package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2178 {

	static String map[][];
	static int N, M;
	static int new_x, new_y;
	static int cnt;
	static int visited[][];
	static int[] di = {1,-1,0,0};
	static int[] dj = {0,0,1,-1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new String[N+1][M+1];
		visited = new int[N+1][M+1];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().split("");
		}
				
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0,0));
		visited[0][0] = 1;
		
		while(!queue.isEmpty()) {
			Point new_index = queue.poll();
			int row = new_index.x;
			int col = new_index.y;
			for(int i=0; i<4; i++) { // 네 방향 탐색
				int new_x = row+di[i];
				int new_y = col+dj[i];
				if(new_x>=0 && new_x<N && new_y>=0 && new_y<M && 
						map[new_x][new_y].equals("1") && visited[new_x][new_y]==0) {
					visited[new_x][new_y] = visited[row][col]+1;
					queue.add(new Point(new_x, new_y));
				}
			}
		}
		System.out.println(visited[N-1][M-1]);
	}
	
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
