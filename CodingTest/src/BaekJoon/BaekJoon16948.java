package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon16948 { // 데스 나이트(S1)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] arr = new int[N][N];
		int[][] dir = {{-2,-1},{-2,1},{0,-2},{0,2},{2, -1},{2, 1}};
		int sX = Integer.parseInt(st.nextToken());
		int sY = Integer.parseInt(st.nextToken());
		int eX = Integer.parseInt(st.nextToken());
		int eY = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
		q.offer(new int[] {sX, sY, 0});
		boolean[][] visit = new boolean[N][N];
		visit[sX][sY] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int cnt = now[2];
			if(x == eX && y == eY) {
				System.out.println(cnt);
				System.exit(0);
			}
			for(int d=0; d<6; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx<0 || ny<0 || nx >= N || ny >= N || visit[nx][ny]) continue;
				visit[nx][ny] = true;
				q.offer(new int[] {nx, ny, cnt+1});
			}
		}
		System.out.println(-1);
	}
}
