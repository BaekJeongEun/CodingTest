package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BaekJoon11728 { // 배열 합치기 (S5)

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[] a = new int[A];
		int[] b = new int[B];
		int[] result = new int[A+B];
		int loop = Math.min(A, B);
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<A; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<B; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		for(int i=0; i<loop; i++) {
			if(a[i]<b[i]) {
				result[idx++] = a[i];
				result[idx++] = b[i];
			}else {
				result[idx++] = b[i];
				result[idx++] = a[i];				
			}
		}
		boolean aMax = true;
		int start = B, end = A;
		if(A<B) {
			aMax = false;
			start = A;
			end = B;
		}
		for(int i=start; i<end; i++) {
			if(aMax) result[idx++] = a[i];
			else result[idx++] = b[i];
		}
		Arrays.sort(result);
		for(int i=0; i<result.length; i++) {
			sb.append(result[i]).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
