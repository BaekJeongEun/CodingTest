package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon14719 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int w, h, l_max, r_max, sum = 0, second_max;
		int arr[] = new int[500];
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<w; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < w - 1; i++) {
			l_max = arr[i + 1];
			for (int j = i + 1; j >= 0; j--) { // 왼쪽 max 수 찾기
				if (arr[j] > l_max) {
					l_max = arr[j];
				}
			}
			r_max = arr[i + 1];
			for (int j = i + 1; j < w; j++) { // 오른쪽 max 수 찾기
				if (arr[j] > r_max) {
					r_max = arr[j];
				}
			}
			second_max = (l_max < r_max) ? l_max : r_max;

			sum += (second_max - arr[i + 1]);
		}
		System.out.println(sum);
	}

}
