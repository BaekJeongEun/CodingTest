package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11053 {

	static int N, arr[], max;
	static Integer cnt[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		cnt = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++)
			rec(i);
		max = cnt[0];
		for(int i=1; i<N; i++) {
			max = Math.max(max, cnt[i]);
		}
		System.out.println(max);
	}

	private static int rec(int idx) {
		if (cnt[idx] == null) {
			cnt[idx] = 1;
			for (int i = idx - 1; i >= 0; i--) {
				if (arr[idx] > arr[i]) {
					cnt[idx] = Math.max(cnt[idx], rec(i) + 1);
				}
			}
		}
		return cnt[idx];
	}

}
