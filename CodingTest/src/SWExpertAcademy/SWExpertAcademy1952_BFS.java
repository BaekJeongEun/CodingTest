package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWExpertAcademy1952_BFS {

	static int T, min, feeDay, feeMonth, fee3Month, feeYear;
	static int[] plan = new int[12];
	static Queue<Node> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 입력 => 변수 및 자료 구조
			st = new StringTokenizer(br.readLine());
			feeDay = Integer.parseInt(st.nextToken());
			feeMonth = Integer.parseInt(st.nextToken());
			fee3Month = Integer.parseInt(st.nextToken());
			feeYear = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			// 완탐 bfs
			// 최초 시점의 Node를 하나 queue에 담고 시작
			min = feeYear;
			queue.offer(new Node(0, 0));
			bfs();

			sb.append("#" + tc + " " + min + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			// 꺼내서 다음 단계로
			Node node = queue.poll();
			int cnt = node.cnt;
			int sum = node.sum;

			// 기저 조건
			if (cnt >= 12) {
				min = Math.min(min, sum);
				continue; // 현재 12월에 도달한 Node는 min을 따지고 이하 더 계속 방문하지 X
			}
			// 계속 방문
			if (plan[cnt] == 0) {
				queue.offer(new Node(cnt + 1, sum));
			} else {
				queue.offer(new Node(cnt + 1, sum + (plan[cnt] * feeDay)));
				queue.offer(new Node(cnt + 1, sum + feeMonth));
				queue.offer(new Node(cnt + 1, sum + fee3Month));
			}
		}
	}

	private static class Node {
		int cnt, sum;

		Node(int cnt, int sum) {
			this.cnt = cnt;
			this.sum = sum;
		}
	}

}
