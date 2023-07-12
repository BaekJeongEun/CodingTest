package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWExpertAcademy_Rich {

   private static int TC, N, M, Q, result;
   private static int[][] cells;
   private static boolean[][] visit;

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      TC = Integer.parseInt(br.readLine());

      for (int t = 1; t <= TC; t++) {
         st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         Q = Integer.parseInt(st.nextToken());
         cells = new int[N][M];
         visit = new boolean[N][M];
         result = 0;
         for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
               cells[n][m] = Integer.parseInt(st.nextToken());
            }
         }

         for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken()) - 1;
            cells[n][m] = Integer.parseInt(st.nextToken());
            updateArray(n, m);
            PriorityQueue<int[]> pQueue = createQueue();

            while (!pQueue.isEmpty()) {
            	int[] current = pQueue.poll();
               result += check(current);
            }
         }
         System.out.println("#" + t + " " + result);
      }
   }

   private static int check(int[] mold) {
      int cn = mold[0];
      int cm = mold[1];
      int num = mold[2];

      for (int n = 0; n < N; n++) {
         if (cells[n][cm] > num) {
            return 0;
         } else {
            visit[n][cm] = true;
         }
      }
      for (int m = 0; m < M; m++) {
         if (cells[cn][m] > num) {
            return 0;
         } else {
            visit[cn][m] = true;
         }
      }
      visit[cn][cm] = false;
      return 1;
   }

   private static void updateArray(int cn, int cm) {
      for (int n = 0; n < N; n++) {
         if (cells[cn][cm] < cells[n][cm])
            visit[n][cm] = false;
      }
      for (int m = 0; m < M; m++) {
         if (cells[cn][cm] < cells[cn][m])
            visit[cn][m] = false;
      }
      visit[cn][cm] = false;
   }

   private static PriorityQueue<int[]> createQueue() {
      PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[2] - o2[2];
		}
	});
      int maxN, maxM, maxNum;

      for (int n = 0; n < N; n++) {
         maxN = maxM = 0;
         maxNum = Integer.MIN_VALUE;
         for (int m = 0; m < M; m++) {
            if (!visit[n][m] && cells[n][m] > maxNum) {
               maxNum = cells[n][m];
               maxN = n;
               maxM = m;
            }
         }
         pQueue.offer(new int[] {maxN, maxM, maxNum});
      }
      return pQueue;
   }
}