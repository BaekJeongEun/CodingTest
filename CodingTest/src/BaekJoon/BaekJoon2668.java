package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BaekJoon2668 { // 숫자고르기 (G5)
	static int N, total;
	static int[] arr;
	static boolean[] visit;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		visit = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i=1; i<=N; i++) {
			visit[i] = true;
			dfs(i, i);
			visit[i] = false;
		}

		Collections.sort(list);
		sb.append(list.size()+"\n");
		for(Integer i : list) {
			sb.append(i+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void dfs(int cur, int origin) {
		if(origin == arr[cur]) {
			list.add(origin);
			return;
		}
		if(visit[arr[cur]]) return;
		visit[arr[cur]] = true;
		dfs(arr[cur], origin);
		visit[arr[cur]] = false;
	}

}
