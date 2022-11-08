package BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon14503 { // 로봇 청소기(G5)
    static int N, M, ans;
    static int[][] arr, dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // 북0 서1 남2 동3

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        switch (d) {
        case 1:
            d = 3;
            break;
        case 3:
            d = 1;
            break;
        }
        bfs(r, c, d);
        System.out.println(ans);
    }

    private static void bfs(int r, int c, int di) {
        Queue<Machine> q = new ArrayDeque<>();
        if(arr[r][c]==0) {
            arr[r][c] = -1;
            ans++;
        }
        q.offer(new Machine(r, c, di));

        while (!q.isEmpty()) {
            Machine now = q.poll();
            int x = now.x;
            int y = now.y;
            int direc = now.d;
            int nd = direc;
            boolean find = false;
            for(int d=0; d<4; d++) {
                nd = (nd + 1 > 3) ? 0 : nd + 1;
                int nx = x + dir[nd][0];
                int ny = y + dir[nd][1];
                if(isArea(nx, ny)) {
                    if(arr[nx][ny]==0) { // 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면
                        arr[nx][ny] = -1;
                        ans++;
                        q.offer(new Machine(nx, ny, nd)); // 그 방향으로 회전한 다음 한 칸을 전진
                        find = true;
                        break;
                    }
                }
            }
            if(!find) { // 네 방향 모두 청소가 이미 되어있거나 벽인 경우
                // 바라보는 방향을 유지한 채로 한 칸 후진
                int nx = x - dir[direc][0];
                int ny = y - dir[direc][1];
                if(isArea(nx, ny) && arr[nx][ny]!=1) {
                    q.offer(new Machine(nx, ny, direc));
                }
            }
            
        }
    }
    
    private static boolean isArea(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }

    private static class Machine {
        int x, y, d;

        public Machine(int x, int y, int d) {
            super();
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}