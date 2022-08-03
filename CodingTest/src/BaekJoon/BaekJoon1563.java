package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1563 { // 재귀 시간초과
	static int N;
	static long total;
	static String alphabet[] = {"O", "L", "A"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs("");
		System.out.println(total%1000000);
	}
	
	private static void dfs(String str) {
		
		if(!check(str)) { // 개근상 아니면
			return;
		}
		if(str.length() == N) {
			total++;
			return;
		}
		String str1 = "";
		for(int i=0; i<3; i++) {
			str1 = str+alphabet[i];
			dfs(str1);
		}
	}
	
	private static boolean check(String str) {
		boolean awards = true;
		// 개근상인지
		if(str.contains("AAA")) // 결석 세 번 연속
			awards = false;
		long count = str.chars().filter(c->c=='L').count();
		if(count >=2)awards = false;
		//if(awards) total++;
		return awards;
	}
}
