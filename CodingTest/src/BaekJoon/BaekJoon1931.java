package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BaekJoon1931 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int arr[][] = new int[N][2];
		StringTokenizer st;

		for (int k = 0; k < N; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[k][0] = Integer.parseInt(st.nextToken());
			arr[k][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// ����ð��� ���� ��� ���۽ð��� ���������� �����ؾ��Ѵ�.
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}

		});
		int prev_end_time = 0;

		for (int i = 0; i < N; i++) {
			// ���� ����ð��� ���� ȸ�� ���� �ð����� �۰ų� ���ٸ� ����
			if (prev_end_time <= arr[i][0]) {
				prev_end_time = arr[i][1];
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}