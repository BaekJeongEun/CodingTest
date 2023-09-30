package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon16174 { // 점프왕 쩰리 (Large)(S1)
	static int N;
	static boolean success;
	static int[][] arr, dir= {{1,0},{0,1}};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0, new boolean[N][N]);
		System.out.println(success?"HaruHaru":"Hing");
	}
	private static void dfs(int sX, int sY, boolean[][] visit) {
		visit[sX][sY] = true;
		if(sX == N-1 && sY == N-1 && arr[sX][sY] == -1) {
			success = true;
			return;
		}
		for(int d=0; d<2; d++) {
			int mul = arr[sX][sY];
			int nx = sX + dir[d][0]*mul;
			int ny = sY + dir[d][1]*mul;
			if(nx <0 || ny<0 || nx>=N || ny>=N || visit[nx][ny]) continue;
			dfs(nx, ny, visit);
			visit[nx][ny] = false;
		}
	}

}
