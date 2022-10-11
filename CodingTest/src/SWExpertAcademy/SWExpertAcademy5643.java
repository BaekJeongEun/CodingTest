package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWExpertAcademy5643 { // 키 순서
	static int N, M, min= 0, max=0, total=0;
	static boolean connect[][], visit[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			connect = new boolean[N+1][N+1];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				connect[a][b] = true;// a보다 b가 큼
			} 
			total=0;
			for(int i=1; i<=N; i++) {
				min=0; max=0;
				visit = new boolean[N+1];
				min(i);
				visit = new boolean[N+1];
				max(i);				
				if(min + max == N-1) total++;			
			}
			sb.append("#"+tc+" "+total+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void max(int cur) {
		// 현재 수보다 큰 놈 찾기~
		visit[cur] = true;
		for(int i=1; i<=N; i++) {
			if(connect[cur][i] && !visit[i]) {
				max++;
				max(i);
			}
		}
	}
	private static void min(int cur) {
		visit[cur] = true;
		for(int i=1; i<=N; i++) {
			if(connect[i][cur] && !visit[i]) {
				min++;
				min(i);
			}
		}
	}

}
