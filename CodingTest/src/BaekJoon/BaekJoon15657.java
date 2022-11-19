package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon15657 { // N과 M(8)
	static int N, M, arr[], select[];
	static boolean visit[];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		select = new int[M];
		visit = new boolean[N];
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void perm(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(select[i]+" ");
			}sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(cnt>0 && select[cnt-1]>arr[i]) continue;
			select[cnt] = arr[i];
			perm(cnt+1);
		}
	}
}