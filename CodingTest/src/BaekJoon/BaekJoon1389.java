package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1389 { // 케빈 베이컨의 6단계 법칙 (S1)
	static int N, M, min = Integer.MAX_VALUE, minIdx = -1;
	static ArrayList<Integer> list[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for(int i=1; i<=N; i++) {
			int sum = 0;
			for(int j=1; j<=N; j++) {
				if(i != j)
					sum += bfs(i, j);
			}
			if(min > sum) {
				min = sum;
				minIdx = i;
			}
		}
		System.out.println(minIdx);
	}
	private static int bfs(int start, int end) {
		int cost = 0;
		
		Queue<Point> q = new ArrayDeque();
		q.offer(new Point(start, 1));
		A:while(!q.isEmpty()) {
			Point now = q.poll();
			for(int s=0; s<list[now.idx].size(); s++) {
				if(list[now.idx].get(s) == end) {
					cost = now.cost;
					break A;
				}
				q.offer(new Point(list[now.idx].get(s), now.cost+1));
			}
		}
		return cost;
	}
	
	private static class Point{
		int idx, cost;

		public Point(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
}
