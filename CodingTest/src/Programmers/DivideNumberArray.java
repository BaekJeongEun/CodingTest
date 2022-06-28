package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DivideNumberArray {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(solution(new int[] {5,9,7,10}, 5)));
	}
	public static int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> arrL = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) {
        	if(arr[i] % divisor == 0) {
        		arrL.add(arr[i]);
        	}
        }
        Collections.sort(arrL);
        
        if(arrL.size()==0) {
        	answer = new int[1];
        	answer[0] = -1;
        }
        else {
        	   answer = arrL.stream()
                       .mapToInt(i -> i)
                       .toArray();
        }
        return answer;
    }
}
