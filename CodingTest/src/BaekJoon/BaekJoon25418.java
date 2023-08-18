package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon25418 { // 정수 a를 k로 만들기(S3)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
		q.offer(new int[] { A, 0 });
		boolean[] visit = new boolean[1000001];
		visit[A] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int num = now[0];
			int cnt = now[1];
			if (num == K) {
				System.out.println(cnt);
				System.exit(0);
			}

			int nextNum = num * 2;
			if (nextNum <= K && !visit[nextNum]) {
				visit[nextNum] = true;
				q.offer(new int[] { nextNum, cnt + 1 });
			}

			nextNum = num + 1;
			if (nextNum <= K && !visit[nextNum]) {
				visit[nextNum] = true;
				q.offer(new int[] { nextNum, cnt + 1 });
			}
		}
	}
}
