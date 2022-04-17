package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon10871 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp < X)
				sb.append(temp+" ");
		}
		System.out.println(sb.toString());
	}
}
