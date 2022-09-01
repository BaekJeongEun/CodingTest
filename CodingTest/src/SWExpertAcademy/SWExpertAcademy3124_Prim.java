package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWExpertAcademy3124_Prim {
	static class Node {
		int to, weight;
		public Node(int to, int weigth) {
			super();
			this.to = to;
			this.weight = weigth;
		}
	}
	static int V, E;
	static long minEdge[];
	static boolean visit[];
	static ArrayList<Node> list[];
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
			minEdge = new long[V];
			visit = new boolean[V];
			Arrays.fill(minEdge, Long.MAX_VALUE);
			list = new ArrayList[V];
			for(int i=0; i<V; i++) {
				list[i] = new ArrayList();
			}
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken())-1;
				int B = Integer.parseInt(st.nextToken())-1;
				int C = Integer.parseInt(st.nextToken());
				list[A].add(new Node(B, C));
				list[B].add(new Node(A, C));
			}
			sb.append("#"+tc+" "+getMST()+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static long getMST() {
		long result = 0, cnt = 0, min;
		int minV;
		minEdge[0] = 0;
		
		while(cnt < V) {
			min = Long.MAX_VALUE;
			minV = -1;
			for(int i=0; i<V; i++) {
				if(!visit[i] && min > minEdge[i]) {
					minV = i;
					min = minEdge[i];
				}
			}
			
			if(min == Long.MAX_VALUE) break;
			visit[minV] = true;
			result += min;
			cnt++;
		
			for(int i=0; i<list[minV].size(); i++) {
				if(!visit[list[minV].get(i).to] && list[minV].get(i).weight < minEdge[list[minV].get(i).to]) {
					minEdge[list[minV].get(i).to] = list[minV].get(i).weight;
				}
			}
		}
		
		return result;
	}
	
	
}
