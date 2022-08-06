package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon9417 { // 최대 GCD (S4)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()), max = Integer.MIN_VALUE;
		int arr[];
		StringTokenizer st;
		for(int tc=0; tc<N; tc++) {
			st = new StringTokenizer(br.readLine());
			max = Integer.MIN_VALUE;
			arr = new int[st.countTokens()];
			for(int i=0; i<arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					if(i!=j) {
						max = Math.max(max, gcd(arr[i], arr[j]));
					}
				}
			}
			sb.append(max).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int gcd(int i, int j) {
		int mod = i;
		while(j!=0) {
			mod = i%j;
			i = j;
			j = mod;
		}
		return i;
	}

}
