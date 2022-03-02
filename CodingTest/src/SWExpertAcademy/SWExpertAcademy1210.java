package SWExpertAcademy;

import java.util.Scanner;

public class SWExpertAcademy1210 {
	static int TC;
	static int ans;
	static int[][] map;

	static int[] di = { 0, 0, -1 }; // 0:left, 1:right, 2:up
	static int[] dj = { -1, 1, 0 };

	static int nowi, nowj, nexti, nextj;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		TC = 10;
		for (int tc = 1; tc <= TC; tc++) {
			sc.nextInt(); // tc��ȣ�� ���� �Է����� ����. �Ⱦ������� �ޱ� �ؾ���

			ans = -1;
			map = new int[100][100];
			nowi = nowj = nexti = nextj = -1; // ��ȿ���� ���� ������ �ʱ�ȭ�ϰ� ����

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 2) { // �ٴ� �����
						nowi = i;
						nowj = j;
					}
				}
			}

			while (true) {
				map[nowi][nowj] = 9;
				for (int d = 0; d < 3; d++) { // 3�� ������ �̵������� ��ĭ ã�Ƽ� ������ǥ ����
					nexti = nowi + di[d];
					nextj = nowj + dj[d];

					if (nexti >= 0 && nexti < 100 && nextj >= 0 && nextj < 100 && map[nexti][nextj] == 1) {
						nowi = nexti;
						nowj = nextj;
						break; // ��, ��, �� ������ Ž����. ��, �� �߿� �̵������ϸ� �ٷ� �̵��ϰ� ���δ� �Ȱ�����.
					}
				}
				if(nowi == 0) { // ����� ����!
					ans = nowj; // ���� ����ȣ�� ��!
					break; // while ����!
				}
			}
			
//			print(map);
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void print(int[][] map) {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				System.out.print((map[i][j]==9?"*":map[i][j])+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
