package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWExpertAcademy_1238 { // Contact (D4)
	static boolean[] visit;
	static ArrayList<Integer> arr[];
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc<=10; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			visit = new boolean[101];
			int start = Integer.parseInt(st.nextToken());
			arr = new ArrayList[101];
			for(int i=1; i<=100; i++) {
				arr[i] = new ArrayList();
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from].add(to);
			}
			sb.append("#").append(tc).append(" ").append(bfs(start)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visit[start] = true;
		q.offer(start);
		int max = Integer.MIN_VALUE;
		while(!q.isEmpty()) {
			max = Integer.MIN_VALUE;
			int size = q.size();
			for(int s=0; s<size; s++) { // 현재 큐에 들어있는 친구들이 퍼졌을 때
				int cur = q.poll();
				max = Math.max(max, cur);
				for(int i=0; i<arr[cur].size(); i++) { // 나랑 연결된 애들 큐에 다 넣어
					int next = arr[cur].get(i);
					if(visit[next]) continue;
					visit[next] = true;
					q.offer(next);
				}
			}
		}
		return max;
	}

}
