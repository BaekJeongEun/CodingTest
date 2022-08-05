package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon12891 { // DNA 비밀번호 (S2)
	static int S, P, cnt;
	static String input, curr = "";
	static int[] temp;
	static int[] dna = new int[4]; // A C G T
	static boolean exit = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		input = br.readLine();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			dna[i] = Integer.parseInt(st.nextToken());
		}
		temp = new int[4];

		for (int i = 0; i < P; i++) {
			int index = check1(input.charAt(i));
			if (index != -1) {
				temp[index]++;
			}
		}
		if(check()) {
			cnt++;
		}
		curr = input.substring(0, P);
		for(int i=P-1, j=0; i<input.length()-1; i++, j++) {
			// 앞 글자 떼어내기
			char charStr = input.charAt(j);
			int index = check1(charStr);
			temp[index]--;
			
			// 뒷 글자 붙이기
			charStr = input.charAt(i+1);
			index = check1(charStr);
			temp[index]++;			
			
			if(check()) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	static int check1(char str) {
		int idx = 0;
		switch (str) {
		case 'A':
			idx = 0;
			break;
		case 'C':
			idx = 1;
			break;
		case 'G':
			idx = 2;
			break;
		case 'T':
			idx = 3;
			break;
		}

		return idx;
	}

	static boolean check() {
		for (int i = 0; i < 4; i++) {
			// System.out.println(temp[i] + " " + dna[i]);
			if (temp[i] < dna[i]) {
				return false;
			}
		}
		System.out.println("가능해!!!!!!!!!!!!");
		return true;
	}
}
