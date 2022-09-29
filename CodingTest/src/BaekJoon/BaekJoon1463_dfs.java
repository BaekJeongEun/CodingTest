package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1463_dfs {
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dfs(N, 0);
		System.out.println(min);
	}
	private static void dfs(int n, int cnt) {
		if(n == 1) {
			min = Math.min(min, cnt);
			return;
		}
		if(cnt >= min) return;
		if(n%3==0) {
			dfs(n/3, cnt+1);
		}
		if(n%2==0) {
			dfs(n/2, cnt+1);
		}
		dfs(n-1, cnt+1);
	}
}
