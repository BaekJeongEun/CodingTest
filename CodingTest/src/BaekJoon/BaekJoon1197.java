package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1197 { // 최소 스패닝 트리 (G4)

	static Edge[] edgeList;
	static int[] parents;
	static int V,E;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		make();
		Arrays.sort(edgeList);
		int result = 0, count = 0;
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++count == V-1) {
					break;
				}
			}
		}
		System.out.println(result);
	}
	private static boolean union(int from, int to) {
		int aRoot = find(from);
		int bRoot = find(to);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	static void make() {
		parents = new int[V+1];
		for(int i=1; i<=V; i++) {
			parents[i] = i;
		}
	}
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		public Edge(int from, int to, int weigth) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weigth;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}

}
