package Programmers;

import java.io.IOException;
import java.util.Arrays;

public class PuzzleGame {

	public static void main(String[] args) throws IOException {
		int[] diffs = {1, 328, 467, 209, 54};
		int[] times = {2, 7, 1, 4, 3};
		
		System.out.println(solution(diffs, times, 1723));
	}

	public static long solution(int[] diffs, int[] times, long limit) { 
        long left = diffs[0];       
        long right = Arrays.stream(diffs).max().getAsInt();
        long answer = right;
        
        while(left <= right) {
        	long mid = (right+left)/2;
        	long time = getTime(diffs, times, mid);
        	if(time <= limit) { // 제한시간보다 작으면 숙련도 낮춰야 함
        		right = mid - 1;
        		answer = (int) Math.min(answer, mid);
        	} else {
        		left = mid + 1;
        	}
        }
        return answer;
    }

	private static long getTime(int[] diffs, int[] times, long level) {
		long time = 0;
		for(int i=0; i<diffs.length; i++) {
			if(diffs[i]<=level) {
				time += times[i];
			}else {
				time += ((times[i-1]+times[i]) * (diffs[i]-level) + times[i]);
			}
		}
		return time;
	}
}
