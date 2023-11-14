package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon25682 { // 체스판 다시 칠하기 2(G3)
	static int n;
	static int[] nums;
	static int[] oper = new int[4];
	static StringBuilder sb = new StringBuilder();
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stk;

		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(stk.nextToken());
		}
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(stk.nextToken());
		}

		dfs(nums[0], 1);

		bw.write(max + "\n");
		bw.write(min + "\n");

		bw.flush();
		bw.close();
	}

	static void dfs(int num, int idx) {
		if (idx == n) {
			min = Math.min(num, min);
			max = Math.max(num, max);
			return;
		} else {
			for (int i = 0; i < 4; i++) {
				if (oper[i] > 0) {
					oper[i]--;
					if (i == 0)
						dfs(num + nums[idx], idx + 1);
					else if (i == 1)
						dfs(num - nums[idx], idx + 1);
					else if (i == 2)
						dfs(num * nums[idx], idx + 1);
					else if (i == 3)
						dfs(num / nums[idx], idx + 1);
					break;
				}
				oper[i]++;
			}
		}
	}

}
