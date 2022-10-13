package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon14501 { // 퇴사 (S3)
	static int N, max=Integer.MIN_VALUE;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());	
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0); // 며칠째인지, 가격
		System.out.println(max);
	}
	private static void dfs(int day, int cost) {
		if(day > N) return;
		max = Math.max(max, cost);
		System.out.println(max);
		for(int i=day; i<N; i++) {
			dfs(i+arr[i][0], cost+arr[i][1]);
			
		}
	}
}