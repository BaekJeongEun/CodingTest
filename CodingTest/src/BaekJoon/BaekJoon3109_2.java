package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon3109_2 { // 빵집 (G2)
	static char[][] arr;
	static int[][] dir = {{-1, 1}, {0,1}, {1,1}}; // 대각선 위, 오른쪽, 대각선 아래
	static int R, C, cnt=0;
	static boolean exit = false;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		for(int r=0; r<R; r++) {
			arr[r] = br.readLine().toCharArray();
		}
		for(int i=0; i<R; i++) {
			exit = false;
			dfs(i, 0);
		}
		System.out.println(cnt);
	}
	
	private static void dfs(int startX, int startY) {
		if(startX>=0 && startX<R && startY == C-1) {
			cnt++;
			exit = true;
			return;
		}
		int nextX, nextY;
		arr[startX][startY] = 'x';
		for(int d=0; d<3; d++) {
			if(exit) break;
			nextX= startX + dir[d][0];
			nextY= startY + dir[d][1];
			if(nextX>=0 && nextY>=0 && nextX<R && nextY<C && arr[nextX][nextY]=='.') {
				dfs(nextX, nextY);
			}
		}
	}
}