package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1912_two_pointer { // 연속합 (S2) - 투포인터

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = Integer.MIN_VALUE;
		int start = 0, end = 1, sum=0;
		while(start<N) {
			sum += arr[start];
			max = Math.max(max, sum);
			if(sum >= 0) {
				start++;
			}else {
				end = start + 1;
				start = end;
				if(N == end) break;
				sum = 0;
			}
		}
		max = Math.max(max, sum);
		System.out.println(max);
	}
}