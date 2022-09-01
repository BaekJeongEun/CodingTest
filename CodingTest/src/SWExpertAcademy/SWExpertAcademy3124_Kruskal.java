package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWExpertAcademy3124_Kruskal {
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
	static int V, E;
	static int parents[];
	static ArrayList<Edge> list;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parents = new int[V+1];
			for(int i=1; i<=V; i++){
				parents[i] = i;
			}
			list = new ArrayList<>();
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				list.add(new Edge(A, B, C));
			}
			long result = 0, cnt = 0;
			Collections.sort(list);
			for(Edge e : list) {
				if(union(e.from, e.to)) {
					result += e.weight;
					if(V-1 == ++cnt) break;
				}
			}
			sb.append("#"+tc+" "+result+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	private static boolean union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if(A == B) return false;
		if(B>A)
			parents[B] = A;
		else parents[A] = B;
		return true;
	}
}
