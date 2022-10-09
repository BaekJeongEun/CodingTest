package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon14889 { // 키 순서 (G4)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] connect = new int[n][n];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			connect[a][b] = 1;
		}
		int result =0;
		
		for(int i=0; i<n; i++) {
			int cnt = 0;
			Queue<Integer> q = new ArrayDeque();
			boolean visit[] = new boolean[n];
			visit[i] = true;
			q.offer(i);
			// 큰 사람
			while(!q.isEmpty()) {
				int now = q.poll();
				for(int cur=0; cur<n; cur++) {
					if(!visit[cur] && connect[cur][now] == 1) {
						q.add(cur);
						visit[cur] = true;
						cnt++;
					}
				}
			}
			visit = new boolean[n];
			visit[i] = true;
			q.offer(i);
			// 작은 사람
			while(!q.isEmpty()) {
				int now = q.poll();
				for(int cur=0; cur<n; cur++) {
					if(!visit[cur] && connect[now][cur] == 1) {
						q.add(cur);
						visit[cur] = true;
						cnt++;
					}
				}
			}
			if(n-1 == cnt) result++;
		}
		
		System.out.println(result);

	}

}
