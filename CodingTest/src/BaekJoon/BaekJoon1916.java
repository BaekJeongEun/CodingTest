package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon1916 { // 최소배용 구하기 (G5)
	static int N;
	static ArrayList<ArrayList<Node>> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			arr.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			arr.get(from).add(new Node(to, weight));
		}
		st = new StringTokenizer(br.readLine());
		System.out.println(dijkstra(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1));
	}

	private static int dijkstra(int start, int end) {
		int[] dist = new int[N];
		boolean[] visit = new boolean[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
		q.offer(new Node(start, 0));
		dist[start] = 0;
		while(!q.isEmpty()) {
			Node now = q.poll();
			int node = now.node;
			if(visit[node]) continue;
			visit[node] = true;
			for(int i=0; i<arr.get(node).size(); i++) {
				Node nextNode = arr.get(node).get(i);
				if(dist[nextNode.node] > nextNode.weight + dist[node]) {
					dist[nextNode.node] = nextNode.weight + dist[node];
					q.offer(new Node(nextNode.node, dist[nextNode.node]));
				}
			}
		}
		return dist[end];
	}

	public static class Node {
		int node, weight;
		public Node(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}
	}
}
