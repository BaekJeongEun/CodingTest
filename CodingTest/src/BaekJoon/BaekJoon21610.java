package BaekJoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon21610 { // 마법사 상어와 비바라기 (G5)
    static int N, M, total;
    static Point[][] arr;
    static Queue<Point> q;
    static ArrayList<Point> newCloudList;
    static int[][] diagonal = {{-1,-1}, {1,1}, {-1,1}, {1,-1}};
    static int[][] dir = {{}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new Point[N][N];
        q = new ArrayDeque();
        newCloudList = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                Point create = new Point(i, j, Integer.parseInt(st.nextToken()), false);
                if((i==N-1 && j==0) || (i==N-1 && j==1) || (i==N-2 && j==0) || (i==N-2 && j==1)) {
                    create.cloud = true;
                    q.offer(create);
                }
                arr[i][j] = create;
            }
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            
            bfs(d, s);
        }
        System.out.println(total);
    }
    private static void bfs(int d, int s) {
        // 구름 이동하면서 증가
        move(d, s);
        diagonalCheck();
        createCloud();
    }
    private static void move(int d, int s) { // 구름 이동 + 1
        int size = q.size();
        newCloudList = new ArrayList<>();
        for(int i=0; i<size; i++) {
            Point now = q.poll();	
            int x = now.x;
            int y = now.y;
            arr[x][y].cloud = false;
            now.cloud = false;
            int nx = (x+dir[d][0]*(s%N)+N)%N;
            int ny = (y+dir[d][1]*(s%N)+N)%N;
            arr[nx][ny].cloud = true;
            arr[nx][ny].num++;
            Point create = new Point(nx, ny, arr[nx][ny].num+1, true);
            newCloudList.add(create);
        }
        
        for(int i=0; i<newCloudList.size(); i++) {
        	Point now = newCloudList.get(i);
        	arr[now.x][now.y].cloud = true;
        }
    }
    private static void diagonalCheck() {
    	int size = newCloudList.size();
        for(int i=0; i<size; i++) { // 생성된 구름의 대각선 파악
            Point now = newCloudList.get(i);
            int x = now.x;
            int y = now.y;
            // 대각선 위치에 구름이 있는지 카운트
            int cnt = 0;
            for(int di=0; di<4; di++) {
                int nx = x + diagonal[di][0];
                int ny = y + diagonal[di][1];
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(arr[nx][ny].num > 0)
                	cnt++;
            }
            arr[x][y].num += cnt;
            now.num += cnt;
        }
	}
	private static void createCloud() {
    	total = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) { // 현재 구름 제외한 곳과 물이 2이상인 곳 구름 생성
                if(!arr[i][j].cloud && arr[i][j].num>=2) {
                    arr[i][j].cloud = true;
                    arr[i][j].num -= 2;
                    q.offer(arr[i][j]);
                }
                total += arr[i][j].num;
            }
        }
        for(int i=0; i<newCloudList.size(); i++) { // 현재 구름들 소멸
        	Point now = newCloudList.get(i);
        	arr[now.x][now.y].cloud = false;
        }
    }
    static class Point{
        int x, y, num;
        boolean cloud;
        public Point(int x, int y, int num, boolean cloud) {
            super();
            this.x = x;
            this.y = y;
            this.num = num;
            this.cloud = cloud;
        }
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", num=" + num + ", cloud=" + cloud + "]";
		}
        
    }
}