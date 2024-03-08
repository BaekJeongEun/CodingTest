package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon1446 { // 지름길 (S1)
	static int N, D, min = Integer.MAX_VALUE;
	static List<Point> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			if (to > D)
				continue;
			if (to - from <= length)
				continue;
			arr.add(new Point(from, to, length));
		}
		Collections.sort(arr, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.from == o2.from)
					return o1.to - o2.to;
				return o1.from - o2.from;
			}
		});
		System.out.println(bfs());
	}

	private static int bfs() {
		int[] visit = new int[10001];
		Arrays.fill(visit, 10001);
		int idx = 0, move = 0;
		while (move < D) { // 움직인 거리가 D보다 작을 경우
			if(idx < arr.size()) { // 남은 지름길이 있다면
				Point now = arr.get(idx);
				if(move == now.from) { // 움직인 거리가 현재 지름길의 시작 위치라면
					visit[now.to] = Math.min(visit[move]+now.length, visit[now.to]); // 현재 지름길의 도착지점을 현재까지 움직인 거리에 지름길 더한 것과 현재 지름길
				}else { // 알맞은 지름길이 아니라면 1 이동
					visit[move+1] = Math.min(visit[move+1], visit[move]+1);
				}
			}else { // 남은 지름길이 없다면
				visit[move+1] = Math.min(visit[move+1], visit[move]+1);
				move++;
			}
		}
		return visit[D];
	}

	static public class Point {
		int from, to, length;

		public Point(int from, int to, int length) {
			super();
			this.from = from;
			this.to = to;
			this.length = length;
		}

	}
}
