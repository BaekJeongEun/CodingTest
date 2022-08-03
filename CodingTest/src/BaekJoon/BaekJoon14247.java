package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon14247 { // 나무 자르기 (S2)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] grow = new int[N];
		int sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			grow[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(grow);
		for(int i=0; i<N; i++) {
			sum += arr[i] + grow[i]*i;
		}
		System.out.println(sum);
	}

}
