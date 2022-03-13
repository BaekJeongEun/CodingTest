package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2606 {
	static int arr[][];
	static boolean visited[];
	static int cnt, N, TC;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		TC = Integer.parseInt(br.readLine());
		for(int i=0; i<TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		bfs(1); // 1과 연결된 컴퓨터부터 bfs 탐색 시작
		System.out.println(cnt);
	}
	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		visited[x] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll(); // 큐에 저장된 포인트 꺼내기
						
			for(int i=1; i<=N; i++) {
								
				if((arr[now][i]==1 && !visited[i])) {
					visited[i] = true;
					q.add(i);
					cnt++;
				}
			}
		}
	}
}
