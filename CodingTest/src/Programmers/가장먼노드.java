package Programmers;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class 가장먼노드 {

    public static void main(String[] args) {
        System.out.println(
            solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        int[] dist = new int[n];
        boolean[] visit = new boolean[n];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            arr.get(edge[i][0] - 1).add(edge[i][1] - 1);
            arr.get(edge[i][1] - 1).add(edge[i][0] - 1);
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visit[0] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            visit[now] = true;
            for (Integer i : arr.get(now)) {
                if (!visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                    dist[i] = dist[now] + 1;
                }
            }
        }
        int max = Arrays.stream(dist).max().getAsInt();
        for (Integer i : dist) {
            if (i == max) {
                answer++;
            }
        }
        return answer;
    }
}