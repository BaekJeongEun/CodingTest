package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWExpertAcademy1974 { // 스도쿠 검증

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int arr[][] = new int[9][9];
			StringTokenizer st = null;
			boolean exit = false;
			int temp[] = null;
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				temp = new int[10];
				// 입력받으면서 가로 스도쿠 확인
				for (int j = 0; j < 9 && !exit; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					temp[arr[i][j]]++;
					if (temp[arr[i][j]] > 1) {
						exit = true;
					}
				}
			}
			// 세로 스도쿠 확인
			for (int j = 0; j < 9 && !exit; j++) {
				temp = new int[10];
				for (int k = 0; k < 9 && !exit; k++) {
					temp[arr[k][j]]++;
					if (temp[arr[k][j]] > 1) {
						exit = true;
					}
				}
			}
			// 정사각형 스도쿠 확인
			for (int j = 0; j < 9 && !exit; j += 3) {
				for (int k = 0; k < 9 && !exit; k += 3) {
					temp = new int[10];
					for (int l = j; l < j + 3 && !exit; l++) {
						for (int m = k; m < k + 3 && !exit; m++) {
							temp[arr[l][m]]++;
							if (temp[arr[l][m]] > 1) {
								exit = true;
							}
						}
					}
				}
			}

			System.out.println("#" + tc + " " + (exit ? "0" : "1"));
		}
	}

}
