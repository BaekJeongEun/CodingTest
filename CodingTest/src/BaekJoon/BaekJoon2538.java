package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2538 { // 치즈(G3)
	static int N, M, total;
	static boolean[][] cheese;
	static int[][] arr, dir= {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheese = new boolean[N][M];
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					cheese[i][j] = true;
					total++;
				}
			}
		}
		int time = 0;
		while(total > 0) {
			total = 0;
			arr = new int[N][M];
			bfs(0, 0);
					
			for(int x=0; x<N; x++) {
				for(int y=0; y<M; y++) {
					if(arr[x][y] >= 2) {
						cheese[x][y] = false;
					}
				}
			}


			for(int q=0; q<N; q++) {
				for(int w=0; w<M; w++) {
					if(cheese[q][w]) total++;
				}
			}
			time++;
		}
		System.out.println(time);
	}
	private static void bfs(int sX, int sY) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[][] visit = new boolean[N][M];
		visit[sX][sY] = true;
		q.offer(new int[] {sX, sY});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			for(int d=0; d<4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx<0 || nx>=N || ny<0 ||ny>=M || arr[nx][ny] >= 2) continue;
				if(!cheese[x][y] && cheese[nx][ny]) arr[nx][ny]++;
				if(visit[nx][ny] || cheese[nx][ny]) continue;
				visit[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
	}
}
