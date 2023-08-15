package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1325 { // 효율적인 해킹(S1)
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] answer;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        visited = new boolean[N+1];
		answer = new int[N+1];

        for (int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            bfs(i);
        }
        int max = Arrays.stream(answer).max().getAsInt();
        for (int i=0; i<answer.length; i++) {
            if (answer[i] == max) {
            	sb.append(i + " ");
            }
        }
        System.out.println(sb.toString());
    }

    public static void bfs(int index) {
        Queue<Integer> q = new LinkedList<>();
        visited[index] = true;
        q.offer(index);

        while (!q.isEmpty()) {
            int cv = q.poll();
            for (int computer : graph.get(cv)) {
                if (!visited[computer]) {
                    visited[computer] = true;
                    answer[computer]++;
                    q.offer(computer);
                }
            }
        }
    }

}