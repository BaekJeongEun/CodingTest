package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon10816 { // 숫자카드2 (S4)
	static int N, M, arrN[], arrM[]
;	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arrN = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrN);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(temp)).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int binarySearch(int target) {
		// upperbound
		int start = 0, end = N, mid, upper=0, lower=0;
		while(start<end) {
			mid = (start+end)/2;
			if(arrN[mid]>target) {
				end = mid;
			}else {
				upper = mid+1;
				start = mid+1;
			}
		}
		// lowerbound
		start = 0; end = N;
		while(start<end) {
			mid = (start+end)/2;
			if(arrN[mid]>=target) {
				end = mid;
			}else {
				lower = mid+1;
				start = mid+1;
			}
		}
		return upper-lower;
	}

}
