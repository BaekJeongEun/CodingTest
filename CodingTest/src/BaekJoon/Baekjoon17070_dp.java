package BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon17070_dp { // 파이프 옮기기 1( G5)
    static int N, ans;
    static int arr[][], dp[][][];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N][3]; // x, y, 방향
        /**
         * 0 : 가로 1 : 세로 2 : 대각선
         */
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 1;
        while(idx <N && arr[0][idx] == 0) {
            dp[0][idx++][0] = 1;
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (arr[i][j] == 0) {
                    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]; // 가로, 대각선
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2]; // 세로, 대각선
                    if (arr[i - 1][j] == 0 && arr[i][j - 1] == 0)
                        dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2]; // 가로, 세로, 대각선
                }
            }
        }
        System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
    }
}