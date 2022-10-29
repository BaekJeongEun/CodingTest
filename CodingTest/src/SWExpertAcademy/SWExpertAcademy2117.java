package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWExpertAcademy2117 { // 홈 방범 서비스
	static int N, M, max;
	static int arr[][], cost[], dir[][]= {{1,0}, {-1,0}, {0,-1}, {0,1}};
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			cost = new int[N*2];
			for(int k=1; k<=N*2-1; k++) {
				cost[k] =  (k * k + (k - 1) * (k - 1));
			}
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = Integer.MIN_VALUE;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					homeService(i, j);
				}
			}
			
			sb.append("#"+tc+" "+max+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void homeService(int x, int y) {
		Queue<int[]> q = new ArrayDeque();
		visit = new boolean[N][N];
		q.offer(new int[] {x, y});
		visit[x][y] = true;
		int cnt = 0;
		if(arr[x][y] == 1) {
			cnt = 1;
		}
		int K = 1;
		while(!q.isEmpty()) {
			if(cnt * M >= cost[K]) {
				max = Math.max(max, cnt);
			}
			int size = q.size();
			while(size-- > 0) {
				int[] now = q.poll();
				int nowX = now[0];
				int nowY = now[1];
				for(int d=0; d<4; d++) {
					int nx = nowX + dir[d][0];
					int ny = nowY + dir[d][1];
					if(nx<0 || ny<0 || nx>=N || ny>=N || visit[nx][ny]) continue;
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
					if(arr[nx][ny] == 1)
						cnt++;
				}
			}
			K++;
			
		}
	}
}
