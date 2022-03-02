package BaekJoon;

import java.util.Scanner;

public class BaekJoon2304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // ��� ����
		int[] map = new int[1001]; // ��չ�ȣ�� 1000���� ������ 1000�� ���� �־����.
		
		int maxH=0;
		int maxIdx=0;
		
		for(int n=0; n<N; n++) {
			int L = sc.nextInt(); // �����ġ
			int H = sc.nextInt(); // ��ճ���
			map[L] = H;
			if(maxH < H) {
				maxH = H;
				maxIdx = L; // �ְ� ��� ��ġ ���
			}
		}
		
		int tmpMax = 0; // ���� ��ճ��� ����ؼ� �̰ź��� ���������� ����
		int ans = 0; // ��ü �ٰ����� ���� ����
		for(int i=0; i<=maxIdx; i++) { // �տ��� ��������
			if(tmpMax < map[i])
				tmpMax = map[i];
			ans += tmpMax;
		}
		
		tmpMax = 0;
		for(int i=1000; i>maxIdx; i--) { // �ڿ��� ��������
			if(tmpMax < map[i])
				tmpMax = map[i];
			ans += tmpMax;
		}
		System.out.println(ans);
	}
}



