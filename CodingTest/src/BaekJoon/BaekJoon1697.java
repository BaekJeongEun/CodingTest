package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1697 {
	static int visited[], K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new int [100005];
		
		System.out.println(bfs(N));
	}
	static int bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		
		while(!q.isEmpty()) {
			int current = q.poll();
			// 동생이 있는 위치 K를 방문한 적 있으면 나가기
			if(visited[K] != 0) break;
			// 인덱스 범위 안 벗어나고, 방문한적 없어야 큐에 삽입
			if(current-1>=0 && visited[current-1]==0) {
				q.add(current-1); 
				visited[current-1]=visited[current]+1;
			}
			if(current+1<visited.length && visited[current+1]==0) {
				q.add(current+1);
				visited[current+1]=visited[current]+1;
			}
			if(current*2<visited.length && visited[current*2]==0) {
				q.add(current*2);
				visited[current*2]=visited[current]+1;
			}
		}
		// 동생 위치까지의 이동 횟수 반환
		return (K==n)?0:visited[K];
	}
}