package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWExpertAcademy_요리사 {
	static int min = Integer.MAX_VALUE, N;
	static int[][] arr;
	static ArrayList<Integer> combList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			min = Integer.MAX_VALUE;
			combList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			comb(0, 0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static void comb(int idx, int cnt) {
		if (cnt == N/2) {
			checkSynergy();
			return;
		}
		for (int i = idx; i < N; i++) {
			combList.add(i+1);
			comb(i + 1, cnt + 1);
			combList.remove(new Integer(i+1));
		}
	}

	private static void checkSynergy() {
		ArrayList<Integer> B = new ArrayList<>();
		int size = combList.size(), sumA = 0, sumB=0;
		
		for(int i=1; i<=N; i++) {
			if(!combList.contains(new Integer(i))) {
				B.add(i);
			}
		}
		
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (i != j) {
					int gradi1 = combList.get(i)-1;
					int gradi2 = combList.get(j)-1;
					sumA += arr[gradi1][gradi2]+arr[gradi2][gradi1];
					
					gradi1 = B.get(i)-1;
					gradi2 = B.get(j)-1;
					sumB += arr[gradi1][gradi2]+arr[gradi2][gradi1];
				}
			}
		}
		min = Math.min(min, Math.abs(sumA - sumB));
	}
}