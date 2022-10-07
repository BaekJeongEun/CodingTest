package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1194 { // 달이 차오른다, 가자. (G1)
    static int N, M, startX, startY;
    static char[][] arr;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int[][][] visited;

public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new char[N][M];
    visited = new int[N][M][64];
    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
            Arrays.fill(visited[i][j], Integer.MAX_VALUE);
    for (int i = 0; i < N; i++) {
        char[] str = br.readLine().toCharArray();
        for (int j = 0; j < M; j++) {
            arr[i][j] = str[j];
            if (arr[i][j] == '0') {
                startX = i;
                startY = j;
                arr[i][j] = '.';
            }
        }
    }
    bfs(startX, startY);
}

private static void bfs(int startX, int startY) {
    Queue<Point> q = new ArrayDeque();
    q.offer(new Point(startX, startY, 0, 0));
    visited[startX][startY][0] = 0;
    A: while (!q.isEmpty()) {
        Point now = q.poll();
        int x = now.x;
        int y = now.y;
        int cnt = now.cnt;
        for (int d = 0; d < 4; d++) {
            int visit = now.visit;
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] != '#') {
                if (arr[nx][ny] == '1') {
                    System.out.println(cnt + 1);
                    System.exit(0);
                    break A;
                }
                if (visited[nx][ny][visit] <= cnt+1)
                    continue;
                if ("abcdef".contains(arr[nx][ny] + "")) { // 소문자라면 키 가지고 큐에 들어가
                    visit |= (1 << (arr[nx][ny] - 97));
                    visited[nx][ny][visit] = cnt + 1;
                    q.offer(new Point(nx, ny, cnt + 1, visit));
                } else if ("ABCDEF".contains(arr[nx][ny] + "") && ((1 << (arr[nx][ny] - 65)) & visit) != 0) { // 대문자라면
                    visited[nx][ny][visit] = cnt + 1;
                    q.offer(new Point(nx, ny, cnt + 1, visit));
                } else if (arr[nx][ny] == '.') { // 평지이거나 0일때
                    visited[nx][ny][visit] = cnt + 1;
                    q.offer(new Point(nx, ny, cnt + 1, visit));
                }
            }
        }
    }
    System.out.println("-1");
}

private static class Point {
    int x, y, cnt, visit;

    public Point(int x, int y, int cnt, int visit) {
        super();
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.visit = visit;
    }

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + ", cnt=" + cnt + ", visit=" + visit + "]";
    }

}
}