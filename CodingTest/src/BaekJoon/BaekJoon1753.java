package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon1753 { // 최단경로 (G4)
	static int V, E, start;
	static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
	static int[] dist;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine())-1;
		dist = new int[V];
		for(int i=0; i<V; i++) {
			arr.add(new ArrayList<>());
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			arr.get(u).add(new Node(v, w));
		}
		dijkstra();
		for(int i=0; i<V; i++) {
			if(i==start) {
				sb.append("0").append("\n");
			}else {
				sb.append(dist[i]==Integer.MAX_VALUE?"INF":dist[i]+"").append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void dijkstra() {
		PriorityQueue<Node> q = new PriorityQueue<>((a, b)->Integer.compare(a.weight, b.weight));
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		q.offer(new Node(start, 0));
		while(!q.isEmpty()) {
			Node now = q.poll();
			int to = now.to;
			for(int i =0; i<arr.get(to).size(); i++) {
				Node nextNode = arr.get(to).get(i);
				if(dist[nextNode.to] > nextNode.weight + dist[to]) {
					dist[nextNode.to] = nextNode.weight + dist[to];
					q.offer(new Node(nextNode.to, dist[nextNode.to]));
				}
			}
		}
	}

	public static class Node {
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
	}
}
