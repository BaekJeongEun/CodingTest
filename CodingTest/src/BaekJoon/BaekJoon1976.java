package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1976 { // 여행 가자(G4)
	static int N, M;
	static ArrayList<ArrayList<Integer>> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			arr.add(new ArrayList<>());
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1)
					arr.get(i).add(j);
				if(i == j) arr.get(i).add(j);
			}
		}
		ArrayList<Integer> plan = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			plan.add(Integer.parseInt(st.nextToken())-1);
		}
		for(int s=0; s<plan.size()-1; s++) {
			bfs(plan.get(s), plan.get(s+1));			
		}
		
		System.out.println("YES");
	}
	static void bfs(int start, int end) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[N];
		q.offer(start);
		visit[start] = true;
		boolean exit = false;
		while(!q.isEmpty()) {
			Integer now = q.poll();
			if(now == end) {
				return;
			}
			for(int i=0; i<arr.get(now).size(); i++) {
				if(visit[new Integer(arr.get(now).get(i))]) continue;
				q.offer(new Integer(arr.get(now).get(i)));
				visit[new Integer(arr.get(now).get(i))] = true;
			}
		}
		System.out.println("NO");
		System.exit(0);
    }
}
