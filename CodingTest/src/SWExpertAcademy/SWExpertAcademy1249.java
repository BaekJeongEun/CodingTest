package SWExpertAcademy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWExpertAcademy1249 { // 보급로 (D4)
    static int N, arr[][];
    static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static int visit[][];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visit = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] str = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    visit[i][j] = Integer.MAX_VALUE;
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }
            sb.append("#" + tc + " " + bfs(0, 0) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int bfs(int startX, int startY) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(startX, startY));
        visit[startX][startY] = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();
            
            int x = now.x;
            int y = now.y;
            if (x == N - 1 && y == N - 1) {
                list.add(visit[x][y]);
                continue;
            }
            for (int d = 0; d < 4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;
                if(visit[x][y] + arr[nx][ny] >= visit[nx][ny])
                    continue;
                q.offer(new Point(nx, ny));
                visit[nx][ny] = visit[x][y] + arr[nx][ny];
            }
        }
        return list.stream().mapToInt(i -> i).min().getAsInt();
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + "]";
        }
    }
}