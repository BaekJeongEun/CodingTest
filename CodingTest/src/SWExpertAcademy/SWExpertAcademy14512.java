package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWExpertAcademy14512 { // 상담 시간 (D3)
	static int N, M, min, start, end;
	static int arr[][], pick[];
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			start = Integer.MAX_VALUE; end = Integer.MIN_VALUE;
			arr = new int[N][2];
			pick = new int[N];
			visit = new boolean[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				start = Math.min(start, arr[i][0]);
				end = Math.max(end, arr[i][1]);
			}
			min = Integer.MAX_VALUE;
			perm(0);
			System.out.println((min==Integer.MAX_VALUE)?-1:min);
		}
		
	}
	private static void perm(int cnt) {
		if(cnt == N) {
			for(int p=1; p<=end; p++) { // 1분부터 시작
				int pre = p; // 첫 상담시간 + 1
				int i;
				for( i=0; i<N; i++) {
					if(pre >= arr[pick[i]][0] && pre <= arr[pick[i]][1]) {
						pre++; // 1분동안 상담
					}else {
						break;
					}
				}
				if(i==N)
					min = Math.min(min, p);
			}
			return;
		}
		for(int i=0; i<N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			pick[cnt] = i;
			perm(cnt+1);
			visit[i] = false;
		}
	}

}
