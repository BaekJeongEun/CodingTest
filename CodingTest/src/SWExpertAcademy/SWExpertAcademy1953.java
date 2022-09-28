package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWExpertAcademy1953 { // 탈주범 검거
    static int N, M, R, C, L;
    static int[][] arr, dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static boolean[][] visit;
    static Queue<Point> q = new ArrayDeque<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            visit = new boolean[N][M];
            q = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("#" + tc + " " + bfs(R, C));
        }
    }

    private static int bfs(int startX, int startY) {
        q.offer(new Point(startX, startY));
        visit[startX][startY] = true;
        int sum = 0;
        while (L-- > 0) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Point now = q.poll();
                move(now.x, now.y);
                sum ++;
            }
        }
        return sum;
    }

    private static void move(int x, int y) {
        int direction = arr[x][y];
        int[] dSize = {};
        int nextX = x, nextY = y;
        
        switch (direction) {
        case 1:
            dSize = new int[] { 0, 1, 2, 3 };
            break;
        case 2:
            dSize = new int[] { 0, 2 };
            break;
        case 3:
            dSize = new int[] { 1, 3 };
            break;
        case 4:
            dSize = new int[] { 0, 1 };
            break;
        case 5:
            dSize = new int[] { 1, 2 };
            break;
        case 6:
            dSize = new int[] { 2, 3 };
            break;
        case 7:
            dSize = new int[] { 3, 0 };
            break;
        }

        for(int d:dSize){
            nextX = x + dir[d][0];
            nextY = y + dir[d][1];
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || visit[nextX][nextY])
                continue;
            // 다음 위치로 갈 수 있는 길이라면
            int next = arr[nextX][nextY];
            boolean check = false;
            switch (d) {
            case 0: // 위로 가야할 차례이면
                if (next == 1 || next == 2 || next == 5 || next == 6) { // 다음 파이프의 아래가 뚫려 있어야 함
                	check = true;
                }
                break;
            case 1:
                if (next == 1 || next == 3 || next == 6 || next == 7) {
                	check = true;
                }
                break;
            case 2:
                if (next == 1 || next == 2 || next == 4 || next == 7) {
                	check = true;
                }
                break;
            case 3:
                if (next == 1 || next == 3 || next == 4 || next == 5) {
                	check = true;
                }
                break;
            }
            if(check) {
                q.offer(new Point(nextX, nextY));
                visit[nextX][nextY] = true;
            }
        }
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

    }
}