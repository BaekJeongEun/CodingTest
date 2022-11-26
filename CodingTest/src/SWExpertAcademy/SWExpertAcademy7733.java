package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWExpertAcademy7733 { // 치즈 도둑 (D4)
    static int N, ans, lump, day;
    static int[][] arr, dir= {{-1,0},{0,-1},{0,1},{1,0}};
    static boolean[][] visit;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ans = Integer.MIN_VALUE;
            day = 1;
            lump = 1;
            while(lump > 0) {
            	// 치즈 먹기
            	visit = new boolean[N][N];
            	lump = 0;
            	for(int i=0; i<N; i++) {
            		for(int j=0; j<N; j++) {
            			// 현재 날짜보다 더 큰 수라면 치즈 덩어리
            			if(visit[i][j] || arr[i][j]<day) continue;
            			visit[i][j] = true;
            			bfs(i, j, day);
            			lump++; // 덩어리 개수 증가
            		}
            	}
            	day++;
            	ans = Math.max(ans, lump);
            }
            sb.append("#"+tc+" "+ans+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
	private static void bfs(int i, int j, int day) {
		Queue<Point> q = new ArrayDeque();
		q.offer(new Point (i, j));
		while(!q.isEmpty()) {
			Point now = q.poll();
			int x = now.x;
			int y = now.y;
			for(int d=0; d<4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx<0 || ny<0 || nx>=N ||ny>=N || visit[nx][ny] || arr[nx][ny]<day) continue;
				visit[nx][ny] = true;
				q.offer(new Point(nx, ny));
			}
		}
	} 
    private static class Point{
        int x, y;
        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
}