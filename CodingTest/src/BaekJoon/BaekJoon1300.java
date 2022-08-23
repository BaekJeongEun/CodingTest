package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1300 { // K번째 수 (G2)

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		long mid, start = 1, end = K, total = 0, temp;
		while (start <= end) {
			mid = (start + end) / 2;
			total = 0;
			for (int i = 1; i <= N; i++) {
				temp = (mid / i >= N) ? N : mid / i; // 각 행마다 개수
				total += temp;
			}
			if (total < K) {
				start = mid + 1;
			} else
				end = mid - 1;
		}
		System.out.println(start);
	}

}
