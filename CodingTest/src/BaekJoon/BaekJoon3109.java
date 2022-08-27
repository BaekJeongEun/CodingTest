package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon3109 { // 빵집 (G2)
	static char[][] arr;
	static int[][] dir = {{-1, 1}, {0,1}, {1,1}}; // 대각선 위, 오른쪽, 대각선 아래
	static int R, C;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		for(int r=0; r<R; r++) {
			arr[r] = br.readLine().toCharArray();
		}
		int cnt = 0;
		for(int i=0; i<R; i++) {
			if(dfs(i, 0)) cnt++;
		}
		System.out.println(cnt);
	}
	
	private static boolean dfs(int startX, int startY) {
		int x = startX, y = startY;
		int nextX, nextY;
		arr[startX][y] = 'x';
		for(int d=0; d<3; d++) {
			nextX= x + dir[d][0];
			nextY= y + dir[d][1];
			if(nextX>=0 && nextX<R && nextY == C-1) return true;
			if(nextX>=0 && nextY>=0 && nextX<R && nextY<C && arr[nextX][nextY]=='.') {
				if(dfs(nextX, nextY))
					return true;
			}
		}
		return false;
	}
}