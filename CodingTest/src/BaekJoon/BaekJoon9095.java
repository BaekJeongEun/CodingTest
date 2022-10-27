package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon9095 { // 1, 2, 3 더하기 2 (S1)
    static int N, K;
    static ArrayList<String> list = new ArrayList<>();
    static int[] pick;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        pick = new int[N];
        comb(0, 0);
        
        System.out.println((list.size() >= K)?list.get(K-1):"-1");
        
    }
    private static void comb(int cnt, int sum) {
        if(sum == N) {
            StringBuilder sb = new StringBuilder();
            int i=0;
            for(i=0; i<pick.length; i++) {
                if(pick[i] == 0) break;
                sb.append(pick[i]);
                sb.append("+");
            }
            
            list.add(sb.toString().substring(0, sb.toString().length()-1));
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