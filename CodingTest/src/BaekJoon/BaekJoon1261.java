package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon1261 {
	static int N, M;
	static boolean visit[][]; // 비용
	static int[][] arr, dir = {{0,1},{0,-1},{1,0},{-1,0}}; // 방 정보
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		visit = new boolean[N][M];
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				arr[i][j] = tmp[j] - 48;
			}
		}
		System.out.println(bfs());
	}
	private static int bfs() {
		int answer = 0;
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[2]-b[2]); // x, y, 벽 부순 횟수
		
		visit[0][0] = true;
		q.offer(new int[] {0, 0, 0});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int cnt = now[2];
			if(x == N-1 && y == M-1) {
				return cnt;
			}
			for(int d=0; d<4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];

				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(!visit[nx][ny]) {
					visit[nx][ny] = true;
					if(arr[nx][ny] == 0) {
						q.offer(new int[] {nx, ny, cnt});
				    } else {
						q.offer(new int[] {nx, ny, cnt + 1});
					}
				}
			}
		}
		return answer;
	}

}
