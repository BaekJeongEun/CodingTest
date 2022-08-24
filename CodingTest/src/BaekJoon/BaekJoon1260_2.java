package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1260_2 { // 인접행렬
	
	static int[][] adjMatrix;
	static int N, M, V;
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1];
		adjMatrix = new int[N+1][N+1];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
		}
	
		dfs(V);
		System.out.println();
		visit = new boolean[N+1];
		bfs(V);
	}
	private static void dfs(int cur) {
		
		visit[cur] = true;
		System.out.print(cur+" ");
		
		for (int i=1; i<=N; i++) {
			if(!visit[i] && adjMatrix[cur][i] != 0) { 
				dfs(i);
			}
		}
	}	
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int cur = (int) q.poll();
			System.out.print(cur+" ");
			for(int i=1; i<=N; i++) {
				if(!visit[i] && adjMatrix[cur][i] != 0) {
					visit[i] = true;
					q.offer(i);
				}
			}
		}
	}

}
