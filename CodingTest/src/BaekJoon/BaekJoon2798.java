package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
public class BaekJoon2798 {
	static int N, M;
	static Integer[] numbers, input;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers, Collections.reverseOrder());
		
		System.out.println(combiantion(0, 0, 0));
	}
	static int combiantion(int sum, int start, int cnt) {
		if(cnt == 3 ) {
			return sum>M?0:sum;
		}
		if(start >= N) return 0;
		int max = 0;
		for(int i=start; i<N; i++) {
			max = Math.max(max ,combiantion(sum+numbers[i], i+1, cnt+1));
		}
		return max;
	}
}
