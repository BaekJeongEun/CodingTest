package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon17070 { // 파이프 옮기기 1 (G5)
    static int N, ans;
    static int[][] arr;
    static boolean[][] visit;
    static int[][] dX = { { 0, 1, 0 }, { 0, 1, 1 }, { 0, 1, 1 } }; // 가로, 
    static int[][] dY = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 1, 0 } };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit[0][0] = true;
        visit[0][1] = true;
        dfs(new Point(0, 1, 0));
        System.out.println(ans);
    }

    private static void dfs(Point point) {
        Point now = point;
        int x = now.x;
        int y = now.y;
        int direction = now.direction;
        if (x == N - 1 && y == N - 1) {
            ans++;
            return;
        }
        for (int d = 0; d < 3; d++) {
            int nX = x + dX[direction][d];
            int nY = y + dY[direction][d];
            if (nX < 0 || nY < 0 || nX >= N || nY >= N || arr[nX][nY] == 1 || (nX == x && nY == y) || visit[nX][nY]) {
                continue;
            }
            if(d == 1 && (arr[nX-1][nY] != 0 || arr[nX][nY-1] != 0)) {
                continue;
            }
            visit[nX][nY] = true;
            dfs(new Point(nX, nY, d));
            visit[nX][nY] = false;
        }
    }

    private static class Point {
        int x, y, direction;

        public Point(int x, int y, int direction) {
            super();
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + ", direction=" + direction + "]";
        }

    }
}