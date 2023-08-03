package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Virus { // 바이러스 (L2)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long K = Integer.parseInt(st.nextToken());
		long P = Integer.parseInt(st.nextToken());
		long N = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			K *= P;
			K %= 1000000007;
		}
		System.out.println(K);
	}

}
