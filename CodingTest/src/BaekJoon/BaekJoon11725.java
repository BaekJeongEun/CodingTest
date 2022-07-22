package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class BaekJoon11725 {
	static ArrayList<Integer>[] node;
	static int[] answer;
	static boolean[] visit;
	static int N;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		answer = new int[N + 1];
		visit = new boolean[N + 1];
		node = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			node[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			int node1 = scan.nextInt();
			int node2 = scan.nextInt();
			node[node1].add(node2);
			node[node2].add(node1);
		}

		dfs(1);
		for (int i = 2; i <= N; i++) {
			System.out.println(answer[i]);
		}
	}

	private static void dfs(int parent) {
		for (int n : node[parent]) {
			if (!visit[n]) {
				answer[n] = parent;
				visit[n] = true;
				dfs(n);
			}
		}
	}
}
/*
 * // 인접행렬 시간초과 package BaekJoon;
 * 
 * import java.util.ArrayList; import java.util.Scanner;
 * 
 * public class BaekJoon11725 { static int[][] arr; static int[] answer; static
 * int N;
 * 
 * public static void main(String[] args) { Scanner scan = new
 * Scanner(System.in);
 * 
 * N = scan.nextInt(); arr = new int[N+1][N+1]; answer = new int[N+1]; for (int
 * i = 1; i < N; i++) { int node1 = scan.nextInt(); int node2 = scan.nextInt();
 * arr[node1][node2] = 1; arr[node2][node1] = 1; }
 * 
 * dfs(1); for(int i=2; i<=N; i++) { System.out.println(answer[i]); } }
 * 
 * private static void dfs(int parent) { for (int i = 1; i <= N; i++) { if
 * (arr[parent][i] == 1 && arr[i][parent] == 1 && answer[i]==0) { answer[i] =
 * parent; arr[parent][i] = 0; arr[i][parent] = 0; dfs(i); } } } }
 */
