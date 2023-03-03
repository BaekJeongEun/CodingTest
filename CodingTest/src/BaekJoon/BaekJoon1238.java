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

public class BaekJoon1238 { // 파티 (G3)
	static int N, M, X;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Node>> arr = new ArrayList<>();
		ArrayList<ArrayList<Node>> backArr = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			arr.add(new ArrayList<>());
			backArr.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int t = Integer.parseInt(st.nextToken());
			arr.get(a).add(new Node(b, t));
			backArr.get(b).add(new Node(a, t));
		}
		int[] go = dijkstra(arr);
		int[] back = dijkstra(backArr);
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			max = Math.max(max, go[i]+back[i]);
		}
		System.out.println(max);
	}
	
	public static int[] dijkstra(ArrayList<ArrayList<Node>> arr) {
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> q = new PriorityQueue<>((a, b)->Integer.compare(a.weight, b.weight));
		q.offer(new Node(X-1, 0));
		dist[X-1] = 0;
		while(!q.isEmpty()) {
			Node now = q.poll();
			int num = now.node;
			if(dist[num] < now.weight) {
				continue;
			}
			for(int i=0; i<arr.get(num).size(); i++) {
				Node nextNode = arr.get(now.node).get(i);
				if(dist[nextNode.node] > now.weight+nextNode.weight) {
					dist[nextNode.node] = now.weight+nextNode.weight;
					q.offer(new Node(nextNode.node, dist[nextNode.node]));
				}
			}
		}
		return dist;
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
