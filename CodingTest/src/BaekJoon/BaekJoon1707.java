package BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1707 { // 이분 그래프 (G4)
	static ArrayList<Integer>[] adList;
    static int[] visit;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            adList = new ArrayList[V + 1];
            visit = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                adList[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adList[u].add(v);
                adList[v].add(u);
            }
            boolean check = true;
            for (int i = 1; i <= V; i++) {
                if (visit[i] == 0 && !bfs(i)) {
                    check = false;
                    break;
                }
            }
            System.out.println((check) ? "YES" : "NO");
        }
    }

    private static boolean bfs(int start) {
        int color = 1;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(start, color));
        while (!q.isEmpty()) {
            Node now = q.poll();
            int nowNum = now.num;
            int nowColor = now.color;
            for (int i = 0; i < adList[nowNum].size(); i++) {
                if (0 == visit[adList[nowNum].get(i)]) {
                    q.offer(new Node(adList[nowNum].get(i), nowColor * (-1)));
                    visit[adList[nowNum].get(i)] = nowColor * (-1);
                } else if (nowColor == visit[adList[nowNum].get(i)]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class Node {
        int num;
        int color;

        public Node(int num, int color) {
            super();
            this.num = num;
            this.color = color;
        }
    }
}
