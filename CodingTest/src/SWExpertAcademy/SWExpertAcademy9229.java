package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWExpertAcademy9229 {
	static int N, M, ans=-1;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			for(int n=0; n<N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			ans = -1;
			comb(0, 0, 0);
			System.out.println("#"+tc+" "+ans);
		}
	}
	static void comb(int cnt, int idx, int sum) {
		if(sum > M)
		{
			return;
		}
		if(cnt == 2) {
			ans = Math.max(ans, sum);
			return;
		}
		if(idx >= N) return;
		comb(cnt+1, idx+1, sum+arr[idx]);
		comb(cnt, idx+1, sum);
	}
}