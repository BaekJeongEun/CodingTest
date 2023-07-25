package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon17142 { // 낚시왕 (G1)
    static int R, C, M, total;
    static Point[][] arr;
    static ArrayList<Point> list = new ArrayList();
    static int[][] dir = { {}, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상1, 하2, 우3, 좌4

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new Point[R + 1][C + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken()); // 속력
            int d = Integer.parseInt(st.nextToken()); // 이동방향
            int z = Integer.parseInt(st.nextToken()); // 크기
            Point now = new Point(r, c, s, d, z);
            list.add(now);
            arr[r][c] = now;
        }
        for (int i = 1; i <= C; i++) {
            total += fishing(i);
            move();
        }
        System.out.println(total);
    }

    /**
     * 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
     */
    private static int fishing(int king) {
        int size = 0;
        for (int r = 1; r <= R; r++) { 
            if (arr[r][king] != null) {
                size = arr[r][king].z;
                list.remove(arr[r][king]);
                arr[r][king] = null;
                break;
            }
        }
        return size;
    }

    /**
     * 상어가 이동한다.
     */
    private static void move() {
        int size = list.size();
        PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o2.z - o1.z;
            }
        });
        for (int qs = 0; qs < size; qs++) {
            Point now = list.get(0);
            int s = now.s;
            int d = now.d;
            int z = now.z;
            int r = now.r, c = now.c;
            int dist = 0;
            if (d <= 2) { // 상, 하 일 경우 c 고정 S%(R*2-2)
                dist = s % (R * 2 - 2);
                while (dist-- > 0) {
                    if (d == 1) { // 상
                        r--;
                    } else { // 하
                        r++;
                    }
                    if (r == 0) { // 상방향으로 갔다가 범위 벗어나면
                        d = 2; // 아래 방향으로 바꿔
                        r = 2; // 위치도 +1
                    } else if (r == R+1) { // 하
                        d = 1; 
                        r = R-1;
                    }
                }
            } else { // 좌, 우 일 경우 r 고정
                dist = s % (C * 2 - 2);
                while (dist-- > 0) {
                    if (d == 3) { // 우
                        c++;
                    } else { // 좌
                        c--;
                    }
                    if (c == C+1) { // 우
                        d = 4;
                        c = C-1;
                    } else if (c == 0) { // 좌
                        d = 3;
                        c = 2;
                    }
                }
            }
            list.remove(0);
            
            q.offer(new Point(r, c, s, d, z));
        }
        int sum = 0;
        arr = new Point[R + 1][C + 1];
        while(!q.isEmpty()) {
            Point now = q.poll();
            if(arr[now.r][now.c] == null) {
                arr[now.r][now.c] = now;
                list.add(now);
            }
        }
    }

    private static class Point {
        int r, c, s, d, z;

        public Point(int r, int c, int s, int d, int z) {
            super();
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Point [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
        }
    }
}