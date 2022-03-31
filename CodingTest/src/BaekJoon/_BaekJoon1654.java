package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _BaekJoon1654 {
	static int n, k, arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		System.out.println(rec(0,arr[arr.length-1], arr[arr.length-1]/2, 0));
	}
	private static int rec(int s, int e, int mid, int sum) {
		
		int cur_mid = (s+e)/2;
		if(s>e) return cur_mid;
		int temp_sum=0;
		for(int i=0; i<n; i++) {
			temp_sum += arr[i]/cur_mid;
		}
		if(temp_sum<k) { // 개수가 적다 -> 길이를 줄여야 한다
			return rec(s, mid-1, cur_mid, sum);
		}else {
			return rec(mid+1, e, cur_mid, sum); 
		}
	}
}
