package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class VisitInOrder { // 순서대로 방문하기(L3)
	static int N, M, answer, arr[][], dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static Order orders[];
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visit = new boolean[N][N];
		orders = new Order[M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			orders[i] = new Order(x, y);
		}
		visit[orders[0].x][orders[0].y] = true;
		dfs(orders[0].x, orders[0].y, 1);
		System.out.println(answer);
	}
	private static void dfs(int x, int y, int order) {
		if(orders[order].x == x && orders[order].y == y) {
			if(order == M-1) {
				answer++;
				return;
			}
			dfs(x, y, order+1);
		}
		for(int d=0; d<4; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if(nx<0 || ny<0 || nx>=N || ny>=N || visit[nx][ny] || arr[nx][ny] == 1) continue;
			visit[nx][ny] = true;
			dfs(nx, ny, order);
			visit[nx][ny] = false;
		}
	}
	public static class Order {
		int x, y;
		public Order(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
