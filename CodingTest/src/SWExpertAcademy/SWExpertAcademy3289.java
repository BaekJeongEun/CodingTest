package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWExpertAcademy3289 { // 서로소 집합 (D4)
	static int[] parents;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine()), m, n;
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			for(int i=1; i<=n; i++) { 
				parents[i] = i; 
			}
			sb.append("#").append(tc).append(" ");
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int set = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(set==1) {
					sb.append((find(a)==find(b))?"1":"0");
				}else {
					setUnion(a, b);
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static int find(int a) {
		if(parents[a] == a) { 
			return a;
		}
		return parents[a] = find(parents[a]); 
	}

	private static void setUnion(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return;
		
		parents[bRoot] = aRoot;
	}
}
