package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class ConnectIsland { // 섬 연결하기 (L2)
	static int[] parent;
	public static void main(String[] args) {
		System.out.println(solution(4, new int[][]{{0,1,1},{0,2,2},{1,3,1},{2,3,8}}));
	}
	
	public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
        for(int i=0; i<n; i++) {
        	parent[i] = i;
        }
        for(int[] edge : costs) {
        	int from = edge[0];
        	int to = edge[1];
        	int cost = edge[2];
        	
        	// 각 노드의 부모 노드 찾기
        	int fromP = dfs(from);
        	int toP = dfs(to);
        	
        	// 둘이 부모 노드가 같다면, 연결되어 있다면 해당 간선은 넘어가!
        	if(fromP==toP) continue;
        	
        	// 둘이 부모 노드가 달라? 그럼 최소 비용으로 추가!
        	answer += cost;
        	parent[toP] = fromP; // 이 경로를 추가했으니 연결된 최상위 부모 노드로 갱신
        }
        
        return answer;
    }

	private static int dfs(int node) {
		if(parent[node]==node) return node;
		return parent[node] = dfs(parent[node]);
	}

}
