package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon2529 { // 부등호 (S1)
	static int K, N;
	static String max="", min="";
	static boolean visit[];
	static int[] pick;
	static char[] operation;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		K = Integer.parseInt(br.readLine());
		N = K + 1;
		operation = new char[K];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			operation[i] = st.nextToken().charAt(0);
		}
		
		visit = new boolean[10];
		pick = new int[N];
		maxPermu(0);
		visit = new boolean[10];
		pick = new int[N];
		minPermu(0);
		sb.append(max+"\n"+min);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void check() {
		int pre = pick[0], post;
		for(int i=1; i<pick.length; i++) {
			post = pick[i];
			if(operation[i-1] == '<') {
				if(pre >= post) {
					return;
				}
			}else {
				if(pre <= post) {
					return;
				}
			}
			pre = post;
		}
		StringBuilder sb = new StringBuilder();
		if(max == "") {
			for(int i=0; i<pick.length; i++) {
				sb.append(pick[i]+"");
			}
			max = sb.toString();
		}
		else if(min == "") {
			for(int i=0; i<pick.length; i++) {
				sb.append(pick[i]+"");
			}
			min = sb.toString();
		}
	}
	private static void maxPermu(int cnt) {
		if(max != "") return;
		if(cnt == N) {
			check();
			return;
		}
		for(int i=9; i>=0; i--) {
			if(visit[i]) continue;
			visit[i] = true;
			pick[cnt] = i;
			maxPermu(cnt+1);
			visit[i] = false;
		}
	}
	private static void minPermu(int cnt) {
		if(min != "") return;
		if(cnt == N) {
			check();
			return;
		}
		for(int i=0; i<=9; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			pick[cnt] = i;
			minPermu(cnt+1);
			visit[i] = false;
		}
	}

}
