package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class NoSameNumber {

	public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1};
		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int idx=0;
        answer.add(arr[0]);
        for(int i=1; i<arr.length; i++) {
        	if(arr[i]!=arr[i-1]) {
        		answer.add(arr[i]);
        	}
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}
