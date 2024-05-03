package Programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class OilDrilling {
	static int N, M, answer = Integer.MIN_VALUE, sum;
	static boolean[][] visit;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) {
		int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0},{0, 0, 0, 0, 1, 1, 0, 0},{1, 1, 0, 0, 0, 1, 1, 0},{1, 1, 1, 0, 0, 0, 0, 0},{1, 1, 1, 0, 0, 0, 1, 1}};
		N = land.length;
		M = land[0].length;
		visit = new boolean[N][M];
		System.out.println(solution(land));
	}
	public static int solution(int[][] land) {
        for(int j=0; j<M; j++) {
        	visit = new boolean[N][M];
        	sum = 0;
        	for(int i=0; i<N; i++) {
        		if(!visit[i][j] && land[i][j] == 1) {
        			bfs(i, j, land);
        		}
        	}
        }
        return answer;
    }
	private static void bfs(int i, int j, int[][] land) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		while(!q.isEmpty()) {
			sum++;
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			for(int d=0; d<4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny] || land[nx][ny]==0) continue;
				q.offer(new int[] {nx, ny});
				visit[nx][ny] = true;
			}
		}
		answer = Math.max(answer, sum);
	}
}
