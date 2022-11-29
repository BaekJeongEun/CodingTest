package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2178_2 { // 미로 탐색 (S1)

	static int map[][];
	static int N, M;
	static int new_x, new_y;
	static int cnt;
	static boolean visited[][];
	static int[] di = {1,-1,0,0};
	static int[] dj = {0,0,1,-1};
	static Queue<Point> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str[] = br.readLine().split("");
			for(int j=0; j<M; j++)
				map[i][j] = Integer.parseInt(str[j]);
		}
				
		queue.add(new Point(0,0,1));
		visited[0][0] = true;
		
		System.out.println(bfs());
	}
	
	
	private static int bfs() {
		int min = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			Point new_index = queue.poll();
			int row = new_index.x;
			int col = new_index.y;
			if(row == N-1 && col == M-1) {
				min = Math.min(min, new_index.t);
			}
			for(int i=0; i<4; i++) { // 네 방향 탐색
				int new_x = row+di[i];
				int new_y = col+dj[i];
				if(new_x>=0 && new_x<N && new_y>=0 && new_y<M && !visited[new_x][new_y] && map[new_x][new_y]==1) {				
					visited[new_x][new_y] = true;
					queue.add(new Point(new_x, new_y, new_index.t + 1));
				}
			}
		}
		return min;
	}


	static class Point{
		int x, y, t;
		public Point(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

}
