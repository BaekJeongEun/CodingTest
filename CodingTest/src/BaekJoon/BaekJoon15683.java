package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon15683 { // 감시 (G4)
	static int N, M, arr[][], temp[][], min=Integer.MAX_VALUE, dir[][]= {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static ArrayList<CCTV> cctv;
	static ArrayList<Integer> pickCCTV;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		cctv = new ArrayList<>();
		pickCCTV = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] > 0 && arr[i][j] < 6) {
					cctv.add(new CCTV(arr[i][j], i, j));
				}
			}
		}
		
		permu(0);
		System.out.println(min);
	}
	
	private static void permu(int cnt) {
		
		if(cctv.size() == pickCCTV.size()) { // 순열 다 돌렸다면
			// 사각지대 찾기
			checkBlindSpot();
			return;
		}
		
		for(int i=0; i<4; i++) { // 네방향
			pickCCTV.add(i);
			permu(cnt+1);
			pickCCTV.remove(pickCCTV.size()-1);
		}
	}
	
	private static void checkBlindSpot() {
		temp = new int[N][M];
		int cnt=0;
		for(int i = 0; i < arr.length; i++) { // 원본 복사
			System.arraycopy(arr[i], 0, temp[i], 0, arr[i].length);
		}
		for(int i = 0; i < cctv.size(); i++) { // cctv 돌려보기
			move(cctv.get(i), pickCCTV.get(i));
		}

		for(int i=0; i<N; i++) { // 사각지대 개수 세기
			for(int j=0; j<M; j++) {
				if(temp[i][j] == 0) cnt++;
			}
		}
		
		min = Math.min(min, cnt);
	}

	private static void move(CCTV nowCCTV, int d) { // 지금 CCTV가 상하좌우 중에 어딜 바라보니
		int num = nowCCTV.num;
		int x = nowCCTV.x;
		int y = nowCCTV.y;
		
		switch(num) {
		case 1:
			if(d==0) { // 우
				on(x, y, d);
			}else if(d==1) { // 하
				on(x, y, d);
			}else if(d==2) { // 좌
				on(x, y, d);
			}else if(d==3) { // 상
				on(x, y, d);
			}
			break;

		case 2:
			if(d==0 || d==2) { // 좌우
				on(x, y, 0);
				on(x, y, 2);
			}else if(d==1 || d==3) { // 상하
				on(x, y, 1);
				on(x, y, 3);
			}
			break;

		case 3:
			if(d==0) { // 상우
				on(x, y, 3);
				on(x, y, 0);
			}else if(d==1) { // 우하
				on(x, y, 0);
				on(x, y, 1);
			}else if(d==2) { // 하좌
				on(x, y, 1);
				on(x, y, 2);
			}else if(d==3) { // 좌상
				on(x, y, 2);
				on(x, y, 3);
			}
			break;

		case 4:
			if(d==0) { // 좌상우
				on(x, y, 2);
				on(x, y, 3);
				on(x, y, 0);
			}else if(d==1) { // 상우하
				on(x, y, 0);
				on(x, y, 3);
				on(x, y, 1);
			}else if(d==2) { // 우하좌
				on(x, y, 0);
				on(x, y, 1);
				on(x, y, 2);
			}else if(d==3) { // 하좌상
				on(x, y, 1);
				on(x, y, 2);
				on(x, y, 3);
			}
			break;

		case 5:
			on(x, y, 0);
			on(x, y, 1);
			on(x, y, 2);
			on(x, y, 3);
			break;
		}
	}

	private static void on(int x, int y, int d) {
		int nextX = x, nextY = y;
		while(true) {
			if(nextX>=0 && nextY>=0 && nextX<N && nextY<M && temp[nextX][nextY]!=6) {
				temp[nextX][nextY] = -1;
				nextX += dir[d][0];
				nextY += dir[d][1];
			}else break;
		}
	}

	public static class CCTV{
		int num, x, y;
		public CCTV(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
}
