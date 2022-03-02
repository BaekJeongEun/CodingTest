package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon1032 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer newString = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		String str[] = new String[N];
		
		for(int i=0; i<N; i++) {
			str[i] = br.readLine();
		}
		
		newString.append(str[0]);
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<str[0].length(); j++) {
				if(str[i].charAt(j) != newString.charAt(j)) {
					newString.replace(j,j+1, "?");
				}
			}
		}
		System.out.println(newString);
	}
}
