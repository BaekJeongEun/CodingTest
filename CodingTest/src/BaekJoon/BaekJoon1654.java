package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1654 {
	static long k, arr[];
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new long[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		System.out.println(rec(1,arr[arr.length-1], 0));
	}
	private static int rec(long s, long e, int result) {
		//System.out.println(s+" "+e);
		if(s>e) return result;
		long cur_mid =  (long) Math.floor((s+e))/2;
		int temp_sum=0;
		for(int i=0; i<n; i++) {
			temp_sum += (arr[i]/cur_mid);
		}
			
		if(temp_sum<k) { // 개수가 적다 -> 길이를 줄여야 한다
			e = cur_mid - 1;
		}else {
			s = cur_mid + 1;
			result = (int)cur_mid;
		} 
		int next_result = rec(s, e, result);
		
		return Math.max(result, next_result);
	}
}
