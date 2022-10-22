package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon10819 { // 차이를 최대로 (S2)
	static int N, max = Integer.MIN_VALUE;
	static int[] arr, combList;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		combList = new int[N];
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		perm(0);
		System.out.println(max);
	}
	private static void perm(int cnt) {
		if(cnt == N) {
			sum();
			return;
		}
		for(int i=0; i<N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			combList[cnt] = arr[i];
			perm(cnt+1);
			visit[i] = false;
		}
	}
	private static void sum() {
		int sum = 0;
		for(int i=0; i<N-1; i++) {
			sum += Math.abs(combList[i] - combList[i+1]);
		}
		max = Math.max(max, sum);
	}
}
