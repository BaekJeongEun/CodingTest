package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon3020 { // 개똥벌레 (G5)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] ceil = new int[H + 1];
		int[] floor = new int[H + 1];

		for (int i = 0; i < N / 2; i++) {
			floor[Integer.parseInt(br.readLine())]++;
			ceil[Integer.parseInt(br.readLine())]++;
		}

		for (int i = H - 1; i > 0; i--) {
			ceil[i] += ceil[i + 1];
			floor[i] += floor[i + 1];
		}

		int[] arr = new int[H + 1];
		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= H; i++) {
			arr[i] = floor[i] + ceil[H - i + 1];
			min = Math.min(min, arr[i]);
		}
		int cnt = 0;
		for (int i = 1; i <= H; i++) {
			if (arr[i] == min)
				cnt++;
		}
		System.out.println(min + " " + cnt);
	}
}