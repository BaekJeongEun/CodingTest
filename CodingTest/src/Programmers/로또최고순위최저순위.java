package Programmers;

import java.io.IOException;
import java.util.Arrays;

public class 로또최고순위최저순위 {
	public static void main(String[] args) throws IOException{
		int[] lottos = {0, 0, 0, 0, 0, 0};
		int[] win_nums = {38, 19, 20, 40, 15, 25};
		int[] answer = new int[2];
		
		int zero_cnt=0, equal_cnt=0, win=0, lose=0; // 최고등수: 0개수+동일개수, 최저등수: 동일개수
		
		for(int i=0; i<6; i++) {
			if(lottos[i]==0) {
				zero_cnt++;
				continue;
			}
			for(int j=0; j<6; j++) {
				if(lottos[i] == win_nums[j]) {
					equal_cnt++;
				}
				
			}
		}
		win = (zero_cnt+equal_cnt<=1)?6:6-(zero_cnt+equal_cnt)+1;
		lose = (equal_cnt<=1)?6:6-equal_cnt+1;
		answer[0] = win;
		answer[1] = lose;
		System.out.println(Arrays.toString(answer));
	}
}
