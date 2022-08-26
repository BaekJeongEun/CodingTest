package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon10971 { // 외판원 순회 2(S2)
	static int arr[][], N, min = Integer.MAX_VALUE;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[N][N];
		visit = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<N; i++) {
			dfs(i, i, 0, 0);
		}
		System.out.println(min);
	}
	private static void dfs(int start, int end, int cnt, int sum) {
		if(cnt == N && start == end) {
			min = Math.min(min, sum);
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visit[end] && arr[end][i]>0) {
				visit[end] = true;
				sum += arr[end][i];
				if(sum <= min)
					dfs(start, i, cnt+1, sum);
				visit[end] = false;
				sum -= arr[end][i];
			}
		}
	}

}
