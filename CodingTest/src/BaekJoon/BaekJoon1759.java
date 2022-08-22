package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1759 { // 암호 만들기 (G5)
	static String input;
	static String str[];
	static int L, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		str = new String[C];
		input = "";
		for(int i=0; i<C; i++) {
			str[i] = st.nextToken();
		}
		Arrays.sort(str);
		comb("", 0);
	}

	private static void comb(String cur, int idx) {
		if(cur.length() == L) {
			if((cur.contains("a") || cur.contains("e") || cur.contains("i") || cur.contains("o") || cur.contains("u")))
				return;
			String temp = cur;
			temp = temp.replace("a", "");
			temp = temp.replace("e", "");
			temp = temp.replace("i", "");
			temp = temp.replace("o", "");
			temp = temp.replace("u", "");
			if(temp.length()>=2)
				System.out.println(cur);
			return;
		}
		for(int i=idx; i<C; i++) {
			cur += str[i];
			comb(cur, i+1);
			cur = cur.substring(0, cur.length()-1);
		}
	}

}
