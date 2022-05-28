package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon2615Omok {
	static String arr[][] = new String[19][19];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = new String[19];

		int win = 0; // �̱� ��� ����
		int x = 0, y = 0;
		boolean exit = false;

		for (int i = 0; i < 19; i++) {
			str = br.readLine().split(" ");
			arr[i] = str;
		}

		for (int i = 0; i < 19 && !exit; i++) {
			for (int j = 0; j < 19; j++) {
				if (arr[i][j].equals("1") || arr[i][j].equals("2")) {
					exit = check(i, j);
					if (exit) {
						win = Integer.parseInt(arr[i][j]);
						x = i;
						y = j;
						break;
					}
				}
			}
		}
		System.out.println(win);
		if (win != 0)
			System.out.println((x + 1) + " " + (y + 1));
	}

	public static boolean check(int x, int y) {
		int cnt = 1; // ī��Ʈ ����
		boolean exit = false;

		if (!exit) {
			// �밢�� �� Ž��
			int j = y + 1;
			for (int i = x - 1; i >= 0 && j <= 18; i--) {
				if (arr[i][j].equals(arr[x][y])) {
					cnt++;
				} else
					break;

				j++;
			}
			if(18>x && y>0 && (arr[x+1][y-1].equals(arr[x][y])))	// ���� Ȯ��
				cnt = 6;
			if (cnt == 5)
				exit = true;
		}
		cnt = 1; // ī��Ʈ ����
		if (!exit) {
			// ������ Ž��
			int i = x, j = y + 1;
			for (; j <= 18; j++) {
				if (arr[i][j].equals(arr[x][y])) {
					cnt++;
				} else
					break;
			}
			if(0<y && arr[x][y-1].equals(arr[x][y]))	// ���� Ȯ��
				cnt = 6;
			if (cnt == 5)
				exit = true;
		}
		cnt = 1; // ī��Ʈ ����
		if (!exit) {
			// �Ʒ��� Ž��
			int i = x + 1, j = y;
			for (; i <= 18; i++) {
				if (arr[i][j].equals(arr[x][y])) {
					cnt++;
				} else
					break;
			}
			if(0<x && arr[x-1][y].equals(arr[x][y]))	// ���� Ȯ��
				cnt = 6;
			if (cnt == 5)
				exit = true;
		}
		cnt = 1; // ī��Ʈ ����
		if (!exit) {
			// �밢�� �Ʒ� Ž��
			int i = x + 1, j = y + 1;
			for (; i <= 18 && j <= 18; i++) {
				if (arr[i][j].equals(arr[x][y])) {
					cnt++;
				} else
					break;
				j++;
			}
			if(x>0 && y>0 && arr[x-1][y-1].equals(arr[x][y]))	// ���� Ȯ��
				cnt = 6;
			if (cnt == 5)
				exit = true;
		}

		return exit;
	}
}
