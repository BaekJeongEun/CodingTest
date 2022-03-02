package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon16926_2 {
	static int arr[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// ����->��, �Ʒ�->��, ��->����, ��->�Ʒ�
		int dir[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int TC = Integer.parseInt(st.nextToken());
		arr = new int[h][w];
		String str[] = null;
		for (int i = 0; i < h; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < w; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		for (int tc = 0; tc < TC; tc++) {
			int check = Math.min(h, w) / 2; // ������ �� �簢�� ����
			for (int cnt = 0; cnt < check; cnt++) {
				int n_max = h - cnt - 1;
				int m_max = w - cnt - 1;
				int tmp = arr[cnt][cnt];
				// ���� �� : �� <- ��
				for (int i = cnt; i < m_max; i++) {
					arr[cnt][i] = arr[cnt][i + 1];
				} // ������ �� : �Ʒ� <- ��
				for (int i = cnt; i < n_max; i++) {
					arr[i][m_max] = arr[i + 1][m_max];
				} // �Ʒ��� �� : �� -> ��
				for (int i = m_max; i > cnt; i--) {
					arr[n_max][i] = arr[n_max][i - 1];
				} // ���� �� : �� -> �Ʒ�
				for (int i = n_max; i > cnt; i--) {
					arr[i][cnt] = arr[i - 1][cnt];
				}
				arr[cnt + 1][cnt] = tmp;
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
