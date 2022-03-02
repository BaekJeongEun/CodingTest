package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1065 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(han_soo(N));
	}
	public static int han_soo(int n) {
		int cnt = 99;
		
		if(n < 100)
			return n;
		else {
			if(n==1000) {
				n = 999;
			}
			for(int i=100; i<=n; i++) {
				int hundred = i/100;
				int ten = (i/10)%10;
				int one = i%10;
				
				if(hundred-ten == ten-one) {
					cnt++;
				}
			}		
		}
		return cnt;
	}
	
//	public static int han_soo(int n) {
//		int hundred = n/100;
//		int ten = (n/10)%10;
//		int one = n%10;
//		
//		if((n >0 && n < 100) || (n>=100 && (hundred-ten == ten-one))) { // 한 자릿수, 두 자릿수, 세 자릿수 중 한수인 경우
//			System.out.println(n+" !");
//			return 1 + han_soo(n-1);
//		}
//		else if(!(n>=100 && !(hundred-ten == ten-one))) {
//			return 0;
//		}
//		else
//			return han_soo(n-1);
//	}
}
