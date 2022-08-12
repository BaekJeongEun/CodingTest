package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon3273 { //두 수의 합 (S3)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int k = Integer.parseInt(br.readLine());
		int cnt = 0;
		int start = 0, end = n - 1, sum = arr[start]+arr[end];
		while (start < end) {
			if (sum == k) {
				cnt++;
				sum = arr[--end] + arr[++start];
			} else if (sum < k) { // 작으니까 늘리기
				sum = arr[++start] + arr[end];
			} else if (sum > k) { // 크니까 줄이기
				sum = arr[start] + arr[--end];
			}
		}

		//System.out.println(cnt);
		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}

}
