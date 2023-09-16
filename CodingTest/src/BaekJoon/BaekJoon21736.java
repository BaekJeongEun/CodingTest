package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon21736 { // 헌내기는 친구가 필요해 (S2)
	static int N, M, answer, IX, IY;
	static char[][] arr;
	static boolean[][] visit;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				arr[i][j] = temp[j];
				if(temp[j] == 'I') {
					IX = i; IY = j;
				}
			}
		}
		bfs();
		System.out.println(answer==0?"TT":answer);
	}
	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {IX, IY});
		visit[IX][IY] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			if(arr[x][y] == 'P') {
				answer++;
			}
			for(int d=0; d<4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx<0 || ny<0 || nx>= N || ny>= M || visit[nx][ny] || arr[nx][ny]=='I' || arr[nx][ny]=='X') continue;
				q.offer(new int[] {nx, ny});
				visit[nx][ny] = true;
			}
		}
	}

}
