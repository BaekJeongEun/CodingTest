package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon4803 { // 트리(G4)
	static ArrayList<Integer>[] graph;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc=1; ; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0 && m==0) break;
			
			graph = new ArrayList[n];
			visit = new boolean[n];
			for(int i=0; i<n; i++) {
				graph[i] = new ArrayList<>();
			}
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				graph[from].add(to);
				graph[to].add(from);
			}
			int answer = 0;
			for(int i=0; i<n; i++) {
				if(visit[i]) continue;
				answer += bfs(i);
			}
			sb.append("Case "+tc+": ");
			if(answer>1) {
				sb.append("A forest of " + answer + " trees.");
			}else if (answer == 1) {
				sb.append("There is one tree.");
            } else {
            	sb.append("No trees.");
            }
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static int bfs(int root) {
		Queue<Integer> q = new ArrayDeque<>();
		int node = 0, edge = 0;
		q.add(root);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			if(visit[now]) continue;
			visit[now] = true;
			node++;
			for(int i=0; i<graph[now].size(); i++) {
				int next = graph[now].get(i);
				edge++;
				if(!visit[next])
					q.add(next);
			}
		}
		return (edge/2) + 1 == node ? 1 : 0;
	}

}
