package Programmers;

import java.util.Arrays;

public class Budget {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2,2,3,3}, 10));
	}
	public static int solution(int[] d, int budget) {
        int answer = 0, sum=0;
        Arrays.sort(d);
        for(int i=0; i<d.length; i++) {
        	if(sum+d[i]<=budget) {
        		sum+=d[i];
        		answer++;
        	}
        }
        return answer;
    }
}
