package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1260 { // 인접리스트
	
	static ArrayList<Integer> adjList[];
	static int N, M, V;
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1];
		adjList = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList();
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
	
		dfs(V);
		System.out.println();
		visit = new boolean[N+1];
		bfs(V);
	}
	private static void dfs(int cur) {
		
		visit[cur] = true;
		System.out.print(cur+" ");
		Collections.sort(adjList[cur]);
		
		for (int i=0; i<adjList[cur].size(); i++) {
			if(!visit[adjList[cur].get(i)]) { 
				dfs(adjList[cur].get(i));
			}
		}
	}	
	private static void bfs(int start) {
		Queue q = new ArrayDeque();
		q.offer(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int cur = (int) q.poll();
			System.out.print(cur+" ");
			Collections.sort(adjList[cur]);
			for(int i=0; i<adjList[cur].size(); i++) {
				if(!visit[adjList[cur].get(i)]) {
					visit[adjList[cur].get(i)] = true;
					q.offer(adjList[cur].get(i));
				}
			}
		}
	}

}
