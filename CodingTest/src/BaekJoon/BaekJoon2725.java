package BaekJoon;

import java.util.*;
import java.io.*;

public class BaekJoon2725 { // 보이는 점의 개수 (S2)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		int N;

		long[] arr = new long[1001];
		arr[1] = 3;
		for (int i = 2; i <= 1000; i++) {
			int cnt = 0;
			for (int j = 1; j < i; j++) {
				if(gcd(i, j) == 1)
					cnt++;
			}
			arr[i] = arr[i-1] + 2 * cnt;
		}

		for (int i = 0; i < TC; i++) {
			N = Integer.parseInt(br.readLine());
			System.out.println(arr[N]);

		}

	}

	private static long gcd(long i, long j) {
		long mod = i;
		while(j != 0) {
			mod = i%j;
			i=j;
			j=mod;
		}
		return i;
	}

}
