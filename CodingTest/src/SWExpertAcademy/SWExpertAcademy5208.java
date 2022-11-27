package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWExpertAcademy5208 { // 전기버스 2 (D3)
	static int min, N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			for(int i=0; i<N-1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			sb.append("#"+tc+" "+min+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void dfs(int cnt, int idx) {
		if(cnt>min) return;
		if(idx >= N-1) {
			min = Math.min(min, cnt)-1;
			return;
		}
		for(int i=0; i<arr[idx]; i++) {
			dfs(cnt+1, idx+i+1);
		}
	}
	
}
