package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BaekJoon16562 { // 친구비 (G4)
	static int N, M, K, total, cnt;
	static ArrayList<Integer> adjList[];
	static ArrayList<int[]> cost;
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		cost = new ArrayList<>();
		adjList = new ArrayList[N+1];
		visit = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
			cost.add(new int[] {i, Integer.parseInt(st.nextToken())});
		}
		Collections.sort(cost, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			adjList[n1].add(n2);
			adjList[n2].add(n1);
		}
		for(int i=0; i<N; i++) {
			int cur[] = cost.get(i);
			if(visit[cur[0]] || K<cur[1]) continue;
			total += cur[1];
			K -= cur[1];
			dfs(cur[0]);
		}
		for(int i=1; i<=N; i++) {
			if(visit[i]) cnt++;
		}
		System.out.println((cnt == N)?total:"Oh no");
	}
	private static void dfs(int start) {
		visit[start] = true;
		for(int i=0; i<adjList[start].size(); i++) {
			if(visit[adjList[start].get(i)]) continue;
			visit[adjList[start].get(i)] = true;
			dfs(adjList[start].get(i));
		}
		
	}

}
