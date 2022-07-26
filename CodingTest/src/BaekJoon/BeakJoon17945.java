package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BeakJoon17945 { // 통학의 신

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[] arr = new int[2];
		
		arr[0] = (int) (((-A) + (Math.sqrt(Math.pow(A, 2) - (B)))));
		arr[1] = (int) (((-A) - (Math.sqrt(Math.pow(A, 2) - (B)))));
		
		Arrays.sort(arr);
		
		if(arr[0]!=arr[1])
			System.out.println(arr[0] + " "+ arr[1]);
		else
			System.out.println(arr[0]);
	}

}
