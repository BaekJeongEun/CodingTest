package Programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class  가장큰수 {

	public static void main(String[] args) {
		int[] arr = {6, 3, 30};
		System.out.println(solution(arr));
	}

	public static String solution(int[] numbers) {
        String answer = "";
        String[] number = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
        	number[i] = numbers[i]+"";
        }
        Arrays.sort(number, new Comparator<String>() {
    	    @Override
    	    public int compare(String a, String b) {
    	    	return (b+a).compareTo(a+b);
    	    }
    	});
        
        if(number[0].equals("0")) {
        	return "0";
        }
        for(int i = 0; i<number.length; i++) {
        	answer+=number[i];
        }
        
        return answer;
    }
}
