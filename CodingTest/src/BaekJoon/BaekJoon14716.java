package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon14716 { // 현수막 (S1)
	static int N, M, answer;
	static int[][] arr, dir= {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,1},{-1,1},{1,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 1) {
					bfs(i, j);
					answer++;
				}
			}
		}		
		System.out.println(answer);
	}
	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {i, j});
		arr[i][j] = 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			for(int d=0; d<8; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx <0|| ny<0 || nx>=N || ny>=M || arr[nx][ny] != 1) continue;
				q.offer(new int[] {nx, ny});
				arr[nx][ny] = 0;
			}
		}
	}

}
