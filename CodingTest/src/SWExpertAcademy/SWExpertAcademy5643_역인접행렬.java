package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWExpertAcademy5643_역인접행렬 { // 키 순서 - 역인접행렬
	static int N, M, total=0, cnt=0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			boolean[][] adjMatrix = new boolean[N+1][N+1];
			boolean[][] radjMatrix = new boolean[N+1][N+1];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[b][a] = adjMatrix[a][b] = true;// a보다 b가 큼
			} 
			total=0;
			for(int i=1; i<=N; i++) {
				cnt=0;
				dfs(i, adjMatrix, new boolean[N+1]);		
				dfs(i, radjMatrix, new boolean[N+1]);	
				if(cnt == N-1) total++;			
			}
			sb.append("#"+tc+" "+total+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void dfs(int cur, boolean[][] connect, boolean[] visit) {
		// 현재 수보다 큰 놈 찾기~
		visit[cur] = true;
		for(int i=1; i<=N; i++) { // 자신의 입접행렬 들여다보기
			if(connect[cur][i] && !visit[i]) { // connect 전달 대상에 따라 i가 cur보다 키가 큰 경우(i가 cur보다 키가 작은 경우) 아직 탐색되지 않았다면
				cnt++;
				dfs(i, connect, visit);
			}
		}
	}

}
