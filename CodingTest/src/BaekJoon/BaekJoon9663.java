package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon9663 { // N-Queen (G4)
	static int N, total;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dfs(0);
		System.out.println(total);
	}
	private static void dfs(int cur) {
		if(cur == N) {
			total++;
			return;
		}
		for(int i=0; i<N; i++) {
			arr[cur] = i;
			if(check(cur)) {
				dfs(cur+1);
			}
		}
	}
	private static boolean check(int cur) {
		for(int i=0; i<cur; i++) {
			if(arr[cur] == arr[i]) return false;
			else if(Math.abs(cur-i) == Math.abs(arr[cur]-arr[i])) return false;
		}
		return true;
	}

}
