package Programmers;

import java.util.Arrays;

public class InterceptionSystem { // 요격 시스템(L2)

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{4,5}, {4,8},{10,14},{11,13},{5, 12},{3, 7},{1,4}}));
	}
	public static int solution(int[][] targets) {
        int answer = 0, last=-1;
        Arrays.sort(targets, (a, b)->a[1]-b[1]);
        for(int i=0; i<targets.length; i++) {
        	if(last >= targets[i][0] && last<=targets[i][1]) continue;
        	answer++;
        	last = targets[i][1] - 1;
        }
        return answer;
    }
}
