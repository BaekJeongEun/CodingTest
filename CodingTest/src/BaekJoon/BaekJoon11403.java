package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon11403 { // 경로 찾기 (S1)
	static int N;
	static int[][] arr;
	static int[][] result;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		result = new int[N][N];
		visit = new boolean[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = Arrays.copyOf(arr, arr.length);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 1) {
					dfs(i, j);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(result[i][j]).append(" ");
			}sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int start, int idx) {
		for(int i=0; i<N; i++) {
			if(arr[idx][i]==1) {
				result[start][i] = 1;
				dfs(start, i);
			}
		}
	}

}
