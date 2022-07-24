package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon2644 {
	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	static int total = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N+1];
		visit = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());		
		
		int target1 = Integer.parseInt(st.nextToken());
		int target2 = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			arr[i]= new ArrayList<Integer>();
		}
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			arr[child].add(parent);
			arr[parent].add(child);
		}
		
		bfs(target1, target2, 0);
		
		System.out.println(total);
	}
	private static void bfs(int target1, int target2, int cnt) {
		if(target1 == target2) {
			total = cnt;
			return;
		}

		visit[target1] = true;
		for(int i=0; i<arr[target1].size(); i++) {
			int nextStart = arr[target1].get(i);
			if(!visit[nextStart]) {
				bfs(nextStart, target2, cnt+1);
			}
		}
	}
}
