package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BaekJoon1181 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] strL = new String[N];
		for(int i=0; i<N; i++) {
			strL[i] = br.readLine();
		}
		Arrays.sort(strL, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() != o2.length())	// 문자열 길이 다르다면
					return o1.length()-o2.length(); // 문자열 길이 작은 순서대로 (작은 것 - 큰 것 = 음수, 더 작아서 앞으로 감) 
				else
					return o1.compareTo(o2);	// 문자열 길이 같다면 문자 비교
			}
		});
		for(int i=0; i<N; i++) {
			System.out.println(strL[i]);
		}
	}
}