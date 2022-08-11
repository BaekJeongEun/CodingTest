package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2003_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0, end = 0, cnt = 0, sum = arr[0];
		while (end < N) {
			if(sum < M) {
				end++;
				sum += arr[end];
			}else if(sum > M) {
				sum -= arr[start];
				start++;
			}
			else if(sum==M) {
				cnt++;
				end++;
				sum += arr[end];
				sum -= arr[start];
				start++;
			}
		}
		System.out.println(cnt);
	}
}