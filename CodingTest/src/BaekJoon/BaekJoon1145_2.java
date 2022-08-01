package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1145_2 { // 적어도 대부분의 배수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[5];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Arrays.stream(arr).min().getAsInt();
		int i=min;
		for(; ; i++) {
			int cnt = 0;
			for(int j=0; j<5; j++) {
				if(i % arr[j] ==0) {
					cnt++;
				}
			}
			if(cnt>=3) {
				break;
			}
		}
		System.out.println(i);
	}

}
