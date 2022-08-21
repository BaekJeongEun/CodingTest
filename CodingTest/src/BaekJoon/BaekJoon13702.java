package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon13702 { // 이상한 술집(S3)
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()), total=0;
		long mid = 0, start = 1, end = Long.MIN_VALUE;
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			end = Math.max(end, arr[i]);
		}
		while(start <= end) {
			mid = (start+end)/2;
			total=0;
			for(int i=0; i<N; i++) {
				total += arr[i]/mid; // 몇 명 줄 수 있는가
			}
			if(total < K) { // 학생수보다 작다면 막걸리 양 줄이기
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		System.out.println(end);
	}
}