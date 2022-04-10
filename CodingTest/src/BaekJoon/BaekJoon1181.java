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
				if(o1.length() != o2.length())
					return o1.length()-o2.length();
				else
					return o1.compareTo(o2);
			}
		});
		for(int i=0; i<N; i++) {
			System.out.println(strL[i]);
		}
	}

}
