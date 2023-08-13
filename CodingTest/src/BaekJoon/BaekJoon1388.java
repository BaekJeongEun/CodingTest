package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1388 { // 바닥 장식(S4)
	static int N, M;
	static char[][] arr;
	static boolean[][] visit;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				arr[i][j] = temp[j];
			}
		}
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visit[i][j]) continue;
				dfs(i, j, arr[i][j]);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	private static void dfs(int x, int y, char c) {
		visit[x][y] = true;
		for(int d=0; d<4; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if(nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny] || arr[nx][ny] != c) continue;
			if(((d == 0 || d ==1) && c == '-') || ((d == 2 || d ==3) && c == '|'))
				dfs(nx, ny, c);
		}
	}

}
