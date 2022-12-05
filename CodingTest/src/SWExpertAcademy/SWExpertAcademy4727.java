package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWExpertAcademy4727 { // 견우와 직녀 (D4)
    static int N, M;
    static int[][] arr, dir= {{0,-1},{0,1},{-1,0},{1,0}}, map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc = 1; tc<=TC; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            map = new int[N][N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            checkCross();
            
            for(int i=0; i<N; i++)
                Arrays.fill(map[i], Integer.MAX_VALUE);
            bfs();
            System.out.println(map[N-1][N-1]);
        }
    }
    private static void bfs() {
        PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.t - o2.t;
			}
        	
		});
        q.offer(new Point(0, 0, 0));
        map[0][0] = 0;
        while(!q.isEmpty()) {
            Point now = q.poll();
            int x = now.x;
            int y = now.y;
            int t = now.t;
            boolean build = now.build;
            if(x == N-1 && y == N-1) {
                map[x][y] = t;
                return;
            }
            for(int d=0; d<4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if(nx<0 || ny<0 || ny>=N || nx>=N || map[nx][ny]<t+1 || arr[nx][ny]==0) continue;
                // 더 최소로 갈 수 있는 경우
                if(arr[nx][ny] == 1) {
                    map[nx][ny] = t+1;
                    q.offer(new Point(nx, ny, t+1));
                }else if(arr[nx][ny]>1 && arr[x][y]==1) { // 오작교일 경우
                    if((arr[nx][ny]+1)%arr[nx][ny]==0) { // 갈 수 있다면
                        map[nx][ny] = t+1;
                        q.offer(new Point(nx, ny, t+1));
                    }else { // 쉬는 시간이라면
                        q.offer(new Point(x, y, t+1));
                    }
                }
            }
        }
    }
    private static void checkCross() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] != 0) continue; // 교차로 아니라면 넘어감
                boolean[] check = new boolean[4];
                int cnt = 0;
                for(int d=0; d<4; d++) {
                    int nx = i + dir[d][0];
                    int ny = j + dir[d][1];
                    if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                    if(arr[nx][ny] == 0) check[d] = true;
                }
                if((check[0] && check[2]) || (check[0]&&check[3]) || (check[1]&&check[2]) || (check[1]&&check[3])) continue;
                
                arr[i][j] = M;
            }
        }
    }
    private static class Point{
        int x, y, t;
        boolean build = false;
        public Point(int x, int y, int t) {
            super();
            this.x = x;
            this.y = y;
            this.t = t;
        }
        public Point(int x, int y, int t, boolean build) {
            super();
            this.x = x;
            this.y = y;
            this.t = t;
            this.build = build;
        }
    }
}