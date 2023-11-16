package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon27433 { // 팩토리얼 2(B5)
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fact(n));
        br.close();
    }

    public static long fact(long n) {
        if (n == 0) {		
            return 1;
        }
        if (n > 1) {
            n = n * fact(n - 1); 
        } else {
            n = n * 1; 		
        }
        return n;
    }
}
