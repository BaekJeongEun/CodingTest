package Programmers;

import java.util.Arrays;

public class ToBinary { // 이진 변환 반복하기 (Lv2)
	static int cnt = 0, removeCnt=0;
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("1111111")));
	}

	private static int[] solution(String s) {
		int[] answer = new int[2];
		
		while(!s.equals("1")) {
			s = removeZero(s);
			if(s == "1") break;
			s = toBinary(s);
			if(s == "1") break;
			cnt++;
		}
		answer[0] = cnt;
		answer[1] = removeCnt;
		
        return answer;
	}

	private static String removeZero(String s) {
		removeCnt += s.chars().filter(c -> c == '0').count();
		return s.replaceAll("0", "");
	}

	private static String toBinary(String s) {
		return Integer.toBinaryString(s.length());
	}

}
