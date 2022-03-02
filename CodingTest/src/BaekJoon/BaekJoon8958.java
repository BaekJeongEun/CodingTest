package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// OX ����, �����2
public class BaekJoon8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int i=0; i<TC; i++) {	// ��ü �׽�Ʈ ���̽� Ƚ��
			String str = br.readLine();
			int cnt=0, accumulate=0;
			for(int j=0; j<str.length(); j++) {	// ���ڿ� ���̸�ŭ �ݺ�
				if(str.charAt(j)=='O') {	// O�� ���
					accumulate++;
				}
				else						// X�� ��� 
				{	
					accumulate = 0;			// ������ �ʱ�ȭ
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
//			int cnt = 0;	// ����Ƚ��
//			int sum = 0;	// ���� �ջ� 
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
