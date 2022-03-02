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
		String str = br.readLine(); // ���� ������ �Է¹ޱ� -> ������ ���ڿ��� �Է� �޾��� "1 2"
		
		// ���۵�� ������ ���� ������ �Է¹����ϱ� ����� ��.
		// ver1 : split���� String �迭 ����鼭 �丷����
//		String[] ab = str.split(" "); // ������ �������� ���ڿ��� �߶� �迭�� ����
//		int a = Integer.parseInt(ab[0]);
//		int b = Integer.parseInt(ab[1]);
		
		// ver2 : StringTokenizer ���
		StringTokenizer st = new StringTokenizer(str);
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.println(a+b);
	}

}
