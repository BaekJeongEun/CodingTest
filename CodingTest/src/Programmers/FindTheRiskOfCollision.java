package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class FindTheRiskOfCollision {
	static int[][] arr, dir= {{1,0},{-1,0},{0,1},{0,-1}};
	static int N, answer;
	static Queue<int[]>[] list;

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 3, 2 }, { 6, 4 }, { 4, 7 }, { 1, 4 } },
				new int[][] { { 4, 2 }, { 1, 3 }, { 2, 4 } }));
	}

	public static int solution(int[][] points, int[][] routes) {
		int answer = 0;
		arr = new int[101][101];
		N = points.length;

		list = new LinkedList[N];
		
		for(int i = 0; i < N; i++){
			list[i] = new LinkedList<>();
	    }
	    function(points, routes); // 경로 계산 
	    function2(); // 충돌 계산
		
		return answer;
	}

	private static void function2() {
		int count = 0;
        while(count != N){
            int [][] map = new int [101][101];
            count = 0;
            for(int i = 0; i < N; i++){
                if(list[i].isEmpty()){
                    count++;
                    continue;
                }
                int [] temp = list[i].poll();
                map[temp[0]][temp[1]]++;
            }
            for(int i = 0; i < 101; i++){
                for(int j = 0; j < 101; j++){
                    if(map[i][j] > 1) answer++; 
                }
            }
        }
	}

	private static void function(int[][] points, int[][] routes) {
		for(int i = 0; i < N; i++){
            int [] point = points[routes[i][0] - 1];
            int x = point[0];
            int y = point[1];
            list[i].add(new int[]{x, y});
            for(int j = 1; j < routes[0].length; j++){
                int [] next_point = points[routes[i][j] - 1];
                int nx = next_point[0];
                int ny = next_point[1];
                
                int xp = nx - x;  
                int yp = ny - y; 
                while(xp != 0){
                    if(xp > 0){
                        xp--;
                        x++;
                        list[i].add(new int[]{x, y});
                    }
                    else{
                        xp++;
                        x--;
                        list[i].add(new int[]{x, y});
                    }
                }
                while(yp != 0){
                    if(yp > 0){
                        yp--;
                        y++;
                        list[i].add(new int[]{x, y});
                    }
                    else{
                        yp++;
                        y--;
                        list[i].add(new int[]{x, y});
                    }
                }
            }
        }
	}
}
