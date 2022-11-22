package SWExpertAcademy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWExpertAcademy8382 { // 방향전환 (D4)
    static int N, M, ans;
    static int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } }; // 좌0 우1 상2 하3

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken()) + 100;
            int sY = Integer.parseInt(st.nextToken()) + 100;
            int eX = Integer.parseInt(st.nextToken()) + 100;
            int eY = Integer.parseInt(st.nextToken()) + 100;

            ans = 0;
            bfs(sX, sY, eX, eY);
            sb.append("#" + tc + " " + ans + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int sX, int sY, int eX, int eY) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visit = new boolean[201][201][2];
        q.offer(new int[] { sX, sY, 0, 0 }); // x, y, dir, cnt
        q.offer(new int[] { sX, sY, 1, 0 });
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int di = now[2];
            int cnt = now[3];
            if (x == eX && y == eY) {
                ans = cnt;
                return;
            }
            if (di == 1) { // 좌우
                for (int d = 2; d < 4; d++) {
                    int nx = x + dir[d][0];
                    int ny = y + dir[d][1];
                    if(nx<0 || ny<0 || nx>=201 || ny>=201 || visit[nx][ny][0]) continue;
                    visit[nx][ny][0] = true;
                    q.offer(new int[] { nx, ny, 0, cnt + 1 });
                }
            } else { // 상하
                for (int d = 0; d < 2; d++) {
                    int nx = x + dir[d][0];
                    int ny = y + dir[d][1];
                    if(nx<0 || ny<0 || nx>=201 || ny>=201 || visit[nx][ny][1]) continue;
                    visit[nx][ny][1] = true;
                    q.offer(new int[] { nx, ny, 1, cnt + 1 });
                }
            }
        }
    }

}