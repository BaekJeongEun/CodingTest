package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon15652 { // N과 M(4)
	static int N, M, arr[], select[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		select = new int[M];
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		permutation(0);
	}
	private static void permutation(int cnt) {
		if(cnt == M) {
			for(int i=0; i<select.length; i++) {
				System.out.print(select[i]+" ");
			}System.out.println();
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(cnt > 0 && select[cnt-1]>arr[i]) {
				continue;
			}
			select[cnt] = arr[i];
			permutation(cnt+1);
			
		}
	}
}