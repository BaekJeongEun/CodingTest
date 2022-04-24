package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2579 {
	static int N, arr[], sum[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		sum = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		sum[1] = arr[1];
		if (N >= 2) {
			sum[2] = arr[1] + arr[2];
			if(N>=3)
				sum[3] = Math.max(arr[1], arr[2]) + arr[3];
		}
		for (int i = 4; i <= N; i++) {
			sum[i] = Math.max(arr[i - 1] + sum[i - 3], sum[i - 2]) + arr[i];
		}
		System.out.println(sum[N]);
	}
}