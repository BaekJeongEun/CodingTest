package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1094 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = Integer.toBinaryString(Integer.parseInt(br.readLine()));
		System.out.println(st);
		int cnt=0;
		for(int i=0; i<st.length(); i++) {
			if(st.charAt(i)=='1') {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
