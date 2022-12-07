package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWExpertAcademy2819 { //
    static int N = 4, M = 4;
    static int[][] arr, dir= {{0,-1},{0,1},{-1,0},{1,0}};
    static HashSet<String> set;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 1; tc <= TC; tc++) {
            arr = new int[N][M];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            set = new HashSet<>();
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    bfs(i, j);
                }
            }
            sb.append("#"+tc+" "+set.size()+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    private static void bfs(int sX, int sY) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point (sX, sY, ""+arr[sX][sY]));
        while(!q.isEmpty()) {
            Point now = q.poll();
            int x = now.x;
            int y = now.y;
            String str = now.str;
            if(str.length() == 7) {
                if(!set.contains(str)) {
                    set.add(str);
                }
                continue;
            }
            for(int d=0; d<4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                q.offer(new Point(nx, ny, str+arr[nx][ny]));
            }
        }
    }
    
    private static class Point{
        int x, y;
        String str;
        public Point(int x, int y, String str) {
            super();
            this.x = x;
            this.y = y;
            this.str = str;
        }
    }
}