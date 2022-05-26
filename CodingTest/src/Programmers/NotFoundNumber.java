package Programmers;

import java.util.Arrays;
import java.util.HashSet;

public class NotFoundNumber {
	public static void main(String[] args) {
		int arr[]={5,8,4,0,6,7,9};
		System.out.println(solution(arr));

	}
	
	public static int solution(int[] numbers) {
        int answer = 0;
        for(int i=0;i<numbers.length; i++) {
        	answer+=numbers[i];
        }
        
        return 45-answer;
    }

}
