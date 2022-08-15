package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon20366 { // 같이 눈사람 만들래? (G3)

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int start = 0, end = N - 1, min = Integer.MAX_VALUE;

		for (int s = 0; s < N; s++) {
			for (int e = s + 3; e < N; e++) {
				start = s + 1;
				end = e - 1;
				while (start < end) {
					int sum = (arr[s] + arr[e]) - (arr[start] + arr[end]);
					if (Math.abs(sum) < min) {
						min = Math.abs(sum);
					}
					if (sum < 0)
						end--;
					else
						start++;
				}
			}
		}
		System.out.println(min);
	}
}