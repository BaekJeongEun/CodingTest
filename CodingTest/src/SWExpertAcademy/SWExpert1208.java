package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWExpert1208 { // flatten

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<N; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;
			}

			Arrays.sort(arr);
			System.out.println("#"+tc+" "+(arr[99]-arr[0]));
		}
	}

}
