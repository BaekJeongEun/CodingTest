package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BaekJoon1000 {

	public static void main(String[] args) throws IOException {
		
		
		Scanner sc = new Scanner(System.in);
/*
		int a = sc.nextInt();
		int b = sc.nextInt();
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine(); // 한줄 통으로 입력받기 -> 무조건 문자열로 입력 받아짐 "1 2"
		
		// 버퍼드는 무조건 한줄 통으로 입력받으니까 끊어야 됨.
		// ver1 : split으로 String 배열 만들면서 토막내기
//		String[] ab = str.split(" "); // 공백을 기준으로 문자열을 잘라 배열에 저장
//		int a = Integer.parseInt(ab[0]);
//		int b = Integer.parseInt(ab[1]);
		
		// ver2 : StringTokenizer 사용
		StringTokenizer st = new StringTokenizer(str);
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.println(a+b);
	}

}
