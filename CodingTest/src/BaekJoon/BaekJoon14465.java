package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon14465 { // 소가 길을 건너간 이유 5 (S2)

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		for(int i=0; i<B; i++) {
			arr[Integer.parseInt(br.readLine())] = 1;
		}

		int start = 1, cnt=0, min=Integer.MAX_VALUE, sum=0;
		for(int i=start; i<=N-K+1; i++) {
			cnt=0;
			for(int j=i; j<i+K; j++) {
				if(arr[j]==1) {
					cnt++;
				}
			}
			min = Math.min(min, cnt);
		}
		System.out.println(min);
	}

}
