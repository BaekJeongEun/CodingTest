package Programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class OilDrilling { // 석유 시추 (L2)
	static int N, M, answer;
	static boolean[][] visit;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static int[] oil;
	public static void main(String[] args) {
		int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0},{0, 0, 0, 0, 1, 1, 0, 0},{1, 1, 0, 0, 0, 1, 1, 0},{1, 1, 1, 0, 0, 0, 0, 0},{1, 1, 1, 0, 0, 0, 1, 1}};
		N = land.length;
		M = land[0].length;
		oil = new int[M];
		visit = new boolean[N][M];
		System.out.println(solution(land));
	}
	public static int solution(int[][] land) {
        visit = new boolean[N][M];
        for(int j=0; j<M; j++) {
        	for(int i=0; i<N; i++) {
        		if(!visit[i][j] && land[i][j] == 1) {
        			bfs(i, j, land);
        		}
        	}
        }
        return Arrays.stream(oil).max().getAsInt();
    }
	private static void bfs(int i, int j, int[][] land) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		int cnt = 1;
		Set<Integer> set = new HashSet<>();
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			set.add(y);
			for(int d=0; d<4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny] || land[nx][ny]==0) continue;
				q.offer(new int[] {nx, ny});
				visit[nx][ny] = true;
				cnt++;
			}
		}
		for(int idx : set) {
			oil[idx] += cnt;
		}
	}
}
