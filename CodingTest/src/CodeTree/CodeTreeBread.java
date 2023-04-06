package CodeTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CodeTreeBread { // 코드트리 빵 (G2)

    static int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}; // 상 좌 우 하
    static int N, M, time = 0;
    static Area[][] area;
    static ArrayList<Person> person = new ArrayList<>(); // 편의점 도착하면 빼내기

    public static void main(String[] args) throws IOException {
        input();
        move();
    }

    public static void move() {
        while (!person.isEmpty()) {
            time++;
            A: for (int p = 0; p < person.size(); p++) {
                Person now = person.get(p);
                int num = now.num;
                if (now.x == -1 && now.y == -1 && time == num) { // 베이스캠프 들어가기
                    if (intoBaseCamp(now, p)) {
                        continue A;
                    }
                }
                // 편의점에 도착하면 사람 빼내기
                if (bfs(now)) {
                    person.remove(p);
                    p--;
                }
            }
        }
        System.out.println(time);
    }

    private static boolean bfs(Person person) {
        Queue<Node> queue = person.queue;
        boolean[][] visit = person.visit;
        int goalX = person.goalX, goalY = person.goalY;
        int size = queue.size();
        for (int s = 0; s < size; s++) {
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            for (int d = 0; d < 4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny] || (area[nx][ny] != null
                    && area[nx][ny].block)) {
                    continue;
                }
                if (nx == goalX && ny == goalY) { // 편의점 들어왔다면
                    area[goalX][goalY].block = true;
                    return true;
                }
                visit[nx][ny] = true;
                queue.offer(new Node(nx, ny));
            }
        }
        return false;
    }

    private static boolean intoBaseCamp(Person now, int index) {
        int goalX = now.goalX;
        int goalY = now.goalY;
        // 목표 편의점에서 모든 베이스 캠프 중 가장 가까운 베이스 캠프 찾기
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];
        visit[goalX][goalY] = true;
        queue.offer(new Node(goalX, goalY)); // 편의점 시작
        A:
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            for (int d = 0; d < 4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny] || (area[nx][ny] != null
                    && area[nx][ny].block)) {
                    continue;
                }
                if ((area[nx][ny] != null && !area[nx][ny].isConvenient) && !area[nx][ny].block) {
                    person.get(index).x = nx;
                    person.get(index).y = ny;
                    area[nx][ny].block = true;
                    person.get(index).queue.offer(new Node(nx, ny));
                    person.get(index).visit[nx][ny] = true;
                    return true;
                }
                visit[nx][ny] = true;
                queue.offer(new Node(nx, ny));
            }
        }
        return false;
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new Area[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    area[i][j] = new Area(i, j, 0, false, false);
                }
            }
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            area[x][y] = new Area(x, y, i, false, true);

            person.add(new Person(-1, -1, i, x, y));
        }
    }

    public static class Node {

        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Person {

        int x, y, num;
        int goalX, goalY;
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];

        public Person(int x, int y, int num, int goalX, int goalY) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.goalX = goalX;
            this.goalY = goalY;
        }
    }

    public static class Area implements Comparable<Area> {

        int x, y, num;
        boolean block, isConvenient;

        public Area(int x, int y, int num, boolean block, boolean isConvenient) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.block = block;
            this.isConvenient = isConvenient;
        }

        @Override
        public int compareTo(Area o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
}