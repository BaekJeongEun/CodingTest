package Programmers;

import java.util.Arrays;

public class PhoneList {

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "12", "123", "1235", "567", "88" }));
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;

		Arrays.sort(phone_book);

		for (int i = 0; i < phone_book.length-1 && answer; i++) {
			if(phone_book[i+1].startsWith(phone_book[i]))
				answer = false;
		}
		return answer;
	}
}
