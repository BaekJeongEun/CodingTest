package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon1167 {
	static int V, answer, second;
	static ArrayList<int[]>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		V = Integer.parseInt(br.readLine());
		list = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList();
		}
		for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1)
                    break;
                int weight = Integer.parseInt(st.nextToken());
                list[start].add(new int[]{end,weight});
            }
        }
		dijkstra(1); 
		if (second != 1)
            dijkstra(second);
		System.out.println(answer);
	}

	private static void dijkstra(int start) {
		boolean[] visit = new boolean[V + 1];
		int[] arr = new int[V + 1];
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
		q.offer(new int[] { start, 0 });
		visit[start] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int num = now[0];
			ArrayList<int[]> adjList = list[num];
			for (int[] cur : adjList) {
				int nNum = cur[0];
				int nCost = cur[1];
				if(!visit[nNum] && arr[nNum] < arr[num] + nCost) {
                    arr[nNum] = arr[num] + nCost;
                    q.offer(new int[] {nNum, arr[nNum]});
                    visit[nNum] = true;
                }
			}
		}
		for (int i = 1; i <= V; i++) {
			if(answer< arr[i]) {
                answer = arr[i];
                second = i;
            }
		}
	}

}
