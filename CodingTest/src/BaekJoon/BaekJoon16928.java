package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon16928 { // 뱀과 사다리 게임(G5)
	private static int N, M, min=Integer.MAX_VALUE;
	private static HashMap<Integer, Integer> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new HashMap<>();
		for(int i=0; i<N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map.put(x, y);
		}
		bfs();
		System.out.println(min);
	}

	public static void bfs() {
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]); // x, y, 횟스
		q.offer(new int[] {0, 1, 0});
		boolean[] visit = new boolean[101];
		visit[1] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int num = 10*x+y;
			int cnt = now[2];
			if(num == 100) {
				min = Math.min(min, cnt);
			}
			for(int d=1; d<=6; d++) {
				int nextNum = num + d;
				if(map.containsKey(nextNum)) {
					nextNum = map.get(nextNum);
				}
				if(nextNum > 100 || visit[nextNum]) continue;
				int nX = nextNum / 10;
				int nY = nextNum % 10;
				q.offer(new int[] {nX, nY, cnt+1});
				visit[nextNum] = true;
			}
		}
	}

}
