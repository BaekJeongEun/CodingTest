package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1747 { // 소수&팰린드롬(S1)
	static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if (n == 1){
            System.out.println(2);
            System.exit(0);
        }
        for (int i = n; ; i++){
            if (isPalind(i) && isPrime(i)){
                System.out.println(i);
                System.exit(0);
            }
        }
    }
    public static boolean isPrime(int x){
        for (int i = 2; i <= Math.sqrt(x); i++){
            if (x % i == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isPalind(int x) {
        String strX = Integer.toString(x);
        int cnt = strX.length();
        for (int i = 0; i <= cnt / 2; i++){
            if (strX.charAt(i) != strX.charAt(cnt-i-1)){
                return false;
            }
        }
        return true;
    }
}
