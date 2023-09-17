package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon6118 { // 숨바꼭질 (S1)
	static int N, M;
	static ArrayList<ArrayList<Integer>> arr;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1];
		arr = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			arr.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			arr.get(to).add(from);
			arr.get(from).add(to);
		}
		Queue<int[]> q = new ArrayDeque<>();
		int[] answer = new int[3]; 
		q.offer(new int[] {1, 0}); 
		visit[1] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int node = now[0];
			int dist = now[1];
			if(dist > answer[1]) {
				answer[0] = node;
				answer[1] = dist;
				answer[2] = 1;
			} else if(dist == answer[1]) {
				answer[2]++;
				answer[0] = Math.min(answer[0], node);
			}
			for(int cur : arr.get(node)) {
				if(visit[cur]) continue;
				visit[cur] = true;
				q.offer(new int[] {cur, dist + 1});
			}
		}
		for(int x : answer)
            sb.append(x).append(" ");
		System.out.println(sb.toString());
	}

}
