package ndbCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡볶이떡만들기 {
	static int n, m;
	static long arr[]; // https://www.acmicpc.net/board/view/23581
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		System.out.println(binary(0, arr[arr.length-1]));
	}
	private static long binary(long start, long end) {
		long mid = (start+end)/2, sum=0;
		if(start>end) return mid;
		for(int i=0; i<n; i++) {
			if(arr[i] > mid) {
				sum += arr[i]-mid;
			}
		}		
		if(sum >= m) return binary(mid+1, end); 
		else return binary(start, mid-1);
	}

}



