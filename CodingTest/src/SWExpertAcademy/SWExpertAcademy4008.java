package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWExpertAcademy4008 { // 슛자만들기 (모의 SW 역량테스트)
	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static int[] operation;
	static int[] opPickList;
	static boolean[] used;
	static int[] num;
	static int N, operateNum, operateCnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			operateCnt = 0;
			N = Integer.parseInt(br.readLine());
			operateNum = N - 1;
			operation = new int[4];
			opPickList = new int[operateNum];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				int n = Integer.parseInt(st.nextToken());
				operateCnt += n;
				operation[i] = n;
			}
			num = new int[N];
			used = new boolean[operateCnt];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			permu(0);
			sb.append("#" + tc + " " + Math.abs(max - min) + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void permu(int cnt) {
		if (cnt == operateNum) {
			// 연산
			operate();
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (operation[i] > 0) {
				operation[i]--;
				opPickList[cnt]=i;
				permu(cnt + 1);
				operation[i]++;
			}
		}
	}

	private static void operate() {
		int result = num[0];
		for (int i = 0; i < operateNum; i++) {
			int curOp = opPickList[i];
			if (curOp == 0) {
				result += num[i + 1];
			} else if (curOp == 1) {
				result -= num[i + 1];
			} else if (curOp == 2) {
				result *= num[i + 1];
			} else if (curOp == 3) {
				result /= num[i + 1];
			}
		}
		min = Math.min(min, result);
		max = Math.max(max, result);
	}

}
