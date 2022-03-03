package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BaekJoon1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = Integer.MAX_VALUE; // 초기 상태 여부 확인을 위한 값으로 설정
		StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-"); // ( - ) 를 기준으로 배열에 저장하기 위함

		while (subtraction.hasMoreTokens()) {
			int temp = 0;

			// ( + ) 를 기준으로 배열에 저장하기 위함
			StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");

			// 덧셈으로 나뉜 토큰들을 모두 더한다.
			while (addition.hasMoreTokens()) {
				temp += Integer.parseInt(addition.nextToken());
			}

			// 첫 번째토큰인 경우 temp값이 첫 번째 수가 됨
			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			} else { // 아닐 경우 전부 빼기
				sum -= temp;
			}
		}
		System.out.println(sum);

	}
}
