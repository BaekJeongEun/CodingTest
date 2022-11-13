package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWExpertAcademy1486 { // 장훈이의 높은 선반
	static int[] arr;
	static int N, B, min;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc =1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			min = Integer.MAX_VALUE;
			recur(0, 0);
			sb.append("#"+tc+" "+min+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void recur(int height, int idx) {
		if(height-B>=0 && height-B>=min) return;
		if(height >= B) {
			min = Math.min(min, height-B);
			return;
		}
		for(int i=idx; i<N; i++) {
			recur(height + arr[i], i+1);
		}
		
	}
}
