package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon14697 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		boolean exit = false;
		for(int x=0; !exit && a*x<=N; x++) {
			for(int y=0; !exit && a*x + b*y<=N; y++) {
				for(int z=0; !exit && a*x + b*y + c*z<=N; z++) {
					if(a*x + b*y + c*z == N) {
						exit = true;
					}
				}
			}
		}
		
		System.out.println(exit?"1":"0");
	}

}
