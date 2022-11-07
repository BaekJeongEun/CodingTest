package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon14889 { // 스타트와 링크(S2)
    static int N, pickCnt, unpickCnt, min = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0, 0);
        System.out.println(min);
    }
    private static void comb(int idx, int cnt) {
        if(cnt == N/2) {
            int[] pick = new int[N/2];
            int[] unpick = new int[N/2];
            int pickIdx = 0;
            int unpickIdx = 0;
            for(int i=0; i<N; i++) {
                if(visit[i]) pick[pickIdx++] = i;
                else unpick[unpickIdx++] = i;
            }
            pickCnt = 0;
            perm(new int[N/2], pick, 0, true);
            unpickCnt = 0;
            perm(new int[N/2],unpick, 0, false);
            min = Math.min(min, Math.abs(pickCnt-unpickCnt));
            return;
        }
        for(int i=idx; i<N; i++) {
            visit[i] = true;
            comb(i+1, cnt+1);
            visit[i] = false;
        }
    }
    private static void perm(int[] index, int[] pick, int cnt, boolean pickStatus) {
        if(cnt == 2) {
            if(pickStatus)
                pickCnt += arr[index[0]][index[1]];
            else unpickCnt += arr[index[0]][index[1]];
            return;
        }
        for(int i=0; i<N/2; i++) {
            index[cnt] = pick[i];
            perm(index, pick, cnt+1, pickStatus);
        }
    }

}