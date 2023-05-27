package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1326 { // 폴짝폴짝 (S2)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		boolean[] visit = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = 1;
		}
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()) - 1;
		int b = Integer.parseInt(st.nextToken()) - 1;
		if (a == b) {
			System.out.println(0);
			System.exit(0);
		}
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { a, 0 });
		visit[a] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int num = arr[cur[0]];
			int next = cur[0];

			while (true) {
				next += num;
				if (next > N)
					break;
				if (visit[next])
					continue;
				visit[next] = true;

				if (next == b) {
					System.out.println(cur[1] + 1);
					return;
				}
				q.add(new int[] { next, cur[1] + 1 });
			}

			next = cur[0];
			while (true) {
				next -= num;
				if (next < 1)
					break;
				if (visit[next])
					continue;
				visit[next] = true;

				if (next == b) {
					System.out.println(cur[1] + 1);
					return;
				}

				q.add(new int[] { next, cur[1] + 1 });
			}

		}
		System.out.println(-1);
	}

}
