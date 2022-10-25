package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon5014 { // 스타트링크 (G5)
	static int F, S, G, U, D;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new long[1000001];
		for(int i=0; i<arr.length; i++) {
			arr[i] = 1000001;
		}
		dfs(0, S);
		System.out.println((arr[G] >= 1000001)?"use the stairs":arr[G]);
	}
	private static void dfs(long cnt, int curStair) {
		arr[curStair] = cnt;
		if(curStair == G || curStair>=1000001) {
			return;
		}
		if(curStair+U <= F && arr[curStair+U] > cnt+1) {
			dfs(cnt+1, curStair+U);
		}
		if(curStair-D > 0 && arr[curStair-D] > cnt+1) {
			dfs(cnt+1, curStair-D);
		}
	}

}
