package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2675 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int i=0; i<TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String[] str = st.nextToken().split("");
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<str.length; j++) {
				for(int k=0; k<n; k++) {
					sb.append(str[j]);
				}
			}
			System.out.println(sb.toString());
		}
	}
}
