package SWExpertAcademy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class SWExpertAcademy14891 {
    static int N, dir[][] = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}}, cnt[][];
    static char[][] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new char[N][N];
            cnt = new int[N][N];
            for(int i=0; i<N; i++) {
                char[] temp = br.readLine().toCharArray();
                arr[i] = temp;
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(arr[i][j] != '*') {
                        check(i, j);
                    }
                }
            }
            int ans = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(arr[i][j] != '*' && cnt[i][j] == 0) {
                        ans++;
                        bfs(new int[] {i, j});
                    }
                }
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(arr[i][j] != '*' && cnt[i][j] > 0) ans++;
                }
            }
            System.out.println(ans);
        }
    }
    private static void bfs(int[] now) {
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(now);
        cnt[now[0]][now[1]] = -1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for(int d=0; d<8; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if(nx<0 || ny<0 || nx>= N || ny>=N || cnt[nx][ny] == -1 || arr[nx][ny] == '*') continue;
                cnt[nx][ny] = -1;
                if(cnt[nx][ny]==0)
                    queue.offer(new int[] {nx, ny});
            }
        }
    }
    private static void check(int x, int y) {
        int sum = 0;
        for(int d=0; d<8; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            if(nx<0 || ny<0 || nx>=N || ny>=N || arr[nx][ny] != '*') continue;
            sum++;
        }
        cnt[x][y] = sum;
    }
}