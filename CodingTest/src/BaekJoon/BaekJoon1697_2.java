package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1697_2 { // 숨바꼭질 (S1)
	static int N, K, min = Integer.MAX_VALUE;
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visit = new boolean[100001];
		
		System.out.println(bfs(N));
	}
	private static int bfs(int cur) {
		int cnt = 0;
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(cur, 0));
		visit[cur] = true;
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(now.idx == K) {
				cnt = now.time;
				break;
			}
			if(now.idx+1 <= 100000 && !visit[now.idx+1]) {
				q.offer(new Point(now.idx+1, now.time+1));
				visit[now.idx+1] = true;
			}
			if(now.idx-1 >= 0 && !visit[now.idx-1]) {
				q.offer(new Point(now.idx-1, now.time+1));
				visit[now.idx-1] = true;
			}
			if(now.idx*2 <= 100000 && !visit[now.idx*2]) {
				q.offer(new Point(now.idx*2, now.time+1));
				visit[now.idx*2] = true;
			}
		}
		return cnt;
	}
	private static class Point{
		int idx, time;

		public Point(int idx, int time) {
			super();
			this.idx = idx;
			this.time = time;
		}
		
	}
}