package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1726 { // 로봇 (G3)
   static int N, M, startX, startY, startD, endX, endY, endD;
   static int[][] arr;
   static int moveX[] = {0,1,-1,0,0};
   static int moveY[] = {0,0,0,1,-1};
   static Queue<Point> q = new ArrayDeque();
   static boolean[][][] visit;
   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      arr = new int[N][M];
      visit = new boolean[N][M][5];
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < M; j++) {
            arr[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      st = new StringTokenizer(br.readLine());
      startX = Integer.parseInt(st.nextToken()) - 1;
      startY = Integer.parseInt(st.nextToken()) - 1;
      startD = Integer.parseInt(st.nextToken());
      visit[startX][startY][startD] = true;
      q.offer(new Point(startX, startY, startD, 0));
      st = new StringTokenizer(br.readLine());
      endX = Integer.parseInt(st.nextToken()) - 1;
      endY = Integer.parseInt(st.nextToken()) - 1;
      endD = Integer.parseInt(st.nextToken());
      System.out.println(bfs());
   }

   private static int bfs() {
      int result = Integer.MAX_VALUE;
      while(!q.isEmpty()) {
         Point now = q.poll();
         int x = now.x;
         int y = now.y;
         int d = now.dir;
         int command = now.command;
         
         if(x == endX && y == endY && endD == d) {
            result = command;
            break;
         }
         for(int k=1; k<=3; k++) { // k 1~3까지 이동
            int nx = x + (moveX[d] * k);
            int ny = y + (moveY[d] * k);
            if(!check(nx, ny)) continue;
            if(arr[nx][ny]==0) { // 궤도라면
               if(!visit[nx][ny][d]) {
                  q.offer(new Point(nx, ny, d, command + 1));
                  visit[nx][ny][d] = true;
               }
            }else break; // 궤도가 아니라면 멈추기, 어차피 더 못 감
         }
         
         for (int i = 1; i <= 4; i++) {
                if (d != i && !visit[x][y][i]) {
                    int cnt = 1;
                    if ((d == 1 && i == 2) || (d == 2 && i == 1) || (d == 3 && i == 4) || (d == 4 && i == 3)) { 
                        cnt++;
                    }
                    visit[x][y][i] = true;
                    q.offer(new Point(x, y, i, command + cnt));
                }
            }
      }
      return result;
   }

   private static boolean check(int x, int y) {
      return (x>=0 && y>=0 && x<N && y<M); // 로봇이 갈 수 있는 지역이라면
   }

   private static class Point {
      int x, y, dir, command;

      public Point(int x, int y, int dir, int command) {
         super();
         this.x = x;
         this.y = y;
         this.dir = dir;
         this.command = command;
      }

      @Override
      public String toString() {
         return "Point [x=" + x + ", y=" + y + ", dir=" + dir + ", command=" + command + "]";
      }
   }
}