package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2606_adjList {
	static ArrayList<Integer>[] adjList;
	static boolean visited[];
	static int cnt, N, TC;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		adjList = new ArrayList[N + 1];
		for (int l = 1; l <= N; l++) {
			adjList[l] = new ArrayList<>();
		}
		TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adjList[x].add(y);
			adjList[y].add(x);
		}
		for (int i = 1; i <= N; i++) {
			if (visited[i])
				continue;
			cnt++;
			bfs(i);
		}

		System.out.println(cnt);
	}

	static void bfs(int x) {
		visited[x] = true;

		for (int i = 0; i < adjList[x].size(); i++) {
			if(visited[adjList[x].get(i)]) continue;
			visited[adjList[x].get(i)] = true;
		}
	}
}
