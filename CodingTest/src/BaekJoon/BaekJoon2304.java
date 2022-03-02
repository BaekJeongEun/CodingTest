package BaekJoon;

import java.util.Scanner;

public class BaekJoon2304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 기둥 갯수
		int[] map = new int[1001]; // 기둥번호가 1000이하 범위라 1000도 쓸수 있어야함.
		
		int maxH=0;
		int maxIdx=0;
		
		for(int n=0; n<N; n++) {
			int L = sc.nextInt(); // 기둥위치
			int H = sc.nextInt(); // 기둥높이
			map[L] = H;
			if(maxH < H) {
				maxH = H;
				maxIdx = L; // 최고 기둥 위치 기억
			}
		}
		
		int tmpMax = 0; // 기존 기둥높이 기억해서 이거보다 높아질때만 갱신
		int ans = 0; // 전체 다각형의 넓이 누적
		for(int i=0; i<=maxIdx; i++) { // 앞에서 고점까지
			if(tmpMax < map[i])
				tmpMax = map[i];
			ans += tmpMax;
		}
		
		tmpMax = 0;
		for(int i=1000; i>maxIdx; i--) { // 뒤에서 고점까지
			if(tmpMax < map[i])
				tmpMax = map[i];
			ans += tmpMax;
		}
		System.out.println(ans);
	}
}



