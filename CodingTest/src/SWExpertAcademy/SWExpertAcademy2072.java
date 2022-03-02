// 2072. 홀수만 더하기

package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWExpertAcademy2072 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine()); // 진행할 테스트 횟수
		
		for(int tc=1; tc<=TC; tc++) {
			int sum = 0;			// 합계
			String str = br.readLine();
//			String str1[] = str.split(" ");
			StringTokenizer st = new StringTokenizer(str);
			for(int i=0; i<10; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(num % 2 == 1) {
					sum += num;
				}
			}
			System.out.println("#"+tc+" "+sum);
		}

	}

}



//package day0112;
//
//import java.util.Scanner;
//
//public class SWExpertAcademy {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int TC = sc.nextInt(); // 진행할 테스트 횟수
//		
//		for(int tc=1; tc<=TC; tc++) {
//			int sum = 0;			// 합계
//			
//			for(int i=0; i<10; i++) {
//				int num = sc.nextInt();
//				if(num % 2 == 1) {
//					sum += num;
//				}
//			}
//			System.out.println("#"+tc+" "+sum);
//		}
//
//	}
//
//}
