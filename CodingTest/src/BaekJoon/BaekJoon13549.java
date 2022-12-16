package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon13549 { // 숨바꼭질 3(G5)
	static int N, K, min = Integer.MAX_VALUE;
	static int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bfs();
	}
	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {N, 0});
		while(!q.isEmpty()) {
			for(int d=0; d<4; d++) {
				int[] now = q.poll();
				int cur = now[0];
				int time = now[1];
				if(cur == K) {
					System.out.println(time);
					System.exit(0);
				}
				// -1 걷기
				q.offer(new int[] {cur-1, time+1});
				// 1 걷기
				q.offer(new int[] {cur+1, time+1});
				// 순간이동
				q.offer(new int[] {cur*2, time});
			}
		}
	}

}
