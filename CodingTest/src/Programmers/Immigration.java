package Programmers;

import java.util.Arrays;

public class Immigration {

	public static void main(String[] args) {
		System.out.println(solution(6, new int[] {7,10}));
	}
	public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long start = 1;
        long end = (long)times[times.length-1]*n;
        
        while(start<=end) {
        	long mid = (start+end)/2;
        	long sum = 0;
        	for(int time : times) {
        		sum += mid / time;
        	}
        	if(n <= sum) {
        		end = mid-1;
        		answer = mid;
        	}else {
        		start = mid+1;
        	}
        }
        
        return answer;
    }
}
