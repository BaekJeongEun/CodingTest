package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1743 { // 음식물 피하기 (S1)
	static int N, M, K, max = Integer.MIN_VALUE;
	static int[][] arr, dir= {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());	
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			arr[r][c] = 1;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visit[i][j] || arr[i][j] == 0) continue;
				bfs(i, j);
			}
		}
		System.out.println(max);
	}
	private static void bfs(int sx, int sy) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {sx, sy});
		visit[sx][sy] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			for(int d=0; d<4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny] || arr[nx][ny] == 0) continue;
				visit[nx][ny] = true;
				q.offer(new int[] {nx, ny});
				cnt++;
			}
		}
		max = Math.max(max, cnt);
	}

}
