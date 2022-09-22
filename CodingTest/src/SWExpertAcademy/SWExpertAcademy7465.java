package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWExpertAcademy7465 { // 창용 마을 무리의 개수 (D4)
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Set<Integer> set;
		int TC = Integer.parseInt(br.readLine()), m, n;
		for(int tc=1; tc<=TC; tc++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			set = new HashSet<>();
			for(int i=1; i<=n; i++) {
				parents[i] = i;
			}
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			for(int i=1; i<=n; i++) {
				set.add(find(i));
			}
			sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return;
		}		
		parents[bRoot] = aRoot;
	}
	private static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
}