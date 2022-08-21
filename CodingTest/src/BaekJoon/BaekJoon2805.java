package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2805 { // 나무 자르기(S2)

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		long start = 0, end = Long.MIN_VALUE, mid = 0, total=0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, arr[i]);
		}
		
		while(start < end) {
			mid = (start+end)/2;
			total = 0; // 나무 길이의 합
			for(int i=0; i<N; i++) {
				total += (arr[i] - mid <= 0)? 0 : arr[i]-mid;
			}
			if(total >= M) {
				start = mid + 1;
			}else {
				end = mid;
			}
		}
		System.out.println(start-1);
	}
}
