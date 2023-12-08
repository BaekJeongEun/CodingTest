package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon19236 { // 청소년 상어(G2)
	static int answer = Integer.MIN_VALUE;
	static int[][] dir = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		ArrayList<Fish> list = new ArrayList<>();

		int[][] arr = new int[4][4];
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				int idx = Integer.parseInt(st.nextToken());
				Fish fish = new Fish(i, j, idx, Integer.parseInt(st.nextToken())-1, true);
				arr[i][j] = idx;
				list.add(fish);
			}
		}

		Collections.sort(list, (a, b)->a.num-b.num);
		Fish fish = list.get(arr[0][0] - 1);
		Shark shark = new Shark(0, 0, fish.direction, fish.num);
		fish.alive = false;
		arr[0][0] = -1;
		// 상어 출발
		dfs(arr, shark, list);
		System.out.println(answer);
	}
	private static void dfs(int[][] arr, Shark shark, List<Fish> list) {
		// 상어 방향, eat 갱신
		answer = Math.max(answer, shark.eat);
		// 물고기 움직이기
		list.forEach(e -> moveFish(e, arr, list));
		// 상어가 물고기 먹기
		for(int i=1; i<4; i++) { // 최대 4번 움직이며 먹을 수 있는 물고기 탐색
			int nx = shark.x + dir[shark.direction][0]*i;
			int ny = shark.y + dir[shark.direction][1]*i;
			if(nx >=0 && ny>=0 && nx<4 && ny<4 && arr[nx][ny]>0) {
				int[][] arrCopies = copyArr(arr);
				arrCopies[shark.x][shark.y] = 0;
				List<Fish> fishCopies = copyFishes(list);
				Fish f = fishCopies.get(arr[nx][ny] - 1);
				Shark createShark = new Shark(f.x, f.y, f.direction, shark.eat+f.num);
				f.alive = false;
				arrCopies[nx][ny] = -1;
				dfs(arrCopies, createShark, fishCopies);
			}
		}
	}
	 static int[][] copyArr(int[][] arr) {
	        int[][] temp = new int[4][4];

	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {
	                temp[i][j] = arr[i][j];
	            }
	        }

	        return temp;
	    }

	static List<Fish> copyFishes(List<Fish> fishes) {
        List<Fish> temp = new ArrayList<>();
        fishes.forEach(e -> temp.add(new Fish(e.x, e.y, e.num, e.direction, e.alive)));
        return temp;
    }
	static void moveFish(Fish fish, int[][] arr, List<Fish> fishes) {
        if (fish.alive == false) return;

        for (int i = 0; i < 8; i++) {
            int nextDir = (fish.direction + i) % 8;
            int nx = fish.x + dir[nextDir][0];
            int ny = fish.y + dir[nextDir][1];

            if (0 <= nx && nx < 4 && 0 <= ny && ny < 4 && arr[nx][ny] > -1) {
                arr[fish.x][fish.y] = 0;
                
                if (arr[nx][ny] == 0) {
                    fish.x = nx;
                    fish.y = ny;
                } else {
                    Fish temp = fishes.get(arr[nx][ny] - 1);
                    temp.x = fish.x;
                    temp.y = fish.y;
                    arr[fish.x][fish.y] = temp.num;

                    fish.x = nx;
                    fish.y = ny;
                }

                arr[nx][ny] = fish.num;
                fish.direction = nextDir;
                return;
            }
        }
    }

	static class Shark {
		int x, y, direction, eat;
		public Shark(int x, int y, int direction, int eat) {
			super();
			this.x = x;
			this.y = y;
			this.direction = direction;
			this.eat = eat;
		}
	}
	static class Fish {
		int x, y, num, direction;
		boolean alive = true;
		public Fish(int x, int y, int num, int direction, boolean alive) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.direction = direction;
			this.alive = alive;
		}
	}
}
