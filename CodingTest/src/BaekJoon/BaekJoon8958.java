package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// OX 퀴즈, 브론즈2
public class BaekJoon8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int i=0; i<TC; i++) {	// 전체 테스트 케이스 횟수
			String str = br.readLine();
			int cnt=0, accumulate=0;
			for(int j=0; j<str.length(); j++) {	// 문자열 길이만큼 반복
				if(str.charAt(j)=='O') {	// O일 경우
					accumulate++;
				}
				else						// X일 경우 
				{	
					accumulate = 0;			// 누적값 초기화
				}
				cnt += accumulate;
			}
			System.out.println(cnt);
		}
	}

}

//package BaekJoon;
//
//import java.util.Scanner;
//
//public class BaekJoon8958 {
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
// 
//		String arr[] = new String[in.nextInt()];
// 
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = in.next();
//		}
//		
//		in.close();
//		
//		for (int i = 0; i < arr.length; i++) {
//			
//			int cnt = 0;	// 연속횟수
//			int sum = 0;	// 누적 합산 
//			
//			for (int j = 0; j < arr[i].length(); j++) {
//				
//				if (arr[i].charAt(j) == 'O') {
//					cnt++;
//				} 
//				else {
//					cnt = 0;
//				}
//				sum += cnt;
//			}
//			
//			System.out.println(sum);
//		}
//	}
//}
