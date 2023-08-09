package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon24479 { // 깊이 우선 탐색 1 (S2)
	static int N, M, R, cnt=1;
	static ArrayList<ArrayList<Integer>> arr;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		answer = new int[N+1];
		for(int i=0; i<=N; i++) {
			arr.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr.get(u).add(v);
			arr.get(v).add(u);
		}
		for(int i=1; i<=N; i++) {
			Collections.sort(arr.get(i));
		}
		
		dfs(R);
		for(int i=1; i<=N; i++) {
			sb.append(answer[i]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void dfs(int start) {
		answer[start] = cnt;
		for(int i=0; i<arr.get(start).size(); i++) {
			int now = arr.get(start).get(i);
			if(answer[now] != 0) continue;
			cnt++;
			dfs(now);
		}
	}

}
