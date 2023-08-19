package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon13565 { // 침투(S2)
	static int N, M;
	static int[][] arr, dir= {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		for(int j=0; j<M; j++) {
			int num = arr[0][j];
			if(num == 0 && !visit[0][j]) {
				bfs(0, j);
			}
			
		}
		boolean exit = false;
		for(int i=0; i<M; i++) {
			if(visit[N-1][i]) {
				exit = true;
				break;
			}
		}
		System.out.println(exit?"YES":"NO");
	}
	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			for(int d=0; d<4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny] || arr[nx][ny] == 1) continue;
				visit[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
	}

}
