package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11047 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int price = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = N - 1; i >= 0; i--) {
			if (arr[i] <= price) {
					cnt += (price/arr[i]);
			}
			price -= arr[i]*(price/arr[i]);
		}
		
		System.out.println(cnt);
	}

}
