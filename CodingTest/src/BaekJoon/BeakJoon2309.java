package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BeakJoon2309 {
	static int arr[];
	static boolean visit[];
	static boolean success;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9];
		visit = new boolean[9];
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] input = new int[7];
		dfs(0,0,0, input);
	}

	private static void dfs(int idx, int cnt, int sum, int[] input) {
		if(cnt == 7) {
			if(!success && sum==100) {
				Arrays.sort(input);
				for(int i=0; i<input.length; i++) {
					System.out.println(input[i]);
				}
				success = true;
				return;
			}
			return;
		}
		for(int i=idx; i<9; i++) {
			if(!visit[i]) {
				visit[i] = true;
				input[cnt] = arr[i];
				dfs(idx+1, cnt+1, sum+arr[i], input);
				visit[i] = false;
			}
		}
	}

}
