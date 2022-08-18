package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon22988 { // 재활용 캠페인 (G2)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long X = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ArrayList<Long> arr = new ArrayList<>();
		int start = 0, end = N, count = 0;
		for (int i = 0; i < N; i++) {
			long temp = Long.parseLong(st.nextToken());
			if (temp == X) {
				count++;
				continue;
			}
			arr.add(temp);
		}
		Collections.sort(arr);
		
		int size = arr.size();
		end = arr.size() - 1;
		while (start <= end) {
			// 반+반
			long sum = arr.get(start) + arr.get(end);
			if (sum + (X / 2)>= X) {
				start++;
				end--;
				count++;
				size -= 2;
			}else start++;
		}
		// 3병 이상 남았다면 한 병 취급
		count += size / 3;
		
		System.out.println(count);
	}
}