package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BaekJoon13549 { // 숨바꼭질 3(G5)
	static int N, K, min = Integer.MAX_VALUE;
	static int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[100001];
		LinkedList<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {N, 0});
		
		int X, time = 0;
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			X = tmp[0];
			time = tmp[1];
			visited[X] = true;
			
			// 수빈이가 동생을 찾음
			if (X == K) break;
			
			// 걷거나 순간이동
			if (X*2 <= 100000 && !visited[X*2]) {
				queue.addFirst(new int[] {X*2, time});
			}
			if (X < K && X < 100000 && !visited[X+1]) {
				queue.add(new int[] {X+1, time+1});
			}
			if (X > 0 && !visited[X-1]) {
				queue.add(new int[] {X-1, time+1});
			}
		}
		System.out.println(time);

	}

}
