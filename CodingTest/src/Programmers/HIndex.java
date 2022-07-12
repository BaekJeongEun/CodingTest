package Programmers;

import java.util.Arrays;

public class HIndex {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 0, 6, 1, 5}));
	}
	public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++) {
        	if(citations.length-i <= citations[i]) {
        		answer = citations.length-i;
        		break;
        	}
        }
        return answer;
    }
}
