package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1260_3 { // DFS와 BFS (S2)
	static int N, M, V;
	static ArrayList<Integer>[] adjList;
	static StringBuilder sb = new StringBuilder();
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		visit = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			adjList[n1].add(n2);
			adjList[n2].add(n1);
		}
		visit[V] = true;
		dfs(V);
		sb.append("\n");
		visit = new boolean[N+1];
		bfs(V);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void dfs(int cur) {
		sb.append(cur+" ");
		Collections.sort(adjList[cur]);
		for(int i=0; i<adjList[cur].size(); i++) {
			if(visit[adjList[cur].get(i)]) continue;
			visit[adjList[cur].get(i)] = true;
			dfs(adjList[cur].get(i));
		}
		
	}
	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque();
		q.offer(start);
		visit[start] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur+" ");
			Collections.sort(adjList[cur]);
			for(int i=0; i<adjList[cur].size(); i++) {
				if(visit[adjList[cur].get(i)]) continue;
				q.offer(adjList[cur].get(i));
				visit[adjList[cur].get(i)] = true;
			}
		}
	}

}
