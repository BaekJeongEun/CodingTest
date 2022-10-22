package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon1182 { // 부분수열의 합 (S2)

	static int N, S, total;
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());		
		S = Integer.parseInt(st.nextToken());		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		visit = new boolean[N];
		subset(0);
		System.out.println(total);
	}
	private static void subset(int cnt) {
		if(cnt == N) {
			int sum = 0;
			boolean exit = false;
			for(int i=0; i<N; i++) {
				if(visit[i]) {
					exit = true;
					sum += arr[i];
				}
			}
			if(exit && sum==S) total++;
			return;
		}
		visit[cnt] = true;
		subset(cnt+1);
		visit[cnt] = false;
		subset(cnt+1);
	}

}
