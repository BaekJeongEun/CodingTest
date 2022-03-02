package BaekJoon;

import java.util.Scanner;

public class BaekJoon2609 {
// ���ؿ¶������� 2609�� �ִ������� �ּҰ���� Java�� ����Ǯ��
	public static void main(String[] args) {
// �־��� �Է����� �ޱ�
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
// ��Ŭ���� ȣ������ ����ؼ� �μ��� �ִ����� ���
		int N = eucd(Math.max(A, B), Math.min(A, B));
// �ִ������� �μ��� ������ �� ���ϱ�
		A = A / N;
		B = B / N;
// �� ���� �ּҰ���� = �� ���� �ִ� ����� * ������ ���� ��
		int M = A * B * N;
// ���
		System.out.println(N);
		System.out.println(M);
	}

	/**
	 * ��Ŭ���� ȣ���� ���� �޼���
	 * 
	 * @param bn : ū ����
	 * @param sn : ���� ����
	 * @return ū ���ڸ� �������ڷ� ���� ���� 0�̸� �������� ����, �ƴϸ� ������·� �ڽ��� ȣ��
	 */
	static int eucd(int bn, int sn) {
// ū���ڸ� �������ڷ� ���� �������� ���
		int r = bn % sn;
// �������� 0�̸� �������ڰ� �ִ������̹Ƿ� �������� ����
		if (r == 0) {
			return sn;
		} else {
// �������� 0 �̻��̸� ������·� ȣ��
// �̶� �Ķ���ʹ� �������ڿ� �������� �־���
			return eucd(sn, r);
		}
	}
}

/*
 * import java.io.BufferedReader; import java.io.IOException; import
 * java.io.InputStreamReader; import java.util.StringTokenizer;
 * 
 * public class BaekJoon2609 {
 * 
 * public static void main(String[] args) throws IOException { BufferedReader br
 * = new BufferedReader(new InputStreamReader(System.in));
 * 
 * StringTokenizer st = new StringTokenizer(br.readLine()); int
 * a=Integer.parseInt(st.nextToken()); int b=Integer.parseInt(st.nextToken());
 * int max, min, greatest=0, least=0;
 * 
 * if(a>b) { max = a; min = b; } else{ max = b; min = a; } for(int i=1; i<=min;
 * i++) { if(max%i==0 && min%i==0) { greatest = i; } if((max*i)%min==0 &&
 * least==0) { least = max*i; } } System.out.println(greatest+"\n"+least);
 * 
 * }
 * 
 * }
 */