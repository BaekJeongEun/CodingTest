package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon11060 { // 점프 점프 (S2)
	static int N, arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean[] visit = new boolean[N];
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
		q.offer(new int[] {0, 0});
		visit[0] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int idx = now[0];
			int cnt = now[1];
			if(idx == N-1) {
				System.out.println(cnt);
				System.exit(0);
			}
			for(int i=1; i<=arr[idx]; i++) {
				int nx = idx + i;
				if(nx >= N || visit[nx]) continue;
				visit[nx] = true;
				q.offer(new int[] {nx, cnt+1});
			}
		}
		System.out.println(-1);
	}

}
