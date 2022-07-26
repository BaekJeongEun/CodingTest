package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon16283 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int x = -1;
		int y = -1;

		int loop = (w % a == 0) ? w / a - 1 : w / a;
		A:for (int i = 1; i <= loop; i++) {
			if ((a * i) + b * (n - i) == w) {
				if(x !=-1 && y!=-1) {
					x = -1;
					y = -1;
					break A;
				}
				x = i;
				y = n-i;
			}
		}
		
		if(x==-1 && y==-1) System.out.println(-1);
		else System.out.println(x+" "+y);
	}
}
