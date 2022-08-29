package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon16236 { // 아기상어 (G3)
	static int N, arr[][], dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int sharkX, sharkY, sharkSize = 2, timer = 0, eatCnt=0;
	static boolean visit[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					arr[i][j] = 0;
				}
			}
		}
		int result = 0;
		while (true) {
			visit = new boolean[N][N];
			result = bfs(sharkX, sharkY);
			if (result == -1)
				break;
			timer += result;
		}
		System.out.println(timer);
	}

	private static int bfs(int x, int y) {
		Queue<Fish> fish = new ArrayDeque();
		ArrayList<Fish> list = new ArrayList();
		fish.add(new Fish(x, y, 0));
		visit[x][y] = true; // 아기상어 초기 위치 방문체크

		while (!fish.isEmpty()) { // 아기상어 초기 위치에서부터 최대한 움직였을 때 물고기 얼마나 먹었는지
			Fish now = fish.poll(); // 현재 위치에서 탐색 시작
			for (int d = 0; d < 4; d++) {
				int nextX = now.x + dir[d][0];
				int nextY = now.y + dir[d][1];
				if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && !visit[nextX][nextY]
						&& arr[nextX][nextY] <= sharkSize) { // 크기가 아기상어보다 크면 못 지나감
					fish.add(new Fish(nextX, nextY, now.dist + 1)); // 갈 수 있는 위치
					visit[nextX][nextY] = true;
					if (arr[nextX][nextY] != 0 && arr[nextX][nextY] < sharkSize) { // 아기상어보다 작은 물고기 만났을 땐 먹이 리스트 후보에 추가
						list.add(new Fish(nextX, nextY, now.dist + 1));
					}
				}
			}
		}
		// 움직였을 때 먹을 수 있던 물고기 있다면 젤 가까운 놈으로 먹기
		if (!list.isEmpty()) {
			Collections.sort(list);
			arr[list.get(0).x][list.get(0).y] = 0;
			eatCnt++;
			sharkX = list.get(0).x;
			sharkY = list.get(0).y; // 물고기 먹고 초기화
			if (eatCnt >= sharkSize) {
				sharkSize++;
				eatCnt = 0;
			}
			return list.get(0).dist;
		}else {
			return -1;
		}
	}

	private static class Fish implements Comparable<Fish> {
		int x, y, dist;

		public Fish(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {
			if (o.dist == this.dist) { // 거리가 같으면
				if (o.x == this.x) // x까지 같으면
					return this.y - o.y;
				else
					return this.x - o.x;
			}
			return this.dist - o.dist;
		}

	}
}
