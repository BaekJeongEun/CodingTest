package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon9095 { // 1, 2, 3 더하기 2 (S3)
    static int N, T, answer;
    static int[] pick;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
        	N = Integer.parseInt(br.readLine());
        	pick = new int[N];
        	answer = 0;
            comb(0, 0);
            sb.append(answer).append("\n");
        }
        
        System.out.println(sb.toString());
        
    }
    private static void comb(int cnt, int sum) {
        if(sum == N) {
        	answer++;
            return;
        }
        for(int i=1; i<=3; i++) {
            if(sum + i <= N) {
                pick[cnt] = i;
                comb(cnt+1, sum+i);
                pick[cnt] = 0;
            }
        }
    }

}