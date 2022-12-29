package BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1520 { // 내리막길 (G3)
    static int M, N, cnt;
    static int[][] count, arr, dir= {{-1,0}, {0,-1}, {0,1}, {1,0}};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        count = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(cnt);
    }
    private static void dfs(int x, int y) {
        if(x == N-1 && y == M-1) {
        	cnt++;
            return;
        }
        count[x][y]++;
        for(int d=0; d<4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            if(nx<0 || ny<0 || nx>=N || ny>=M || arr[nx][ny] >= arr[x][y]) continue;
            dfs(nx, ny);
        }
    }

}