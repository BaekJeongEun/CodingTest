package Programmers;

public class Fatigue {
	static int [][] dungeon;
	static boolean[] visited;
	static int answer=0;
	public static void main(String[] args) {
		System.out.println(solution(80, new int[][] {{80,20}, {50,40}, {30,10}}));
	}
	public static int solution(int k, int[][] dungeons) {
        dungeon = dungeons;
        visited = new boolean[dungeons.length];
        dfs(0, k);
        return answer;
    }
	public static void dfs(int cnt, int k) {
		for(int i=0; i<dungeon.length; i++) {
			if(!visited[i] && dungeon[i][0] <= k) { // 체력이 k만큼은 남았는가
				visited[i] = true;
				dfs(cnt+1, k-dungeon[i][1]); // 현재 던전 끝난 후 소모된 체력으로 다음 순번 go!
				visited[i] = false;
			}
		}
		answer = Math.max(answer, cnt); // 현재 던전 끝나고 던전 개수 최대 값 갱신
	}
}
