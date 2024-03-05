package BaekJoon;

import java.io.*;
import java.util.*;

public class BaekJoon11478 { // 서로 다른 부분 문자열의 개수(S3)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		Set<String> set = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				set.add(str.substring(i, j));
			}
		}
		bw.write(set.size() + "");
        bw.flush();
        bw.close();
	}
}
