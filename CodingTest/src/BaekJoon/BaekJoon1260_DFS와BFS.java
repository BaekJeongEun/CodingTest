package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1260_DFS와BFS {
	static int N, M, V;
	static int[][] check; // ���� �������
	static boolean[] checked; // Ȯ�� ����

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		check = new int[1001][1001]; // ��ǥ�� �״�� �޾Ƶ��̱� ���� +1�ؼ� ����
		checked = new boolean[1001]; // �ʱⰪ False

		// ���� ������� ����
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			check[x][y] = check[y][x] = 1;
		}

		dfs(V);
		checked = new boolean[1001]; // Ȯ�λ��� �ʱ�ȭ
		System.out.println(); // �ٹٲ�

		bfs(); // bfsȣ��
	}

	static public void dfs(int i) { // ����, ����
		checked[i] = true;
		System.out.print(i + " ");

		for (int j = 1; j <= N; j++) {
			if (check[i][j] == 1 && checked[j] == false) {
				dfs(j);
			}
		}
	}

	static public void bfs() { // �ʺ�, ť
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(V); // �������� Queue�� �־�� ��
		checked[V] = true;
		System.out.print(V + " ");

		// Queue�� �� ������ �ݺ�. �湮 ������ Ȯ��, ��� �� Queue�� �־� ������� Ȯ��
		while (!queue.isEmpty()) {
			int temp = queue.poll();

			for (int j = 1; j <= N; j++) {
				if (check[temp][j] == 1 && checked[j] == false) {
					queue.offer(j);
					checked[j] = true;
					System.out.print(j + " ");
				}
			}
		}
	}
}