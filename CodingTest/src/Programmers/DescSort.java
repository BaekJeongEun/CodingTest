package Programmers;

import java.util.Arrays;
import java.util.Collections;

public class DescSort { // 문자열 내림차순으로 배치하기

	public static void main(String[] args) {
		System.out.println(solution("Zbcdefg"));

	}
	public static String solution(String s) {
        String answer = "";
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        for(int i=s.length()-1; i>=0; i--)
        	answer+=arr[i];
        return answer;
    }

}
