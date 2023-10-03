package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon14562 { // 태권왕(S2)

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int C = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			sb.append(bfs(S, T)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int bfs(int s, int t) {
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		q.offer(new int[] { s, 0, t });
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int score = now[0];
			int cnt = now[1];
			int tScore = now[2];
			if (score == tScore) {
				return cnt;
			}
			if (score > tScore)
				continue;
			q.offer(new int[] { score + 1, cnt + 1, tScore });
			q.offer(new int[] { score * 2, cnt + 1, tScore + 3 });

		}
		return 0;
	}

}
