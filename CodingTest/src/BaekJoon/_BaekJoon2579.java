package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _BaekJoon2579 {
	static int N, sum, arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i=0; i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(rec(0));
	}
	static int rec(int cur) {
		sum += arr[cur];
		if(cur>=N || cur+1>=N || cur+2>=N)
			return sum;
		if(arr[cur+1]<arr[cur+2])
			return rec(cur+2);
		else
			return rec(cur+1);
	}
}