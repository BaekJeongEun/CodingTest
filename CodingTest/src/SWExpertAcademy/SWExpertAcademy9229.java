package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWExpertAcademy9229 { // 한빈이와 Spot Mart (D3)

	static int N, M, total;
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			total = 0;
			arr = new int[N];
			visit = new boolean[N];

			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			recur(0, 0, 0); // idx, cnt, weight
			total = (total==0)?-1:total;
			sb.append("#").append(tc).append(" ").append(total).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void recur(int idx, int cnt, int weight) {
		if(cnt == 2) {
			if(weight <= M) {
				total = Math.max(total, weight);
			}
			return;
		}
		for(int i=idx; i<N; i++) {
			if(visit[i]) continue;
			
			visit[i] = true;
			weight += arr[i];
			recur(i+1, cnt+1, weight);
			visit[i] = false;
			weight -= arr[i];
		}
	}

}
