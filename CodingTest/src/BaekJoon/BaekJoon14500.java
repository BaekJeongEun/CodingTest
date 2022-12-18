package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon14500 { // 테트로미노 (G4)
	static int N, M, max = Integer.MIN_VALUE;
	static int[][] arr, dir= {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visit[i][j] = true;
				dfs(i, j, 1, arr[i][j]);
				visit[i][j] = false;
			}
		}
		System.out.println(max);
	}
	private static void dfs(int x, int y, int cnt, int sum) {
		if(cnt == 4) { // 정사각형 4개 이어붙이기 끝
			max = Math.max(max, sum);
			return;
		}
		for(int d=0; d<4; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if(nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny]) continue;
			if(cnt == 2) { // 정사각형 모양의 경우
				visit[nx][ny] = true;
				dfs(x, y, cnt+1, sum+arr[nx][ny]);
				visit[nx][ny] = false;
			}
			visit[nx][ny] = true;
			dfs(nx, ny, cnt+1, sum+arr[nx][ny]);
			visit[nx][ny] = false;
		}
	}

}
