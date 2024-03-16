package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class VisitInOrder { // 순서대로 방문하기(L3)
	static int N, M, arr[][], dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static Order orders[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
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
		System.out.println(bfs());
	}
	private static int bfs() {
		int answer = 0;
		boolean temp[][] = new boolean[N][N];
		Queue<Node> q = new ArrayDeque<>();
		temp[orders[0].x][orders[0].y] = true;
		q.offer(new Node(orders[0].x, orders[0].y, 0, temp));
		while(!q.isEmpty()) {
			Node now = q.poll();
			int x = now.x;
			int y = now.y;
			int order = now.order+1;
			boolean[][] visit = now.visit;
			if(order == M && x == orders[order-1].x && y == orders[order-1].y) {
				answer++;
			}
			for(int d=0; d<4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx < 0 || ny < 0 || nx>=N || ny>=N || visit[nx][ny] || arr[nx][ny] == 1) continue;
				visit[nx][ny] = true;
				int nextOrder = order;
				if(order<M && orders[order].x == nx && orders[order].y == ny) {
					nextOrder++;
				}
				q.offer(new Node(nx, ny, nextOrder, visit));
			}
		}
		return answer;
	}
	public static class Node {
		int x, y, order;
		boolean visit[][];
		public Node(int x, int y, int order, boolean visit[][]) {
			super();
			this.x = x;
			this.y = y;
			this.order = order;
			this.visit = visit;
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
