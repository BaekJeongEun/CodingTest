package ndbCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡볶이떡만들기 {
	static int n, m, arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		System.out.println(binary(0, arr[arr.length-1]));
	}
	private static int binary(int start, int end) {
		if(start>end) return 0;
		int mid = (start+end)/2, sum=0;
		for(int i=0; i<n; i++) {
			if(arr[i] > mid) {
				sum += arr[i]-mid;
			}
		}
		if(sum == m) return mid;
		if(sum<m) return binary(start, mid-1);
		else return binary(mid+1, end);
	}

}
