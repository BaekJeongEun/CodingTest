package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Commute { // 출퇴근길(L3)
	static int n, m, S, T;
	static ArrayList<ArrayList<Integer>> arr;
	static boolean[] arrVisit, reverseVisit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		arrVisit = new boolean[n+1];
		reverseVisit = new boolean[n+1];
		for(int i=0; i<=n; i++) {
			arr.add(new ArrayList<>());
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			arr.get(to).add(from);
		}
		// S -> T
		arrVisit[S] = true;
		bfs(T, arrVisit);
		
		// T -> S
		reverseVisit[T] = true;
		bfs(S, reverseVisit);
		
		int cnt = 0;
		for(int i=0; i<=n; i++) {
			if(arrVisit[i] && reverseVisit[i]) cnt++;
		}
		System.out.println(cnt);
	}
	private static void bfs(int end, boolean[] visit) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(end);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=0; i<arr.get(now).size(); i++) {
				if(visit[arr.get(now).get(i)]) continue;
				visit[arr.get(now).get(i)] = true;
				q.offer(arr.get(now).get(i));
			}
		}
	}

}
