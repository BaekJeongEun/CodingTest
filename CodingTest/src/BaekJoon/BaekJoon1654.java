package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1654 { // 랜선 자르기 (S2)

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long K = Integer.parseInt(st.nextToken());
		long mid =0, start=1, end=Long.MIN_VALUE, total=0;
		long[] arr = new long[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			end = Math.max(end, arr[i]);
		}
		while(start<=end) {
			mid = (start+end)/2;
			total = 0;
			for(int i=0; i<N; i++) {
				total += arr[i]/mid;
			}
			if(total < K) { // 만들어야 할 랜선 개수보다 적다면 길이 줄여서 개수 늘리기
				end = mid - 1;
			}else start = mid + 1;
		}
		System.out.println(end);
	}
}