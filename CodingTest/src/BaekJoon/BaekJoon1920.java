package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1920 {
	static int n, m, A[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		A = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++)
			System.out.println(binary(0,A.length-1,Integer.parseInt(st.nextToken())));

	}
	private static int binary(int start, int end, int target) {
		if(start > end) return 0;
		int mid = (start+end)/2;
		if(A[mid]==target) return 1;
		if(A[mid]<target) return binary(mid+1, end, target);
		else return binary(start, mid-1, target);
	}
}
