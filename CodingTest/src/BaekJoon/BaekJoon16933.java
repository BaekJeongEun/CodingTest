package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon16933 { // 벽 부수고 이동하기 3(G1)
	static int N, M, K;
	static int[][] arr, dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[][][][] visit;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M][K+1][2];
		for(int i=0; i<N; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				arr[i][j] = temp[j] - '0';
			}
		}
		System.out.println(bfs());
	}
	private static int bfs() {
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() { // x, y, 낮/밤, 거리 , K
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[3] - o2[3];
			}
		});
		q.offer(new int[] {0, 0, 0, 1, 0});
		visit[0][0][0][0] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int crash = now[2];
			int length = now[3];
			int k = now[4];
			if(x == N-1 && y == M-1) {
				return length;
			}
			for(int d=0; d<4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
				if(crash == 1 && k+1<=K && !visit[nx][ny][k+1][1] && arr[nx][ny]==1) {
					visit[nx][ny][k+1][1] = true;
					q.offer(new int[] {nx, ny, 0, length+1, k+1});
				}
				if(!visit[nx][ny][k][crash] && arr[nx][ny]==0) {
					visit[nx][ny][k][crash] = true;
					q.offer(new int[] {nx, ny, crash==1?0:1, length+1, k});
				}
			}
			if(!visit[x][y][k][crash]) {
				visit[x][y][k][crash] = true;
				q.offer(new int[] {x, y, crash==1?0:1, length+1, k});
			}
		}
		return -1;
	}

}
