package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon13460 { // 구슬탈출2 (G1)
    static int N, M, ans = -1;
    static boolean[][][][] visit;
    static char[][] arr;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; // 상 하 좌 우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N][M][N][M];
        arr = new char[N][M];
        int rX = 0, rY = 0, bX = 0, bY = 0;
        for(int i=0; i<N; i++) {
            char[] temp = br.readLine().toCharArray();
            for(int j=0; j<M; j++) {
                if(temp[j] == 'R') {
                    rX = i; rY = j;
                    continue;
                }else if(temp[j] == 'B') {
                    bX = i; bY = j;
                    continue;
                }
                arr[i][j] = temp[j];
            }
        }
        bfs(rX, rY, bX, bY);
        System.out.println(ans);
    }
    
    private static void bfs(int redX, int redY, int blueX, int blueY) {
        Queue<Marble> q = new ArrayDeque<>();
        q.offer(new Marble(redX, redY, blueX, blueY, 1));
        visit[redX][redY][blueX][blueY] = true;
        while(!q.isEmpty()) {
            Marble now = q.poll();
            int rx = now.rX;
            int ry = now.rY;
            int bx = now.bX;
            int by = now.bY;
            int cnt = now.cnt;
            if(cnt == 11) {
                return;
            }
            // 현재 위치에서 상하좌우 움직이기
            for(int d=0; d<4; d++) {
                int rnx = rx, rny = ry, rcnt=0;
                int bnx = bx, bny = by, bcnt=0;
                boolean rHole=false, bHole=false;
                // d방향으로 빨간 공 움직이기
                while(arr[rnx+dir[d][0]][rny+dir[d][1]] != '#') {
                    rnx += dir[d][0];
                    rny += dir[d][1];
                    rcnt++;
                    if(arr[rnx][rny]=='O') {
                        rHole = true;
                        break;
                    }
                }
                // d방향으로 파란 공 움직이기
                while(arr[bnx+dir[d][0]][bny+dir[d][1]] != '#') {
                    bnx += dir[d][0];
                    bny += dir[d][1];
                    bcnt++;
                    if(arr[bnx][bny]=='O') {
                        bHole = true;
                        break;
                    }
                }
                if(bHole) continue; // 파란 것마저 들어가면 안 됨
                
                if(rHole && !bHole) {
                    ans = cnt;
                    return;
                }
                
                // 빨간 공과 파란 공 위치가 같다면
                if(rnx==bnx && rny==bny) {
                    // d 방향 위쪽일 때 움직인 거리 더 긴 것의 x++
                    if(d == 0) {
                        if(rcnt < bcnt) {
                            bnx++;
                        }else rnx++;
                    }
                    // d 방향 아래쪽일 때 움직인 거리 더 긴 것의 x--
                    if(d == 1) {
                        if(rcnt < bcnt) {
                            bnx--;
                        }else rnx--;
                    }
                    // d 방향 왼쪽일 때 움직인 거리 더 긴 것의 y++
                    if(d == 2) {
                        if(rcnt < bcnt) {
                            bny++;
                        }else rny++;
                    }
                    // d 방향 오른쪽일 때 움직인 거리 더 긴 것의 y--
                    if(d == 3) {
                        if(rcnt < bcnt) {
                            bny--;
                        }else rny--;
                    }
                }
                // 방문처리 후 큐에 넣기
                if(visit[rnx][rny][bnx][bny]) continue;
                visit[rnx][rny][bnx][bny] = true;
                q.offer(new Marble(rnx, rny, bnx, bny, cnt+1));
            }
        }
    }

    static class Marble{
        int rX, rY, bX, bY, cnt;
        public Marble(int rX, int rY, int bX, int bY, int cnt) {
            super();
            this.rX = rX;
            this.rY = rY;
            this.bX = bX;
            this.bY = bY;
            this.cnt = cnt;
        }
        @Override
        public String toString() {
            return "Marble [rX=" + rX + ", rY=" + rY + ", bX=" + bX + ", bY=" + bY + ", cnt=" + cnt + "]";
        }
    }
}