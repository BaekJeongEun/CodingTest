package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BaekJoon12101 { // 1, 2, 3 더하기 2
	static int N, K;
	static int[] pick;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		pick = new int[N];
		dfs(0, 0);
		System.out.println("-1");
	}
	private static void dfs(int cnt, int sum) {
		if(sum == N) {
			K--;
			if(K == 0) {
				StringBuilder sb = new StringBuilder();
				for(int i=0; i<N; i++) {
					if(pick[i]==0) break;
					sb.append(pick[i]);
					if(i != N-2) {
						sb.append("+");
					}
				}
				System.out.println(sb.toString());
				System.exit(0);
			}
			return;
		}
		for(int i=1; i<=3; i++) {
			if(sum+i <= N) {
				pick[cnt] = i;
				dfs(cnt+1, sum+i);
				pick[cnt] = 0;
			}
		}
	}

}
