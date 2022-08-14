package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2467 { // 용액(G5)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		int start = 0, end = N - 1, a = 0, b = 0;
		long min = Long.MAX_VALUE;

		while (start < end) {
			long temp = arr[start] + arr[end];
			if (Math.abs(temp) < min) {
				min = Math.abs(temp);
				a = start;
				b = end;
			}
			
			if(temp < 0) start++;
			else end--;
		}
		System.out.println(arr[a] + " " + arr[b]);
	}

}
