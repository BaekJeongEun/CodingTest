package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWExpertAcademy6808 { // 규영이와 인영이의 카드게임 (D3)
	static int N, win = 0, lose = 0;
	static int[] arr, input, mine;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		HashSet<Integer> set = new HashSet<>();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {

			st = new StringTokenizer(br.readLine());
			arr = new int[9];
			input = new int[9];
			visit = new boolean[9];
			for(int i=1; i<=18; i++) {
				set.add(i);
			}
			for (int i = 0; i < 9; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				set.remove(arr[i]);
			}
			mine = set.stream().sorted().mapToInt(Integer::intValue).toArray();
			permu(0, input);

			sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
			win = 0;
			lose = 0;
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void permu(int cnt, int[] input) {
		if (cnt == 9) {
			// 인영이 이기는 경우 카운트
			if (game(input)) {
				lose++;
			} else
				win++;
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (!visit[i]) {
				visit[i] = true;
				input[cnt] = mine[i];
				permu(cnt + 1, input);
				visit[i] = false;
			}
		}

	}

	private static boolean game(int[] input) {
		// arr과 input 게임 시작! 이기면 true
		
		int gyu = 0, in = 0;
		for (int i = 0; i < 9; i++) {
			if (arr[i] > input[i])
				gyu += arr[i] + input[i];
			else if (arr[i] < input[i])
				in += arr[i] + input[i];
		}
		return (in > gyu) ? true : false;
	}
}