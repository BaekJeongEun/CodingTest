package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1806 { // 부분합 (G4)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		System.out.println(st.hasMoreTokens());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0, end = 0, min = Integer.MAX_VALUE, sum = 0;
		while (start <= N && end <= N) {
			if (sum >= M && min > end-start) {
				min = end - start;			
			}
			if (M > sum) {
				sum += arr[end++];
			}else sum -= arr[start++];
			System.out.println("start "+start+"  end "+end);
		}
		
		System.out.println((min==Integer.MAX_VALUE)?0:min);
	}

}
