package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon1504 { // 특정한 최단 경로 (G4)
	static int N, E, u, v;
	static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			arr.add(new ArrayList<>());
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			arr.get(a).add(new Node(b, c));
			arr.get(b).add(new Node(a, c));
		}
		st = new StringTokenizer(br.readLine());
		u = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		int result1 = 0;
		result1 += dijkstra(0, u-1);
		result1 += dijkstra(u-1, v-1);
		result1 += dijkstra(v-1, N-1);
		
		int result2 = 0;
		result2 += dijkstra(0, v-1);
		result2 += dijkstra(v-1, u-1);
		result2 += dijkstra(u-1, N-1);
		
		System.out.println((result1==Integer.MAX_VALUE || result2==Integer.MAX_VALUE)?-1:Math.min(result1, result2));
	}
	private static int dijkstra(int start, int end) {
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.weight - o2.weight;
			}
		});
		q.offer(new Node(start, 0));
		dist[start] = 0;
		while(!q.isEmpty()) {
			Node now = q.poll();
			int node = now.node;
			for(int i=0; i<arr.get(node).size(); i++) {
				Node nextNode = arr.get(node).get(i);
				if(dist[nextNode.node] > dist[node]+nextNode.weight) {
					dist[nextNode.node] = dist[node]+nextNode.weight;
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
