package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _BaekJoon1920 {
	static int[] arr_n = new int[2147483647];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr_n = new int[100001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr_n[Integer.parseInt(st.nextToken())] = 1;
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			if(arr_n[Integer.parseInt(st.nextToken())] == 1)
				System.out.println("1");
			else System.out.println("0");
		}
		
	}
}
