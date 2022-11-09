package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon21608 { // 상어 초등학교 (G5)
    static int N, arr[][], dir[][]= {{0,1},{0,-1},{1,0},{-1,0}};
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    static Queue<Integer> q = new ArrayDeque<Integer>();
    static ArrayList<Point> emptyList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N*N; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            ArrayList<Integer> temp = new ArrayList<>();
            for(int m=0; m<4; m++)
            	temp.add(Integer.parseInt(st.nextToken()));
            map.put(key, temp);
            q.offer(key);
            emptyList.add(new Point(i/N, i%N));
        }
        while(!q.isEmpty()) {
            findSeat(q.poll());
        }
        int sum = 0;
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		int person = 0;
        		int num = arr[i][j];
        		for(int d=0; d<4; d++) {
        			int nx = i +dir[d][0];
        			int ny = j +dir[d][1];
        			if(nx>=0 && ny>=0 && nx<N && ny<N && map.get(num).contains(arr[nx][ny])) {
        				person++;
        			}
        		}
        		sum += Math.pow(10, person-1);
        	}
        }
        System.out.println(sum);
    }
    private static void findSeat(int now) {
        // map 돌면서 좋아하는 학생, 빈칸 개수 세기
    	PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if(o1.like == o2.like) {
					if(o1.empty == o2.empty) {
						if(o2.x == o1.x)
							return o1.y - o2.y;
						else return o1.x - o2.x;
					}
					else return o2.empty - o1.empty;					
				}
				return o2.like - o1.like;
			}
		});
        for(int i=0; i<emptyList.size(); i++) {
            int[] result = go(emptyList.get(i), now);
            Point create = new Point(emptyList.get(i).x, emptyList.get(i).y);
            create.like = result[0];
            create.empty = result[1];
            create.idx = i;
            q.offer(create);
        }
        Point cur = q.poll();
        arr[cur.x][cur.y] = now;
        emptyList.remove(cur.idx);
    }
    private static int[] go(Point point, int cur) {
        // 현재 위치에서 좋아하는 학생, 빈칸 개수 반환
        int[] result = new int[2];
        int x = point.x;
        int y = point.y;
        int now = arr[x][y];
        ArrayList<Integer> like = map.get(cur);
        int likeCnt = 0, empty =0;
        for(int d=0; d<4; d++) {
        	int nx = x + dir[d][0];
        	int ny = y + dir[d][1];
        	if(nx>=0 && nx<N && ny>=0 && ny<N) {
        		if(like.contains(arr[nx][ny])) {
        			likeCnt++;
        		}else if(arr[nx][ny] == 0) {
        			empty++;
        		}
        	}
        }
        result[0] = likeCnt;
        result[1] = empty;
        return result;
    }
    static class Point {
        int x, y, idx;
        int empty, like;
        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", idx=" + idx + ", empty=" + empty + ", like=" + like + "]";
		}
        
    }
}