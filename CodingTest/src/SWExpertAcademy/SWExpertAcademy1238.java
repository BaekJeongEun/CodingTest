package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWExpertAcademy1238 {

	static int N, start, from, to, result;
	static boolean input[][], visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			input = new boolean[101][101];
			visit = new boolean[101];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				input[from][to] = true;
			}

			sb.append("#").append(tc).append(" ").append(bfs()).append("\n");
		}
		System.out.println(sb.toString());

	}

	static int bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visit[start] = true;
		int max=0;
		
		while(!queue.isEmpty()) {
			max=0;
			int size = queue.size();
			for(int s=0; s<size; s++) {
				int now = queue.poll();
				max = Math.max(now, max);
				
				for(int i=0; i<100; i++) {
					if(!visit[i] && input[now][i]) {
						queue.add(i);
						visit[i] = true;
					}
				}
			}
			result = max;
		}
		return result;
	}
}