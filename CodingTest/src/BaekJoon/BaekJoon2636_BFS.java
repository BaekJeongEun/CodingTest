package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2636_BFS { // 치즈 (G4)
    static int N, M, answer, time;
    static int[][] arr, dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static Queue<Point> air = new ArrayDeque();
    boolean[][] visit = new boolean[N][M];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    answer++;
                }
                if((i == 0 || i==N-1) && arr[i][j] == 0) {
                    arr[i][j] = -1;
                    air.add(new Point(i, j));
                }
                if((j == 0 || j==M-1) && arr[i][j] == 0) {
                    arr[i][j] = -1;
                    air.add(new Point(i, j));
                }
            }
        }
        go();
        System.out.println(time+"\n"+answer);
    }

private static void go() {
    int result = countCheese(); // 첫 치즈 큐에 넣기
    if(result == 0) {
        return;
    }
    time++;
    while (true) {
        //result = addQueue(); // 다음 큐에 들어갈 치즈 개수
        count();
        result = countCheese();
        if (result == 0) { // 다음 단계로 갈 수 없다면
            break;
        }
        answer = result;
        time++;
    }
}

private static void count() {
    for(int i=0; i<N; i++) {
        for(int j=0; j<M; j++) {
            if(arr[i][j] == 2)
                air.offer(new Point(i,j));
        }
    }
    
}

private static int countCheese() { // 치즈 만나면 2로 바꾸기
    int sum = 0;
    while(!air.isEmpty()) {
        Point now = air.poll();
        int x = now.x;
        int y = now.y;
        for(int d=0; d<4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            if(nx<0 || ny <0 || nx >= N || ny>=M) continue; // 맞닿은 게 치즈가 아니라면 넘어가기
            if(arr[nx][ny] == 0) {
                arr[nx][ny] = -1;
                air.offer(new Point(nx, ny));
            }
            if(arr[nx][ny]==1) {
                arr[nx][ny] = 2;
                sum++;
            }
        }
    }
    return sum;
}

private static class Point{
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